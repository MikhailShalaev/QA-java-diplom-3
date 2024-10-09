package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    public static String loginPageUrl = "https://stellarburgers.nomoreparties.site/login";
    private final By inputFieldEmail = By.xpath(".//input[@type='text']");
    private final By inputFieldPassword = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Водим адрес почты")
    public void inputEmail(String email){
        driver.findElement(inputFieldEmail).sendKeys(email);
    }
    @Step("Водим пароль")
    public void inputPassword(String password){
        driver.findElement(inputFieldPassword).sendKeys(password);
    }
    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    @Step("Нажимаем кнопку Зарегистрироваться")
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    @Step("Нажимаем кнопку Восстановить пароль")
    public void clickForgotPasswordButton(){
        driver.findElement(forgotPasswordButton).click();
    }
    @Step("Проверяем, отображается ли кнопка Войти")
    public boolean isLoginButtonVisible(){
        return driver.findElement(loginButton).isDisplayed();
    }

        }
