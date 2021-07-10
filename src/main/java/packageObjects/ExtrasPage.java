package packageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ExtrasPage {

    public ExtrasPage(WebDriver driver) {this.driver = driver;}

    WebDriver driver;

    //initialize variable
    By clause = By.cssSelector("div.mt-7:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)");

    public void selectClause() throws InterruptedException
    {
        driver.findElement(clause).click();
        Thread.sleep(500);
    }

    public void enterClauseText(String ctext) throws InterruptedException
    {
        driver.findElement(By.xpath("//textarea[@class='textarea pt-4 pr-7 pl-7 resizable pb-4 ']")).sendKeys(ctext);
        Thread.sleep(1000);
    }

    public CompliancePage clickNextButton()
    {
        driver.findElement(By.cssSelector(".mt-7:nth-child(1) > div")).click();
        return new CompliancePage(driver);
    }
}
