package pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//body")
    private WebElement body;

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public abstract AbstractPage openPage();

    protected void focusAway() {
        body.click();
    }
}
