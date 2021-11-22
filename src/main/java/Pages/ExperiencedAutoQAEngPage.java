package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.TestData.*;

public class ExperiencedAutoQAEngPage extends BasePage {
    public ExperiencedAutoQAEngPage(WebDriver driver) {
        super(driver);
    }
    By applyBtn=By.cssSelector("input[value='Apply']");
    By generalDescriptionSection =By.cssSelector("div:nth-of-type(1) > .pull-right.requirements > .content-title > h2");
    By requirmentsSection= By.cssSelector("div:nth-of-type(1) > .pull-left.requirements > .content-title > h2");
    By responsibilitiesSection =By.cssSelector("div:nth-of-type(2) > .pull-right.requirements > .content-title > h2");
    By whatWeOfferSection =By.cssSelector("div:nth-of-type(2) > .pull-left.requirements > .content-title > h2");
    By applyFor = By.cssSelector("div[role='form']  h2");
    By nameField =By.cssSelector("input[name='your-name']");
    By emailField =By.cssSelector("input[name='your-email']");
    By mobileField = By.cssSelector("input[name='mobile-number']");
    By uploacCVField =By.cssSelector("input#uploadtextfield");
    By linkedInLinkField = By.cssSelector("input[name='linkedin']");
    By yourMsgField =By.cssSelector("textarea[name='your-message']");
    By errorMsgPopUP = By.cssSelector(".message-form-content [aria-hidden]");
    By sendApplicationBtn =By.cssSelector("input[value='Send']");
    By closeErrorPopBtn = By.cssSelector(".close-form");
    By emptyEmailErrorMsg = By.cssSelector(".your-email [aria-hidden]");
    By emptyNameErrorMSG =By.cssSelector(".your-name [aria-hidden]");
    By emptyMobileNumber = By.cssSelector(".mobile-number [aria-hidden]");
    By invalidEmailFormatErrorMsg =By.cssSelector(".wpcf7-form-control-wrap.your-email > .wpcf7-not-valid-tip");


        public boolean checkGeneralDescriptionSectionIsDisplayed(){
            try {
                return findElement(generalDescriptionSection).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
    public boolean checkRequirementsSectionIsDisplayed(){
        try {
            return findElement(requirmentsSection).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean checkWhatWeOfferSectionIsDisplayed(){
        try {
            return findElement(whatWeOfferSection).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean checkResponsibilitiesSectionIsDisplayed(){
        try {
            return findElement(responsibilitiesSection).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public boolean checkApplyBtnIsFound(){
            return findElementClickable(applyBtn,2).isDisplayed();
    }
    public void ApplyToPosition(){
            findElement(applyBtn).click();
            waitUntilLoadingIconDisappears(3);
    }
    public String CheckApplyFormIsOpened(){
         String applyForHeader= findElement(applyFor).getText();
        return  applyForHeader;
    }

    public void fillApplicationFormWithEmptyEmailField(){
            waitUntilElementVisible(applyFor,3);
            findElement(nameField).sendKeys(NAME);
            findElement(mobileField).sendKeys(MOBILE);
            findElement(uploacCVField).sendKeys("src/main/java/utilities/CV.txt");
            findElement(linkedInLinkField).sendKeys(SUBJECT);
            findElement(yourMsgField).sendKeys(YOUR_MESSAGE);
            findElement(sendApplicationBtn).click();
        }
    public void fillApplicationFormWithOutAllRequiredFields(){
        waitUntilElementVisible(applyFor,3);
        findElement(uploacCVField).sendKeys("src/main/java/utilities/CV.txt");
        findElement(linkedInLinkField).sendKeys(SUBJECT);
        findElement(yourMsgField).sendKeys(YOUR_MESSAGE);
        findElement(sendApplicationBtn).click();
    }
    public void fillApplicationFormWithInvalidEmailFormat(){
        waitUntilElementVisible(applyFor,3);
        findElement(nameField).sendKeys(NAME);
        findElement(mobileField).sendKeys(MOBILE);
        findElement(emailField).sendKeys(INVALID_EMAIL_FORMAT);
        findElement(uploacCVField).sendKeys("src/main/java/utilities/CV.txt");
        findElement(linkedInLinkField).sendKeys(SUBJECT);
        findElement(yourMsgField).sendKeys(YOUR_MESSAGE);
        findElement(sendApplicationBtn).click();
    }

        public Boolean checkErrorPopUp(){
            waitUntilLoadingIconDisappears(5);
            try {
                return findElement(errorMsgPopUP).isDisplayed();
            } catch (Exception ex) {
                return false;
            }
        }
        public void closeErrorPopUp(){
            findElementClickable(closeErrorPopBtn,2).click();
        }
    public Boolean checkErrorMsgForEmptyEmailFieldIsDisplayed(){
        waitUntilLoadingIconDisappears(2);
        try {
            return findElement(emptyEmailErrorMsg).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public Boolean checkErrorMsgForEmptyNameFieldIsDisplayed(){
        waitUntilLoadingIconDisappears(2);
        try {
            return findElement(emptyNameErrorMSG).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public Boolean checkErrorMsgForEmptyMobileNumberFieldIsDisplayed(){
        waitUntilLoadingIconDisappears(2);
        try {
            return findElement(emptyMobileNumber).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public Boolean checkErrorMsgForInvalidEmailFormatIsDisplayed(){
        waitUntilLoadingIconDisappears(2);
        try {
            return findElement(invalidEmailFormatErrorMsg ).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
}

