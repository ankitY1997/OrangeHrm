package com.utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utills {

	/** instance WebDriver class */
	public static WebDriver driver;

	/**
	 * readProperties is used to read a data into properties file
	 * 
	 * @param data
	 * @return String
	 * @since 11/03/23
	 * @author ankit yadav
	 */
	public static String readProperties(String data) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream("./UrlData/Url.properties");
			Properties pr = new Properties();
			pr.load(fis);
			value = pr.getProperty(data);

		} catch (IOException e) {
			// do nothing
		}
		return value;

	}

	/**
	 * typeIntoText method is used to type a text into textfield
	 * 
	 * @param WebElement,String
	 * @since 12/03/23
	 * @author ankit yadav
	 */

	public void typeInToText(WebElement element, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(element));
		if (element.isDisplayed() && element.isEnabled()) {
			element.sendKeys(value);
		} else {
			System.out.println("elment is not visible" + this.getClass());
		}

	}

	/**
	 * clickOn method is used to click on the webelement
	 * 
	 * @author ankit yadav
	 * @param WebElement
	 */
	public void clickOn(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}
	}

	/**
	 * Sleep method is used to sleep the current thread for given second
	 * 
	 * @param wait
	 * @author ankit yadav
	 */
	public static void Sleep(int wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
