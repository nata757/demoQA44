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



    @AfterMethod
    public void  tearDown() {
        driver.quit();
    }

}
