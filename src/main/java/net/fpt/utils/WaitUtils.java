package net.fpt.utils;

import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static net.fpt.utils.FlutterActionUtil.isTextOnScreen;

/**
 * This will contain all wait related utility methods.
 *
 */

public class WaitUtils {

    /**
     * This method is for static wait
     *
     * @param millis
     */
    public static void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }

    /**
     * This method is for static wait
     *
     * @param second
     */
    public static void staticSecondWait(final long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (final InterruptedException e) {
        }
    }

    /**
     * This method is for static wait
     *
     * @param minutes
     */
    public static void staticMinuteWait(final int minutes) {
        try {
            TimeUnit.MINUTES.sleep(minutes);
        } catch (final InterruptedException e) {
        }
    }

    /**
     * To wait for button to be clickable
     *
     * @param wait
     * @param element
     */
    public static void waitForElementToBeClickable(final WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * To wait for element (By) to be invisible
     *
     * @param wait
     * @param locator
     */
    public static void waitForElementToBeInvisible(final By locator, WebDriverWait wait) {
        long s = System.currentTimeMillis();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * To wait for given element (By) to be present
     *
     * @param wait
     * @param locator
     */
    public static void waitForElementToBePresent(final By locator, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * To wait for element (By) to be visible
     *
     * @param wait
     * @param locator
     */
    public static void waitForElementToBeVisible(final By locator, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * To wait for element to be visible
     *
     * @param wait
     * @param element
     */
    public static void waitForElementToBeVisible(final WebElement element, WebDriverWait wait) {
        long s = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementsToBeInvisible(final List<WebElement> elements, WebDriverWait wait) {
        final long s = System.currentTimeMillis();
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void waitForElementToBeNotPresent(final By element, WebDriverWait wait) {
        long s = System.currentTimeMillis();
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(element)));
    }

    public static void waitUntilNestedElementPresent(WebElement element, By locator, WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, locator));
    }

    /**
     * Function to wait for a text by OCR
     *
     * @param text
     *
     * */
    public static void waitForOCR(String text) throws TesseractException {
        int count = 0;
        while (!isTextOnScreen(text)) {
            staticSecondWait(1);
            if (count > 60) {
                throw new AssertionError("Cannot find text.");
            }
            count++;
        }
    }

    /**
     * Function to wait for a text absent by OCR
     *
     * @param text
     *
     * */
    public static void waitForAbsentOCR(String text) throws TesseractException {
        int count = 0;
        while (isTextOnScreen(text)) {
            staticSecondWait(1);
            if (count > 60) {
                throw new AssertionError("Text is still present");
            }
            count++;
        }
    }
}
