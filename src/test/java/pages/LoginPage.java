package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;


public class LoginPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(HomeworkTest.class);
     private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
      private final String URL = cfg.url2();
       private By loginButton =  By.cssSelector("button.header2__auth");  //локатор раздела логина
        private By accField =  By.cssSelector("input.js-email-input");  //локатор поля аккаунта логина
         private By passField =  By.cssSelector("input.js-psw-input");  //локатор поля пароля логина
          private By logButton =  By.cssSelector("div.new-input-line>button");  //локатор кнопки логина

    WebDriverFactory factory = new WebDriverFactory();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(URL);

        return this;
    }

    public void clickAuth(){
        driver.findElement(logButton).click();
    }

    public void auth() {
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(accField)).sendKeys(cfg.login());
        driver.findElement(passField).sendKeys(cfg.pass());
        driver.findElement(logButton).click();
    }


}



/*public class pages.LoginPage extends pages.AbstractPage {
    private static final String URL = "https://github.com/";
    private By search = By.xpath("//input[@name='q']");

    public pages.LoginPage(WebDriver driver) {
        super(driver);
    }

    public pages.LoginPage open() {
        driver.get(URL);

        return this;
    }

    public SearchPage search(String text) {
        driver.findElement(search).sendKeys(text);
        driver.findElement(search).sendKeys(Keys.ENTER);

        return new SearchPage(driver);
    }

}*/
