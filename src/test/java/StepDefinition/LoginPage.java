package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver;	
@Given("User is in login page" )
	public void loginfunction() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	options.addArguments("--disable-gpu");	
	
	  driver = new ChromeDriver(options);
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 driver.manage().window().maximize();	
	
	}
@When("^user enters (.*) and (.*)$")
	public void loginpage(String usernamevalue, String passwordvalue) throws InterruptedException {
	Thread.sleep(5000);
	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
	username.sendKeys(usernamevalue);
	
	
	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
	password.sendKeys(passwordvalue);	
	
		
		}
@And("Click on login button")
public void entercredentials() throws InterruptedException {
	Thread.sleep(3000);
	WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
	login.click();
		
	}
@Then("^User navigated to Homepage$")
	public void homepage() throws InterruptedException {
	Thread.sleep(3000);
	WebElement upgrade = driver.findElement(By.xpath("//button[@class='oxd-glass-button orangehrm-upgrade-button']"));
	String text = upgrade.getText();
	
	if (text.equals("Upgrade")) {
		System.out.println("Home page launched successfully");
	}
		else {
			System.out.println("Home not launched");
		}
	
		}
}

