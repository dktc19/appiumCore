package MyRunner;

import net.fpt.driver.CreateDriver;
import net.fpt.utils.SquashAPIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.List;


import static net.fpt.utils.SquashAPIUtil.*;


public class RunCucumberByCompositionBase {
    static final Logger logger = LoggerFactory.getLogger(RunCucumberByCompositionBase.class);

    @BeforeSuite
    public void beforeSuite(ITestContext context) throws Exception {
        logger.info("<<< BeforeSuite >>>");

    }




}

