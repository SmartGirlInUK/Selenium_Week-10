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
        driver.findElement(By.name("Email")).sendKeys("admin@gmail.com");
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
        Assert.assertEquals("Welcome Text Validation","Login was unsuccessful. Please correct the errors and try again.\nNo customer account found",msg);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
