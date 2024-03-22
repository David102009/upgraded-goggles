package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.BaseClass;
import Utilities.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class loginStepDef extends CommonMethods{

	
	@Given("the user has navigated to the login page")
	public void the_user_has_navigated_to_the_login_page() {
	sDp.clickLoginLogoutOrRegister("login");
	lP.assertLoginFeatures();
		}

	@When("the user enters the correct userame and password")
	public void the_user_enters_the_correct_userame_and_password() {
	CommonMethods.sendKey(lP.inputEmailBox, BaseClass.getProperty("userName"));
	CommonMethods.sendKey(lP.inputPasswordBox, BaseClass.getProperty("passWord"));
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
	CommonMethods.click(lP.loginButton);
	}

	@Then("the user is redirected to the homepage")
	public void the_user_is_redirected_to_the_homepage() {
	 Assert.assertEquals("titleOfTheHomePage", BaseClass.getDriver().getTitle());
	}

	@Then("a welcome message is displayed")
	public void a_welcome_message_is_displayed() {
	  System.out.println("This test is going to fail");
	}
	
	@When("the user enters an incorrect username or password")
	public void the_user_enters_an_incorrect_username_or_password() {
	  CommonMethods.sendKey(lP.inputEmailBox, BaseClass.getProperty("incorrectUserName"));
	  CommonMethods.sendKey(lP.inputPasswordBox, BaseClass.getProperty("incorrectPassword"));
	}


	@Then("an error message is displayed")
	public void an_error_message_is_displayed() {
	Assert.assertTrue(lP.errorMessage.isDisplayed());
	}

	@When("the user clicks on the {string} link")
	public void the_user_clicks_on_the_link(String string) {
	    CommonMethods.click(lP.forgotPasswordLink);
	}

	@Then("the user is redirected to the password recovery page")
	public void the_user_is_redirected_to_the_password_recovery_page() {
	    Assert.assertEquals(BaseClass.getProperty("titleOfTheForgotYourPasswordPage"), BaseClass.getDriver().getTitle());
	}
	
	


}
