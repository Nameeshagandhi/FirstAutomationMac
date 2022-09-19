package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class XPathPractice {
    WebDriver driver;
    WebElement element;

    @BeforeMethod
    public void driverGet() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/selenium-xpath.html");
        driver.manage().window().maximize();
    }

    @Test
    public void main() {
        //absolute xpath
        element = driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/h4/b[1]"));
        System.out.println(element.getText());
        //Relative XPath
        WebElement RelativeElement=driver.findElement(By.xpath("//div[@class='featured-box cloumnsize1']//h4[1]/b"));
        System.out.println(RelativeElement.getText());
        
    }

    @AfterMethod
    public void kill() {
        driver.quit();
    }
}
