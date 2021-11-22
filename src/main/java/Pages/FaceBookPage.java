package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FaceBookPage extends BasePage {
    public FaceBookPage(WebDriver driver) {
        super(driver);

    }
    By ImageFile =By.cssSelector("._2dgj > ._6tay");


    public boolean checkMusalaSoftPicIsFound() {
        try {
            return findElement(ImageFile).isDisplayed();
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}

