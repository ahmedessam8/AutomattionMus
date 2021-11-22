package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompanyPage extends BasePage {
    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    By leaderShipSection =By.cssSelector(".company-members  h2");
    By faceBookLink = By.cssSelector(".musala-icon-facebook");

    public boolean checkLeaderShipSectionIsFound(){
            try {
                return findElement(leaderShipSection).isDisplayed();
            }
            catch (Exception ex)
            {
                return false;
            }
    }
    public FaceBookPage openFaceBookLinkFromFooter(){
        findElement(faceBookLink).click();
        waitUntilLoadingIconAppears(4);
        switchToChildWindow();
    return new FaceBookPage (driver) ;
    }
}
