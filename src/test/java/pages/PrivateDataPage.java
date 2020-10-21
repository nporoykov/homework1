package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;

import static org.junit.Assert.*;

public class PrivateDataPage extends AbstractPage{
    private Logger logger = LogManager.getLogger(PrivateDataPage.class);
        private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
       // private final String URL = cfg.url2();
        private By fname = By.cssSelector("#id_fname_latin");  //локатор
        private By sname = By.cssSelector("#id_lname_latin");  //локатор
        private By birth = By.cssSelector("input[name=date_of_birth]");  //локатор
        private By gender = By.cssSelector("#id_gender");  //локатор
        private By countryDiv = By.cssSelector("div[data-slave-selector*=js-lk-cv-dependent-slave-city]");  //локатор
        private By countryButton = By.cssSelector("button[title=США]");  //локатор
        private By cityDiv = By.xpath("//div[2]/div[2]/div/label/div");  //локатор
        private By cityButton = By.xpath("//div[2]/div[2]/div/div/div/button[2]");  //локатор
        private By engDiv = By.xpath("//div[3]/div[2]/div/label/div");  //локатор
        private By engButton = By.xpath("//button[contains(text(),'Продвинутый (Advanced)')]");  //локатор
        private By engButtonCont = By.cssSelector("button[name=continue]");  //локатор

         public PrivateDataPage(WebDriver driver) {
            super(driver);
        }

        public PrivateDataPage putSurAndName(String name, String surname){
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(fname)).sendKeys(name);
            driver.findElement(sname).sendKeys(surname);
            logger.info("Заполнили фамилию и имя");

            return this;
        }

    public PrivateDataPage putBirth(String date){
        driver.findElement(birth).sendKeys(date);
        logger.info("Заполнили дату рождения");

        return this;
    }

    public PrivateDataPage putGender(){
        Select dropdown = new Select(driver.findElement(gender));
        dropdown.selectByValue("m");
        logger.info("Указали пол");

        return this;
    }

    public PrivateDataPage putCountry(){
        driver.findElement(countryDiv).click();
        driver.findElement(countryButton).click();
        logger.info("Указали страну");

        return this;
    }

    public PrivateDataPage putCity(){
        driver.findElement(cityDiv).click();
        driver.findElement(cityButton).click();
        logger.info("Указали город");

        return this;
    }

    public PrivateDataPage putEnglish(){
        driver.findElement(engDiv).click();
        driver.findElement(engButton).click();
        logger.info("Указали уровень английского");

        return this;
    }

    public PrivateDataPage savePage(){
        driver.findElement(engButtonCont).click();
        logger.info("Нажали кнопку 'Сохранить'");

        return this;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public PrivateDataPage assertSurAndName(){
        assertNotNull(new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(fname)));
        assertNotNull(driver.findElement(sname));
        logger.info("Проверили, что поля имя/фамилию заполнены");

        return this;
    }

    public PrivateDataPage assertBirth(){
        assertNotNull(driver.findElement(birth));
        logger.info("Проверили, что поле дата рождения заполнено");

        return this;
    }

    public PrivateDataPage assertGender(){
        assertNotNull(driver.findElement(gender));
        logger.info("Проверили, что поле пол заполнено");

        return this;
    }

    public PrivateDataPage assertCountry(){
        assertNotNull(driver.findElement(countryDiv));
        logger.info("Проверили, что поле страна заполнено");

        return this;
    }

    public PrivateDataPage assertCity(){
        assertNotNull(driver.findElement(cityDiv));
        logger.info("Проверили, что поле город заполнено");

        return this;
    }

    public PrivateDataPage assertEnglish(){
        assertEquals("Продвинутый (Advanced)", driver.findElement(engDiv).getText().toString());

        return this;
    }


}
