package utils;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;
//HomeworkTest.class
public class BaseHooks {
    protected static WebDriver driver;
    protected static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    private static Logger logger = LogManager.getLogger(BaseHooks.class);

    @BeforeAll
    public static void setup() {
        driver = WebDriverFactory.createDriver(WebDriverType.FIREFOX);
        logger.debug("Подняли WebDriver");

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
            logger.debug("WebDriver закрыт");
        }
    }

    @AfterEach
    public void cleanUp() {
        driver.manage().deleteAllCookies();
    }

}
