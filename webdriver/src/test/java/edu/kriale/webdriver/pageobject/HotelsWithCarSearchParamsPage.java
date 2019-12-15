package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsWithCarSearchParamsPage extends HotelsSearchParamsPage {

    @FindBy(id = "driver-age-checkbox-hlp-hc")
    private WebElement defaultDriverAgeCheckbox;

    @FindBy(id = "car-driver-age-hlp-hc")
    private WebElement driverAgeField;

    @FindBy(xpath="//*[@id='search-button-hlp-hc']")
    protected WebElement withCarSearchButton;


    public HotelsWithCarSearchParamsPage() {
        waitUntil(ExpectedConditions.visibilityOf(defaultDriverAgeCheckbox));
    }

    public HotelsWithCarSearchResultsPage search() {
        clickSearch();
        return new HotelsWithCarSearchResultsPage();
    }

    @Override
    public HotelsWithCarSearchParamsPage clickSearch() {
//        waitUntil(ExpectedConditions.elementToBeClickable(withCarSearchButton));
        withCarSearchButton.click();
        logger.info("Clicked Search button.");
        return this;
    }

    public HotelsWithCarSearchParamsPage clickDefaultDriverAgeCheckbox() {
        defaultDriverAgeCheckbox.click();
        logger.info("Clicked default driver age checkbox");
        return this;
    }

    public HotelsWithCarSearchParamsPage fillDriverAge(int age) {
        driverAgeField.sendKeys(String.valueOf(age));
        logger.info("Filled 'Driver's age' field");
        return this;
    }
}
