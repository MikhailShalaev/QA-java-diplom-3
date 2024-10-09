package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private final WebDriver driver;
    public final By logoutButton = By.xpath(".//button[text()='Выход']");
    public static String personalAccountPageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажимаем кнопку Выход")
    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }
}
