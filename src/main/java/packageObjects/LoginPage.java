package packageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public LoginPage(WebDriver driver) {this.driver = driver;}

    WebDriver driver;

    public void enterUsername(String email)
    {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    public void enterPassword(String pwd)
    {
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
    }

    public GeneralInfoPage clickLoginButton()
    {
        //find and click on the login button
        driver.findElement(By.xpath("//form/button/div")).click();

        //go to generalinfo page
        return new GeneralInfoPage(driver);
    }
}
