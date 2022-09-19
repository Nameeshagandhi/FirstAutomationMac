package RahulShettyAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ActionClass {
    public WebDriver driver;
    public Actions actions;
    @BeforeMethod
    public void login(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        actions=new Actions(driver);
    }

    @Test
    public void test() throws InterruptedException {
        WebElement account=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        actions.moveToElement(account).perform();

            Thread.sleep(1000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
