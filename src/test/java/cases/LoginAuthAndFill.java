package cases;
import config.ServerConfig;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import pages.*;
import utils.*;
//import utils.BaseHooks;


public class LoginAuthAndFill extends BaseHooks{


    @Test
    @Epic("Регресс-тесты")
    @Feature("Тестирование otus.ru")
    @Story("Авторизация и заполнение полей профиля")
    public void loginAndAuthFill() throws InterruptedException {
     //   WebDriverFactory factory = new WebDriverFactory();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open(cfg.url())
                 .clickAuth()
                 .auth(cfg.login(), cfg.pass())
                 .openPrivateDataPage(cfg.url2())
                 .putSurAndName("Petr", "Petrov")
                 .putBirth("10.10.1980")
                 .putGender()
                 .putCountry()
                 .putCity()
                 .putEnglish()
                 .savePage();

    }

}
