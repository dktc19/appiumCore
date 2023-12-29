package net.fpt.utils;

import com.sun.jna.Pointer;
import net.fpt.constants.ReportConstants;
import net.fpt.driver.CreateDriver;
import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.TessAPI1;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageIOHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static net.fpt.utils.FlutterActionUtil.tapByExactCoordinates;
import static net.fpt.utils.ImageAnalyzeUtil.binary;
import static net.fpt.utils.ImageAnalyzeUtil.transformBlackWhite;
import static net.fpt.utils.WaitUtils.waitForOCR;
import static net.sourceforge.tess4j.ITessAPI.TRUE;

public class TesseractOcrUtil {

    /**
     * Scanning for the screen and find the expected vietnamese text,
     * then take invisible bounding box for the text and return its coordinates following parameters of confidence.
     *
     * For testPageIteratorLevel, there are 4 levels:
     *         number 0 represents for block scan.
     *         number 1 represents for parameter scan.
     *         number 2 represents for text line scan.
     *         number 3 represents for each word scan (default).
     *         number 4 represents for symbol scan.
     *
     * For testWordIteratorLevel, a certain word can be chosen when the screen has the iteration of that word. It counts from 0.
     *
     * @param text
     * @param testPageIteratorLevel
     * */
    public static List getTextLocation(String text, int testPageIteratorLevel, int testWordIteratorLevel, int Confidence) throws IOException {
        String dataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        String language = "vie";

        ITessAPI.TessBaseAPI handle = TessAPI1.TessBaseAPICreate();
        List list = new ArrayList<>();
        List result = new ArrayList<>();
        byte[] screenshot = ((TakesScreenshot) CreateDriver.getInstance().getDriver(true)).getScreenshotAs(OutputType.BYTES);
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(screenshot));

        assert image != null;
        ByteBuffer buf = ImageIOHelper.convertImageData(image);
        int bpp = image.getColorModel().getPixelSize();
        int bytespp = bpp / 8;
        int bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);

        TessAPI1.TessBaseAPIInit3(handle, dataPath, language);
        TessAPI1.TessBaseAPISetPageSegMode(handle, ITessAPI.TessPageSegMode.PSM_AUTO);
        TessAPI1.TessBaseAPISetImage(handle, buf, image.getWidth(), image.getHeight(), bytespp, bytespl);

        ITessAPI.ETEXT_DESC monitor = new ITessAPI.ETEXT_DESC();
        TessAPI1.TessBaseAPIRecognize(handle, monitor);
        ITessAPI.TessResultIterator ri = TessAPI1.TessBaseAPIGetIterator(handle);
        ITessAPI.TessPageIterator pi = TessAPI1.TessResultIteratorGetPageIterator(ri);
        TessAPI1.TessPageIteratorBegin(pi);
        int level = 0;
        switch (testPageIteratorLevel) {
            case 0:
                level = TessAPI1.TessPageIteratorLevel.RIL_BLOCK;
                break;
            case 1:
                level = TessAPI1.TessPageIteratorLevel.RIL_PARA;
                break;
            case 2:
                level = TessAPI1.TessPageIteratorLevel.RIL_TEXTLINE;
                break;
            case 4:
                level = TessAPI1.TessPageIteratorLevel.RIL_SYMBOL;
                break;
            case 5:
                level = TessAPI1.TessPageIteratorLevel.RIL_WORD;
                break;
        }

        int countWord = 0;
        do {
            Pointer ptr = TessAPI1.TessResultIteratorGetUTF8Text(ri, level);
            String word = ptr.getString(0).toLowerCase();
            TessAPI1.TessDeleteText(ptr);
            float confidence = TessAPI1.TessResultIteratorConfidence(ri, level);
            IntBuffer leftB = IntBuffer.allocate(1);
            IntBuffer topB = IntBuffer.allocate(1);
            IntBuffer rightB = IntBuffer.allocate(1);
            IntBuffer bottomB = IntBuffer.allocate(1);
            TessAPI1.TessPageIteratorBoundingBox(pi, level, leftB, topB, rightB, bottomB);
            //System.out.println(">>>"+ word + " - " + confidence);
            if (word.contains(text.toLowerCase()) && confidence >= Confidence) {
                int xOffset = (leftB.get() + rightB.get())/2;
                int yOffset = (topB.get() + bottomB.get())/2;
                list.add(xOffset);
                list.add(yOffset);
                countWord++;
            }
        }
        while (TessAPI1.TessPageIteratorNext(pi, level) == TRUE);
        System.out.println(">>>"+ list.toString());
        if (countWord > 1) {
            result.add(list.get(2*testWordIteratorLevel));
            result.add(list.get(2*testWordIteratorLevel + 1));
        } else {
            result.add(list.get(0));
            result.add(list.get(1));
        }
        return result;
    }

    /**
     * Scanning for the screen and find the expected vietnamese text,
     * then take invisible bounding box for the text and return its coordinates following parameters of confidence.
     *
     * For testPageIteratorLevel, there are 4 levels:
     *         number 0 represents for block scan.
     *         number 1 represents for parameter scan.
     *         number 2 represents for text line scan.
     *         number 3 represents for each word scan (default).
     *         number 4 represents for symbol scan.
     *
     * For testWordIteratorLevel, a certain word can be chosen when the screen has the iteration of that word. It counts from 0.
     *
     * @param text
     * @param testPageIteratorLevel
     * */
    public static List getWhiteTextLocation(String text, int testPageIteratorLevel, int testWordIteratorLevel, int Confidence) throws IOException {
        String dataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
        String language = "vie";

        ITessAPI.TessBaseAPI handle = TessAPI1.TessBaseAPICreate();
        List list = new ArrayList<>();
        List result = new ArrayList<>();
        byte[] screenshot = ((TakesScreenshot) CreateDriver.getInstance().getDriver(true)).getScreenshotAs(OutputType.BYTES);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(screenshot));

        assert img != null;
//        BufferedImage image = binary(img);

        BufferedImage image = transformBlackWhite(img);

        ByteBuffer buf = ImageIOHelper.convertImageData(image);
        int bpp = image.getColorModel().getPixelSize();
        int bytespp = bpp / 8;
        int bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);

        TessAPI1.TessBaseAPIInit3(handle, dataPath, language);
        TessAPI1.TessBaseAPISetPageSegMode(handle, ITessAPI.TessPageSegMode.PSM_AUTO);
        TessAPI1.TessBaseAPISetImage(handle, buf, image.getWidth(), image.getHeight(), bytespp, bytespl);

        ITessAPI.ETEXT_DESC monitor = new ITessAPI.ETEXT_DESC();
        TessAPI1.TessBaseAPIRecognize(handle, monitor);
        ITessAPI.TessResultIterator ri = TessAPI1.TessBaseAPIGetIterator(handle);
        ITessAPI.TessPageIterator pi = TessAPI1.TessResultIteratorGetPageIterator(ri);
        TessAPI1.TessPageIteratorBegin(pi);
        int level = 0;
        switch (testPageIteratorLevel) {
            case 0:
                level = TessAPI1.TessPageIteratorLevel.RIL_BLOCK;
                break;
            case 1:
                level = TessAPI1.TessPageIteratorLevel.RIL_PARA;
                break;
            case 2:
                level = TessAPI1.TessPageIteratorLevel.RIL_TEXTLINE;
                break;
            case 3:
                level = TessAPI1.TessPageIteratorLevel.RIL_SYMBOL;
                break;
            case 4:
                level = TessAPI1.TessPageIteratorLevel.RIL_WORD;
                break;
        }

        int countWord = 0;
        do {
            Pointer ptr = TessAPI1.TessResultIteratorGetUTF8Text(ri, level);
            String word = ptr.getString(0).toLowerCase();
            TessAPI1.TessDeleteText(ptr);
            float confidence = TessAPI1.TessResultIteratorConfidence(ri, level);
            IntBuffer leftB = IntBuffer.allocate(1);
            IntBuffer topB = IntBuffer.allocate(1);
            IntBuffer rightB = IntBuffer.allocate(1);
            IntBuffer bottomB = IntBuffer.allocate(1);
            TessAPI1.TessPageIteratorBoundingBox(pi, level, leftB, topB, rightB, bottomB);
            //System.out.println(">>>"+ word + " - " + confidence);
            if (word.contains(text.toLowerCase()) && confidence >= Confidence) {
                int xOffset = (leftB.get() + rightB.get())/2;
                int yOffset = (topB.get() + bottomB.get())/2;
                list.add(xOffset);
                list.add(yOffset);
                countWord++;
            }
        }
        while (TessAPI1.TessPageIteratorNext(pi, level) == TRUE);
        //System.out.println(">>>"+ list.toString());
        if (countWord > 1) {
            result.add(list.get(2*testWordIteratorLevel));
            result.add(list.get(2*testWordIteratorLevel + 1));
        } else {
            result.add(list.get(0));
            result.add(list.get(1));
        }
        return result;
    }

    /**
     * The function used to detect characters from images in many languages
     *
     * Supported language: vie,eng.
     *
     * @param language
     * */
    public static List getTextLocation(String text, int testPageIteratorLevel, int testWordIteratorLevel, int Confidence, String language) throws IOException {
        String dataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;

        ITessAPI.TessBaseAPI handle = TessAPI1.TessBaseAPICreate();
        List list = new ArrayList<>();
        List result = new ArrayList<>();
        byte[] screenshot = ((TakesScreenshot) CreateDriver.getInstance().getDriver(true)).getScreenshotAs(OutputType.BYTES);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(screenshot));

        assert image != null;
        ByteBuffer buf = ImageIOHelper.convertImageData(image);
        int bpp = image.getColorModel().getPixelSize();
        int bytespp = bpp / 8;
        int bytespl = (int) Math.ceil(image.getWidth() * bpp / 8.0);

        TessAPI1.TessBaseAPIInit3(handle, dataPath, language);
        TessAPI1.TessBaseAPISetPageSegMode(handle, ITessAPI.TessPageSegMode.PSM_AUTO);
        TessAPI1.TessBaseAPISetImage(handle, buf, image.getWidth(), image.getHeight(), bytespp, bytespl);

        ITessAPI.ETEXT_DESC monitor = new ITessAPI.ETEXT_DESC();
        TessAPI1.TessBaseAPIRecognize(handle, monitor);
        ITessAPI.TessResultIterator ri = TessAPI1.TessBaseAPIGetIterator(handle);
        ITessAPI.TessPageIterator pi = TessAPI1.TessResultIteratorGetPageIterator(ri);
        TessAPI1.TessPageIteratorBegin(pi);
        int level = 0;
        switch (testPageIteratorLevel) {
            case 0:
                level = TessAPI1.TessPageIteratorLevel.RIL_BLOCK;
                break;
            case 1:
                level = TessAPI1.TessPageIteratorLevel.RIL_PARA;
                break;
            case 2:
                level = TessAPI1.TessPageIteratorLevel.RIL_TEXTLINE;
                break;
            case 3:
                level = TessAPI1.TessPageIteratorLevel.RIL_SYMBOL;
                break;
            case 4:
                level = TessAPI1.TessPageIteratorLevel.RIL_WORD;
                break;
        }

        int countWord = 0;
        do {
            Pointer ptr = TessAPI1.TessResultIteratorGetUTF8Text(ri, level);
            String word = ptr.getString(0).toLowerCase();
            TessAPI1.TessDeleteText(ptr);
            float confidence = TessAPI1.TessResultIteratorConfidence(ri, level);
            IntBuffer leftB = IntBuffer.allocate(1);
            IntBuffer topB = IntBuffer.allocate(1);
            IntBuffer rightB = IntBuffer.allocate(1);
            IntBuffer bottomB = IntBuffer.allocate(1);
            TessAPI1.TessPageIteratorBoundingBox(pi, level, leftB, topB, rightB, bottomB);

            if (word.contains(text.toLowerCase()) && confidence >= Confidence) {
                int xOffset = (leftB.get() + rightB.get())/2;
                int yOffset = (topB.get() + bottomB.get())/2;
                list.add(xOffset);
                list.add(yOffset);
                countWord++;
            }
        }
        while (TessAPI1.TessPageIteratorNext(pi, level) == TRUE);

        if (countWord > 1) {
            result.add(list.get(2*testWordIteratorLevel));
            result.add(list.get(2*testWordIteratorLevel + 1));
        } else {
            result.add(list.get(0));
            result.add(list.get(1));
        }

        return result;
    }

    /**
     * Return X,Y coordinate of the expected text.
     * If there are many same words on screen, testWordIteratorLevel could be used for locating it following the first match.
     * Default of testPageIteratorLevel is RIL_PARA. And that of confidence is 70 percents.
     *
     * @param expectedText
     *
     * */
    public static Point getTextCoordinate(String expectedText) throws IOException {
        return new Point((Integer) getTextLocation(expectedText,4,0, 70).get(0),(Integer) getTextLocation(expectedText,4,0, 70).get(1));
    }


    /**
     * Return X,Y coordinate of the expected text.
     * If there are many words on screen, testWordIteratorLevel could be used for locating it following the input matches as 0 and counting up to expectation.
     * For testPageIteratorLevel, there are 4 levels:
     *      number 0 represents for block scan.
     *      number 1 represents for parameter scan.
     *      number 2 represents for text line scan.
     *      number 3 represents for each word scan.
     *      number 4 represents for symbol scan.
     *
     * @param expectedText
     * @param testWordIteratorLevel
     * @param testPageIteratorLevel
     *
     * */
    public static Point getTextCoordinate(String expectedText, int testPageIteratorLevel, int testWordIteratorLevel, int confidence) throws IOException {
        return new Point((Integer) getTextLocation(expectedText,testPageIteratorLevel,testWordIteratorLevel,confidence).get(0),(Integer) getTextLocation(expectedText,testPageIteratorLevel,testWordIteratorLevel,confidence).get(1));
    }


    public static Point getWhiteTextCoordinate(String expectedText, int testPageIteratorLevel, int testWordIteratorLevel, int confidence) throws IOException {
        return new Point((Integer) getWhiteTextLocation(expectedText,testPageIteratorLevel,testWordIteratorLevel,confidence).get(0),(Integer) getWhiteTextLocation(expectedText,testPageIteratorLevel,testWordIteratorLevel,confidence).get(1));
    }

    /**
     * Function to click on Text with OCR
     *
     * @param text
     *
     * */
    public static void clickToElementByOCR(String text) throws IOException, TesseractException {
        waitForOCR(text);
        tapByExactCoordinates(getWhiteTextCoordinate(text,4,0,70).getX(),getWhiteTextCoordinate(text,4,0,70).getY());
    }

    /**
     * Function to click on Text with OCR
     *
     * @param text
     * @param testPageIteratorLevel
     * @param testWordIteratorLevel
     * @param confidence
     *
     * */
    public static void clickToElementByOCR(String text, int testPageIteratorLevel, int testWordIteratorLevel, int confidence) throws IOException, TesseractException {
        waitForOCR(text);
        tapByExactCoordinates(getWhiteTextCoordinate(text,testPageIteratorLevel,testWordIteratorLevel,confidence).getX(),getWhiteTextCoordinate(text,testPageIteratorLevel,testWordIteratorLevel,confidence).getY());
    }
}
