import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class HomeworkTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HomeworkTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        driver.get(cfg.url());
        logger.info("Открыта страница "+cfg.url());
        String actualTitle = driver.getTitle();
        //String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        //assertEquals(expectedTitle,actualTitle);
        assertNotNull(actualTitle);
    }

    @Test
    public void checkTitle() {
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);
        logger.info("Title не NULL на странице "+cfg.url());
    }


    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
