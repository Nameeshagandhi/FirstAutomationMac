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

public class FrameTest {
    public WebDriver driver;
    public Actions actions;

    @BeforeMethod
    public void login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("Number of frames on screen : "+driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(drag, drop).build().perform();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("draggable")).getText());
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();
        System.out.println("back to the parent frame ");
        System.out.println(driver.findElement(By.xpath("//p[text()='Create targets for draggable elements.']")).getText());
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
        System.out.println(driver.findElement(By.xpath("//p[text()='Dropped!']")).getText());
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
