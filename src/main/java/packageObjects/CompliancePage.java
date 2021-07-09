package packageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CompliancePage {

    public CompliancePage(WebDriver driver) {this.driver = driver;}

    WebDriver driver;

    //initialize variables
    By country = By.xpath("//div[@id='root']/div/div/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]");
    By state = By.xpath("//div[@id='root']/div/div/div/div[2]/div/div[4]/div/div/div[2]/div/div[6]");

    public void selectCountry() throws InterruptedException
    {
        //wait for page to show
        Thread.sleep(1000);

        //click on the country field
        driver.findElement(By.cssSelector(".select__control")).click();

        //select USA
        driver.findElement(country).click();
    }

    public void selectState() throws InterruptedException
    {
        Thread.sleep(1000);

        //click on state field
        driver.findElement(By.cssSelector(".flex:nth-child(1) > .select")).click();

        //select Colorado
        driver.findElement(state).click();
    }

    public void clickCreateContract() throws InterruptedException
    {
        //click on create contract button
        driver.findElement(By.cssSelector(".mt-7:nth-child(1) > div")).click();

        //initiate a wait
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //wait until the next page loads
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div[1]/div[2]/div")));

        //pause the process before closing the browser
        Thread.sleep(1000);
    }
}
