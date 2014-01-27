package blueTests;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import blueSource.BlueEmployee;
import blueSource.BlueIndex;
import blueSource.BlueLogin;
import blueSource.BlueTimeOff;
public class VerifyVacationTime {
	
	private static WebDriver driver;
	
	@BeforeTest
	public static void initializeTest(){
		driver = new InternetExplorerDriver();
		
	}
	
	/**
	 * Adds Vacation time in the range indcated by the user. 
	 * @author Lateef Livers
	 * Jan 23, 2014
	 * @param url address of site
	 * @param firstName Users first name
	 * @param lastName Users last name
	 * @param password Password for user
	 * @param StartDate Start Vacation
	 * @param EndDate End of Vacation
	 * @param VacationType Type of Vacation 
	 * @param employeeFirstName The first name of the employee whose vacation will be entered
	 * @param employeeLastName The last name of the employee whose vacation will be entered
	 */
	@Test(description="Add vacation time")
	@Parameters({"url","firstName","lastName","password","StartDate","EndDate","VacationType","employeeFirstName","employeeLastName"})
	public void AddVacationTime(String url, String firstName, String lastName, String password, String StartDate, String EndDate, String VacationType, String employeeFirstName, String employeeLastName){
		BlueLogin loginPage = new BlueLogin(driver);
		
		loginPage.setURL(url);
		loginPage.open();
		loginPage.enterFirstAndLastName(firstName, lastName);
		loginPage.enterPassword(password);
		
		//At index page
		BlueIndex indexPage = loginPage.submitForm();
		indexPage.searchEmployee(employeeFirstName,employeeLastName);
		
		//At Employee page
		BlueEmployee employeePage = indexPage.selectEmployee();
		
		//At Time off page
		BlueTimeOff timeOffPage = employeePage.manageTimeOff();
		
		
		timeOffPage.enterVacation(StartDate, EndDate, VacationType);
		// Verify update is successful.
		assertTrue(timeOffPage.isUpdateSuccessful());

		
		timeOffPage.deleteFirstEntry();
//		assertTrue(timeOffPage.isDeleteSuccessful());
		
		timeOffPage.clickLogout();
	}
	
	/**
	 * Closes driver after test is complete
	 */
	@AfterTest(description="closes driver")
	public void cleanup(){
		driver.quit();
	}
	

}
