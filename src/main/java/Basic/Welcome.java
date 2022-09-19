package Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Welcome {
    @Test
    public static void main(String args[]) {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.in/");
        driver.quit();
    }
}
