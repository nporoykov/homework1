package cases;

import org.junit.Test;
import pages.InitialPage;
import pages.PrivateDataPage;
import pages.ProfilePage;
import utils.BaseHooks;

public class FillCheck extends BaseHooks{

    @Test
    public void fillCheck() throws InterruptedException {
        InitialPage initialPage = new InitialPage(driver);

        initialPage.open(cfg.url())
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
