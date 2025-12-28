package eal.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.PendingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eal.utilities.CommonMethods;


public class Test_sd extends CommonMethods {
	public static final Logger logger = LogManager.getLogger(CommonMethods.class);

    @Given("User is on homepage")
    public void user_is_on_homepage() {
    	logger.info("Step Definition");
    	waitFor(15);
    }
    
    @Then("user click on lgoin button")
    public void user_click_on_lgoin_button() {
    	logger.info("Step Definition");
    }
}