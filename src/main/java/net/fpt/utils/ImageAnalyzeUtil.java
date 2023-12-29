package net.fpt.utils;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static net.fpt.utils.FlutterActionUtil.driver;

public class ImageAnalyzeUtil {

    /**
     * Compile histogram of 2 input images and return a grayscale output image to show the difference
     *
     * @param img1
     * @param img2
     * */
    public static BufferedImage getDifferenceImage(BufferedImage img1, BufferedImage img2) {
        int width1 = img1.getWidth();
        int width2 = img2.getWidth();
        int height1 = img1.getHeight();
        int height2 = img2.getHeight();
        if ((width1 != width2) || (height1 != height2)) {
            System.err.println("Error: Images dimensions mismatch");
            System.exit(1);
        }

        BufferedImage outImg = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB);

        int diff;
        int result;
        for (int i = 0; i < height1; i++) {
            for (int j = 0; j < width1; j++) {
                int rgb1 = img1.getRGB(j, i);
                int rgb2 = img2.getRGB(j, i);
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = (rgb1) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >> 8) & 0xff;
                int b2 = (rgb2) & 0xff;
                diff = Math.abs(r1 - r2);
                diff += Math.abs(g1 - g2);
                diff += Math.abs(b1 - b2);
                diff /= 3;
                result = (diff << 16) | (diff << 8) | diff;
                outImg.setRGB(j, i, result); // Set result
            }
        }

        return outImg;
    }

    /**
     * To analyze the difference grayscale image to determine the result's images is difference or not
     * The input image is grayscale that proposed the difference of
     *
     * @param img
     * */
    public static Boolean isImageSimilarity(BufferedImage img) {
        int height = img.getHeight();
        int width = img.getWidth();
        int totalPixel = height*width;
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = img.getRGB(j,i);
                int red = (rgb >> 16) & 0xff;
                if (red > 0) {
                    count++;
                }
            }
        }

        return (count * 100) / totalPixel > 1;
    }

    /**
     * To set data for search vietnamese in images
     *
     * */
    private static Tesseract getTesseract() {
        Tesseract instance = new Tesseract();
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        instance.setDatapath(path);
        instance.setLanguage("vie");
        return instance;
    }

    /**
     * Return a string that includes all words in given image
     *
     * @param imagePath
     * */
    public static String textFromImage(String imagePath) throws TesseractException {
        Tesseract tesseract = getTesseract();
        File file = new File(imagePath);
        return tesseract.doOCR(file);
    }

    /**
     * Return a string that includes all words in given image
     *
     * @param imageFile
     * */
    public static String extractTextFromImage(File imageFile) throws TesseractException {
        Tesseract tesseract = getTesseract();
        return tesseract.doOCR(imageFile);
    }

    public static File captureScreenAndReturnFile() {
        File imagePath = null;
        try {
            driver.context("NATIVE_APP");
            imagePath = ((TakesScreenshot)driver).
                    getScreenshotAs(OutputType.FILE);
        } catch (TimeoutException e) {
        } finally {
            driver.context("FLUTTER");
        }
        return imagePath;
    }

    /**
     * Transform BufferedImage from color to binary (black and white)
     *
     * @param src
     *
     * */
    public static BufferedImage binary(BufferedImage src) {
        int width = src.getWidth();
        int height = src.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = src.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }/*www. ja  va2  s  .  co m*/
        }
        return grayImage;
    }

    public static BufferedImage transformBlackWhite(BufferedImage img_input){
        try {
            BufferedImage image = img_input;

            // Get the width and height of the image
            int width = image.getWidth();
            int height = image.getHeight();

            // Loop through each pixel in the image
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    // Get the color of the current pixel
                    Color color = new Color(image.getRGB(x, y));

                    // Invert the color of the pixel
                    int red = 255 - color.getRed();
                    int green = 255 - color.getGreen();
                    int blue = 255 - color.getBlue();

                    // Set the new color of the pixel
                    Color newColor = new Color(red, green, blue);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int pixel = image.getRGB(x, y);
                    if (pixel != Color.BLACK.getRGB()) {
                        image.setRGB(x, y, Color.WHITE.getRGB());
                    }
                }
            }
            return image;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return img_input;
    }
}
