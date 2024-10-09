package config;

import base.UserCreate;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.Header;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.PersonalAccountPage;
import utils.AccessTokenExtractor;
import utils.CreateUser;
import utils.DeleteUser;
import utils.RandomUserGenerator;

import java.time.Duration;

import static utils.RandomUserGenerator.randomEmail;
import static utils.RandomUserGenerator.randomPasswordInRange;

public abstract class PersonalAccountTestConfig {
    public WebDriver driver;
    protected static WebDriverWait wait;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static PersonalAccountPage personalAccountPage;
    protected static Header header;
    public String accessToken;
    private final static String TEST_URL = "https://stellarburgers.nomoreparties.site";

    @Before
    public void setUp() {
        driver = WebDriverConfiguration.configureDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(TEST_URL);
        homePage = new HomePage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        loginPage = new LoginPage(driver);
        header = new Header(driver);
        UserCreate userCreate = RandomUserGenerator.createRandomUser();
        Response response = CreateUser.userCreateResponse(userCreate);
        accessToken = AccessTokenExtractor.extractAccessToken(response);
        homePage.clickAccountLoginButton();
        loginPage.inputEmail(randomEmail);
        loginPage.inputPassword(randomPasswordInRange);
        loginPage.clickLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/"));

    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            DeleteUser.deleteUserResponse(accessToken);
        } if (driver != null) {
            driver.quit();
        }
    }
}
