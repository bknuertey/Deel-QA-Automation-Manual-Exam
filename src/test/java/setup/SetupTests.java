package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import packageObjects.*;

import java.util.concurrent.TimeUnit;

public class SetupTests
{

    WebDriver driver;

    protected LoginPage loginPage;

    protected GeneralInfoPage generalInfoPage;

    protected PaymentDetails paymentDetails;

    protected ExtrasPage extrasPage;

    protected CompliancePage compliancePage;

    @BeforeTest
    public void setup()
    {
        //add chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //launch a new browser instance
        driver = new ChromeDriver();

        //maximize chrome browser window
        driver.manage().window().maximize();

        //navigate to deel dev website
        driver.get("https://dev.deel.wtf/");

        //go to login page to enter login details
        loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser()
    {
        //close browser
        driver.quit();
    }
}
