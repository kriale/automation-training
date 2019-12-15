package edu.kriale.webdriver.test;

import edu.kriale.webdriver.pageobject.*;
import edu.kriale.webdriver.service.HotelReservationCreator;
import edu.kriale.webdriver.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelSearchResultPageTests extends CommonConditions {
    private static final String EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE =
            "We were unable to find any flights for your package. " +
                    "Please adjust your search or continue booking your hotel separately.";
    private static final String PROPERTY_NAME_FLYING_FROM = "test-data.case4.flying-from";
    private static final String PROPERTY_NAME_SMALL_DRIVER_AGE = "test-data.case8.driver-age";
    private static final String EXPECTED_INCORRECT_DRIVER_AGE_ERROR_MESSAGE = "test-data.case8.expected-message";
    private static final String EXPECTED_LARGE_PASSENGERS_NUMBER_ERROR_MESSAGE = "test-data.case9.expected-message";
    private static final String EXPECTED_TOO_LONG_TIME_ERROR_MESSAGE = "test-data.case10.expected-message";

    @Test(testName = "test-case-2: Simple hotel searching")
    public void searchHotelsWithSimpleParams() {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage();
        HotelsSearchResultsPage resultsPage = page.openPage()
                .fillFromParams(HotelReservationCreator.withNormalCredentialsFromProperty())
                .search();
        Assert.assertTrue(resultsPage.resultsIsDisplayed());
    }

    @Test(testName = "test-case-4: Search hotel with flight from A to A")
    public void searchHotelsWithFlightFromAToA() {
        new HotelsSearchParamsPage()
                .openPage()
                .enableAddFlightCheckbox()
                .fillFlyingFromField(TestDataReader.getTestData(PROPERTY_NAME_FLYING_FROM))
                .fillFromParams(HotelReservationCreator.withSimpleCredentialsFromProperty())
                .clickSearch();
        HotelsSearchResultErrorPage resultErrorPage = new HotelsSearchResultErrorPage();
        Assert.assertEquals(EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE,
                resultErrorPage.getAlertMessage());
    }

    @Test(testName = "test-case-7: Search hotel + car")
    public void searchHotelsWithCar() {
        HotelsWithCarSearchResultsPage resultsPage = new HotelsSearchParamsPage()
                .openPage()
                .fillFromParams(HotelReservationCreator.withEmptyCheckOutFieldFromProperty())
                .openHotelWithCarSection()
                .search();
        Assert.assertTrue(resultsPage.mainContentIsDisplayed());
    }

    @Test(testName = "test-case-8: Search hotel + car with little driver")
    public void searchHotelsWithCarWithLittleDriver() {
        HotelsWithCarSearchParamsPage page = new HotelsSearchParamsPage()
                .openPage()
                .fillFromParams(HotelReservationCreator.withEmptyCheckOutFieldFromProperty())
                .openHotelWithCarSection()
                .clickDefaultDriverAgeCheckbox()
                .fillDriverAge(Integer.parseInt(TestDataReader
                        .getTestData(PROPERTY_NAME_SMALL_DRIVER_AGE)))
                .clickSearch();
        Assert.assertEquals(EXPECTED_INCORRECT_DRIVER_AGE_ERROR_MESSAGE, page.getAlertErrorMessage());
    }

    @Test(testName = "test-case-9: Search hotel with a large number of passengers")
    public void searchHotelsWithLargeNumberOfPassengers() {
        new HotelsSearchParamsPage()
                .openPage()
                .fillFromParams(HotelReservationCreator.withEmptyCheckOutFieldFromProperty())
                .openHotelWithCarSection()
                .clickSearch();
        HotelsSearchResultErrorPage resultErrorPage = new HotelsSearchResultErrorPage();
        Assert.assertEquals(EXPECTED_LARGE_PASSENGERS_NUMBER_ERROR_MESSAGE,
                resultErrorPage.getAlertMessage());
    }

    @Test(testName = "test-case-10: Search hotel at too long time")
    public void searchHotelsAtTooLongTime() {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage()
                .openPage()
                .fillFromParams(HotelReservationCreator.withTooLongTimeFromProperty())
                .clickSearch();
        Assert.assertEquals(EXPECTED_TOO_LONG_TIME_ERROR_MESSAGE, page.getAlertErrorMessage());
    }
}
