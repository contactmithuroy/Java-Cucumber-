package eal.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eal.utilities.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps extends CommonMethods {

    private static final Logger logger = LogManager.getLogger(LoginSteps.class);

    @Given("user is on loginPage")
    public void user_is_on_loginpage() {
        logger.info("Successfully loaded login page");
    }

    @Then("user click")
    public void user_click_on_login_button() {
        logger.debug("Waiting for navigation after login button click");
    }
}