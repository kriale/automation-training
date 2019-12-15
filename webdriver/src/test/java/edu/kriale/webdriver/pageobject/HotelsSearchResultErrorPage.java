package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsSearchResultErrorPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='alert7']/h5")
    private WebElement alert7Message;


    public HotelsSearchResultErrorPage() {
        waitUntil(ExpectedConditions.visibilityOf(alert7Message));
    }

    @Override
    public HotelsSearchResultErrorPage openPage() {
        throw new RuntimeException("Can't open hotels search result error page directly by URL. " +
                "Use hotels search params form pages.");
    }

    public String getAlertMessage() {
        return alert7Message.getText().trim();
    }
}
