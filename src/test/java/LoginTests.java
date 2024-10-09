import config.LoginTestConfig;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.RandomUserGenerator.randomEmail;
import static utils.RandomUserGenerator.randomPasswordInRange;

public class LoginTests extends LoginTestConfig {

    @Test
    @Description("Проверка авторизации через кнопку Войти в аккаунт на главной странице")
    public void canLogInViaLoginButton() {
        homePage.clickAccountLoginButton();
        loginPage.inputEmail(randomEmail);
        loginPage.inputPassword(randomPasswordInRange);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe(TEST_URL));
        Assert.assertTrue(homePage.isOrderButtonVisible());
    }

    @Test
    @Description("Проверка авторизации через кнопку Личный кабинет в шапке")
    public void canLoginViaPersonalAccountButton() {
        header.clickPersonalAccountButton();
        loginPage.inputEmail(randomEmail);
        loginPage.inputPassword(randomPasswordInRange);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe(TEST_URL));
        Assert.assertTrue(homePage.isOrderButtonVisible());
    }

    @Test
    @Description("Проверка авторизации через кнопку Войти на странице регистрации")
    public void canLogInViaLoginButtonOnRegisterPage() {
        homePage.clickAccountLoginButton();
        loginPage.clickRegisterButton();
        registerPage.clickLoginButton();
        loginPage.inputEmail(randomEmail);
        loginPage.inputPassword(randomPasswordInRange);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe(TEST_URL));
        Assert.assertTrue(homePage.isOrderButtonVisible());
    }

    @Test
    @Description("Проверка авторизации через кнопку Войти на странице восстановления пароля")
    public void canLoginViaLoginButtonOnRecoverPasswordPage() {
        homePage.clickAccountLoginButton();
        loginPage.clickForgotPasswordButton();
        recoverPasswordPage.clickLoginButton();
        loginPage.inputEmail(randomEmail);
        loginPage.inputPassword(randomPasswordInRange);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe(TEST_URL));
        Assert.assertTrue(homePage.isOrderButtonVisible());
    }

}
