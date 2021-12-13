package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser){
		if(browser.equalsIgnoreCase("chrome")) {
		System.out.println("Browser value is :" + browser);
		WebDriverManager.chromedriver().setup();
		tlDriver.set(new ChromeDriver());
		}
		else if (browser.equalsIgnoreCase("ff")) {
			System.out.println("Browser value is :" + browser);
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());	
		}
		else
		{
			System.out.println("Please enter valid input");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	public static WebDriver getDriver() {
		return tlDriver.get();
	
	}
}
