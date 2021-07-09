package packageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class PaymentDetails {

    public PaymentDetails(WebDriver driver) {this.driver = driver;}

    WebDriver driver;

    //initialize variables
    By amount = By.xpath("//input[@name='rate']");
    By currencyDropDown = By.cssSelector(".select");
    By currency = By.id("react-select-3-option-37");
    By billDateDropDown = By.cssSelector("div.py-5:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > svg:nth-child(1)");
    By billDate = By.id("react-select-4-option-0");

    public void enterAmount(String amt) throws InterruptedException
    {
        //wait for page to show fully
        Thread.sleep(1000);
        driver.findElement(amount).sendKeys(amt);
    }

    public void selectCurrency() throws InterruptedException
    {
        driver.findElement(currencyDropDown).click();
        driver.findElement(currency).click();
    }

    public void selectPaymentFrequency() throws InterruptedException
    {
        driver.findElement(billDateDropDown).click();
        driver.findElement(billDate).click();
    }

    public void clickNextButton() throws InterruptedException
    {
        //This button was a scroll so first click on the button and scroll to next page
        driver.findElement(By.cssSelector(".mt-9:nth-child(2) > div")).click();

        //instantiate javascript executor
        JavascriptExecutor b = (JavascriptExecutor)driver;

        //wait for the scroll element to show up
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //scroll to the next window
        b.executeScript("window.scrollTo(0,0)");
        Thread.sleep(1000);
    }

    public ExtrasPage clickNxtBtn()
    {
        driver.findElement(By.cssSelector("button.mt-9")).click();
        return new ExtrasPage(driver);
    }
}
