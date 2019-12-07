package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsSearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//*[@id='alert7']/h5")
    private WebElement alert7Message;


    public HotelsSearchResultsPage() {
        waitUntil(ExpectedConditions.visibilityOf(alert7Message));
    }

    public AbstractPage openPage() {
        throw new RuntimeException("Can't open hotels search results page directly by URL. " +
                "Use hotels search params form pages.");
    }

    public String getAlertMessage() {
        return alert7Message.getText().trim();
    }
}
