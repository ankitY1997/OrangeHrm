package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ObjectRepository.LocatorClass;
import com.utills.Utills;

public class LogInPage extends Utills {
	/** for username */
	@FindBy(xpath = LocatorClass.username)
	private WebElement username;

	/** for password */
	@FindBy(xpath = LocatorClass.password)
	private WebElement password;

	/** for login button */
	@FindBy(xpath = LocatorClass.logInButton)
	private WebElement loginbutton;
	
	/**for HomePage */
	@FindBy(xpath=LocatorClass.homepageTittle)
	private WebElement homePageTittle;

	/** READING URL FROM PROPERTIES FILE */
	public String url = Utills.readProperties("URL");
	/** READING USERNAME FROM PROPERTIES FILE */
	public String userName = Utills.readProperties("USERNAME");
	/** READING PASSWORD FROM PROPERTIES FILE */
	public String passWord = Utills.readProperties("PASSWORD");

	public WebDriver driver;

	/**
	 * constructor of LogInPage
	 * 
	 * @param driver
	 * @author ankit yadav
	 */

	public LogInPage(WebDriver driver) {
		super.driver=driver;
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * clickOnLogin method is used to click on login button
	 * 
	 * @param void
	 * @author ankit yadav
	 */
	public void clickOnLogin() {
		Sleep(2000);
		clickOn(loginbutton);
	}

	/**
	 * for set a username
	 * 
	 * @author ankit yadav
	 * @return void
	 */
	public void setUsername() {
		typeInToText(username, userName);
	}

	public void setPassword() {
		typeInToText(password, passWord);
		
	}

	/** verify the tittle */

	public boolean isTitlePresent(WebDriver driver,String expectedTitle) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(homePageTittle));
		String actualTitle = homePageTittle.getText();
		boolean flag = false;
		if (actualTitle.contains(expectedTitle)) {
			return true;
		}
		return flag;
	}

}
