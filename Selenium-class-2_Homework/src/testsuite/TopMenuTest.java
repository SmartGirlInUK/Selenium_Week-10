package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String Url = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(Url);
    }
    @Test
    public void computers(){
        clickOnElement(By.linkText("Computers"));
        String msg=driver.findElement(By.xpath("//h1[text()='Computers']")).getText();
        Assert.assertEquals("Computers Message Validation","Computers",msg);
    }
    @Test
    public void electronics(){
        clickOnElement(By.linkText("Electronics"));
        String msg=driver.findElement(By.xpath("//h1[text()='Electronics']")).getText();
        Assert.assertEquals("Electronics Message Validation","Electronics",msg);
    }
    @Test
    public void apparel(){
        clickOnElement(By.linkText("Apparel"));
        String msg=driver.findElement(By.xpath("//h1[text()='Apparel']")).getText();
        Assert.assertEquals("Apparel Message Validation","Apparel",msg);
    }
    @Test
    public void digitalDownloads(){
        clickOnElement(By.linkText("Digital downloads"));
        String msg=driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        Assert.assertEquals("Digital downloads Message Validation","Digital downloads",msg);
    }
    @Test
    public void Books(){
        clickOnElement(By.linkText("Books"));
        String msg=driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        Assert.assertEquals("Books Message Validation","Books",msg);
    }
    @Test
    public void jewelry(){
        clickOnElement(By.linkText("Jewelry"));
        String msg=driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        Assert.assertEquals("Jewelry Message Validation","Jewelry",msg);
    }
    @Test
    public void giftCards(){
        clickOnElement(By.linkText("Gift Cards"));
        String msg=driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        Assert.assertEquals("Gift Cards Message Validation","Gift Cards",msg);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
