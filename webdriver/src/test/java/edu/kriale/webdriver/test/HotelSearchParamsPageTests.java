package edu.kriale.webdriver.test;

import edu.kriale.webdriver.service.HotelReservationCreator;
import edu.kriale.webdriver.service.TestDataReader;
import edu.kriale.webdriver.pageobject.HotelsSearchParamsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelSearchParamsPageTests extends CommonConditions {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String PROPERTY_NAME_EXPECTED_CHECK_OUT = "test-data.case3.check-out.plus-days.expected";
    private static final String PROPERTY_NAME_CASE5_EXPECTED_MESSAGE = "test-data.case5.expected-message";
    private static final String PROPERTY_NAME_CASE6_EXPECTED_MESSAGE = "test-data.case6.expected-message";


    @Test(testName = "test-case-3: Search hotel for less than one day staying")
    public void searchHotelsForLessThanOneDayStaying() {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage();
        page.openPage().fillFromParams(HotelReservationCreator.withLessThanOneDayStayingFromProperty());
        Assert.assertEquals(LocalDate.now()
                .plusDays(Integer.parseInt(TestDataReader.getTestData(PROPERTY_NAME_EXPECTED_CHECK_OUT)))
                .format(FORMATTER), page.getCheckOutFieldText());
    }

    @Test(testName = "test-case-5: Search hotel with empty form")
    public void searchHotelsWithoutParams() {
        String errorMessage = new HotelsSearchParamsPage()
                .openPage()
                .clickSearch()
                .getAlertErrorMessage();
        Assert.assertEquals(TestDataReader.getTestData(PROPERTY_NAME_CASE5_EXPECTED_MESSAGE), errorMessage);
    }

    @Test(testName = "test-case-6: Search hotel with empty check-in field")
    public void searchHotelsWithoutCheckInDate() {
        String errorMessage =  new HotelsSearchParamsPage()
                .openPage()
                .fillFromParams(HotelReservationCreator.withEmptyCheckOutFieldFromProperty())
                .clickSearch()
                .getAlertErrorMessage();
        Assert.assertEquals(TestDataReader.getTestData(PROPERTY_NAME_CASE6_EXPECTED_MESSAGE), errorMessage);
    }
}