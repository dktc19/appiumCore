package page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import net.fpt.driver.CreateDriver;
import net.fpt.utils.FlutterActionUtil;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class BasePageObject {
    public static AppiumDriver driver;
    public WebDriverWait webDriverWait;
    public TouchAction touchAction;
    public FlutterActionUtil flutterActionUtil;

    public BasePageObject() {
        try {
            this.driver = CreateDriver.getInstance().getDriver(true);
        } catch (Exception ignored) {
            //This will be be thrown when the test starts if it cannot connect to a RemoteWebDriver Instance
        }
        webDriverWait = new WebDriverWait(driver, 30, 250);
        touchAction = new TouchAction(driver);
        flutterActionUtil = new FlutterActionUtil(driver);
    }
}
