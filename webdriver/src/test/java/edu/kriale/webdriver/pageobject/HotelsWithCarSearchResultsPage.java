package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsWithCarSearchResultsPage extends HotelsSearchResultsPage {
    @FindBy(xpath = "//*[@class='bColumn']")
    private WebElement mainContent;


    @Override
    public HotelsSearchResultErrorPage openPage() {
        throw new RuntimeException("Can't open hotels with car search results page directly by URL. " +
                "Use hotels search params form pages.");
    }

    public HotelsWithCarSearchResultsPage() {
//        waitUntil(ExpectedConditions.visibilityOf(mainContent));
    }

    public boolean mainContentIsDisplayed() {
        return mainContent.isDisplayed();
    }

    @Override
    public boolean resultsIsDisplayed() {
        throw new RuntimeException("Can't use this method of the super class");
    }
}
