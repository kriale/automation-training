package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private final static String HOME_PAGE_URL = "https://www.ebookers.com/";

    @FindBy(id="header-account-menu")
    private WebElement menuAccountButton;

    @FindBy(id="account-signin")
    private WebElement accountMenuSignInButton;

    @FindBy(id="tab-hotel-tab-hlp")
    private WebElement hotelsSearchParamsPageMenuButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOf(hotelsSearchParamsPageMenuButton));
        return this;
    }

    public SignInPage openSignInPage() {
        menuAccountButton.click();
        accountMenuSignInButton.click();
        return new SignInPage(driver);
    }

    public HotelsSearchParamsPage openHotelsSearchParamsPage() {
        hotelsSearchParamsPageMenuButton.click();
        return new HotelsSearchParamsPage(driver);
    }
}
