package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By emailId = By.id("email");
	private By passWord = By.id("passwd");
	private By signInBtton = By.id("SubmitLogin");
	private By forgotPwdLink = By.xpath("//*[@id=\"login_form\"]/div/p[1]/a");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPasseord(String pwd) {
		driver.findElement(passWord).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		driver.findElement(signInBtton).click();
	}





}
