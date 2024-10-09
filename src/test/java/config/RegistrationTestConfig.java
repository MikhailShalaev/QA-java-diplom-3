package config;

import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.RegisterPage;
import utils.AccessTokenExtractor;
import utils.DeleteUser;
import utils.LoginUser;

import java.time.Duration;

import static utils.RandomUserGenerator.randomEmail;
import static utils.RandomUserGenerator.randomPasswordInRange;

public abstract class RegistrationTestConfig {
    private WebDriver driver;
    protected static WebDriverWait wait;
    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static RegisterPage registerPage;
    public String accessToken;
    private final static String TEST_URL = "https://stellarburgers.nomoreparties.site";


    @Before
    public void setUp() {
        driver = WebDriverConfiguration.configureDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(TEST_URL);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @After
    public void tearDown() {
        Response response = LoginUser.userLoginResponseFromString(randomEmail, randomPasswordInRange);
        accessToken = AccessTokenExtractor.extractAccessTokenFromLogin(response);
        if (accessToken != null) {
            DeleteUser.deleteUserResponse(accessToken);

        }
        if (driver != null) {
            driver.quit();
        }
    }
}
