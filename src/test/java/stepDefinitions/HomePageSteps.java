package stepDefinitions;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MessagePage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private ConfigReader configReader=new ConfigReader();
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private HomePage homePage;
	private MessagePage messagePage;
	static String receiverName;
	static String lastMessage;
	
	@Given("authorized user has already logged in to application")
	public void authorized_user_has_already_logged_in_to_application() {
	    String username = configReader.init_prop().getProperty("username");
	    String password = configReader.init_prop().getProperty("password");	
	    DriverFactory.getDriver().get(configReader.init_prop().getProperty("url"));
	    homePage=loginPage.doLogin(username, password);
	}

	@When("user searches Profectus Kamaljeet {string}")
	public void user_searches_Profectus_Kamaljeet(String linkedinProfile) {
		DriverFactory.getDriver().get(linkedinProfile);
	    messagePage=homePage.openMessageWindow();
	    if(messagePage==null)
	    	System.out.println("Kamaljeet is not in logged in user's connections");
	}
	
	@Then("user gets the profile name on message window")
	public void user_gets_the_profile_name_on_message_window() {
		if(messagePage!=null)
			receiverName=messagePage.profileNameonMessageWindow();
	}

	@When("user enters hello message from given personName")
	public void user_enters_hello_message_from_given_personName() {
		if(messagePage!=null)
			messagePage.typeMessage("Hello " + receiverName);
		System.out.println("Message : "+"Hello " + receiverName);
	}


	@When("user gets sent message content")
	public void user_gets_sent_message_content() {
		if(messagePage!=null)
			lastMessage = messagePage.getLastMessageContent();
		else
			System.out.println("Kamaljeet is not in logged in user's connections");
	}

	@Then("message content should be {string}")
	public void message_content_should_be(String expectedMessage) {
		Assert.assertEquals(expectedMessage, lastMessage);
	}
	
	@Then("user sees the Connect button only")
	public void user_sees_the_Connect_button_only() {
		Assert.assertTrue(homePage.isConnectButtonPresent());
	}
	
	@When("user clicks on Sign Out button")
	public void user_clicks_on_Sign_Out_button() {
		homePage.logout();
	}
	
	@Then("user gets return url {string}")
	public void user_gets_return_url(String expectedUrl) {
		String actualUrl=homePage.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}
}
