package utils;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomeworkTest;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;
    protected static ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @BeforeClass
    public static void setup() throws MalformedURLException {
        String selenoidURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        caps.setVersion("80.0");
        caps.setCapability("enableVNC", true);
        caps.setCapability("screenResolution", "1280x1024");

        driver = new RemoteWebDriver(new URL(selenoidURL), caps);

       // driver = WebDriverFactory.createDriver(WebDriverType.FIREFOX);

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
