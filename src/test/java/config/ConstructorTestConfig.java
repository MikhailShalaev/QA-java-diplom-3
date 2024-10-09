package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.HomePage;

import java.time.Duration;

public abstract class ConstructorTestConfig {
    public WebDriver driver;
    protected static WebDriverWait wait;
    protected static HomePage homePage;
    private final static String TEST_URL = "https://stellarburgers.nomoreparties.site";

    @Before

    public void setUp() {
        driver = WebDriverConfiguration.configureDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(TEST_URL);
        homePage = new HomePage(driver);
                }

    @After
    public void tearDown() {
            if (driver != null) {
            driver.quit();
        }
}}
