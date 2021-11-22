package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }
    By checkOurOpenPositionBtn =By.cssSelector("[data-alt='Check our open positions']");

    public void selectCheckOurOpenPositionBtn(){
        findElement(checkOurOpenPositionBtn).click();

    }
}
