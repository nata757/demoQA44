import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class PhoneBookFirstTest {
    WebDriver driver;
    String title;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
    }

    @Test
    public void shouldBeRightTitle() {
        title = driver.getTitle();
        Assert.assertEquals(title, "PhonebookUi", "The page contains a wrong title");
    }

    @Test
    public void loginTest() {
        //driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("test@gmail.com");
        driver.findElement(By.className("btn")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(), 'Bakanov ')]")).isDisplayed());



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
