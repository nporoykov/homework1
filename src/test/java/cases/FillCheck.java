package cases;

import org.junit.Test;
import pages.InitialPage;
import pages.PdpPage;
import utils.BaseHooks;

public class FillCheck extends BaseHooks{

    @Test
    public void fillCheck() throws InterruptedException {
        InitialPage initialPage = new InitialPage(driver);

        initialPage.open(cfg.url())
                .clickAuth()
                .auth(cfg.login(), cfg.pass());


        PdpPage pdpPage = new PdpPage(driver);
        pdpPage.openPrivateDataPage(cfg.url2());

        PrivateDataPage privateDataPage = new PrivateDataPage(driver);
        privateDataPage.assertSurAndName()
                       .assertBirth()
                       .assertGender()
                       .assertCountry()
                       .assertCity()
                       .assertEnglish();

    }

}
