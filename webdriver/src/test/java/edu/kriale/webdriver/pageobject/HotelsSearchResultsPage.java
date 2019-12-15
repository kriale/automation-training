package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsSearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//*[@class='results']")
    private WebElement searchResultListing;


    public HotelsSearchResultsPage() {
        waitUntil(ExpectedConditions.visibilityOf(searchResultListing));
    }

    public HotelsSearchResultErrorPage openPage() {
        throw new RuntimeException("Can't open hotels search results page directly by URL. " +
                "Use hotels search params form pages.");
    }

    public boolean resultsIsDisplayed() {
        return searchResultListing.isDisplayed();
    }
}
