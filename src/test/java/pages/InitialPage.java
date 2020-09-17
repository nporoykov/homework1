package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InitialPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(InitialPage.class);

       @FindBy(xpath = "//product-card[contains(@product-id,'81933675')]")
       private WebElement cardArticul;
       //private By engButton = By.xpath("//product-card[contains(@product-id,'81933675')]");  //локатор карточки в каталоге

    

     public InitialPage(WebDriver driver) {
         super(driver);
         PageFactory.initElements(driver, this);
    }

    public InitialPage open(String url) {
        driver.get(url);
        logger.info("Открыта страница "+url);

        return this;
    }

    public ProfilePage auth(String account, String pass) {
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(accField)).sendKeys(account);
        passField.sendKeys(pass);
        logButton.click();
        logger.info("Залогинились на сайте");

        return new ProfilePage(driver);
    }
}


