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


    By firstNameInput = By.xpath("//input[@id='form-name']");
    By lastNameInput = By.xpath("//input[@id='form-lastName']");
    By aboutInput = By.xpath("//*[@id='form-about']");
    By saveButton = By.xpath("//*[@class='btn btn-primary']");
    By addContactMenuLink = By.xpath("//ul[@class='navbar-nav mr-auto']//li[last()]");
    By firstNameField = By.xpath("//div[@id='contact-first-name']");
    By lastNameField = By.xpath("//div[@id='contact-last-name']");
    By contactDescriptionField = By.xpath("//div[@id='contact-description']");

public void getAuth() {
    driver.findElement(By.xpath("//input[@name='email']")).clear();
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmail.com");
    driver.findElement(By.xpath("//input[@name='password']")).clear();
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@gmail.com");
    driver.findElement(By.xpath("//button[@type ='submit']")).click();
}

    @Test
    public void addNewContactTest(){
        String firstName = "Peter";
        String lastName = "Bolt";
        String about = "Peter is my friend";
        getAuth();
        driver.findElement(addContactMenuLink).click();
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(aboutInput).clear();
        driver.findElement(aboutInput).sendKeys(about);
        driver.findElement(saveButton).click();

        Assert.assertEquals(driver.findElement(firstNameField).getText(), firstName);
        Assert.assertEquals(driver.findElement(lastNameField).getText(), lastName);
        Assert.assertEquals(driver.findElement(contactDescriptionField).getText(),about);



    }
    @Test
    public void loginTest() {
        getAuth();

        Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='navbar-nav mr-auto']//li[last()]")).isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"http://phonebook.telran-edu.de:8080/contacts");
    }



}

