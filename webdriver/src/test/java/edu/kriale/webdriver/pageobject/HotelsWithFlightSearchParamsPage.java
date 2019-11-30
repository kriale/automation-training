package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsWithFlightSearchParamsPage extends HotelsSearchParamsPage {
    @FindBy(id = "hotel-flight-origin-hlp")
    private WebElement flyingFromField;

    @FindBy(xpath = "//*[@id='hotel-added-flights-hp-hotel']//div[@class='auto-complete-dropdown']")
    private WebElement flyingFromAutoCompleteDropdown;

    public HotelsWithFlightSearchParamsPage(WebDriver driver) {
        super(driver);
    }

    public HotelsWithFlightSearchParamsPage fillFlyingFromField(String flyingFrom) {
        flyingFromField.sendKeys(flyingFrom);
        focusAway();
        return this;
    }
}
