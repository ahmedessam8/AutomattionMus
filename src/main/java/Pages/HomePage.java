package Pages;

import Models.Objects.ContactUs;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static utilities.TestData.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By contactUsBtn =By.cssSelector(".fancybox > .btn.btn-1b.contact-label");
    By contactUsPopUP =By.cssSelector("div#contact_form_pop");
    By nameField =By.cssSelector("input[name='your-name']");
    By emailField =By.cssSelector("input[name='your-email']");
    By mobileField =By.cssSelector("input[name='mobile-number']");
    By subjectField =By.cssSelector("input[name='your-subject']");
    By msgField= By.cssSelector("textarea[name='your-message']");
    By sendBtn = By.cssSelector("input[value='Send']");
    By emailValidationError =By.cssSelector(".wpcf7-form-control-wrap.your-email > .wpcf7-not-valid-tip");
    By companyTap =By.xpath("//div[@id='menu']/ul[@class='nav']//a[@href='https://www.musala.com/company/']");
    By careersTab =By.xpath("//body[1]/header[1]/nav[2]/div[1]/div[1]/ul[1]/li[5]/a[1]");

public void openContactUs() {

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("window.scrollBy(0,500)");
    findElement(contactUsBtn).click();
    waitUntilElementVisible(contactUsPopUP, 3);

}
    public void fillContactUsFormWithInvalidEmailFormat(ContactUs contactUs)throws IOException {

        findElement(nameField).sendKeys(contactUs.getName());
        findElement(mobileField).sendKeys(contactUs.getMobile());
        findElement(emailField).sendKeys(contactUs.getEmail());
        findElement(subjectField).sendKeys(contactUs.getSubject());
        findElement(msgField).sendKeys(contactUs.getMessage());
        findElement(sendBtn).click();
        waitUntilLoadingIconAppears(1);

  }
  public void clearContactUsFormFields(){
      findElement(nameField).clear();
      findElement(mobileField).clear();
      findElement(emailField).clear();
      findElement(subjectField).clear();
      findElement(msgField).clear();
  }

 public boolean emailValidationMsgIsDisplayed() {
     try {
         return findElement(emailValidationError).isDisplayed();
     }
     catch (Exception ex)
     {
         return false;
     }
 }
 public HomePage openCompany(){
    findElement(companyTap).click();
    waitUntilLoadingIconDisappears(3);
     return new HomePage(driver);
 }
 public HomePage openCareersTab(){
    findElementClickable(careersTab,3).click();
     return new HomePage(driver);
 }
}
