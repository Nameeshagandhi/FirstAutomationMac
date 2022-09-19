package RahulShettyAcademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameEX {
    public WebDriver driver;

    @BeforeMethod
    public void login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        System.out.println(driver.findElements(By.tagName("frame")).size());
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        Thread.sleep(4000);
        System.out.println(driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
