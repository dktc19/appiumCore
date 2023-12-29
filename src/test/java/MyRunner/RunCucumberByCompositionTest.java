package MyRunner;

import io.cucumber.testng.*;
import net.fpt.driver.CreateDriver;
import net.fpt.utils.SquashAPIUtil;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.util.List;



@CucumberOptions(

      /*  features = "src/test/java/Features/todo.feature",*/
        glue = {"stepDefinitions"},
        plugin ={"html:target/cucumber-reports/reportHomepage.html", "json:target/cucumber-reports/CucumberTestReport.json","message:target/cucumber-report-feature-composite.ndjson"})

public class RunCucumberByCompositionTest extends  RunCucumberByCompositionBase  {

    private TestNGCucumberRunner testNGCucumberRunner;

    //public AppiumDriver driver;
    SquashAPIUtil.TestCaseOBJ tc;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber(ITestContext context) {
        logger.info("<<< BeforeClass >>>");
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @BeforeTest(alwaysRun = true)
    //@Parameters({ "browser", "version", "platform" })
    public void setUpClass(ITestContext context) throws Exception {
        logger.info("<<< BeforeTest >>>");
/*        CreateDriver.getInstance().setDriver("android",
                "android",
                "local"
        );*/
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature)
    {
        logger.info("<<< scenario "+ cucumberFeature +" >>>");
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @AfterTest(alwaysRun = true)
    //@Parameters({ "browser", "version", "platform" })
    public void tearDownTest(ITestContext context) {
    }


    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(ITestContext context) {
        logger.info("<<< AfterClass >>>");
        testNGCucumberRunner.finish();
    }
}
