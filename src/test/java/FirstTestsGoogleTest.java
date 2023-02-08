import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestsGoogleTest {
    // before test method setUp

    // Tests

    // after test method tearDown
    WebDriver driver;
    String title;



    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }
    @Test
    public void shouldBeRightTitle(){
        title = driver.getTitle();
        Assert.assertEquals(title, "Google","The page contains a wrong title");
    }

    @Test
    public void searchGoogle() {
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Tel-Ran");
        driver.findElement(By.name("btnK")).click();

        Assert.assertTrue(driver.getPageSource().contains("Tel-Ran.de"), "The expected text was not in the search page");

        String actualText = driver.findElement(By.id("hdtb-tls")).getText();
        String expectedText = "Инструменты";

        Assert.assertEquals(actualText, expectedText, "Фактический текст не соответствует ожидаемому");
    }



    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }

}
