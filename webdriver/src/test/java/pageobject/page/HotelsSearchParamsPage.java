package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelsSearchParamsPage extends AbstractPage {
    private static final String HOTELS_SEARCH_PARAMS_PAGE_URL = "https://www.ebookers.com/Hotels";

    @FindBy(xpath="//*[@id='hotel-destination-hlp']")
    private WebElement goingToField;

    @FindBy(xpath="//*[@id='hotel-checkin-hlp']")
    private WebElement checkInField;

    @FindBy(xpath="//*[@id='hotel-checkout-hlp']")
    private WebElement checkOutField;

    @FindBy(xpath="//*[@id='hotel-rooms-hlp']")
    private WebElement roomsField;

    @FindBy(xpath="//*[@id='hotel-1-children-hlp']")
    private WebElement adultsField;

    @FindBy(xpath="//*[@id='hotel-1-children-hlp']")
    private WebElement childrenField;

    @FindBy(xpath="//button[@data-gcw-change-submit-text='Search']")
    private WebElement searchButton;

    @FindBy(id = "hotel-add-flight-checkbox-hlp")
    private WebElement addFlightCheckbox;

    public HotelsSearchParamsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage openPage() {
        driver.get(HOTELS_SEARCH_PARAMS_PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOf(goingToField));
        return this;
    }

    public HotelsSearchResultsPage search() {
        searchButton.click();
        return new HotelsSearchResultsPage(driver);
    }

    public void fillGoingToField(String destination) {
        goingToField.sendKeys(destination);
        focusAway();
    }

    public void fillCheckInField(String checkInDate) {
        checkInField.sendKeys(checkInDate);
        focusAway();
    }

    public void fillCheckOutField(String checkOutDate) {
        checkOutField.sendKeys(checkOutDate);
        focusAway();
    }

    public void fillRoomsField(int roomsNumber) {
        roomsField.click();
        focusAway();
    }

    public void fillAdultsField(int adultsNumber) {
        adultsField.click();
        focusAway();
    }

    public void fillChildrenField(int childrenNumber) {
        childrenField.click();
        focusAway();
    }

    public HotelsWithFlightSearchParamsPage enableAddFlightCheckbox() {
        addFlightCheckbox.click();
        return new HotelsWithFlightSearchParamsPage(driver);
    }

    public String getCheckOutFieldText() {
        return checkOutField.getAttribute("value");
    }
}
