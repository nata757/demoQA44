import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
    }
    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//button[@type ='submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='navbar-nav mr-auto']//li[last()]")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"http://phonebook.telran-edu.de:8080/contacts");
    }

}

