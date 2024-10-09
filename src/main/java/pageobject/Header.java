package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By stellarBurgersLogoButton = By.xpath(".//div/header/nav/div");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажимаем на кнопку Личный кабинет")
    public void clickPersonalAccountButton(){
        driver.findElement(personalAccountButton).click();
    }
    @Step("Нажимаем на кнопку Конструктор")
    public void clickConstructorButton(){
        driver.findElement(constructorButton).click();
    }
    @Step("Нажимаем на логотип в шапке")
    public void clickStellarBurgersLogoButton(){
        driver.findElement(stellarBurgersLogoButton).click();
    }
}
