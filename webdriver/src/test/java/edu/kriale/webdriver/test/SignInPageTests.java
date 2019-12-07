package edu.kriale.webdriver.test;

import edu.kriale.webdriver.pageobject.HomePage;
import edu.kriale.webdriver.service.AccountCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends CommonConditions {
    @Test(testName = "test-case-1: User sing in")
    public void signUpTest() {
        HomePage page = (new HomePage())
                .openPage()
                .openSignInPage()
                .signIn(AccountCreator.withCredentialsFromProperty());
        Assert.assertTrue(page.userGreetingNameSpanIsExist());
    }
}
