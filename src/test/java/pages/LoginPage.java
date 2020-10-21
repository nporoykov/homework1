package pages;


import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;


public class LoginPage extends AbstractPage {
    private Logger logger = LogManager.getLogger(LoginPage.class);

       @FindBy(css="button.header2__auth") //локатор раздела логина
       private WebElement loginButton;

       @FindBy(css="input.js-email-input")  //локатор поля аккаунта логина
       private WebElement accField;

       @FindBy(css="input.js-psw-input")  //локатор поля пароля логина
       private WebElement passField;

       @FindBy(css="div.new-input-line>button")  //локатор кнопки логина
       private WebElement logButton;

     public LoginPage(WebDriver driver) {
         super(driver);
         PageFactory.initElements(driver, this);
    }

    @Step("Открытие страницу {url}")
    public LoginPage open(String url) {
        driver.get(url);
        logger.info(String.format("Открыта страница %s", url));

        return this;
    }

    @Step("Кликаем на кнопку логина и открывается страница авторизации")
    public LoginPage clickAuth(){
        loginButton.click();
        logger.info("Перешли на подстраницу логина");

        return this;
    }

    @Step("Вводим аккаунт={account} и пароль={pass}")
    public ProfilePage auth(String account, String pass) {
        new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOf(accField)).sendKeys(account);
        passField.sendKeys(pass);
        logButton.click();
        logger.info("Залогинились на сайте");

        return new ProfilePage(driver);
    }
}


