package stepDefinitions;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	static String title;
	static String leftPaneText;
	private ConfigReader configReader=new ConfigReader();
	private HomePage homePage;
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get(configReader.init_prop().getProperty("url"));
		
	}

	@When("user get the title of the page")
	public void user_get_the_title_of_the_page() {
	    title=loginPage.getLoginPageTitle();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertEquals(expectedTitleName,title);
	}

	@When("user enters correct username and password")
	public void user_enters_correct_username_and_password() {
		loginPage.Login(configReader.init_prop().getProperty("username"), configReader.init_prop().getProperty("password"));
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		homePage=loginPage.ClickonLoginbutton();
	}

	@Then("user get a left pane text of the home page")
	public void user_get_a_left_pane_text_of_the_home_page() {
	   leftPaneText= loginPage.getLeftPaneTextOfHomePage();
	}

	@Then("left pane text should be {string}")
	public void left_pane_text_should_be(String expectedText) {
		Assert.assertEquals(expectedText,leftPaneText);
	}
}
