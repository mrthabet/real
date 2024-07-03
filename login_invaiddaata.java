package seleniumtestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.login;

public class login_invaiddaata {


    private WebDriver driver;

    @BeforeTest
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testOrangeHRM() throws IOException { 
        login login = new login(driver);
        login.login("admin@comp1.com", "12340000056789");
        System.out.println("بياات غير صاحة");

       
    }

 
   // @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
