package MakeSeleniumEasy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookLogin {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        // Setting browser driver through WebDriverManager
        WebDriverManager.chromedriver().setup();
        // Opening chrome browser
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
    }
    @Test
    public void login(){
        //Locating a web element using id
        WebElement emailTextBox= driver.findElement(By.id("email"));
        // Checking if element is displayed
        Boolean flagEmailTextBox=emailTextBox.isDisplayed();
        if(flagEmailTextBox==true)
            System.out.println("Element is displayed");
        else
            System.out.println("Element is not displaying");

        // Checking if element is enable
        Boolean flagEnableEmailTextBox=driver.findElement(By.id("email")).isEnabled();
        if(flagEnableEmailTextBox==true)
            System.out.println("Element is Enabled");
        else
            System.out.println("Element is not Enabled");

        // Typing in text box
        if(flagEmailTextBox == true && flagEnableEmailTextBox== true){
            emailTextBox.sendKeys("gandhinameesha20@gmail.com");
            String typeValue=emailTextBox.getAttribute("value");
            System.out.println("Typed Value : "+typeValue);
            if(typeValue.contains("gandhi")){
                System.out.println("Correct value is typed");
            }
            else {
                System.out.println("Correct value is not typed");
            }
        }else {
            System.out.println("Either element is not displayed or enabled");
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
