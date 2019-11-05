package pageobject.test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.page.HotelsSearchParamsPage;
import pageobject.page.HotelsSearchResultsPage;
import pageobject.page.HotelsWithFlightSearchParamsPage;

public class WebDriverSeleniumPOTest {
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
    public void searchHotelsForLessThanOneDayStaying() throws InterruptedException {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        page.openPage();
        page.fillGoingToField("Singapore, Singapore");
        page.fillCheckInField("06/11/2019");
        page.fillCheckOutField("06/11/2019");
        Assertions.assertEquals("07/11/2019", page.getCheckOutFieldText());
    }

    @Test
    @DisplayName("test-case-4: Search hotel with flight from A to A")
    public void searchHotelsWithFlightFromAToA() throws InterruptedException {
        HotelsSearchParamsPage page = new HotelsSearchParamsPage(driver);
        page.openPage();
        page.fillGoingToField("Minsk, Minsk Region, Belarus");
        page.fillCheckInField("06/11/2019");
        page.fillCheckOutField("08/11/2019");
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
