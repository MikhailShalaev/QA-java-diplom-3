package config;

import base.UserCreate;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.*;
import utils.AccessTokenExtractor;
import utils.CreateUser;
import utils.DeleteUser;
import utils.RandomUserGenerator;

import java.time.Duration;

public abstract class LoginTestConfig {
    private WebDriver driver;
    protected static WebDriverWait wait;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static RegisterPage registerPage;
    protected static RecoverPasswordPage recoverPasswordPage;
    protected static Header header;
    public String accessToken;
    public final static String TEST_URL = "https://stellarburgers.nomoreparties.site/";


    @Before
    public void setUp() {
        driver = WebDriverConfiguration.configureDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(TEST_URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        recoverPasswordPage = new RecoverPasswordPage(driver);
        header = new Header(driver);
        UserCreate userCreate = RandomUserGenerator.createRandomUser();
        Response response = CreateUser.userCreateResponse(userCreate);
        accessToken = AccessTokenExtractor.extractAccessToken(response);

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
