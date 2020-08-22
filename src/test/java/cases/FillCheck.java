package cases;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PrivateDataPage;
import pages.ProfilePage;
import utils.WebDriverFactory;
import utils.WebDriverType;

public class FillCheck {

    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    WebDriverFactory factory = new WebDriverFactory();
    WebDriver driver = factory.createDriver(WebDriverType.FIREFOX);

    @Test
    public void fillCheck() throws InterruptedException {
        WebDriverFactory factory = new WebDriverFactory();
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
