package pageobject.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.page.HotelsSearchParamsPage;
import pageobject.page.HotelsSearchResultsPage;
import pageobject.page.HotelsWithFlightSearchParamsPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WebDriverSeleniumPOTest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE =
            "We were unable to find any flights for your package. " +
                    "Please adjust your search or continue booking your hotel separately.";

    private WebDriver driver;

    @BeforeEach()
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("test-case-3: Search hotel for less than one day staying")
    public void searchHotelsForLessThanOneDayStaying() {
        LocalDate date = LocalDate.now().plusDays(2);

        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        page.openPage();
        page.fillGoingToField("Singapore, Singapore");
        page.fillCheckInField(date.format(FORMATTER));
        page.fillCheckOutField(date.format(FORMATTER));
        Assertions.assertEquals(date.plusDays(1).format(FORMATTER), page.getCheckOutFieldText());
    }

    @Test
    @DisplayName("test-case-4: Search hotel with flight from A to A")
    public void searchHotelsWithFlightFromAToA() {
        LocalDate date = LocalDate.now().plusDays(1);

        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        page.openPage();
        page.fillGoingToField("Minsk, Minsk Region, Belarus");
        page.fillCheckInField(date.format(FORMATTER));
        page.fillCheckOutField(date.plusDays(2).format(FORMATTER));
        page.fillRoomsField(1);
        page.fillAdultsField(2);

        HotelsWithFlightSearchParamsPage pageWithFlight = page.enableAddFlightCheckbox();
        pageWithFlight.fillFlyingFromField("Minsk, Belarus (MSQ-Minsk Intl.)");

        HotelsSearchResultsPage resultsPage = pageWithFlight.search();

        Assertions.assertEquals(EXPECTED_EQUAL_DEPARTURE_AND_ARRIVAL_ALERT_MESSAGE,
                        resultsPage.getAlertMessage());
    }

    @AfterEach()
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
