package cases;
import org.junit.*;
import pages.*;
import utils.*;
//import utils.BaseHooks;


public class LoginAuthAndFill extends BaseHooks{

    @Test
    public void loginAndAuthFill() throws InterruptedException {
     //   WebDriverFactory factory = new WebDriverFactory();
        InitialPage initialPage = new InitialPage(driver);

        initialPage.open(cfg.url())
                 .clickAuth()
                 .auth(cfg.login(), cfg.pass());


        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPrivateDataPage(cfg.url2());

        PrivateDataPage privateDataPage = new PrivateDataPage(driver);
        privateDataPage.putSurAndName("Petr", "Petrov")
                .putBirth("10.10.1980")
                .putGender()
                .putCountry()
                .putCity()
                .putEnglish()
                .savePage();

    }

}
