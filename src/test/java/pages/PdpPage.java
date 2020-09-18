package pages;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class PdpPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(PdpPage.class);
    private String catalogPrice;
 //   //uc-pdp-price-view/span
 //   @FindBy(xpath = "//meta[contains(@itemprop,'price')]")
 //   private WebElement pdpPrice;

    @FindBy(xpath = "//meta[contains(@itemprop,'price')]")
    private WebElement pdpPrice;


    public PdpPage(WebDriver driver, String price) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.catalogPrice = price;
    }

   public PdpPage checkPrice(){
       String price = pdpPrice.getAttribute("content").toString().replaceAll(" ", "");
       assertEquals(catalogPrice, price);

       return this;
   }


}
