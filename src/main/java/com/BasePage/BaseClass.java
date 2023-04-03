package com.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.utills.ExtentReport;

public class BaseClass extends ExtentReport {

	public WebDriver driver;

	/**
	 * Used to Launch a browser
	 * 
	 * @param browser
	 * @return void
	 * @since 11/03/2023
	 * @author ankit yadav
	 */
	@BeforeSuite
	public void openBrowser(@Optional("chrome") String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-web-security");
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
	}

	/**
	 * this method is used to close the connection and browser
	 * 
	 * @return void
	 * @since 11/03/23
	 * @author ankit yadav
	 */

	@AfterSuite
	public void closeConnection() {
		driver.quit();
	}

	/**
	 * openUrl method is used to open a Url
	 * 
	 * @return void
	 * @since 11/03/2023
	 * @author ankit yadav
	 */
	public void openUrl(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}
}
