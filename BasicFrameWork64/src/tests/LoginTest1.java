package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest1 {
  
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=3G5RCjbabDA&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiM0c1UkNqYmFiREEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY1NTM4MzUxOCwiaWF0IjoxNjU1MzgyMzE4LCJqdGkiOiJmNDI5MjllOC0wZmVkLTRkMGQtYTU5NC0zZmE4ZmYzNzkwZTYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.hCV7AWl7hPYOE8TlJQdpJTBHzYhD-6GMHq2EPBaObrgNoukcj8E60Vvm_6_VjZY7x5lqPLQbSzfvA5imBmCRfRzgu4F7G5vRVK1i9OQH03Qw-5_sKRz-E8RkDwcjasZTV1-mBOlmZNHGxvPTuIdKv-Jvdgio5gwD5AHeYML2HA4a0nVLiTHcHk7HKGGWvrUh2Lf9cGhVj4Ug1n68vqe5hHnDPiA9H38_mZy3Go73xNXL58G4tsbVU0GP5_dJIj-Ghf6Tt1svekLRNc9XXX9P6E1TkmB08-ztZMaZjoRxQbLla6dx1Kolva7liK-su_ELuLxLgzZ45MndHDMsGSw6vg&preferred_environment=/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  
  }

  @Test
  public void loginEmailWithSpecialCharTest() throws InterruptedException {
	  driver.findElement(By.id("usernameInput-input")).sendKeys("nvbvcbmmvj#@");
		driver.findElement(By.name("password")).sendKeys("jnjcbjvbcjkvbc");
		driver.findElement(By.id("signIn")).click();
		
		Thread.sleep(2000);	  
  	  String expecteErr = "Please enter a username or card number without special characters.";
		String actualErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		System.out.println(actualErr);
		Assert.assertEquals(actualErr, expecteErr);
  	}

  @Test
  public void loginEmailWithEmptyEmailTest() throws InterruptedException {
		driver.findElement(By.name("password")).sendKeys("jnjcbjvbcjkvbc");
		driver.findElement(By.id("signIn")).click();
		
		Thread.sleep(2000);	  
  	  String expecteErr = "Please enter your username or card number.";
		String actualErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
		System.out.println(actualErr);
		Assert.assertEquals(actualErr, expecteErr);
  	}

  @Test
  public void loginEmailWithEmptyPasswordTest() throws InterruptedException {
	  driver.findElement(By.id("usernameInput-input")).sendKeys("nvbvcbmmvj");
		driver.findElement(By.id("signIn")).click();
		
		Thread.sleep(2000);	  
  	  String expecteErr = "Please enter your password.";
		String actualErr = driver.findElement(By.id("PasswordTextField__errors-password")).getText();
		System.out.println(actualErr);
		Assert.assertEquals(actualErr, expecteErr);
  	}

  @Test
  public void loginEmailWithWrongEmailPasswordTest() throws InterruptedException {
	  driver.findElement(By.id("usernameInput-input")).sendKeys("nvbvcbmmvj");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.name("password")).sendKeys("jnjcbjvbcjkvbc");
		
		Thread.sleep(2000);	  
  	  String expecteErr = "Please check your card number / username or password and try again.";
		String actualErr = driver.findElement(By.id("globalError")).getText();
		System.out.println(actualErr);
		Assert.assertEquals(actualErr, expecteErr);
  	}
}
