package edu.kriale.webdriver.service;

import edu.kriale.webdriver.model.Account;

public class AccountCreator {
    private static final String TEST_DATA_ACCOUNT_EMAIL = "test-data.account.email";
    private static final String TEST_DATA_ACCOUNT_PASSWORD = "test-data.account.password";


    public static Account withCredentialsFromProperty() {
        return new Account(TestDataReader.getTestData(TEST_DATA_ACCOUNT_EMAIL),
                TestDataReader.getTestData(TEST_DATA_ACCOUNT_PASSWORD));
    }
}
