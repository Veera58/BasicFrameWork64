package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  
	WebDriver driver;
	
	//WebElement email = driver.findElement(By.id("usernameInput-input"));
	//WebElement password = driver.findElement(By.name("password")); 
		
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalError;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailError;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordError;

	public void OpenBrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("C:\\Testing\\porp.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\Chromedriver.exe");
			driver = new ChromeDriver(); 
		}else {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver(); 
		}

		
	PageFactory.initElements(driver, this);
	}

	public void OpenLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=3G5RCjbabDA&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiM0c1UkNqYmFiREEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NTM4MzUxOCwiaWF0IjoxNjU1MzgyMzE4LCJqdGkiOiJmNDI5MjllOC0wZmVkLTRkMGQtYTU5NC0zZmE4ZmYzNzkwZTYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.hCV7AWl7hPYOE8TlJQdpJTBHzYhD-6GMHq2EPBaObrgNoukcj8E60Vvm_6_VjZY7x5lqPLQbSzfvA5imBmCRfRzgu4F7G5vRVK1i9OQH03Qw-5_sKRz-E8RkDwcjasZTV1-mBOlmZNHGxvPTuIdKv-Jvdgio5gwD5AHeYML2HA4a0nVLiTHcHk7HKGGWvrUh2Lf9cGhVj4Ug1n68vqe5hHnDPiA9H38_mZy3Go73xNXL58G4tsbVU0GP5_dJIj-Ghf6Tt1svekLRNc9XXX9P6E1TkmB08-ztZMaZjoRxQbLla6dx1Kolva7liK-su_ELuLxLgzZ45MndHDMsGSw6vg&preferred_environment=/");
	}
		
	public void CloseBrowser() {
		 driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signInButton.click();	
		Thread.sleep(2000);
	}
	
	public String readEmailErr() {  //void will be changed to string and ask to add return line.
		String actualErr = emailError.getText();
		System.out.println(actualErr);
		return actualErr;
	}

	public String readPasswordErr() {
		String actualErr = passwordError.getText();
		System.out.println(actualErr);
		return actualErr;	
	}

	public String readGlobalErr() {
		String actualErr = globalError.getText();
		System.out.println(actualErr);
		return actualErr;
		}
	
}
