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
                .checkArticulExistance()
                .rememberCatPrice()
                .clickArticul()
                .checkPrice();


    }

}
