package edu.kriale.webdriver.pageobject;

import java.util.List;
import edu.kriale.webdriver.model.HotelReservation;
import edu.kriale.webdriver.model.HotelReservationRoom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HotelsSearchParamsPage extends AbstractPage {
    private static final String HOTELS_SEARCH_PARAMS_PAGE_URL = "https://www.ebookers.com/Hotels";
    private static final String HOTEL_DESTINATION_FIELD_ID = "hotel-destination-hlp";
    private static final String ATTRIBUTE_VALUE = "value";

    @FindBy(xpath="//*[@id='hotel-destination-hlp']")
    private WebElement goingToField;

    @FindBy(xpath="//*[@id='hotel-checkin-hlp']")
    private WebElement checkInField;

    @FindBy(xpath="//*[@id='hotel-checkout-hlp']")
    private WebElement checkOutField;

    @FindBy(xpath="//*[@id='hotel-rooms-hlp']")
    private WebElement roomsField;

    @FindBy(xpath="//*[@id='hotel-1-adults-hlp']")
    private WebElement adultsField;

    @FindBy(xpath="//*[@id='hotel-1-children-hlp']")
    private WebElement childrenField;

    @FindBy(xpath="//button[@data-gcw-change-submit-text='Search']")
    private WebElement searchButton;

    @FindBy(id = "hotel-add-flight-checkbox-hlp")
    private WebElement addFlightCheckbox;

    @FindBy(id = "tab-hotelCar-tab-hlp-hc")
    private WebElement hotelsWithCarSectionButton;

    @FindBy(id = "tab-hotel-tab-hlp")
    private WebElement hotelsOnlySectionButton;

    @FindBy(xpath = "//a[@class='error-link']")
    private WebElement errorAlert;

    public HotelsSearchParamsPage() {
    }

    @Override
    public HotelsSearchParamsPage openPage() {
        driver.get(HOTELS_SEARCH_PARAMS_PAGE_URL);
        logger.info("Open Hotels Search Param Page.");
        waitUntil(ExpectedConditions.presenceOfElementLocated(By.id(HOTEL_DESTINATION_FIELD_ID)));
        return this;
    }

    public HotelsSearchResultsPage search() {
        clickSearch();
        return new HotelsSearchResultsPage();
    }

    public HotelsSearchParamsPage clickSearch() {
        waitUntil(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        logger.info("Clicked Search button.");
        return this;
    }

    public HotelsSearchParamsPage fillFromParams(HotelReservation params) {
        params.getGoingTo().ifPresent(this::fillGoingToField);
        params.getReservationDates().ifPresent(e -> {
            e.getCheckInDate().ifPresent(this::fillCheckInField);
            e.getCheckOutDate().ifPresent(this::fillCheckOutField);
        });
        fillRoomsList(params.getHotelReservationRooms());
        logger.info("Filled hotels search params.");
        return this;
    }

    protected void fillRoomsList(List<HotelReservationRoom> rooms) {
        if (rooms.size() > 0) {
            fillRoom(rooms.get(0));
        }
    }

    protected void fillRoom(HotelReservationRoom room) {
        room.getAdultsNumber().ifPresent(this::fillAdultsField);
        room.getChildrenNumber().ifPresent(this::fillChildrenField);
        logger.info("Filled room params: " + room);
    }


    public HotelsSearchParamsPage fillGoingToField(String destination) {
        goingToField.sendKeys(destination);
        logger.info("Filled 'Going-to' field.");
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillCheckInField(String checkInDate) {
        checkInField.sendKeys(checkInDate);
        logger.info("Filled 'Check-in' field.");
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillCheckOutField(String checkOutDate) {
        checkOutField.sendKeys(checkOutDate);
        logger.info("Filled 'Check-out' field.");
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillRoomsField(int roomsNumber) {
        roomsField.sendKeys(String.valueOf(roomsNumber));
        logger.info("Filled 'Rooms' field.");
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillAdultsField(int adultsNumber) {
        adultsField.sendKeys(String.valueOf(adultsNumber));
        logger.info("Filled 'Adults' field.");
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillChildrenField(int childrenNumber) {
        childrenField.sendKeys(String.valueOf(childrenNumber));
        logger.info("Filled 'Children' field.");
        focusAway();
        return this;
    }

    public HotelsWithFlightSearchParamsPage enableAddFlightCheckbox() {
        addFlightCheckbox.click();
        logger.info("Enabled 'Add flight' checkbox.");
        return new HotelsWithFlightSearchParamsPage();
    }

    public HotelsWithCarSearchParamsPage openHotelWithCarSection() {
        hotelsWithCarSectionButton.click();
        logger.info("Select 'Hotels + Car' section");
        return new HotelsWithCarSearchParamsPage();
    }

    public HotelsSearchParamsPage openHotelOnlySection() {
        hotelsOnlySectionButton.click();
        logger.info("Select 'Hotels Only' section");
        return this;
    }

    public String getCheckOutFieldText() {
        return checkOutField.getAttribute(ATTRIBUTE_VALUE);
    }

    public String getAlertErrorMessage() {
        logger.info("Get error alert message text");
        return errorAlert.getText().trim();
    }
}
