package packageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class GeneralInfoPage {

    public GeneralInfoPage(WebDriver driver) {this.driver = driver;}

    WebDriver driver;

    //initiate variables
    By Modal = By.className("modal-content");
    By createContract = By.xpath("//p[contains(.,'Create a Contract')]");
    By fixedRate = By.xpath("//a[@href='/create/fixed']");
    By contractName = By.xpath("//div[@id='root']/div/div/div/form/div/div/div[2]/input");
    By jobTitle = By.xpath("//input[@name='jobTitle']");
    By scope = By.xpath("//textarea[@name='scope']");


    public void closeModal() throws InterruptedException
    {
        //wait for modal to show up then close it
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Modal));

        //use webelement to find and switch to the modal
        WebElement getModal = driver.findElement(Modal);
        driver.switchTo().activeElement();

        //click on the x button to close modal
        driver.findElement(By.cssSelector("body > div.fade.popup.whats-new-popup.modal.show > div > div > div > div.whats-new-slides > button")).click();
    }

    public void clickCreateContract() throws InterruptedException
    {
        //wait for the sidebar to show with options
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createContract));

        //click on create a contract
        driver.findElement(createContract).click();
    }

    public void clickFixedRate() throws InterruptedException
    {
        driver.findElement(fixedRate).click();
    }

    public void enterContractName(String cname) throws InterruptedException
    {
        driver.findElement(contractName).sendKeys(cname);
    }

    public void enterJobTitle(String jname) throws InterruptedException
    {
        //find the job title field and use sendkeys to enter text
        driver.findElement(jobTitle).sendKeys(jname);
    }

    public void selectSeniorityLevel() throws InterruptedException
    {
        //open the seniority level menu
        driver.findElement(By.cssSelector(".select")).click();

        //click on option number 4
        driver.findElement(By.id("react-select-2-option-4")).click();
    }

    public void enterScope(String scopetext) throws InterruptedException
    {
        driver.findElement(scope).sendKeys(scopetext);
    }

    public void chooseDate() throws InterruptedException
    {
        //get the date of previous day
        LocalDateTime previousDayOfMonth = LocalDateTime.now().minusDays(1);

        //format date into short month name, single day and full year
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLLL d, yyyy");

        //convert date into string, it will display in this format short month name day, year
        String formattedDate = previousDayOfMonth.format(formatter);

        //click on dropdown arrow in the date field
        driver.findElement(By.cssSelector(".chevron svg")).click();

        //initiate javascript executor to scroll to bottom of page
        JavascriptExecutor a = ((JavascriptExecutor)driver);

        //initiate javascript executor to click on date
        //JavascriptExecutor b = ((JavascriptExecutor)driver);

        //scroll to bottom of page
        a.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //This is my first solution which works as well but is not native
        // click on date of previous day using string from formattedDate
        //b.executeScript("arguments[0].click();", driver.findElement(By.xpath("//abbr[@aria-label='"+formattedDate+ "']")));

        //This is my preferred solution as it is native
        driver.findElement(By.xpath("//abbr[@aria-label='"+formattedDate+ "']")).click();

        Thread.sleep(1000);
    }

    public PaymentDetails clickNextButton()
    {
        //click on next button
        driver.findElement(By.cssSelector(".mb-7")).click();
        return new PaymentDetails(driver);
    }
}
