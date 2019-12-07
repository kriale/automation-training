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


    public HotelsSearchParamsPage() {
    }

    @Override
    public HotelsSearchParamsPage openPage() {
        driver.get(HOTELS_SEARCH_PARAMS_PAGE_URL);
        waitUntil(ExpectedConditions.presenceOfElementLocated(By.id(HOTEL_DESTINATION_FIELD_ID)));
        return this;
    }

    public HotelsSearchResultsPage search() {
        waitUntil(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        return new HotelsSearchResultsPage();
    }

    public HotelsSearchParamsPage fillFromParams(HotelReservation params) {
        params.getGoingTo().ifPresent(this::fillGoingToField);
        params.getReservationDates().ifPresent(e -> {
            e.getCheckInDate().ifPresent(this::fillCheckInField);
            e.getCheckOutDate().ifPresent(this::fillCheckOutField);
        });
        fillRoomsList(params.getHotelReservationRooms());
        return this;
    }

    private void fillRoomsList(List<HotelReservationRoom> rooms) {
        if (rooms.size() > 0) {
            fillRoom(rooms.get(0));
        }
    }

    private void fillRoom(HotelReservationRoom room) {
        room.getAdultsNumber().ifPresent(this::fillAdultsField);
        room.getChildrenNumber().ifPresent(this::fillChildrenField);
    }

    public HotelsSearchParamsPage fillGoingToField(String destination) {
        goingToField.sendKeys(destination);
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillCheckInField(String checkInDate) {
        checkInField.sendKeys(checkInDate);
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillCheckOutField(String checkOutDate) {
        checkOutField.sendKeys(checkOutDate);
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillRoomsField(int roomsNumber) {
        roomsField.sendKeys(String.valueOf(roomsNumber));
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillAdultsField(int adultsNumber) {
        adultsField.sendKeys(String.valueOf(adultsNumber));
        focusAway();
        return this;
    }

    public HotelsSearchParamsPage fillChildrenField(int childrenNumber) {
        childrenField.sendKeys(String.valueOf(childrenNumber));
        focusAway();
        return this;
    }

    public HotelsWithFlightSearchParamsPage enableAddFlightCheckbox() {
        addFlightCheckbox.click();
        return new HotelsWithFlightSearchParamsPage();
    }

    public String getCheckOutFieldText() {
        return checkOutField.getAttribute(ATTRIBUTE_VALUE);
    }
}
