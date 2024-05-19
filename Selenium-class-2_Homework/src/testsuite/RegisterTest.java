package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String Url = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(Url);
    }
    @Test
    public void registerMessage(){
        clickOnElement(By.className("ico-register"));
        String msg=driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        Assert.assertEquals("Register Message Validation","Register",msg);
    }

    @Test
    public void register() {
        clickOnElement(By.className("ico-register"));
        clickOnElement(By.id("gender-female"));
        driver.findElement(By.id("FirstName")).sendKeys("Admin");
        driver.findElement(By.name("LastName")).sendKeys("ABC");
        clickOnElement(By.xpath("//select[@name='DateOfBirthDay']//option[@value='30']"));
        clickOnElement(By.xpath("//select[@name='DateOfBirthMonth']//option[@value='8']"));
        clickOnElement(By.xpath("//select[@name='DateOfBirthYear']//option[@value='1999']"));
        driver.findElement(By.id("Email")).sendKeys("admin123@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("AdminABC");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("AdminABC");
        clickOnElement(By.id("register-button"));
        String msg = driver.findElement(By.className("result")).getText();
        Assert.assertEquals("Registration Validation", "Your registration completed", msg);
    }
    @Test
    public void registerWithExistEmailID() {
        clickOnElement(By.className("ico-register"));
        clickOnElement(By.id("gender-male"));
        driver.findElement(By.id("FirstName")).sendKeys("Xyz");
        driver.findElement(By.name("LastName")).sendKeys("ABC");
        clickOnElement(By.xpath("//select[@name='DateOfBirthDay']//option[@value='23']"));
        clickOnElement(By.xpath("//select[@name='DateOfBirthMonth']//option[@value='6']"));
        clickOnElement(By.xpath("//select[@name='DateOfBirthYear']//option[@value='1986']"));
        driver.findElement(By.id("Email")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("xyz123");
        driver.findElement(By.name("ConfirmPassword")).sendKeys("xyz123");
        clickOnElement(By.id("register-button"));
        String msg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']/ul/li")).getText();
        Assert.assertEquals("User Already Exist", "The specified email already exists", msg);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
