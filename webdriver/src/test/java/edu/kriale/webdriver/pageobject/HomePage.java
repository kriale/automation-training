package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {
    private final static String HOME_PAGE_URL = "https://www.ebookers.com/";
    private final static String MENU_ACCOUNT_BUTTON_ID = "header-account-menu";

    @FindBy(id=MENU_ACCOUNT_BUTTON_ID)
    private WebElement menuAccountButton;

    @FindBy(id="account-signin")
    private WebElement accountMenuSignInButton;

    @FindBy(id="tab-hotel-tab-hlp")
    private WebElement hotelsSearchParamsPageMenuButton;

    @FindBy(id="userGreetingName")
    private WebElement userGreetingNameSpan;

    public HomePage() {
    }

    @Override
    public HomePage openPage() {
        driver.get(HOME_PAGE_URL);
        logger.info("Open Home Page.");
        waitUntil(ExpectedConditions.presenceOfElementLocated(By.id(MENU_ACCOUNT_BUTTON_ID)));
        return this;
    }

    public SignInPage openSignInPage() {
        logger.info("Start open Sign In Page...");
        menuAccountButton.click();
        accountMenuSignInButton.click();
        return new SignInPage();
    }

    public HotelsSearchParamsPage openHotelsSearchParamsPage() {
        logger.info("Start open Hotels Search Params Page...");
        hotelsSearchParamsPageMenuButton.click();
        return new HotelsSearchParamsPage();
    }

    public String getUserGreetingName() {
        return userGreetingNameSpan.getText();
    }

    public boolean UserGreetingNameSpanIsExist() {
        return userGreetingNameSpan != null;
    }
}
