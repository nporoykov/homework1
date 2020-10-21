package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfilePage extends AbstractPage {
    private Logger logger = LogManager.getLogger(ProfilePage.class);
    public ProfilePage(WebDriver driver) { super(driver); }

    @Step("Переходим на страницу {url}")
    public PrivateDataPage openPrivateDataPage(String url) {
        driver.get(url);
        logger.info(String.format("Перешли на страницу %s", url));

        return new PrivateDataPage(driver);
    }

}
