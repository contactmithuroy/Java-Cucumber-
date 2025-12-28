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
	  @Then("Verify UserID is Visible")
	  public void verify_user_id_is_visible() {
		  logger.info("Verifying presense of User ID");
		  boolean useridisVisible = hmpage_pom.verify_userid_isVisible();
		  logger.info("Performing Assertion");
		  softAssert.softAssertTrue(useridisVisible, "User ID Text is Visible in the screen", "User Id text is not visible in the screen");
	  }
}
