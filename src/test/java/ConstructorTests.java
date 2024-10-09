import config.ConstructorTestConfig;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pageobject.HomePage.ingredientsListButton;
import static pageobject.HomePage.sauceListButton;

public class ConstructorTests extends ConstructorTestConfig {

    @Test
    @Description("Проверка активации кнопки Булки")
    public void canBunSectionButtonBeSelected(){
    wait.until(ExpectedConditions.presenceOfElementLocated(ingredientsListButton));
    homePage.clickIngredientsListButton();
    homePage.clickBunListButton();
        Assert.assertTrue(homePage.isBunSectionButtonSelected());
    }

    @Test
    @Description("Проверка активации кнопки Соусы")
    public void canSauceSectionBeSelected(){
        wait.until(ExpectedConditions.presenceOfElementLocated(sauceListButton));
        homePage.clickSauceListButton();
        Assert.assertTrue(homePage.isSauceSectionButtonSelected());
    }

    @Test
    @Description("Проверка активации кнопки Начинки")    public void canIngredientsSectionBeSelected(){
        wait.until(ExpectedConditions.presenceOfElementLocated(ingredientsListButton));
        homePage.clickIngredientsListButton();
        Assert.assertTrue(homePage.isIngredientsSectionButtonSelected());
    }
}
