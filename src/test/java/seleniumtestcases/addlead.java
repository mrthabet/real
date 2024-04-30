package seleniumtestcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.login;

public class addlead {
	private WebDriver driver;

    @BeforeTest
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void navigateToAddLead() {
        // توجه إلى صفحة تحتوي على قائمة ليدات وزر إضافة ليد
    	login login = new login(driver);
        login.login("admin@comp1.com", "123456789");

        // الضغط على عنصر ليد من القائمة الجانبية
        driver.findElement(By.xpath("//span[contains(text(),'Leads')]")).click();
     
        // الضغط على أول ليد من القائمة
        driver.findElement(By.xpath("//a[contains(text(),'All Leads')]")).click();

        // الضغط على زر إضافة ليد
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("ahmed");
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("0102188765439");
        WebElement dropdownElement = driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/select[1]")); 
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("olx"); 
        WebElement dropdownElement1 = driver.findElement(By.xpath("//*[@id=\"add_lead\"]/div/div/div[2]/form/div[1]/div[8]/div/select"));
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByIndex(0);
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[9]/div[1]/textarea[1]")).sendKeys("notes");
        driver.findElement(By.xpath("//body/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[2]/button[1]")).click();
      
    }

  

 
   // @AfterTest
    public void tearDown() {
        driver.quit();
    }
	
}
