package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static utilities.utils.BASE_URL;

public class DriverFactory {
    public Capabilities capabilities;
    public WebDriver webDriver;

    public WebDriver getDrivers (String browser) {
        if (browser.equals("firefox")) {
            capabilities = OptionsManager.getFirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(OptionsManager.getFirefoxOptions());
        }
        else if (browser.equals("chrome")) {
            capabilities = OptionsManager.getChromeOptions();
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(OptionsManager.getChromeOptions());
        }

        return webDriver;
    }
}
