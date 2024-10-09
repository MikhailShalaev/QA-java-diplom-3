package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    private final WebDriver driver;
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажимаем кнопку Войти")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
