package edu.kriale.webdriver.pageobject;

import edu.kriale.webdriver.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='signin-loginid']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='signin-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='submitButton']")
    private WebElement submitButton;

    public SignInPage() {
        waitUntil(ExpectedConditions.elementToBeClickable(emailField));
    }

    @Override
    public SignInPage openPage() {
        throw new RuntimeException("Can't open sign in page directly by URL. " +
                "Use menu of the home page.");
    }

    public HomePage signIn(Account account) {
        account.getEmail().ifPresent(this::fillEmailField);
        account.getPassword().ifPresent(this::fillPasswordField);
        submitButton.click();
        logger.info("Clicked 'Sign In' button.");
        return new HomePage();
    }

    private void fillEmailField(String email) {
        emailField.sendKeys(email);
        logger.info("Filled 'email' field.");
        focusAway();
    }

    private void fillPasswordField(String password) {
        passwordField.sendKeys(password);
        logger.info("Filled 'password' field.");
        focusAway();
    }

}
