package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;


public class LoginPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(LoginPage.class);
       private By loginButton =  By.cssSelector("button.header2__auth");  //локатор раздела логина
        private By accField =  By.cssSelector("input.js-email-input");  //локатор поля аккаунта логина
         private By passField =  By.cssSelector("input.js-psw-input");  //локатор поля пароля логина
          private By logButton =  By.cssSelector("div.new-input-line>button");  //локатор кнопки логина

  //  WebDriverFactory factory = new WebDriverFactory();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(String url) {
        driver.get(url);
        logger.info("Открыта страница "+"https://otus.ru\n");

        return this;
    }

    public LoginPage clickAuth(){
        driver.findElement(loginButton).click();
        logger.info("Перешли на подстраницу логина");

        return this;
    }

    public ProfilePage auth(String account, String pass) {
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfElementLocated(accField)).sendKeys(account);
        driver.findElement(passField).sendKeys(pass);
        driver.findElement(logButton).click();
        logger.info("Залогинились на сайте");

        return new ProfilePage(driver);
    }
}


