package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelsWithFlightSearchParamsPage extends HotelsSearchParamsPage {
    @FindBy(id = "hotel-flight-origin-hlp")
    private WebElement flyingFromField;

    public HotelsWithFlightSearchParamsPage(WebDriver driver) {
        super(driver);
    }

    public void fillFlyingFromField(String flyingFrom) {
        flyingFromField.sendKeys(flyingFrom);
        focusAway();
    }
}
