package net.fpt.utils;

import com.lazerycode.selenium.util.Query;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.offset.PointOption;
import kong.unirest.json.JSONObject;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static net.fpt.utils.FlutterActionUtil.Direction.*;
import static net.fpt.utils.ImageAnalyzeUtil.*;
import static net.fpt.utils.ScreenShotUtil.*;
import static net.fpt.utils.StaticActionUtil.sleepTo;
import static net.fpt.utils.TesseractOcrUtil.*;

public class FlutterActionUtil {
    public static AppiumDriver driver;

    public FlutterActionUtil(AppiumDriver driver) {
        this.driver=driver;
    }

    public static void inputText(MobileElement locator,String str) {
        waitFor(locator);
        driver.executeScript("flutter:setTextEntryEmulation", true);
        clickToElement(locator);
        driver.executeScript("flutter:enterText", str);
    }

    public static void runCmd(String inputString) {
        try {
            Runtime.getRuntime().exec(inputString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inputTextNotClick(String str) {
        driver.executeScript("flutter:setTextEntryEmulation", true);
        driver.executeScript("flutter:enterText", str);
    }

    public static void inputTextByCoordinates(MobileElement finder, int weight, String str) {
        findAndClickCoordinates(finder,weight);
        inputTextNotClick(str);
    }

    /**
     * Using OCR technology to determine the location of elements needed to input the text
     *
     * @param inputText
     * @param textInsideBox
     *
     * */
    public static void inputTextByOcrTech(String textInsideBox, String inputText) {
        try {
            tapByExactCoordinates(getWhiteTextCoordinate(textInsideBox,1,0,70).getX(),getWhiteTextCoordinate(textInsideBox,1,0,70).getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputTextNotClick(inputText);
    }

    /**
     *
     *
     * */
    public static void inputTextByOcrTech(String textInsideBox, String inputText, int testPageIteratorLevel, int testWordIteratorLevel) {
        try {
            tapByExactCoordinates(getWhiteTextCoordinate(textInsideBox,testPageIteratorLevel,testWordIteratorLevel,50).getX(),getWhiteTextCoordinate(textInsideBox,testPageIteratorLevel,testWordIteratorLevel,50).getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputTextNotClick(inputText);
    }

    public static void clickToElement(MobileElement locator){
        MobileElement el = waitForTappable(locator);
        el.click();
    }

    public static MobileElement waitFor(MobileElement locator, long time){
        return (MobileElement) driver.executeScript("flutter:waitFor", locator, time);
    }

    public static MobileElement waitFor(MobileElement locator) {
        return (MobileElement) driver.executeScript("flutter:waitFor", locator, 300);
    }

    /**
     * Wait an object for being absent
     *
     * @param finder
     * */
    public static MobileElement waitForAbsent(MobileElement finder) {
        return (MobileElement) driver.executeScript("flutter:waitForAbsent", finder, 300);
    }

    /**
     * Wait an object for being tappable
     *
     * @param finder
     * */
    public static MobileElement waitForTappable(MobileElement finder) {
        return (MobileElement) driver.executeScript("flutter:waitForTappable", finder, 300);
    }

    /**
     * Tap by coordinates
     *
     * @param x
     * @param y
     */
    public static void tapByCoordinates (int x, int y) {
        sleepTo(5000);
        driver.context("NATIVE_APP");
        Dimension dims = driver.manage().window().getSize();
        int xOffset = Math.round((x*dims.width)/1080);
        int yOffset = Math.round((y*dims.height)/2160) + 10;

        new TouchAction(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(ofMillis(500))).perform();
        driver.context("FLUTTER");
    }

    public static void tapByExactCoordinates(int x, int y) {
        sleepTo(1000);
        driver.context("NATIVE_APP");
        new TouchAction(driver)
                .tap(point(x,y))
                .waitAction(waitOptions(ofMillis(500))).perform();
        driver.context("FLUTTER");
    }

    /**
     * Scroll Down using native API. Function scroll until item is visible or exit in max swipes
     *
     * @param finder
     * @param max_swipes
     */
    public static void scrollDownNativeUntilVisible(MobileElement finder,int max_swipes) {
        int already_swiped = 0;
        while (!(displayed(finder))){
            swipeScreen(DOWN, 200,500,500);
            if (already_swiped > max_swipes){
                throw new AssertionError("Cannot find element by swiping up.");
            }
            ++already_swiped;
        }
    }

    /**
     * Scroll Up using native API. Function scroll until item is visible or exit in max swipes
     *
     * @param finder
     * @param max_swipes
     */
    public static void scrollUpNativeUntilVisible(MobileElement finder,int max_swipes) {
        int already_swiped = 0;
        while (!(displayed(finder))){
            swipeScreen(UP, 200,300,300);
            if (already_swiped > max_swipes){
                throw new AssertionError("Cannot find element by swiping up.");
            }
            ++already_swiped;
        }
    }

    /**
     * Scroll down to find text on screen using OCR technology. Function scroll until text is visible or exit in max swipes
     *
     * @param text
     * @param max_swipes
     */
    public static void scrollDownUntilTextVisible(String text, int max_swipes) throws TesseractException {
        int already_swiped = 0;
        while (!(isTextOnScreen(text))) {
            swipeScreen(DOWN, 200,500,500);
            if (already_swiped > max_swipes){
                throw new AssertionError("Cannot find element by swiping up.");
            }
            ++already_swiped;
        }
    }

    /**
     * Return true if the expected text visible on screen
     *
     * @param text
     *
     * */
    public static Boolean isTextOnScreen(String text) throws TesseractException {
        sleepTo(2000);
        return extractTextFromImage(captureScreenAndReturnFile()).contains(text);
    }

    /**
     * Function to scroll screen until the expected text matches given regular expression
     *
     * @param regex
     * @param max_swipes
     *
     * */
    public static void scrollDownUntilMatchText(String regex, int max_swipes) throws TesseractException {
        int already_swiped = 0;
        while (!(matchTextOnScreen(regex))) {
            swipeScreen(DOWN, 200,500,500);
            if (already_swiped > max_swipes){
                throw new AssertionError("Cannot find element by swiping up.");
            }
            ++already_swiped;
        }
    }

    /**
     * Return true if the regular expression visible on screen
     *
     * @param regex
     *
     * */
    public static Boolean matchTextOnScreen(String regex) throws TesseractException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(extractTextFromImage(captureScreenAndReturnFile()));
        return matcher.find();
    }

    /**
     * Scroll Down using native API. Function scroll until item is visible or exit in max swipes.
     * Then return screen to top of app after scroll down
     *
     * @param finder
     * @param max_swipes
     * */
    public static void scrollNativeUntilVisibleReturnTop(MobileElement finder,int max_swipes) {
        boolean isdisplay = false;
        int already_swiped = 0;
        while (!isdisplay){
            isdisplay = displayed(finder);
            swipeScreen(DOWN, 200,300,300);
            if (already_swiped > max_swipes){
                throw new AssertionError("Cannot find element by swiping up.");
            }
            ++already_swiped;
        }
        while (already_swiped > 0) {
            swipeScreen(Direction.UP,200,300,300);
            --already_swiped;
        }
        System.out.println("Return to top");
    }

    /**
     * Android press back key
     **
     *
     **/

    public static void clickBack() {
        driver.context("NATIVE_APP");
        try {
            ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        } catch (Exception e) {

        }finally {
            driver.context("FLUTTER");
        }
    }

    /**
     * Performs swipe from the center of screen
     *  Animation default time:
     *      - Android: 300 ms
     *      - iOS: 200 ms
     *      - final value depends on your app and could be greater
     *
     * @param dir the direction of swipe
     * @param dimension speed scroll
     * @param animation_time
     * @param press_time
     * @version java-client: 7.3.0
     **/

    public static void swipeScreen(Direction dir, int dimension, int animation_time, int press_time) {
        driver.context("NATIVE_APP");

        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2 );

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2 , dims.height / 2 - dimension);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height / 2 + dimension);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(dims.width/ 2 + dimension, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width/ 2 - dimension, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(press_time)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(animation_time);
        } catch (InterruptedException e) {
            // ignore
        }finally {
            driver.context("FLUTTER");
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    /**
     *
     * */
    public static void swipeCoordinate(int xOffsetStart, int yOffsetStart, int xOffsetEnd, int yOffsetEnd, int animation_time, int press_time) {
        driver.context("NATIVE_APP");

        // init start point = center of screen
        PointOption pointOptionStart = PointOption.point(xOffsetStart, yOffsetStart );
        PointOption pointOptionEnd = PointOption.point(xOffsetEnd, yOffsetEnd);

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(press_time)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(animation_time);
        } catch (InterruptedException e) {
            // ignore
        }finally {
            driver.context("FLUTTER");
        }
    }


    /**
     * Check element is display with flutter driver api
     *
     * @param finder
     * @param wait
     * @return
     */
    public static boolean displayed(MobileElement finder, int wait){
        try {
            waitFor(finder, wait);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean displayed(MobileElement finder){
        try {
            waitFor(finder);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Start command to wake the phone up and unlock it
     *
     * @param cmdScript
     * @return
     * */
    public static void androidWake(String cmdScript) throws IOException {
        Runtime.getRuntime().exec(PropertyUtils.getProperty(cmdScript));
    }

    /**
     * Scroll the screen to find day,month,year on scrolling calendar
     *
     * @param time
     * @param animation_time
     * @param press_time
     * */
    public static void swipeCalendar(Direction dir, Time time, int xOffsetYear, int yOffsetYear , int animation_time, int press_time) {
        driver.context("NATIVE_APP");
        PointOption pointOptionStart, pointOptionEnd;

        switch (time) {
            case DAY:
                pointOptionStart = PointOption.point(xOffsetYear - 420, yOffsetYear);
                if (dir == UP) {
                    pointOptionEnd = PointOption.point(xOffsetYear - 420, yOffsetYear + 80);
                } else {
                    pointOptionEnd = PointOption.point(xOffsetYear - 420, yOffsetYear - 70);
                }
                break;
            case MONTH:
                pointOptionStart = PointOption.point(xOffsetYear - 210, yOffsetYear);
                if (dir == UP) {
                    pointOptionEnd = PointOption.point(xOffsetYear - 210, yOffsetYear + 80);
                } else {
                    pointOptionEnd = PointOption.point(xOffsetYear - 210, yOffsetYear - 70);
                }
                break;
            case YEAR:
                pointOptionStart = PointOption.point(xOffsetYear, yOffsetYear);
                if (dir == UP) {
                    pointOptionEnd = PointOption.point(xOffsetYear, yOffsetYear + 80);
                } else {
                    pointOptionEnd = PointOption.point(xOffsetYear, yOffsetYear - 70);
                }
                break;
            default:
                throw new IllegalArgumentException("swipeCalendar(): time: '" + time + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(waitOptions(ofMillis(press_time)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(animation_time);
        } catch (InterruptedException e) {
            // ignore
        }finally {
            driver.context("FLUTTER");
        }
    }

    public enum Time {
        DAY,
        MONTH,
        YEAR;
    }

    /**
     * Check native locator is displayed
     *
     * @param element
     * @param wait
     */
    public static boolean checkElementDisplayed(WebDriverWait wait, Query element){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element.by()));
            if (element.findWebElement().isDisplayed())
                return true;
        }
        catch (NoSuchElementException e){
            System.out.println("NoSuchElementException");
        }
        catch (TimeoutException e){
            System.out.println("TimeoutException");
        }
        return false;
    }

    /**
     * Function to swipe down a certain distance
     *
     * @param moveOffset
     * */
    public static void swipeOffset(int moveOffset) {
        swipeScreen(DOWN,moveOffset,1500,1500);
    }

    /**
     * Function to swipe up a certain distance
     *
     * @param moveOffset
     * */
    public static void swipeUpOffset(int moveOffset) {
        swipeScreen(DOWN,moveOffset,500,500);
    }

    public static String getTextElement(WebDriverWait wait, Query q) {
        WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(q.by()));
        return myElement.getText();
    }

    /**
     * Compare 2 arrays equals, but difference in order
     *
     * @param arrayList1
     * @param arrayList2
     * */
    public static Boolean compareArray(String[] arrayList1, String[] arrayList2) {
        HashSet<String> set1 = new HashSet<String>(Arrays.asList(arrayList1));
        HashSet<String> set2 = new HashSet<String>(Arrays.asList(arrayList2));
        return set1.equals(set2);
    }

    /**
     * Find all bound's coordinates of an element, including 4 corners of it
     *
     * @param buttonFinder
     * */
    public static void highByCoordinates ( MobileElement buttonFinder) {

        Map bottomLeft = (Map) driver.executeScript("flutter:getBottomLeft", buttonFinder);
        JSONObject topObjectBottomLeft = new JSONObject(bottomLeft);

        Map bottomRight = (Map) driver.executeScript("flutter:getBottomRight", buttonFinder);
        JSONObject topObjectBottomRight  = new JSONObject(bottomRight);

        Map center = (Map) driver.executeScript("flutter:getCenter", buttonFinder);
        JSONObject topObjectcenter= new JSONObject(center);

        Map topLeft = (Map) driver.executeScript("flutter:getTopLeft", buttonFinder);
        JSONObject topObjectTopLeft  = new JSONObject(topLeft);

        Map topRight = (Map) driver.executeScript("flutter:getTopRight", buttonFinder);
        JSONObject topObjectTopRight  = new JSONObject(topRight);

        driver.context("NATIVE_APP");

        Dimension size = driver.manage().window().getSize();

        int widthd = size.getWidth();
        int heigth = size.getHeight();
        int a = 3;

        System.out.println(widthd+"-"+heigth);

        int detaWidthBottomLeft = topObjectBottomLeft.getInt("dx")*a;
        int detaHeigthBottomLeft=  topObjectBottomLeft.getInt("dy")*a - 10;

        System.out.println(detaWidthBottomLeft+"-"+detaHeigthBottomLeft);

        int detaWidthBottomRight =  topObjectBottomRight.getInt("dx")*a;
        int detaHeigthBottomRight=  topObjectBottomRight.getInt("dy")*a- 10;

        System.out.println(detaWidthBottomRight+"-"+detaHeigthBottomRight);

        int detaWidthcenter= topObjectcenter.getInt("dx")*a;
        int detaHeigthcenter=  topObjectcenter.getInt("dy")*a- 10;

        System.out.println(detaWidthcenter+"-"+detaHeigthcenter);

        int detaWidthTopLeft=  topObjectTopLeft.getInt("dx")*a;
        int detaHeigthTopLeft=  topObjectTopLeft.getInt("dy")*a- 10;

        System.out.println(detaWidthTopLeft+"-"+detaHeigthTopLeft);

        int detaWidthTopRight =  topObjectTopRight.getInt("dx")*a;
        int detaHeigthTopRight=  topObjectTopRight.getInt("dy")*a- 10;

        System.out.println(detaWidthTopRight+"-"+detaHeigthTopRight);
        // move 10 pixels to left
        int xOffset = 10;
        int yOffset = 0;
        TouchAction action = new TouchAction((AndroidDriver) driver);
        action.press(PointOption.point( detaWidthBottomLeft,  detaHeigthBottomLeft))
                .moveTo(PointOption.point(detaWidthBottomRight ,  detaHeigthBottomRight))
                .moveTo(PointOption.point(detaWidthcenter , detaHeigthcenter))
                .moveTo(PointOption.point(detaWidthTopLeft ,  detaHeigthTopLeft))
                .moveTo(PointOption.point(detaWidthTopRight, detaHeigthTopRight)).release().perform();
        driver.context("FLUTTER");
    }

    /**
     * This function will find the element and get its points on coordinates, then click by coordinates
     *
     * @param finder
     * @param weight
     * */
    public static void findAndClickCoordinates(MobileElement finder, int weight) {
        Map center = (Map) driver.executeScript("flutter:getCenter", finder);
        JSONObject topObjectCenter= new JSONObject(center);
        sleepTo(500);

        driver.context("NATIVE_APP");
        Dimension size = driver.manage().window().getSize();
        int deltaHorizontal= topObjectCenter.getInt("dx")*3;
        int deltaVertical=  topObjectCenter.getInt("dy")*3 - 10 - weight;

        new TouchAction(driver)
                .tap(point(deltaHorizontal,deltaVertical))
                .waitAction(waitOptions(ofMillis(500))).perform();

        driver.context("FLUTTER");
    }

    /** Hàm kiểm tra giá trị văn bản (text)
     * author: HungNDT2
     * Description: Hàm matchFound gồm 2 gái trị input đầu vào "giá trị làm mẫu" (patternValue - đây là chuỗi regular expression) và "giá trị cần kiềm tra" (value - normal text)
     * Ex: Khi muốn duyệt 1 chuỗi "102.356đ/tháng" đúng form "<giá tiền>đ/tháng", chúng ta sẽ dùng regex dạng /\d+.\d+đ/\tháng/ => matchFound("\d+.\d+đ/\tháng","102.356đ/tháng") => trả ra true nếu khớp và ngược lại
     * Input: String - patternValue: chuỗi regular expression dùng làm mẫu
     *        String - value: chuỗi văn bản dạng normal text để được kiểm tra
     * Output: Trả về giá trị true hoặc false
     * */
    public static Boolean matchFound(String patternValue, String value) {
        Pattern pattern = Pattern.compile(patternValue);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    /**
     * Hàm lấy một chuỗi ký tự từ một chuỗi
     * author: HungNDT2
     * Input: String - patternRegex: là chuỗi regular expression mẫu dùng để so sánh
     *        String - str: là chuỗi ban đầu
     * Output: trả ra chuỗi cần lấy
     * */
    public static String getStringFromOtherString(String patternRegex, String str) {
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(2);
        } else {
            return null;
        }
    }
}
