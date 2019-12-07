package edu.kriale.webdriver.pageobject;

import edu.kriale.webdriver.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//body")
    private WebElement body;

    protected WebDriver driver;

    public AbstractPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public abstract AbstractPage openPage();

    protected void focusAway() {
        body.click();
    }

    protected void waitUntil(ExpectedCondition<WebElement> expectedCondition) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(expectedCondition);
    }
}
