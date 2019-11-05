package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {
    private final static String HOME_PAGE_URL = "https://www.ebookers.com/";
    private final static String MENU_ACCOUNT_BUTTON_ID = "header-account-menu";

    @FindBy(id=MENU_ACCOUNT_BUTTON_ID)
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
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.id(MENU_ACCOUNT_BUTTON_ID)));
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
