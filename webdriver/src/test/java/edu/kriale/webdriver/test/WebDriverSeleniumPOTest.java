package edu.kriale.webdriver.test;

import org.junit.jupiter.api.*;
import edu.kriale.webdriver.pageobject.HotelsSearchParamsPage;
import edu.kriale.webdriver.pageobject.HotelsSearchResultsPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WebDriverSeleniumPOTest extends CommonConditions {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE =
            "We were unable to find any flights for your package. " +
                    "Please adjust your search or continue booking your hotel separately.";

    @Test
    @DisplayName("test-case-3: Search hotel for less than one day staying")
    public void searchHotelsForLessThanOneDayStaying() {
        LocalDate date = LocalDate.now().plusDays(2);

        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        page.openPage()
                .fillGoingToField("Singapore, Singapore")
                .fillCheckInField(date.format(FORMATTER))
                .fillCheckOutField(date.format(FORMATTER));
        Assertions.assertEquals(date.plusDays(1).format(FORMATTER), page.getCheckOutFieldText());
    }

    @Test
    @DisplayName("test-case-4: Search hotel with flight from A to A")
    public void searchHotelsWithFlightFromAToA() {
        LocalDate date = LocalDate.now().plusDays(1);

        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        HotelsSearchResultsPage resultsPage = page.openPage()
                .fillGoingToField("Minsk, Minsk Region, Belarus")
                .fillCheckInField(date.format(FORMATTER))
                .fillCheckOutField(date.plusDays(2).format(FORMATTER))
                .fillRoomsField(1)
                .fillAdultsField(2)
                .enableAddFlightCheckbox()
                .fillFlyingFromField("Minsk, Belarus (MSQ-Minsk Intl.)")
                .search();

        Assertions.assertEquals(EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE,
                        resultsPage.getAlertMessage());
    }
}
    