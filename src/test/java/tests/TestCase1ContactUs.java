package tests;

import Models.Objects.ContactUs;
import Pages.HomePage;
import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static utilities.utils.readContactUsCsvFile;

public class TestCase1ContactUs extends BaseTest {

    HomePage homePage;

    @Test
    public void testContactUs_usingWrongEmailFormat_shouldReturnErrorMsg() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.openContactUs();
        List<ContactUs> contactUsList = readContactUsCsvFile();
        for (ContactUs contactUs : contactUsList) {
            homePage.fillContactUsFormWithInvalidEmailFormat(contactUs);
            Assert.assertTrue(homePage.emailValidationMsgIsDisplayed());
            homePage.clearContactUsFormFields();
        }
    }

}
