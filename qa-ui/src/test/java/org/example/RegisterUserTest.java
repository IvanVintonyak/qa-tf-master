package org.example;

import org.assertj.core.api.Assertions;
import org.example.pages.MainPage;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    @Test
    public void registerUserTest() {
        MainPage mainPage = new MainPage(getWebDriver())
                .open()
                .registerRandomUser();
        Assertions.assertThat(mainPage.isUserLoggedIn())
                .withFailMessage("Something went wrong, user could not log in to the system ")
                .isFalse();
    }
}
