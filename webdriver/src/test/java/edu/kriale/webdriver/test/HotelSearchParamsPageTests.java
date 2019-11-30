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

    @Test(testName = "test-case-3: Search hotel for less than one day staying")
    public void searchHotelsForLessThanOneDayStaying() {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        page.openPage()
                .fillFromParams(HotelReservationCreator.withLessThanOneDayStayingFromProperty());
        Assert.assertEquals(LocalDate.now()
                .plusDays(Integer.parseInt(TestDataReader.getTestData(PROPERTY_NAME_EXPECTED_CHECK_OUT)))
                .format(FORMATTER), page.getCheckOutFieldText());
    }
}
    