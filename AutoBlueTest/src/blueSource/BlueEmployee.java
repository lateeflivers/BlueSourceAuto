package blueSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Employee Page
 * @author Lateef
 * Jan 22, 2014
 * TODO logic for General info Modal
 * TODO logic for Project info Modal
 * TODO logic to see which Tabs are expanded
 */
public class BlueEmployee extends BluePage{

	private boolean generalInfoExpanded;// = true;
	private boolean projectInfoExpanded;// = false;
	private boolean timeOffInfoExpanded;// = false;
	
	private static final String manageTimeOffXpath = ".//*[@id='accordion']/div/div[7]/div[1]/a[2]";
	private static final String viewTimeOffXpath = ".//*[@id='accordion']/div/div[7]/div[1]/a[1]";
	private static final String manageProjectInfoXpath = ".//*[@id='accordion']/div/div[5]/button";
	private static final String manageGeneralXpath = ".//*[@id='accordion']/div/div[3]/button";
	private static final String backButtonXpath = "html/body/div[1]/a";
	private static final String generalTabBarXpath =".//*[@id='accordion']/div/div[3]";
	private static final String projectTabBarXpath =".//*[@id='accordion']/div/div[5]";
	private static final String timeOffTabBarXpath = ".//*[@id='accordion']/div/div[7]";
	
	/**
	 * Default constructor
	 * @param driver
	 */
	public BlueEmployee(WebDriver driver){
		super(driver);
		generalInfoExpanded = true;
		projectInfoExpanded = false;
		timeOffInfoExpanded = false;

	}

	/**
	 * Clicks the Manage button for "General Info"
	 */
	public void manageGenernalInfo(){
		getWebElementBy(By.xpath(manageGeneralXpath)).click();
	}
	
	/**
	 * If the general tab is not already expanded. Click to expand
	 */
	public void expandGeneralTab(){
		if(isExpanded(generalInfoExpanded)==false)
		{

			getWebElementBy(By.xpath(generalTabBarXpath)).click();
			generalInfoExpanded = true;
			projectInfoExpanded = false;
			timeOffInfoExpanded = false;
		}
	}
	
	/**
	 * If the project tab is not already expanded. Click to expand
	 */
	public void expandProjectTab(){
		if(isExpanded(projectInfoExpanded)==false)
		{
			getWebElementBy(By.xpath(projectTabBarXpath)).click();
			generalInfoExpanded = false;
			projectInfoExpanded = true;
			timeOffInfoExpanded = false;
		}
	}

	/**
	 * If the Time Off  tab is not already expanded. Click to expand
	 */
	public void expandTimeOffTab(){
		if(isExpanded(projectInfoExpanded)==false)
		{
			getWebElementBy(By.xpath(timeOffTabBarXpath)).click();

			generalInfoExpanded = false;
			projectInfoExpanded = false;
			timeOffInfoExpanded = true;
		}
	}
	
	
	/**
	 * Returns if a panel is expanded or not
	 * @param panel	If true table is expanded else it is false
	 * @return True or False
	 */
	private boolean isExpanded(boolean panel){
		return panel;
	}
	
	/**
	 * Clicks the Manage button for "Project Info"
	 */
	public void manageProjectInfo(){
		getWebElementBy(By.xpath(manageProjectInfoXpath)).click();
	}
	
	/**
	 * Navigates to the Manage time off screen
	 * @return new BlueTimeOff driver
	 */
	public BlueTimeOff manageTimeOff(){
		getWebElementBy(By.xpath(manageTimeOffXpath)).click();
		return new BlueTimeOff(driver);
	}


	/**
	 * Navigates back to the index
	 * @return new BlueIndex driver
	 */
	public BlueIndex goBack(){
		getWebElementBy(By.xpath(backButtonXpath)).click();
		return new BlueIndex(driver);
	}
	
	
	
}
