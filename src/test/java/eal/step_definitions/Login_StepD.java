package eal.step_definitions;

import org.apache.logging.log4j.*;
import eal.utilities.CommonMethods;
import io.cucumber.java.en.*;

public class Login_StepD extends CommonMethods {
	  private static final Logger logger = LogManager.getLogger(CommonMethods.class);

	  @Given("Validate User landed on homepage")
	  public void validate_user_landed_on_homepage() {
		  logger.info("Verify Title");
		  boolean titleMatched = hmpage_pom.verify_homepage_title();
		  logger.info("Performing Assertion");
		  softAssert.softAssertTrue(titleMatched, 
				  "Title Matched Successfully", 
				  "Title didnt match");
	  }
	  @Then("Verify UserID is Visible")
	  public void verify_user_id_is_visible() {
		  logger.info("Verifying presense of User ID");
		  boolean useridisVisible = hmpage_pom.verify_userid_isVisible();
		  logger.info("Performing Assertion");
		  softAssert.softAssertTrue(useridisVisible, 
				  "User ID Text is Visible in the screen", 
				  "User Id text is not visible in the screen");
	  }
	  
	  @Then("Verify Password Input is Visible")
	  public void verify_password_input_is_visible() {
		  logger.info("Verifying presense of Password field");
		  boolean passwordisVisible = hmpage_pom.verify_password_isVisible();
		  logger.info("Performing Assertion");
		  softAssert.softAssertTrue(passwordisVisible, 
				  "Password Text is Visible in the screen", 
				  "Password text is not visible in the screen");
	  }
	  
	  @Then("Verify LOGIN is visible")
	  public void verify_login_is_visible() {
		  logger.info("Verifying presense of login button");
		  boolean loginBtnisVisible = hmpage_pom.verify_loginBtn_isVisible();
		  logger.info("Performing Login Assertion");
		  softAssert.softAssertTrue(loginBtnisVisible, 
				  "Login Button  is Visible in the screen", 
				  "Login Button is not visible in the screen");
	  }

	  @Then("Click on Selenium Drop down from the top")
	  public void click_on_selenium_drop_down_from_the_top() {
		  logger.info("Verifying Click Selenium Drop Down From the top");
		  boolean seleniumBtnisVisible = hmpage_pom.verify_seleniumBtn_isVisible();
		  logger.info("Verifying Click on Selenium Drop Down ");
		  boolean clickAndListExpended = hmpage_pom.click_on_seleniumBtn();
		  logger.info("Performing Selenium Drop Down Assertion");
		  softAssert.softAssertTrue(clickAndListExpended, 
				    "Click Selenium dropdown - List expanded", 
				    "Not click on Selenium dropdown - List not expanded");
	  }
	  
	  @Then("Verify Table Demo is available Under Selenium Drop down")
	  public void verify_table_demo_is_available_under_selenium_drop_down() {
		  logger.info("Verify Table Demo is available Under Selenium Drop down ");
		  boolean tableDemoBtnisVisible = hmpage_pom.verify_table_demo_isVisible();
		  logger.info("Performing Table Demo available Assertion");
		  softAssert.softAssertTrue(tableDemoBtnisVisible, 
				    "Table Demo is available in the DropDown", 
				    "Table Demo is not available in the DropDown");
	  }
	  
	  
}
