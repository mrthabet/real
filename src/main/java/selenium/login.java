package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class login {

	private WebDriver driver;

	@FindBy(id = "email")
	private WebElement usernameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div/form/div[3]/button")
	private WebElement loginButton;

	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		driver.get("https://company1.realstatecrm-main.dev.alefsoftware.com/en/login");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
		wait.until(ExpectedConditions.visibilityOf(usernameInput));
		usernameInput.sendKeys(username);

		wait.until(ExpectedConditions.visibilityOf(passwordInput));
		passwordInput.sendKeys(password);

		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
}