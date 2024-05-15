package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String Url = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(Url);
    }
    @Test
    public void login(){
        clickOnElement(By.className("ico-login"));
        String msg=driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Welcome Text Validation","Welcome, Please Sign In!",msg);
    }
    @Test
    public void loginWithValidCredentials(){
        clickOnElement(By.className("ico-login"));
        driver.findElement(By.name("Email")).sendKeys("abcadmin@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("AdminABC");
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        String msg=driver.findElement(By.className("ico-logout")).getText();
        Assert.assertEquals("Welcome Text Validation","Log out",msg);
    }
    @Test
    public void loginWithInvalidCredentials(){
        clickOnElement(By.className("ico-login"));
        driver.findElement(By.name("Email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123ABC");
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        String msg=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error Message Validation","Login was unsuccessful. Please correct the errors and try again.\nNo customer account found",msg);
    }
    @Test
    public void loginWithoutEmail(){
        clickOnElement(By.className("ico-login"));
        driver.findElement(By.name("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("123ABC");
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        String msg=driver.findElement(By.id("Email-error")).getText();
        Assert.assertEquals("Enter Email Validation","Please enter your email",msg);
    }
    @Test
    public void loginWithoutPassword(){
        clickOnElement(By.className("ico-login"));
        driver.findElement(By.name("Email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("");
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        String msg=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error Message Validation","Login was unsuccessful. Please correct the errors and try again.\nNo customer account found",msg);
    }
    @Test
    public void loginWithoutEmailAndPassword(){
        clickOnElement(By.className("ico-login"));
        driver.findElement(By.name("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
        String msg=driver.findElement(By.id("Email-error")).getText();
        Assert.assertEquals("Enter Email Validation","Please enter your email",msg);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
