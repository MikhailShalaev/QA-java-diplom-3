package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;
    private final By inputFieldName = By.xpath(".//label[text()='Имя']/../input");
    private final By inputFieldEmail = By.xpath(".//label[text()='Email']/../input");
    private final By inputFieldPassword = By.xpath(".//label[text()='Пароль']/../input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public final By loginButton = By.xpath(".//a[text()='Войти']");
    public final By registrationErrorMessage = By.xpath("//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Вводим имя пользователя")
    public void inputName(String name) {
        driver.findElement(inputFieldName).sendKeys(name);
    }
    @Step("Вводим адрес почты")
    public void inputEmail(String email) {
        driver.findElement(inputFieldEmail).sendKeys(email);
    }
    @Step("Вводим пароль")
    public void inputPassword(String password) {
        driver.findElement(inputFieldPassword).sendKeys(password);
    }
    @Step("Нажимаем кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    @Step("Проверяем, отображается ли сообщение об ошибке при некорректной длине пароля")
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(registrationErrorMessage).isDisplayed();
    }
}
