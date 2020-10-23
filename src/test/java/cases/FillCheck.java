package cases;

import config.ServerConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.PrivateDataPage;
import pages.ProfilePage;
import utils.BaseHooks;
import utils.WebDriverFactory;
import utils.WebDriverType;

public class FillCheck extends BaseHooks{


    @Test
    @Epic("Проверка OTUS")
    @Feature("Авторизация и проверка заполненных полей профиля")
    public void fillCheck() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open(cfg.url())
                .clickAuth()
                .auth(cfg.login(), cfg.pass())
                .openPrivateDataPage(cfg.url2())
                .assertSurAndName()
                .assertBirth()
                .assertGender()
                .assertCountry()
                .assertCity()
                .assertEnglish();

    }

}
