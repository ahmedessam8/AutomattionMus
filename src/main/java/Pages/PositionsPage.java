package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PositionsPage extends BasePage {
    public PositionsPage(WebDriver driver) {
        super(driver);
    }
By locationDrpList =By.cssSelector("#get_location");
    By experiencedAutoQAEng = By.cssSelector("[data-alt='Experienced Automation QA Engineer']");

 public void SelectExperiencedAutoQAEngPositionFromAnyWhereLocation(){
     Select drpState = new Select(driver.findElement(locationDrpList));
     drpState.selectByValue("Anywhere");
     findElementClickable(experiencedAutoQAEng,2).click();

 }
    public void selectCity(String cityName){
        Select drpState = new Select(driver.findElement(locationDrpList));
        drpState.selectByValue(cityName);
    }
    public void printPositionSummery(String cityName){
        selectCity(cityName);
        List<WebElement> positionNames = findElements(By.tagName("h2"));
        List<WebElement> detailsLinks = findElements(By.xpath("//a[@class='card-jobsHot__link']"));
        System.out.println(cityName);
            for (int i = 0; i < positionNames.size()-1; i++) {
                System.out.println("Position Name : " + positionNames.get(i).getText());
                System.out.println("More info : " + detailsLinks.get(i).getAttribute("href"));
            }
          }

}
