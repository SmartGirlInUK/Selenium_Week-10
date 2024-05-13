package browserfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver=new ChromeDriver();

    public void openBrowser(String baseUrl){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void closeBrowser(){
        driver.quit();
    }

    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void sendTextToElement(By by, String text) {
        WebElement element=driver.findElement(by);
        element.sendKeys(text);
    }

}

