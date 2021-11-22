package tests;

import Pages.CompanyPage;
import Pages.FaceBookPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.TestData.COMPANY_URL;
import static utilities.TestData.MUSALA_FACEBOOK_URL;

public class TestCase2Company extends BaseTest {


    FaceBookPage faceBookPage;

    @Test
    public void checkTheCurrentURL_shouldBeLoadsSucc(){
        CompanyPage companyPage = new CompanyPage(driver);
         goToCompanyPage();
        Assert.assertEquals(companyPage.getURLValue(),COMPANY_URL);
    }
    @Test
    public void verifyLeaderShipSectionIs_shouldBeFound(){
        CompanyPage companyPage = new CompanyPage(driver);
        goToCompanyPage();
        Assert.assertTrue(companyPage.checkLeaderShipSectionIsFound());
    }
    @Test
    public void verifyFaceBookLinkAndImage_shouldBeReturnedSucc(){
        CompanyPage companyPage = new CompanyPage(driver);
        FaceBookPage faceBookPage =new FaceBookPage(driver);
        goToCompanyPage();
        companyPage.openFaceBookLinkFromFooter();
        Assert.assertEquals(faceBookPage.getURLValue(),MUSALA_FACEBOOK_URL);
        Assert.assertTrue(faceBookPage.checkMusalaSoftPicIsFound());
    }


    public HomePage goToCompanyPage(){
        HomePage homePage =new HomePage(driver);
        return homePage.openCompany();

    }

}

