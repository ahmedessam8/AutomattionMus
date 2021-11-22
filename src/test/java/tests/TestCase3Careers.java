package tests;

import Pages.CareersPage;
import Pages.ExperiencedAutoQAEngPage;
import Pages.HomePage;
import Pages.PositionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.TestData.JOIN_US_URL;

public class TestCase3Careers extends BaseTest {


    @Test
    public void verifyClickOnCheckOurOpenPositionsBtn_shouldOpenJoinUsPage(){
        CareersPage careersPage =new CareersPage(driver);
        goToCareersPage();
        careersPage.selectCheckOurOpenPositionBtn();
        Assert.assertEquals(careersPage.getURLValue(),JOIN_US_URL);
    }

    @Test
    public void verifyOnTheMainSectionsInOpenedPositions_shouldReturn_4_mainSectionsSucc(){
        PositionsPage positionsPage =new PositionsPage(driver);
        ExperiencedAutoQAEngPage experiencedAutoQAEngPage =new ExperiencedAutoQAEngPage(driver);
        CareersPage careersPage =new CareersPage(driver);
        goToCareersPage();
        careersPage.selectCheckOurOpenPositionBtn();
        positionsPage.SelectExperiencedAutoQAEngPositionFromAnyWhereLocation();
        Assert.assertTrue(experiencedAutoQAEngPage.checkGeneralDescriptionSectionIsDisplayed());
        Assert.assertTrue(experiencedAutoQAEngPage.checkRequirementsSectionIsDisplayed());
        Assert.assertTrue(experiencedAutoQAEngPage.checkResponsibilitiesSectionIsDisplayed());
        Assert.assertTrue(experiencedAutoQAEngPage.checkWhatWeOfferSectionIsDisplayed());
        Assert.assertTrue(experiencedAutoQAEngPage.checkApplyBtnIsFound());
    }

    @Test // fill application form with Only Email field is missing , check the validation message
    public void verifyApplyingForPositionUsingInvalidData_EmptyEmail(){
        PositionsPage positionsPage =new PositionsPage(driver);
        ExperiencedAutoQAEngPage experiencedAutoQAEngPage =new ExperiencedAutoQAEngPage(driver);
        CareersPage careersPage =new CareersPage(driver);
        goToCareersPage();
        careersPage.selectCheckOurOpenPositionBtn();
        positionsPage.SelectExperiencedAutoQAEngPositionFromAnyWhereLocation();
        experiencedAutoQAEngPage.ApplyToPosition();
        experiencedAutoQAEngPage.fillApplicationFormWithEmptyEmailField();
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorPopUp());
        experiencedAutoQAEngPage.closeErrorPopUp();
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorMsgForEmptyEmailFieldIsDisplayed());

    }
    @Test // fill application form with invalid email format then check the validation Messages
    public void verifyApplyingForPositionWithInvalidEmailFormat_shouldFireValidation(){
        PositionsPage positionsPage =new PositionsPage(driver);
        ExperiencedAutoQAEngPage experiencedAutoQAEngPage =new ExperiencedAutoQAEngPage(driver);
        CareersPage careersPage =new CareersPage(driver);
        goToCareersPage();
        careersPage.selectCheckOurOpenPositionBtn();
        positionsPage.SelectExperiencedAutoQAEngPositionFromAnyWhereLocation();
        experiencedAutoQAEngPage.ApplyToPosition();
        experiencedAutoQAEngPage.fillApplicationFormWithInvalidEmailFormat();
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorPopUp());
        experiencedAutoQAEngPage.closeErrorPopUp();
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorMsgForInvalidEmailFormatIsDisplayed());

    }

    @Test // fill application form with Missing all required fields then check the validation Messages
    public void verifyApplyingForPositionWithoutAllRequiredFields_shouldFireValidations(){
        PositionsPage positionsPage =new PositionsPage(driver);
        ExperiencedAutoQAEngPage experiencedAutoQAEngPage =new ExperiencedAutoQAEngPage(driver);
        CareersPage careersPage =new CareersPage(driver);
        goToCareersPage();
        careersPage.selectCheckOurOpenPositionBtn();
        positionsPage.SelectExperiencedAutoQAEngPositionFromAnyWhereLocation();
        experiencedAutoQAEngPage.ApplyToPosition();
        experiencedAutoQAEngPage.fillApplicationFormWithOutAllRequiredFields();
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorPopUp());
        experiencedAutoQAEngPage.closeErrorPopUp();
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorMsgForEmptyEmailFieldIsDisplayed());
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorMsgForEmptyMobileNumberFieldIsDisplayed());
        Assert.assertTrue(experiencedAutoQAEngPage.checkErrorMsgForEmptyNameFieldIsDisplayed());

    }
    public HomePage goToCareersPage(){
        HomePage homePage =new HomePage(driver);
        return homePage.openCareersTab();

    }
}
