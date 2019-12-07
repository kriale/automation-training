package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsWithFlightSearchParamsPage extends HotelsSearchParamsPage {
    @FindBy(id = "hotel-flight-origin-hlp")
    private WebElement flyingFromField;

    @FindBy(xpath = "//*[@id='hotel-added-flights-hp-hotel']//div[@class='auto-complete-dropdown']")
    private WebElement flyingFromAutoCompleteDropdown;

    public HotelsWithFlightSearchParamsPage() {
    }

    public HotelsWithFlightSearchParamsPage fillFlyingFromField(String flyingFrom) {
        flyingFromField.sendKeys(flyingFrom);
        logger.info("Filled 'Flying from' field.");
        focusAway();
        return this;
    }
}
