package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    public static String homePageUrl = "https://stellarburgers.nomoreparties.site/";
    private final By accountLoginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    public static By bunListButton = By.xpath("//span[text()='Булки']/parent::div");
    public static By sauceListButton = By.xpath(".//span[text()='Соусы']/parent::div");
    public static By ingredientsListButton = By.xpath(".//span[text()='Начинки']/parent::div");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажимаем на кнопку Войти")
    public void clickAccountLoginButton() {
        driver.findElement(accountLoginButton).click();
    }
    @Step("Нажимаем на кнопку Булки")
    public void clickBunListButton() {
        driver.findElement(bunListButton).click();
    }
    @Step("Нажимаем на кнопку Соусы")
    public void clickSauceListButton() {
        driver.findElement(sauceListButton).click();
    }
    @Step("Нажимаем на кнопку Начинки")
    public void clickIngredientsListButton() {
        driver.findElement(ingredientsListButton).click();
    }
    @Step("Проверяем, отображается ли кнопка Оформить заказ")
    public boolean isOrderButtonVisible() {
        return driver.findElement(createOrderButton).isDisplayed();
    }
    @Step("Проверяем, нажата ли кнопка Булки")
    public boolean isBunSectionButtonSelected() {
        return driver.findElement(bunListButton).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    @Step("Проверяем, нажата ли кнопка Соусы")
    public boolean isSauceSectionButtonSelected() {
        return driver.findElement(sauceListButton).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }
    @Step("Проверяем, нажата ли кнопка Начинки")
    public boolean isIngredientsSectionButtonSelected() {
        return driver.findElement(ingredientsListButton).getAttribute("class").contains("tab_tab_type_current__2BEPc");
    }

    }

