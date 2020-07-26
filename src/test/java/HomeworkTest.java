import config.ServerConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class HomeworkTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HomeworkTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    public static String func(WebElement element){
        element.click();
        WebElement alert = new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(By.xpath("//ngb-alert[@type='success' and @class='alert alert-success alert-dismissible']")));
        String text = alert.getText();
        return text;
    }

    @Before
    public void setUp() {
      //  WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
     //   driver = new ChromeDriver();
       driver = new FirefoxDriver();
        //driver = new EdgeDriver();
        logger.info("Драйвер поднят");
      //  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


    }
    @Test
    public void openPage() throws InterruptedException {
        //1. Открыть otus.ru
        driver.get("https://ng-bootstrap.github.io/#/components/alert/examples");
       // driver.get(cfg.url2());
        logger.info("Открыта страница "+"https://ng-bootstrap.github.io/#/components/alert/examples\n");
       //2. Авторизоваться на сайте
/*String login = "sajare9105@mailsecv.com";
String pass = "Ataman777";
String locator = "button.header2__auth";
driver.findElement(By.cssSelector(locator)).click();
logger.info("Перешли на подстраницу логина");*/
      //  new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Change message')]")))).click();
      //  WebElement alert1 = driver.findElement(By.xpath("//ngb-alert[@type='success' and @class='alert alert-success alert-dismissible']"));
        String text1 = func(new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Change message')]")))));
        Thread.sleep(1000);
      //  new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Change message')]")))).click();
     //   WebElement alert2 = driver.findElement(By.xpath("//ngb-alert[@type='success' and @class='alert alert-success alert-dismissible']"));
        String text2 = func(new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(text(),'Change message')]")))));;
        assertNotEquals(text1, text2);





       /* new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.js-email-input"))).sendKeys(login);
        driver.findElement(By.cssSelector("input.js-psw-input")).sendKeys(pass);
        driver.findElement(By.cssSelector("div.new-input-line>button")).click();
        logger.info("Залогинились на сайте");
//3. Перейти в раздел о себе и заполнить поля
       // new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.js-main.js-tabs h1")));
       // new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.header2-menu__item-wrapper.header2-menu__item-wrapper__username"))).click();
       // new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(By.cssSelector("b.header2-menu__dropdown-text_name"))).click();
       driver.get("https://otus.ru/lk/biography/personal/");
       logger.info("Перешли на страницу https://otus.ru/lk/biography/personal/");

        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By.id("id_fname_latin"))).sendKeys("Testov");
        driver.findElement(By.cssSelector("#id_lname_latin")).sendKeys("Testov");
        driver.findElement(By.cssSelector("input[name=date_of_birth]")).sendKeys("07.02.1986");
        Select dropdown = new Select(driver.findElement(By.cssSelector("#id_gender")));
        dropdown.selectByValue("m");
        // Выбор страны
       driver.findElement(By.cssSelector("div[data-slave-selector*=js-lk-cv-dependent-slave-city]")).click();
       driver.findElement(By.cssSelector("button[title=США]")).click();
       //Выбор города
      //* driver.findElement(By.cssSelector("div[data-selected-option-class=lk-cv-block__select-option_selected]")).click();
      //* driver.findElement(By.cssSelector("button[title=Москва]")).click();
        driver.findElement(By.xpath("//div[2]/div[2]/div/label/div")).click();
        driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/button[2]")).click();
       // driver.findElement(By.xpath("//button[contains(@class,'lk-cv-block__select-option_selected' and contains(text(),'Продвинутый (Advanced)')])")).click();


        //Уровень знания английского
   //     driver.findElement(By.cssSelector("div[data-selected-option-class*=lk-cv-block__select-option_selected]")).click();
   //     driver.findElement(By.cssSelector("button[title=Продвинутый (Advanced)]")).click();
        driver.findElement(By.xpath("//div[3]/div[2]/div/label/div")).click();
//       driver.findElement(By.xpath("//div[contains(@data-selected-option-class='lk-cv-block__select-option_selected')]")).click();
   //     driver.findElement(By.xpath("//div[3]/div[2]/div/div/div/button[7]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Продвинутый (Advanced)')]")).click();

        //WebElement country=driver.findElement(new By.ByXPath("//div[contains(@data-slave-selector, '.js-lk-cv-dependent-slave-city')]"));
        //country.click();
        //  WebElement countryRF=driver.findElement(new By.ByXPath("//button[contains(text(),'Россия')]"));
        //  countryRF.click();

        driver.findElement(By.cssSelector("button[name=continue]")).click(); */


        //String actualTitle = driver.getTitle();
        //String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям";
        //assertEquals(expectedTitle,actualTitle);
        //assertNotNull(actualTitle);
    }

 /*   @Test
    public void checkPage(){
        //1. Открыть otus.ru
        driver.get("https://otus.ru/");
        logger.info("Открыта страница https://otus.ru/");
        //2. Авторизоваться на сайте
        String login = "sajare9105@mailsecv.com";
        String pass = "Ataman777";
        String locator = "button.header2__auth";
        driver.findElement(By.cssSelector(locator)).click();

        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.js-email-input"))).sendKeys(login);
        driver.findElement(By.cssSelector("input.js-psw-input")).sendKeys(pass);
        driver.findElement(By.cssSelector("div.new-input-line>button")).click();

        //3. Перейти в раздел о себе и заполнить поля
        // new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.js-main.js-tabs h1")));
        // new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.header2-menu__item-wrapper.header2-menu__item-wrapper__username"))).click();
        // new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(By.cssSelector("b.header2-menu__dropdown-text_name"))).click();
        driver.get("https://otus.ru/lk/biography/personal/");
        logger.info("Перешли на страницу https://otus.ru/lk/biography/personal/");

      //  new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By.id("id_fname_latin"))).sendKeys("Testov");
        assertNotNull(new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(By.id("id_fname_latin"))));
        assertNotNull(driver.findElement(By.cssSelector("#id_lname_latin")));
        assertNotNull(driver.findElement(By.cssSelector("input[name=date_of_birth]")));
        assertNotNull(driver.findElement(By.cssSelector("#id_gender")));
        // Выбор страны
        assertNotNull(driver.findElement(By.cssSelector("div[data-slave-selector*=js-lk-cv-dependent-slave-city]")));
        //Выбор города
        //* driver.findElement(By.cssSelector("div[data-selected-option-class=lk-cv-block__select-option_selected]")).click();
        //* driver.findElement(By.cssSelector("button[title=Москва]")).click();
        assertNotNull(driver.findElement(By.xpath("//div[2]/div[2]/div/label/div")));

        //Уровень знания английского
        //     driver.findElement(By.cssSelector("div[data-selected-option-class*=lk-cv-block__select-option_selected]")).click();
        //     driver.findElement(By.cssSelector("button[title=Продвинутый (Advanced)]")).click();
        assertEquals("Продвинутый (Advanced)", driver.findElement(By.xpath("//div[3]/div[2]/div/label/div")).getText().toString());

    }  */

   /* @Test
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
