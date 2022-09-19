package RahulShettyAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class HandleWindows {
    public WebDriver driver;

    @BeforeMethod
    public void login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
        Set<String> windows = driver.getWindowHandles();
       Iterator<String> iterator= windows.iterator();
        String parentId=iterator.next();
        System.out.println(parentId);
        String childId=iterator.next();
        System.out.println(childId);
        driver.switchTo().window(childId);
        Thread.sleep(4000);
        System.out.println(driver.findElement(By.cssSelector("p[class='im-para red']")).getText());
        String emailId=driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println(emailId);
        driver.switchTo().window(parentId);
        Thread.sleep(2000);
        driver.findElement(By.id("username")).sendKeys(emailId);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
