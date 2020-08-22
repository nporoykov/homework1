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
        private Logger logger = LogManager.getLogger(HomeworkTest.class);
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

     /*
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

        */

         WebDriverFactory factory = new WebDriverFactory();

        public PrivateDataPage(WebDriver driver) {
            super(driver);
        }

        public PrivateDataPage putSurAndName(String name, String surname){
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(fname)).sendKeys(name);
            driver.findElement(sname).sendKeys(surname);

            return this;
        }

    public PrivateDataPage putBirth(String date){
        driver.findElement(birth).sendKeys(date);

        return this;
    }

    public PrivateDataPage putGender(){
        Select dropdown = new Select(driver.findElement(gender));
        dropdown.selectByValue("m");

        return this;
    }

    public PrivateDataPage putCountry(){
        driver.findElement(countryDiv).click();
        driver.findElement(countryButton).click();

        return this;
    }

    public PrivateDataPage putCity(){
        driver.findElement(cityDiv).click();
        driver.findElement(cityButton).click();

        return this;
    }

    public PrivateDataPage putEnglish(){
        driver.findElement(engDiv).click();
        driver.findElement(engButton).click();

        return this;
    }

    public PrivateDataPage savePage(){
        driver.findElement(engButtonCont).click();

        return this;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public PrivateDataPage assertSurAndName(){
        assertNotNull(new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated(fname)));
        assertNotNull(driver.findElement(sname));

        return this;
    }

    public PrivateDataPage assertBirth(){
        assertNotNull(driver.findElement(birth));

        return this;
    }

    public PrivateDataPage assertGender(){
        assertNotNull(driver.findElement(gender));

        return this;
    }

    public PrivateDataPage assertCountry(){
        assertNotNull(driver.findElement(countryDiv));

        return this;
    }

    public PrivateDataPage assertCity(){
        assertNotNull(driver.findElement(cityDiv));

        return this;
    }

    public PrivateDataPage assertEnglish(){
        assertEquals("Продвинутый (Advanced)", driver.findElement(engDiv).getText().toString());

        return this;
    }


}
