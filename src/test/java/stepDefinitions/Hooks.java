package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.fpt.driver.CreateDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static net.fpt.utils.PushImagesUtils.pushImages;

public class Hooks {
    static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    @Before
    public void setUp() throws Exception {
        logger.info("Before Step Definition");
        //chỉ chạy trên local host debug mode bằng cucumber
        CreateDriver.getInstance().setDriver("android",
                "android",
                "local"
        );
        pushImages();
    }

    @After
    public void embedScreenshot(Scenario scenario) throws IOException, InterruptedException {
        byte[] screenshot = ((TakesScreenshot) CreateDriver.getInstance().getDriver(true)).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
            CreateDriver.getInstance().closeDriver();
    }
}
