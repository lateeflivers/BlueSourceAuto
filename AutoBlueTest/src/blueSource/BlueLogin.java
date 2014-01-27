package blueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Login page for BlueSource
 * @author Lateef Livers
 * Jan 22, 2014
 */
public class BlueLogin extends BluePage {
	private static final String passwordErrorMessageXpath =  ".//*[@id='new_employee']/div[2]/div[1]";
	/**
	 * Constructor for BlueLogin page
	 * @param Driver
	 * @param url
	 */
/*	public BlueLogin(WebDriver Driver, String url){
		super(driver,url);
		
	}*/
	
	public BlueLogin(WebDriver driver){
		super(driver);
	}
	
	/**
	 * Enters the userName into the username field in the format of firstname.lastname
	 * @param firstName
	 * @param lastName
	 */
	public void enterFirstAndLastName(String firstName, String lastName){
		String userName;
		userName = firstName+"."+lastName;
		userName = userName.toLowerCase();
		driver.findElement(By.name("employee[username]")).sendKeys(userName);
	}
	
	/**
	 * Enters password into the correct field
	 * @param password
	 */
	public void enterPassword(String password){
		driver.findElement(By.name("employee[password]")).sendKeys(password);
	}
	
	/**
	 * Submits form
	 */
	public BlueIndex submitForm()
	{
		driver.findElement(By.name("employee[password]")).submit();
		return new BlueIndex(driver);
	}

	/**
	 * Use for incorrect login attempts. Attempts a bad login
	 */
	public void submitFormIncorrect(){
		driver.findElement(By.name("employee[password]")).submit();
	}
	
	public String getPasswordErrorMsg(){
		return getWebElementBy(By.xpath(passwordErrorMessageXpath)).getText();

	}
	
	/**
	 * Returns if the login error message is displayed
	 * @return True if error message appears, otherwise false.
	 */
	public boolean isLoginErrorMsgPresent(){
		return isElementPresentAndDisplayed(By.xpath(passwordErrorMessageXpath));
	}
}
