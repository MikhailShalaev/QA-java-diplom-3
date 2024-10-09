import config.PersonalAccountTestConfig;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.PersonalAccountPage;

import static pageobject.HomePage.homePageUrl;
import static pageobject.LoginPage.loginPageUrl;

public class PersonalAccountTests extends PersonalAccountTestConfig {

    @Test
    @Description("Проверка перехода в личный кабинет через кнопку Личный кабинет в шапке")
    public void canGetToPersonalAccountPageViaPersonalAccountButton(){
        header.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.logoutButton));
        Assert.assertEquals(PersonalAccountPage.personalAccountPageUrl, driver.getCurrentUrl());
    }

    @Test
    @Description("Проверка выхода из аккаунта через кнопку Выход в личном кабинете")
    public void canLogoutFromAccountViaLogoutButton(){
        header.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.logoutButton));
        personalAccountPage.clickLogoutButton();
        wait.until(ExpectedConditions.urlToBe(loginPageUrl));
        header.clickPersonalAccountButton();
        Assert.assertEquals(loginPageUrl, driver.getCurrentUrl());
    }

    @Test
    @Description("Проверка перехода к конструктору через нажатие на логотип в шапке")
    public void canGetToConstructorViaStellarBurgersLogoButton(){
        header.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.logoutButton));
        header.clickStellarBurgersLogoButton();
        wait.until(ExpectedConditions.urlToBe(homePageUrl));
        Assert.assertTrue(homePage.isBunSectionButtonSelected());
    }

    @Test
    @Description("Проверка перехода к конструктору через нажатие на кнопку Конструктор в шапке")
    public void canGetToConstructorViaConstructorButton(){
        header.clickPersonalAccountButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountPage.logoutButton));
        header.clickConstructorButton();
        wait.until(ExpectedConditions.urlToBe(homePageUrl));
        Assert.assertTrue(homePage.isBunSectionButtonSelected());
    }
}
