package edu.kriale.webdriver.pageobject;

import edu.kriale.webdriver.model.Account;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='gss-signin-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='gss-signin-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='gss-signin-submit']")
    private WebElement submitButton;

    public SignInPage() {
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
        emailField.sendKeys(password);
        logger.info("Filled 'password' field.");
        focusAway();
    }

}
