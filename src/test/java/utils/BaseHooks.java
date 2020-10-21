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
    private static Logger logger = LogManager.getLogger(HomeworkTest.class);
    protected static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeClass
    public static void setup() {
        driver = WebDriverFactory.createDriver(WebDriverType.FIREFOX);
        logger.debug("Подняли WebDriver");

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
            logger.debug("WebDriver закрыт");
        }
    }

    @After
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

}
