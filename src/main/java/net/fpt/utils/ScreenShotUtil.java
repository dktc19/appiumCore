package net.fpt.utils;


import io.appium.java_client.AppiumDriver;
import net.fpt.driver.CreateDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import static net.fpt.utils.FlutterActionUtil.driver;
import static net.fpt.utils.PropertyUtils.getProperty;
import static net.fpt.utils.SquashAPIUtil.updateCommentExecutionStepByID;
import static net.fpt.utils.SquashAPIUtil.updateExecutionComment;

public class ScreenShotUtil {
    static final Logger logger = LoggerFactory.getLogger(ScreenShotUtil.class);
    public static boolean uploadFileEnabled = Boolean.parseBoolean(getProperty("MinIO.enableUploadFile"));
    public static AppiumDriver driver = CreateDriver.getInstance().getDriver(true);

    public static void takeLocalScreenshot (String imageName) {
        try {
            driver.context("NATIVE_APP");
            String screenshotDirectory= System.getProperty("screenshotDirectory","target/screenshots");
            String fileName =  imageName + "_" + System.currentTimeMillis() + ".jpg";
            String screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
            // file with date path
            String fileWithFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ "/"+ fileName;
            File screenshot= new File(screenshotAbsolutePath);
            if(createFile(screenshot)){
                screenshot = ((TakesScreenshot)driver).
                        getScreenshotAs(OutputType.FILE);
                new MinIO().minFileUploader(fileWithFolder,screenshot);
                logger.info("Written screenshot to " +  screenshotAbsolutePath);
            } else {
                logger.info("Unable to create " +  screenshotAbsolutePath);
            }
        } catch (Exception ex) {
            logger.error("Unable to capture screenshot..."+ ex.getCause());
        }
        driver.context("FLUTTER");
    }

    public static void takeScreenshotAndUpdateSquash(List<SquashAPIUtil.TestCaseOBJ> listObjFeature ,  String textCaseID) {
        try {
            driver.context("NATIVE_APP");
            String screenshotDirectory= System.getProperty("screenshotDirectory","target/screenshots");
            String fileName =  System.currentTimeMillis() + "_" + textCaseID + ".jpg";
            String screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
            // file with date path
            String fileWithFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ "/"+ fileName;
            File screenshort= new File(screenshotAbsolutePath);
            if(createFile(screenshort)){
                screenshort = ((TakesScreenshot)driver).
                        getScreenshotAs(OutputType.FILE);
                new MinIO().minFileUploader(fileWithFolder,screenshort);
                logger.info("Written screenshot to " +  screenshotAbsolutePath);
            } else {
                logger.info("Unable to create " +  screenshotAbsolutePath);
            }

            if(uploadFileEnabled) {
                logger.info("Update to minio");
                String result = "<img src=\"https://hi-static.fpt.vn/sys/selenium-core/stag/" + fileWithFolder+ "\" alt=\"false images\" style=\"width:20%; height:80%;\" />";
                updateExecutionComment(listObjFeature, textCaseID, result);
            }else {
                logger.info("local load");
                String result = "<p><img src=\""+getEncodedString(screenshort)+"\" alt=\"false images\" style=\"width:20%; height:80%;\"/></p>";
                System.out.println(result);
                updateExecutionComment(listObjFeature, textCaseID, result);
            }

        } catch (Exception ex) {
            logger.error("Unable to capture screenshot..."+ ex.getCause());
        }
        driver.context("FLUTTER");
    }

    public static void takeScreenshotAndUpdateSquash(String updatestepID) throws IOException, InterruptedException {
        try {
            driver.context("NATIVE_APP");
            String screenshotDirectory= System.getProperty("screenshotDirectory","target/screenshots");
            String fileName =  System.currentTimeMillis() + "_" + updatestepID + ".jpg";
            String screenshotAbsolutePath = screenshotDirectory + File.separator + fileName;
            // file with date path
            String fileWithFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ "/"+ fileName;
            File screenshort= new File(screenshotAbsolutePath);
            if(createFile(screenshort)){
                screenshort = ((TakesScreenshot)driver).
                        getScreenshotAs(OutputType.FILE);
                new MinIO().minFileUploader(fileWithFolder,screenshort);
                logger.info("Written screenshot to " +  screenshotAbsolutePath);
            } else {
                logger.info("Unable to create " +  screenshotAbsolutePath);
            }

            if(uploadFileEnabled) {
                logger.info("Update to minio");
                String result = "<img src=\"https://hi-static.fpt.vn/sys/selenium-core/stag/" + fileWithFolder+ "\" alt=\"false images\" style=\"width:20%; height:80%;\" />";
                updateCommentExecutionStepByID(updatestepID,result);
            }else {
                logger.info("local load");
                String result = "<p><img src=\""+getEncodedString(screenshort)+"\" alt=\"false images\" style=\"width:20%; height:80%;\"/></p>";
                System.out.println(result);
                updateCommentExecutionStepByID(updatestepID,result);
            }

        } catch (Exception ex) {
            logger.error("Unable to capture screenshot..."+ ex.getCause());
        }
        driver.context("FLUTTER");
    }

    private static boolean createFile(File screenshot){
        boolean filecreate =false;
        if(screenshot.exists()){
            filecreate = true;
        }else {
            File parentDirectory =new File(screenshot.getParent());
            if (parentDirectory.exists() || parentDirectory.mkdir()){
                try{
                    filecreate = screenshot.createNewFile();
                }catch (IOException errorCreatingScreenshot){
                    logger.error("Unable to capture screenshot..."+ errorCreatingScreenshot.getCause());
                }
            }
        }
        return filecreate;
    }

    public static String getEncodedString(File file) throws IOException {
        byte[] fileContent = new byte[0];

        fileContent = FileUtils.readFileToByteArray(file);

        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static BufferedImage getImageFromStorage(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(System.getProperty("screenshotDirectory", "target/screenshots") + "/" + filename + ".jpg"));
        } catch (TimeoutException e) {
            logger.error("Cannot find your file in storage!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
