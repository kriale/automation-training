package edu.kriale.webdriver.test;

import edu.kriale.webdriver.pageobject.HotelsSearchParamsPage;
import edu.kriale.webdriver.pageobject.HotelsSearchResultsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelSearchResultPageTests extends CommonConditions {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE =
            "We were unable to find any flights for your package. " +
                    "Please adjust your search or continue booking your hotel separately.";

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