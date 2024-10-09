import config.RegistrationTestConfig;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pageobject.LoginPage.loginPageUrl;
import static utils.RandomUserGenerator.*;

public class RegistrationTests extends RegistrationTestConfig {
    @Test
    @Description("Позитивная проверка регистрации пользователя на странице регистрации")
    public void registerAccountPositive() {
        homePage.clickAccountLoginButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(randomName);
        registerPage.inputEmail(randomEmail);
        registerPage.inputPassword(randomPasswordInRange);
        registerPage.clickRegisterButton();
        wait.until(ExpectedConditions.urlToBe(loginPageUrl));
        Assert.assertTrue(loginPage.isLoginButtonVisible());

    }

    @Test
    @Description("Негативная проверка регистрации пользователя на странице регистрации")
    public void canNotRegisterWhenPasswordIsLessThanSixSymbols(){
        homePage.clickAccountLoginButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(randomName);
        registerPage.inputEmail(randomEmail);
        registerPage.inputPassword(randomPasswordOutOfRange);
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isErrorMessageDisplayed());

    }
}
