package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//mvn test -Dbrowser.name=yandex
//mvn test -Dbrowser.name=chrome

public class WebDriverConfiguration {
    public static String browser = System.getProperty("browser.name");
    public static WebDriver configureDriver(){

        if (WebDriverConfiguration.browser == null) {
            return createChromeDriver();
        }

        switch (WebDriverConfiguration.browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
                return new ChromeDriver();
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        return new ChromeDriver();
    }
    }

