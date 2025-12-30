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
		softAssert.softAssertTrue(titleMatched, "Title Matched Successfully", "Title didnt match");
	}

	@Then("Verify {string} is visible")
	  public void verify_visible_string(String string_value_form_feature) {
		  boolean validationStatus = false;
		  
		  switch(string_value_form_feature) {
		  	case "UserID":
		  		 logger.info("Verifying presense of"+string_value_form_feature+"text");
				  boolean useridisVisible = hmpage_pom.verify_home_page_elements(string_value_form_feature);
				  validationStatus = useridisVisible;
				  break;
		  		
		  	case "Password":
		  		 logger.info("Verifying presense of "+string_value_form_feature+"text");
				  boolean passwordisVisible = hmpage_pom. hmpage_pom.verify_home_page_elements(string_value_form_feature);
				  validationStatus = passwordisVisible;
		  		break;
		  	
		  	case "LOGIN":
		  		 logger.info("Verifying presense of login button");
				  boolean loginBtnisVisible = hmpage_pom.verify_loginBtn_isVisible();
				  validationStatus =loginBtnisVisible;
		  		break;
		  		
		  	default:
		  		logger.info("No Value is matched");		  		
		  		break;
		  		
		  }
		  logger.info("Performing Assertion");
		  softAssert.softAssertTrue(validationStatus, 
				  string_value_form_feature + " Text is Visible in the screen", 
				  string_value_form_feature +" text is not visible in the screen");
	  }

	@Then("Click on Selenium Drop down from the top")
	public void click_on_selenium_drop_down_from_the_top() {
		logger.info("Verifying Click Selenium Drop Down From the top");
		boolean seleniumBtnisVisible = hmpage_pom.verify_seleniumBtn_isVisible();
		softAssert.softAssertTrue(seleniumBtnisVisible, "Selenium Button is visible", "Selenium Button is not visible");

		logger.info("Verifying Click on Selenium Drop Down ");
		boolean clickAndListExpended = hmpage_pom.click_on_seleniumBtn();
		logger.info("Performing Selenium Drop Down Assertion");
		softAssert.softAssertTrue(clickAndListExpended, "Click Selenium dropdown - List expanded",
				"Not click on Selenium dropdown - List not expanded");
	}

	@Then("Verify Table Demo is available Under Selenium Drop down")
	public void verify_table_demo_is_available_under_selenium_drop_down() {
		logger.info("Verify Table Demo is available Under Selenium Drop down ");
		boolean tableDemoBtnisVisible = hmpage_pom.verify_table_demo_isVisible();
		logger.info("Performing Table Demo available Assertion");
		softAssert.softAssertTrue(tableDemoBtnisVisible, "Table Demo is available in the DropDown",
				"Table Demo is not available in the DropDown");
	}

}
