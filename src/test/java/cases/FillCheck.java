package cases;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PrivateDataPage;
import pages.ProfilePage;
import utils.BaseHooks;
import utils.WebDriverFactory;
import utils.WebDriverType;

public class FillCheck extends BaseHooks{

    @Test
    public void fillCheck() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open(cfg.url())
                .clickAuth()
                .auth(cfg.login(), cfg.pass());


        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPrivateDataPage(cfg.url2());

        PrivateDataPage privateDataPage = new PrivateDataPage(driver);
        privateDataPage.assertSurAndName()
                       .assertBirth()
                       .assertGender()
                       .assertCountry()
                       .assertCity()
                       .assertEnglish();

    }

}
