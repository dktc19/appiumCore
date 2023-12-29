package net.fpt.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.fpt.constants.GlobalConstants;
import net.fpt.utils.PropertyUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

public class CreateDriver {
    static final Logger logger = LoggerFactory.getLogger(CreateDriver.class);
    private static CreateDriver instance = null;
    private static final int IMPLICIT_TIMEOUT = 0;

    private ThreadLocal<WebDriver> webDriver= new ThreadLocal<>();
    private ThreadLocal<String> sessionID = new ThreadLocal<String>();
    private ThreadLocal<String> sessionBrowser = new ThreadLocal<>();
    private ThreadLocal<String> sessionPlatform = new ThreadLocal<>();
    private ThreadLocal<String> sessionVersion = new ThreadLocal<>();
    private ThreadLocal<AppiumDriver<MobileElement>> mobileDriver = new ThreadLocal<AppiumDriver<MobileElement>>();

    private String getEnv = null;
    private Properties props = new Properties();

    // constructor
    private CreateDriver() {
    }
    /**
     * getInstance method to retrieve active driver instance
     *
     * @return CreateDriver
     */
    public static CreateDriver getInstance() {
        if ( instance == null ) {
            instance = new CreateDriver();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    /**
     * browser: Chrome, Firefox, Internet Explorer, Microsoft Edge, Opera, Safari(iPhone/iPad, or Android for mobile)
     * platform: Linux, Windows, Mac, iOS, Android
     * environment: Local, remote, and Sauce Labs
     * Map of driver preferences (this will be covered later in detail)
     * */
    public final void setDriver(String browser, String platform, String environment //Map<String, Object> optPreferences
    )throws Exception {
        logger.info("Create browser: "+  browser + "- platform: "+ platform + "- environment: " + environment);
        final boolean proxyEnabled = Boolean.getBoolean("proxyEnabled");
        final String proxyHostname = System.getProperty("proxyHost");
        final Integer proxyPort = Integer.getInteger("proxyPort");
        final String proxyDetails = String.format("%s:%d", proxyHostname, proxyPort);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String getPlatform = null;
        String localHub = "http://127.0.0.1:4723";
        String remoteURL = System.getenv("appiumRemoteURL");
        String seleniumGridRemoteURL = System.getenv("seleniumGridRemoteURL");
        //String seleniumGridRemoteURL = "http://seleniumhub.fpt.net/wd/hub";

        if (remoteURL != null){
            localHub = "http://"+ remoteURL + ":4723";
        }

        // load properties from file...
        props.load(new FileInputStream(GlobalConstants.SE_PROPS));

        // Setup browser and environment
        switch (browser){
            case "android":
                String dir = System.getProperty("user.dir") + PropertyUtils.getProperty("android.app.location");
                if (remoteURL != null){
                    dir = PropertyUtils.getProperty("android.app.location");
                }
                capabilities.setCapability(MobileCapabilityType.APP, dir);
                capabilities.setCapability("appium:applicationName", PropertyUtils.getProperty("android.app.packageName"));
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyUtils.getProperty("android.device.name"));
                capabilities.setCapability(MobileCapabilityType.UDID, PropertyUtils.getProperty("android.ud.id"));
                capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
                capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Flutter");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                capabilities.setCapability("appium:androidDeviceReadyTimeout", 160);

                capabilities.setCapability("appium:newCommandTimeout", 120);
                capabilities.setCapability("appium:adbExecTimeout", 100000);
                capabilities.setCapability("appium:appWaitForLaunch", true);

                //setup for flutter
                capabilities.setCapability("appium:retryBackoffTime", 30000);
                capabilities.setCapability("appium:maxRetryCount", 30);

                //setup for uiautomator2
                capabilities.setCapability("appium:systemPort", 8200);
                capabilities.setCapability("appium:uiautomator2ServerInstallTimeout", 45000);
                capabilities.setCapability("appium:uiautomator2ServerLaunchTimeout", 45000);
                if ( environment.equalsIgnoreCase("local") ) {
                    logger.info("Start local");
                    mobileDriver.set(new AndroidDriver<MobileElement>
                            (new URL(localHub),capabilities));
                }

                if(environment.equalsIgnoreCase("remote")){

                }
                break;

            case "ios":
                capabilities = DesiredCapabilities.iphone();
                // then pass them to the local WebDriver or RemoteWebDriver
                if ( environment.equalsIgnoreCase("local") ) {
                    mobileDriver.set(new IOSDriver<MobileElement>
                            (new URL(localHub), capabilities));
                }
                break;

            case "chrome":
                HashMap<String, Object> chromePreferences = new HashMap<>();
                chromePreferences.put("profile.password_manager_enabled"
                        ,false);
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();

                chromeOptions.addArguments("--no-default-browser-check");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.setExperimentalOption("prefs",
                        chromePreferences);

                chromeOptions.merge(capabilities);

                if(seleniumGridRemoteURL != null) {
                    //capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.valueOf(platform.toUpperCase()));
                    //capabilities.setCapability(CapabilityType.VERSION, desiredBrowserVersion);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                    if (proxyEnabled) {
                        Proxy proxy = new Proxy();
                        proxy.setHttpProxy(proxyDetails);
                        proxy.setSslProxy(proxyDetails);
                        chromeOptions.setCapability("proxy", proxy);
                    }
                    webDriver.set(new RemoteWebDriver(new URL(seleniumGridRemoteURL), chromeOptions));
                } else {
                    WebDriverManager.chromedriver().setup();
                    webDriver.set(new ChromeDriver(chromeOptions));
                }
                break;

            case "firefox":
                FirefoxProfile profile = new FirefoxProfile();

                //cho phép localtion pop-up
                profile.setPreference("geo.prompt.testing", true);
                profile.setPreference("geo.prompt.testing.allow", true);
                profile.setPreference("geo.enabled", true);
                //profile.setPreference("geo.wifi.uri", "data:application/json,{\"status\":\"OK\",\"accuracy\":10.0,\"location\":{\"lat\":45.0,\"lng\":-122.0}}");
                //profile.setPreference("geo.wifi.uri", System.getProperty("user.dir") + "/src/test/java/test_data_files/geoLocation.json");

                FirefoxOptions options = new FirefoxOptions();
                options.merge(capabilities);
                options.setAcceptInsecureCerts(false);
                options.setProfile(profile);

                if(seleniumGridRemoteURL != null) {
                    //String desiredBrowserVersion = System.getProperty("desiredBrowserVersion");
                    //String desiredPlatform = System.getProperty("desiredPlatform");
                    //capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.valueOf(desiredPlatform.toUpperCase()));
                    //capabilities.setCapability(CapabilityType.VERSION, desiredBrowserVersion);
                    capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                    if (proxyEnabled) {
                        Proxy proxy = new Proxy();
                        proxy.setHttpProxy(proxyDetails);
                        proxy.setSslProxy(proxyDetails);
                        options.setCapability("proxy", proxy);
                    }
                    webDriver.set(new RemoteWebDriver(new URL(seleniumGridRemoteURL), options));
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver.set(new FirefoxDriver(options));
                }
                break;
        }

        getEnv = environment;
        getPlatform = platform;

        if ( browser.equalsIgnoreCase("iphone") ||
                browser.equalsIgnoreCase("android") ) {
            sessionID.set((mobileDriver.get()).getSessionId().toString());
            sessionBrowser.set(browser);
            sessionVersion.set(capabilities.getCapability("deviceName").toString());
            sessionPlatform.set(getPlatform);
        }
        else {
            sessionID.set(((RemoteWebDriver) webDriver.get())
                    .getSessionId().toString());
            sessionBrowser.set(capabilities.getBrowserName());
            sessionVersion.set(capabilities.getVersion());
            sessionPlatform.set(getPlatform);
        }
    }

    /**
     * overloaded setDriver method to switch driver to specific WebDriver
     * if running concurrent drivers
     *
     * @param driver WebDriver instance to switch to
     */
    public void setDriver(WebDriver driver) {
        webDriver.set(driver);
        sessionID.set(((RemoteWebDriver) webDriver.get())
                .getSessionId().toString());
        sessionBrowser.set(((RemoteWebDriver) webDriver.get())
                .getCapabilities().getBrowserName());
        sessionPlatform.set(((RemoteWebDriver) webDriver.get())
                .getCapabilities().getPlatform().toString());
        //setBrowserHandle(getDriver().getWindowHandle());
    }

    /**
     * overloaded setDriver method to switch driver to specific AppiumDriver
     * if running concurrent drivers
     *
     * @param driver AppiumDriver instance to switch to
     */
    public void setDriver(AppiumDriver<MobileElement> driver) {
        mobileDriver.set(driver);
        sessionID.set(mobileDriver.get()
                .getSessionId().toString());
        sessionBrowser.set(mobileDriver.get()
                .getCapabilities().getBrowserName());
        sessionPlatform.set(mobileDriver.get()
                .getCapabilities().getPlatform().toString());
    }


    /**
     * getDriver method to retrieve active driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return webDriver.get();
    }
    /**
     * getDriver method will retrieve the active AppiumDriver
     *
     * @param mobile boolean parameter
     * @return AppiumDriver
     */
    public AppiumDriver<MobileElement> getDriver(boolean mobile) {
        return mobileDriver.get();
    }

    /**
     * getCurrentDriver method will retrieve the active WebDriver
     * or AppiumDriver
     *
     * @return WebDriver
     */
    public WebDriver getCurrentDriver() throws Exception {
        if (getInstance().getSessionBrowser().contains("iphone") ||
                getInstance().getSessionBrowser().contains("ipad") ||
                getInstance().getSessionBrowser().contains("ios") ||
                getInstance().getSessionBrowser().contains("android")) {
            return getInstance().getDriver(true);
        } else {
            return getInstance().getDriver();
        }
    }

    /**
     * closeDriver method to close active driver
     *
     */
    public void closeDriver() {
        try {
            getCurrentDriver().quit();
        }
        catch ( Exception e ) {
            // do something
        }
    }
    /**
     * getSessionId method to retrieve active id
     *
     * @return String
     * @throws Exception
     */
    public String getSessionId() throws Exception {
        return sessionID.get();
    }
    /**
     * getSessionBrowser method to retrieve active browser
     * @return String
     * @throws Exception
     */
    public String getSessionBrowser() throws Exception{
        return sessionBrowser.get();
    }
    /**
     * getSessionVersion method to retrieve active version
     *
     * @return String
     * @throws Exception
     */
    public String getSessionVersion() throws Exception {
        return sessionVersion.get();
    }
    /**
     * getSessionPlatform method to retrieve active platform
     * @return String
     * @throws Exception
     */
    public String getSessionPlatform() throws Exception {
        return sessionPlatform.get();
    }
}
