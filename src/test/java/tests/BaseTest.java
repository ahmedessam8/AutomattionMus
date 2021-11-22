package tests;

import config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import config.ConfigProps;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    public DriverFactory capabilityFactory = new DriverFactory();
    public ConfigProps configProps = new ConfigProps();

    public BaseTest(){}


    @BeforeMethod(alwaysRun = true)
    public void setUp () throws IOException {
        String browser=configProps.getPropValues("browser");
        //if(browser==null) browser="chrome";
        driver = capabilityFactory.getDrivers(browser);
        driver.navigate().to(configProps.getPropValues("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}

