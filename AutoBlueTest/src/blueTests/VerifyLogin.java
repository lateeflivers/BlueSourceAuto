package blueTests;
import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import blueSource.BlueLogin;


public class VerifyLogin {

	private static WebDriver driver;
	
	@BeforeTest
	public static void initializeTest(){
		driver = new InternetExplorerDriver();
		
	}
	
	/**
	 * Verifies Successful Login
	 * @param url
	 * @param firstName
	 * @param lastName
	 * @param password
	 */
	@Test(description="Verifies succesfull login")
	@Parameters({"url","firstName","lastName","password"})
	public void testLoginProcess(String url, String firstName, String lastName, String password){
		BlueLogin loginPage = new BlueLogin(driver);
		
		//Log in
		loginPage.setURL(url);
		loginPage.open();
		loginPage.enterFirstAndLastName(firstName, lastName);
		loginPage.enterPassword(password);
		loginPage.submitForm();
		assertTrue(loginPage.isElementPresentAndDisplayed(By.linkText("Logout")));
		
		loginPage.clickLogout();
		
	}
	
	
	@Test(description="Verify unsuccessful login with a user not in the system")
	@Parameters({"url","firstName","lastName","password"})
	public void verifyBadLogin(String url, String firstName, String lastName, String password){
		BlueLogin loginPage = new BlueLogin(driver);
		
		loginPage.setURL(url);
		loginPage.open();
		loginPage.enterFirstAndLastName(firstName, lastName);
		loginPage.enterPassword(password);
		loginPage.submitFormIncorrect();
		assertTrue(loginPage.isLoginErrorMsgPresent());
	}
	
	/**
	 * Closes driver after test is complete
	 */
	@AfterTest(description="closes driver")
	public void cleanup(){
		driver.quit();
	}
	
	
}
