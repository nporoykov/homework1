package cases;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import pages.*;
import utils.*;
//import utils.BaseHooks;


public class LoginAuthAndFill extends BaseHooks{

    @Test
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


    //    ProfilePage profilePage = new ProfilePage(driver);
//        profilePage.openPrivateDataPage(cfg.url2());
//
//        PrivateDataPage privateDataPage = new PrivateDataPage(driver);
//        privateDataPage.putSurAndName("Petr", "Petrov")
//                .putBirth("10.10.1980")
//                .putGender()
//                .putCountry()
//                .putCity()
//                .putEnglish()
//                .savePage();

    }

}