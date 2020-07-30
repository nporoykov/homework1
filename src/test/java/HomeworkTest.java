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
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class HomeworkTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(HomeworkTest.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
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
        try{
            new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='Да, спасибо']/parent::button"))).click();
            logger.info("Подтвержден регион");
        }catch (Exception e){logger.info("Нет выбора региона");}
       // new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//span[text()='Да, спасибо']/parent::button"))).click();
      //  new WebDriverWait(driver,60).until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//button[@id='27903767-tab']"))).click();
     //   new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//a[text()='Мобильные телефоны']"))).click();
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='HONOR']"))).click();
        logger.info("Фильтрация по HONOR");
        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='Xiaomi']"))).click();
        logger.info("+ Фильтрация по Xiaomi");
        new WebDriverWait(driver,4).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//button[text()='по цене']"))).click();
        logger.info("Фильтрация по цене(от меньшей к большей)");
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div._2LvbieS_AO._1oZmP3Lbj2")));
        logger.info("Подождали пока скроется loader");

      driver.findElement(By.xpath("//a[contains(@title,'Смартфон HONOR')]/ancestor::article//div[contains(@aria-label,'сравнению')]")).click();
      logger.info("Добавился первый в списке HONOR");
        String fin1 = "Товар " + driver.findElement(By.xpath("//a[contains(@title,'Смартфон HONOR')]")).getAttribute("title").toString() + " добавлен к сравнению";
        String checkString1 = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Товар Смартфон HONOR')]"))).getText();
        assertEquals(fin1, checkString1);
        logger.info("Проверили, что отобразилась плашка \"Товар HONOR добавлен к сравнению\"");


      driver.findElement(By.xpath("//a[contains(@title,'Смартфон Xiaomi Redmi')]/ancestor::article//div[contains(@aria-label,'сравнению')]")).click();
      logger.info("Добавился первый в списке Xiaomi");
    //  String str2 = driver.findElement(By.xpath("//a[contains(@title,'Смартфон Xiaomi Redmi')]")).getAttribute("title").toString();
      String fin2 = "Товар " + driver.findElement(By.xpath("//a[contains(@title,'Смартфон Xiaomi Redmi')]")).getAttribute("title").toString() + " добавлен к сравнению";
      String checkString2 = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Товар Смартфон Xiaomi Redmi')]"))).getText();
      assertEquals(fin2, checkString2);
      logger.info("Проверили, что отобразилась плашка \"Товар HONOR добавлен к сравнению\"");

          driver.findElement(By.xpath("//span[text()='Сравнить']")).click();
          logger.info("Перешли в раздел Сравнение");

          List<WebElement> smartPhones = driver.findElements((By.xpath("//img[contains(@alt,'Смартфон ')]")));
          assertEquals(2, smartPhones.size());
          logger.info("Проверили, что в списке товаров 2 позиции");

        driver.findElement(By.xpath("//button[text()='Все характеристики']")).click();
        logger.info("Нажали на опцию \"все характеристики\"");
        driver.findElement(By.xpath("//div[text()='Операционная система']"));
        logger.info("Проверили, что в списке характеристик появилась позиция \"Операционная система\"");

        driver.findElement(By.xpath("//button[text()='Различающиеся характеристики']")).click();
        logger.info("Нажали на опцию \"различающиеся характеристики\"");
        assertEquals(0, driver.findElements(By.xpath("//div[text()='Операционная система']")).size());
        logger.info("Проверили, что позиция \"Операционная система\" не отображается в списке характеристик");

    }


    @After
    public void setDown() {
        if (driver != null) {
           driver.quit();
        }
    }


}
