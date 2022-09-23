package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  
	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
			
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.OpenBrowser();
	  lp.OpenLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.CloseBrowser(); 
	  
  }

  @Test (priority = 1)
  public void loginEmailWithSpecialCharTest() throws InterruptedException {
	  	lp.login(df.emailWithSpecialChar, df.emailWithSpecialChar);
  		String expecteErr = df.specialCharErr;
		String actualErr = lp.readEmailErr(); //while we call the method here, it shows error to change string on login page line 32.
		Assert.assertEquals(actualErr, expecteErr); // remove the print line as we are printing in login page.
  	}

  @Test (priority = 2)
  public void loginEmailWithEmptyEmailTest() throws InterruptedException {
		lp.login("", df.wrongPassword);
  	  String expecteErr = df.emptyEmailErr;
		String actualErr = lp.readEmailErr();
		Assert.assertEquals(actualErr, expecteErr);
  	}

  @Test (priority = 3)
  public void loginEmailWithEmptyPasswordTest() throws InterruptedException {
	  	lp.login(df.wrongEmail, "");
	  	String expecteErr = df.emptyPasswordErr;
		String actualErr = lp.readPasswordErr();
		Assert.assertEquals(actualErr, expecteErr);
  	}

  @Test (priority = 4)
  public void loginEmailWithWrongEmailPasswordTest() throws InterruptedException {
	  	lp.login(df.wrongEmail, df.wrongPassword);
		String expecteErr = df.globalErr;
		String actualErr = lp.readGlobalErr();
		Assert.assertEquals(actualErr, expecteErr);
  	}
}
