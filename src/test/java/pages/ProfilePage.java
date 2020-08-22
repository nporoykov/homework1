package pages;

import org.openqa.selenium.WebDriver;

public class ProfilePage extends AbstractPage {
    public ProfilePage(WebDriver driver) { super(driver); }

    public PrivateDataPage openPrivateDataPage(String url) {
        driver.get(url);

        return new PrivateDataPage(driver);
    }

}
