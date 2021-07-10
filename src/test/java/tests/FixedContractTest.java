package tests;

import org.testng.annotations.Test;
import setup.SetupTests;


public class FixedContractTest extends SetupTests {

    @Test
    public void testLogin() throws InterruptedException {

        loginPage.enterUsername("bnuerteytech@gmail.com");
        loginPage.enterPassword("QwertyAzera1_");
        generalInfoPage = loginPage.clickLoginButton();
    }
    @Test
    public void testGeneralInfo() throws InterruptedException {

        generalInfoPage.closeModal();
        generalInfoPage.clickCreateContract();
        generalInfoPage.clickFixedRate();
        generalInfoPage.enterContractName("Deel");
        generalInfoPage.enterJobTitle("Software Engineer");
        generalInfoPage.selectSeniorityLevel();
        generalInfoPage.enterScope("Help create software for our team");
        generalInfoPage.chooseDate();
        paymentDetails = generalInfoPage.clickNextButton();
    }
    @Test
    public void testPaymentDetails() throws InterruptedException {
        paymentDetails.enterAmount("1000.00");
        paymentDetails.selectCurrency();
        paymentDetails.selectPaymentFrequency();
        paymentDetails.clickNextButton();
        extrasPage = paymentDetails.clickNxtBtn();
    }
    @Test
    public void testExtras() throws InterruptedException {
        extrasPage.selectClause();
        extrasPage.enterClauseText("In case i can not deliver on time, i will give 48hrs notice.");
        compliancePage = extrasPage.clickNextButton();
    }
    @Test
    public void testCompliance() throws InterruptedException {
        try {
            compliancePage.selectCountry();
            compliancePage.selectState();
            compliancePage.clickCreateContract();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
