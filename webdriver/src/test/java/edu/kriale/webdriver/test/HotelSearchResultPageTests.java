package edu.kriale.webdriver.test;

import edu.kriale.webdriver.pageobject.HotelsSearchParamsPage;
import edu.kriale.webdriver.pageobject.HotelsSearchResultsPage;
import edu.kriale.webdriver.service.HotelReservationCreator;
import edu.kriale.webdriver.service.TestDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelSearchResultPageTests extends CommonConditions {
    private static final String EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE =
            "We were unable to find any flights for your package. " +
                    "Please adjust your search or continue booking your hotel separately.";
    private static final String PROPERTY_NAME_FLYING_FROM = "test-data.case4.flying-from";

    @Test(testName = "test-case-4: Search hotel with flight from A to A")
    public void searchHotelsWithFlightFromAToA() {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        HotelsSearchResultsPage resultsPage = page.openPage()
                .fillFromParams(HotelReservationCreator.withSimpleCredentialsFromProperty())
                .enableAddFlightCheckbox()
                .fillFlyingFromField(TestDataReader.getTestData(PROPERTY_NAME_FLYING_FROM))
                .search();
        Assert.assertEquals(EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE,
                resultsPage.getAlertMessage());
    }
}
