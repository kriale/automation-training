package edu.kriale.webdriver.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='gss-signin-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='gss-signin-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='gss-signin-submit']")
    private WebElement submitButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignInPage openPage() {
        throw new RuntimeException("Can't open sign in page directly by URL. " +
                "Use menu of the home page.");
    }

    public HomePage signInAccount(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        submitButton.click();
        return new HomePage(driver);
    }

    private void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    private void fillPasswordField(String password) {
        emailField.sendKeys(password);
    }

}
