package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoQaPage {
    WebDriver driver;

    public DemoQaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



}

