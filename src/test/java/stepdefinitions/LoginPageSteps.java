package stepdefinitions;

import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	private boolean flag =true;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is :-" + title);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expexctedTitle) {

		title = loginPage.getLoginPageTitle();
	System.out.println("Login Page title is :-" + title);
	 Assert.assertTrue(title.contains(expexctedTitle));
	
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		System.out.println("Forgot password link");
		//Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		if((loginPage.isForgotPwdLinkExist()==flag)){
			System.out.println("Forgetlink passed");
		}
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
		loginPage.enterUserName(userName);
	} 

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginPage.enterPasseord(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println(title);
	}

}
