package pages;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfilePage extends AbstractPage {
    private Logger logger = LogManager.getLogger(ProfilePage.class);
    public ProfilePage(WebDriver driver) { super(driver); }

    public PrivateDataPage openPrivateDataPage(String url) {
        driver.get(url);
        logger.info("Перешли на страницу https://otus.ru/lk/biography/personal/");

        return new PrivateDataPage(driver);
    }

}
