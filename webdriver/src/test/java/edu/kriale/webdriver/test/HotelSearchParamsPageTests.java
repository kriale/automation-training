package edu.kriale.webdriver.test;

import org.junit.jupiter.api.*;
import edu.kriale.webdriver.pageobject.HotelsSearchParamsPage;
import edu.kriale.webdriver.pageobject.HotelsSearchResultsPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelSearchParamsPageTests extends CommonConditions {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
}
    