package RahulShettyAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandleEx {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeMethod
    public void login(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
    }

    @Test
    public void test() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[text()='Multiple Windows']"))));
        WebElement element1=driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
        element1.click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> handle=driver.getWindowHandles();
        Iterator<String> iterator=handle.iterator();
        String parentId=iterator.next();
        String childId=iterator.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());
        Thread.sleep(3000);
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());
        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDown(){
     driver.quit();

    }
}
