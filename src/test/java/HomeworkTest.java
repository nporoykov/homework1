import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HomeworkTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HomeworkTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
     //   WebDriverManager.chromedriver().setup();
     //     driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        logger.info("Драйвер поднят");
    }
    @Test
    public void openPage() {
        driver.get(cfg.url());
        logger.info("Открыта страница "+cfg.url());
       // String actualTitle = driver.getTitle();
      //  Да, спасибо
     //   new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='Да, спасибо']/parent::button"))).click();
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//button[@id='27903767-tab']"))).click();
        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//a[text()='Мобильные телефоны']"))).click();
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='HONOR']"))).click();
        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='Xiaomi']"))).click();
        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//button[text()='по цене']"))).click();
        // String locator = "article[6]/div[2]/div/div";
        //WebElement icon = driver.findElement(By.xpath(locator));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(icon).click().build().perform();
        String locator = "//img[contains(@alt,'Смартфон HONOR')]/parent::a";
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(locator))).perform();
        builder.moveToElement(driver.findElement(By.xpath("//img[contains(@alt,'Смартфон HONOR')]/parent::a/preceding-sibling::div/div[1]/div"))).click().perform();

     //   Actions action = new Actions(driver);
    //    WebElement we = driver.findElement(By.xpath(locator));
    //    action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//img[contains(@alt,'Смартфон HONOR')]/parent::a/preceding-sibling::div/div[1]/div"))).click().build().perform();


      //  because another element <div class="_2LvbieS_AO _1oZmP3Lbj2"> obscures it
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//img[contains(@alt,'Смартфон HONOR')]/parent::a/preceding-sibling::div/div[1]/div"))).click();
       // new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//article[8]/div[2]/div/div"))).click();

      //  driver.findElement(By.xpath("//img[contains(@alt,'Смартфон HONOR')]/parent::a/preceding-sibling::div/div[1]/div")).click();
   //     /html/body/div[2]/div[6]/div[2]/div/div[1]/div/div/div/article[6]/div[2]/div[1]/div

    ///preceding-sibling::div/div[contains(@aria-label,'избранное')]/div
        //    driver.findElement(By.xpath("//article[6]/div[2]/div/div")).click();
     //   Товар Смартфон HONOR 7S 1/16GB добавлен к сравнению
    //    asser
     //   String actualString = driver.findElement(By.xpath("//div[contains(text(),'Товар Смартфон HONOR')]")).getText();
     //   assertTrue(actualString.contains("добавлен к сравнению"));
      //  driver.findElement(By.xpath("//article[9]/div[2]/div/div")).click();

        //      href="/product--smartfon-honor
  //    img  alt="Смартфон HONOR 7S 1/16GB"

        //String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        //assertEquals(expectedTitle,actualTitle);
       // assertNotNull(actualTitle);
    }

  /*  @Test
    public void checkTitle() {
        String actualTitle = driver.getTitle();
        assertNotNull(actualTitle);
        logger.info("Title не NULL на странице "+cfg.url());
    } */


    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
//////////////////////////////////////////////////////////////////// ниже добавлено 26.07.2020//////////////////////
/*
public class SampleTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    ////////////Factory/////2nd homework///////////////////
    interface Driver{
        void driverCreation(String option);
    }

    class Chrome implements Driver{
        @Override
        public void driverCreation(String option){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(option);
            driver = new ChromeDriver(options);
            logger.info("Драйвер Chrome поднят");
        }
    }

    class Firefox implements Driver{
        @Override
        public void driverCreation(String option){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(option);
            driver = new FirefoxDriver(options);
            logger.info("Драйвер Firefox поднят");
        }
    }

    class WebDriverFactory{
        public Driver create(String typeOfDriver, String...options){
            switch (typeOfDriver){
                case "Chrome": return new Chrome(options[1], options[1]);
                case "Firefox": return new Firefox();
                default: return null;
            }
        }
    }

////////////Factory/////2nd homework///////////////////

    /*@Test
    public void Log(){

    logger.info("this is info");
    logger.error("this is error");
    logger.fatal("this is fatal");
    logger.debug("this is debug");
    } */
/*
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        logger.info("Драйвер поднят");
    }

    @Test
    public void cookieCreation(){
        driver.get("https://otus.ru/");
        driver.manage().addCookie(new Cookie("Otus1", "Value1"));
        logger.info("Создан КУКИ Otus1 со значением "+ driver.manage().getCookieNamed("Otus1"));
        driver.manage().addCookie(new Cookie("Otus2", "Value2"));
        //logger.info("Создан КУКИ Otus2 со значением "+ driver.manage().getCookieNamed("Otus2"));
        Cookie cookie=new Cookie("Otus3", "Value3");
        driver.manage().addCookie(cookie);
        //logger.info("Создан КУКИ Otus3 со значением "+ driver.manage().getCookieNamed("Otus3"));
        driver.manage().addCookie(new Cookie("Otus4", "Value4"));
        //logger.info("Создан КУКИ Otus4 со значением "+ driver.manage().getCookieNamed("Otus4"));
        driver.manage().deleteCookieNamed("Otus2");
        logger.info("удалили куки Otus2");
        driver.manage().deleteCookie(cookie);
        logger.info("удалили куки Otus2");
        driver.manage().deleteAllCookies();
        logger.info("Все КУКИ УДАЛЕНЫ. МАссив куков "+ driver.manage().getCookies().size());
    }

    // val tets:Int=0

    @Test
    public void setTimeOut() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(cfg.url());
        logger.info("Открыта страница отус "+cfg.url());
        driver.findElement(new By.ById("jivo_close_button")).click();
        //logger.info("30 секунд открылся чат jcont el.isDisplayed()="+el.isDisplayed());

    }



    @Test
    public void driverSize() {
        driver.get(cfg.url());
        driver.findElement(new By.ByLinkText("Рекрутерам")).click();
        //driver.manage().window().maximize();
        //logger.info("Открыта страница отус "+driver.manage().window().getSize());
        //Dimension demension = new Dimension(800, 600);
        //driver.manage().window().setSize(demension);
        //logger.info("Открыта страница отус "+driver.manage().window().getSize());
    }

    @Test
    public void yanTest() {
        driver.get("https://ya.ru");
        driver.findElement(new By.ById("text")).sendKeys("otus");
        driver.findElement(new By.ById("text")).sendKeys(Keys.ENTER);
        // driver.findElement(new By.ById("text")).;
        //driver.findElement(new By.ByClassName("button suggest2-form__button button_theme_websearch button_size_xl i-bem button_js_inited")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(new By.ByClassName("organic__url-text"))).click();
        //   new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//"))).click();
        //driver.manage().window().maximize();
        //logger.info("Открыта страница отус "+driver.manage().window().getSize());
        //Dimension demension = new Dimension(800, 600);
        //driver.manage().window().setSize(demension);
        //logger.info("Открыта страница отус "+driver.manage().window().getSize());
    }

    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
*/