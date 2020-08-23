package utils;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pages.HomeworkTest;

import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;
    protected static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    protected static Logger logger = LogManager.getLogger(BaseHooks.class);

    @BeforeClass
    public static void setup() {
        driver = WebDriverFactory.createDriver(WebDriverType.FIREFOX);

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

}
