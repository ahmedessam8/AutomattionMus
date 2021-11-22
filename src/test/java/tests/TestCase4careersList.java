package tests;

import Pages.CareersPage;
import Pages.HomePage;
import Pages.PositionsPage;
import org.testng.annotations.Test;

public class TestCase4careersList extends BaseTest {
@Test
    public void CheckByListAndPrintTheAvailablePositionsInSpecificCity(){
    CareersPage careersPage =new CareersPage(driver);
    HomePage homePage =new HomePage(driver);
    PositionsPage positionsPage =new PositionsPage(driver);
    homePage.openCareersTab();
    careersPage.selectCheckOurOpenPositionBtn();
    positionsPage.printPositionSummery("Sofia");
    positionsPage.printPositionSummery("Skopje");
    }
}
