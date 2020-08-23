package cases;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.*;
import pages.*;
import utils.*;
//import utils.BaseHooks;


public class LoginAuthAndFill extends BaseHooks{

 //   @BeforeClass
   public static void callsetup(){
                BaseHooks.setup();
    }

   // private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
  //  WebDriverFactory factory = new WebDriverFactory();
  //  WebDriver driver = factory.createDriver(WebDriverType.FIREFOX);

    @Test
    public void loginAndAuthFill() throws InterruptedException {
     //   WebDriverFactory factory = new WebDriverFactory();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open(cfg.url())
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

 //   @AfterClass
    public static void callteardown(){
        BaseHooks.teardown();
    }
}
