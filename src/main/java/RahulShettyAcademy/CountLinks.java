package RahulShettyAcademy;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CountLinks {
    public WebDriver driver;
    public WebElement element;
    public WebDriverWait wait;
    public Actions actions;

    @BeforeMethod
    public void login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        actions = new Actions(driver);
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      //  wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    }

    @Test
    public void test() {
        System.out.println(driver.findElements(By.tagName("a")).size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
