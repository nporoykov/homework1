package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class InitialPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(InitialPage.class);

    @FindBy(xpath = "//product-card[contains(@product-id,'81933675')]")
    private WebElement cardArticul;

    @FindBy(xpath = "//product-card[contains(@product-id,'81933675')]//a")
    private WebElement cardArticulClick;

    private String artPrice;

    public InitialPage(WebDriver driver) {
         super(driver);
         PageFactory.initElements(driver, this);
    }

    public InitialPage open(String url) {
        driver.get(url);
        logger.info("Открыта страница https://leroymerlin.ru/catalogue/dveri/");

        return this;
    }

    public InitialPage checkArticulExistance(){
        String artNumber = cardArticul.getAttribute("product-id").toString();
        assertEquals("81933675", artNumber);

        return this;
    }

    public InitialPage rememberCatPrice() {
        artPrice = cardArticul.getAttribute("product-price").toString();

        return this;
    }

    public PdpPage clickArticul(){
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(cardArticul)).click();

        return new PdpPage(driver, artPrice);
    }

}


/*
try{
            new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//span[text()='Да, спасибо']/parent::button"))).click();
            logger.info("Подтвержден регион");
        }catch (Exception e){logger.info("Нет выбора региона");}

 */