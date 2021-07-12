package com.nextbasecrm.step_defentions;

import com.nextbasecrm.pages.Authorization;
import com.nextbasecrm.pages.Portal;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfiReader;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Nextbase_StepDefinitions {

    /**
     * Scenario:  As a Helper user, I should be able to login to the app
     */
    @Given("Helper user is on nextbase login page")
    public void helper_user_is_on_nextbase_login_page() {
      Driver.getDriver().get(ConfiReader.getProperty("env"));
      String actualTitle = Driver.getDriver().getTitle();
      String expectedTitle = "Authorization";
      Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("User input valid Credentials")
    public void user_input_valid_credentials() {
         Authorization.inputValidCredentials("helperUserName");
    }
    @When("Helper user click on Login")
    public void helper_user_click_on_login() {
        Authorization page = new Authorization();
        page.loginButton.click();
    }
    @Then("User should see in title {string}")
    public void user_should_see_in_title(String string) {
     String actualTitle = Driver.getDriver().getTitle();
     String expectedTitle = "(62) portal";
     Assert.assertEquals(actualTitle,expectedTitle,string);
     Driver.closeDriver();
    }

    /**
     *  Scenario:  As a Helper user, I should be able to login to the app
     */
    @Given("hr user is on nextbase login page")
    public void hr_user_is_on_nextbase_login_page() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Authorization";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @When("hr User input valid Credentials")
    public void hr_user_input_valid_credentials() {
        Authorization.inputValidCredentials("hrUserName");
    }
    @When("hr user click on Login")
    public void hr_user_click_on_login() {
      Authorization page = new Authorization();
      page.loginButton.click();
    }
    @Then("User should see title {string}")
    public void userShouldSeeTitle(String arg0) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "(53) portal";
        Assert.assertEquals(actualTitle,expectedTitle,arg0);
        Driver.closeDriver();
    }

    /**
     * Scenario:As a marketing user, I should be able to login to the app
     */
    @Given("marketing user is on nextbase login page")
    public void marketing_user_is_on_nextbase_login_page() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Authorization";
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    @When("marketing User input valid Credentials")
    public void marketing_user_input_valid_credentials() {
        Authorization.inputValidCredentials("mrUserName");
    }
    @When("marketing user click on Login")
    public void marketing_user_click_on_login() {
        Authorization page = new Authorization();
        page.loginButton.click();
    }
    @Then("marketing User should see title {string}")
    public void marketing_user_should_see_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "(84) portal";
        Assert.assertEquals(actualTitle,expectedTitle,string);
        Driver.closeDriver();
    }

    /**
     * Scenario: users cannot login with invalid credentials.(Negative )
     */

    @Given("User is on nextbase login page")
    public void user_is_on_nextbase_login_page() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Authorization";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("User input invalid Credentials")
    public void user_input_invalid_credentials() {
       Authorization.inputInvalidCredentials();
    }
    @When("user click on Login")
    public void user_click_on_login() {
        Authorization page = new Authorization();
        page.loginButton.click();
    }
    @Then("User should see {string} massage displayed")
    public void user_should_see_massage_displayed(String string) {
        Authorization page = new Authorization();
        String actualErrorMessage = page.ErrorMessage.getText();
        String expectedErrorMessage = "Incorrect login or password";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,string);
        Driver.closeDriver();

    }

    /**
     * Scenario: verify users can check ""Remember me on this computer"" option
     */
    @Given("Helper user navigate is on nextbase login page")
    public void helper_user_navigate_is_on_nextbase_login_page() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Authorization";
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("Helper user input valid Credentials")
    public void helper_user_input_valid_credentials() {
       Authorization.inputValidCredentials("helperUserName");
    }
    @When("Helper user click on Remember me on this compute check box")
    public void helper_user_click_on_remember_me_on_this_compute_check_box() {
        Authorization page = new Authorization();
        page.rememberMeCheckBox.click();
    }
    @When("Helper user login")
    public void helper_user_login() {
        Authorization page = new Authorization();
        page.loginButton.click();
    }
    @When("Helper user log out")
    public void helper_user_log_out() {
        Portal page = new Portal();
        page.userInfDiv.click();
        page.Logout.click();
    }
    @When("Helper user empty the user clear user name and password")
    public void helper_user_empty_the_user_clear_user_name_and_password() {
      Authorization page = new Authorization();
      page.userNameInputBox.clear();
      page.passwordInputBox.clear();

    }
    @When("Helper user refresh the page")
    public void helper_user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();

    }
    @Then("Helper  user should be able to see the username on the username box")
    public void helper_user_should_be_able_to_see_the_username_on_the_username_box() {
        Authorization page = new Authorization();
        String actualUserName = page.userNameInputBox.getAttribute("value");
        String expectedUserName = ConfiReader.getProperty("helperUserName");
       Assert.assertEquals(actualUserName,expectedUserName);
       Driver.closeDriver();



    }

    /**
     *  Scenario: verify users can check ""Remember me on this computer"" option
     */
    @Given("user is on nextbase login page")
    public void user_is_on_nextbase_login_page1() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
    }
    @When("user click on FORGOT YOUR PASSWORD link")
    public void user_click_on_forgot_your_password_link() {
      Authorization page = new Authorization();
      page.forgotMyPasswordLink.click();
    }
    @Then("user should see the {string} title")
    public void user_should_see_the_title(String string) {
       String actualTitle = Driver.getDriver().getTitle();
       String expectedTitle = "Get Password";
       Assert.assertEquals(actualTitle,expectedTitle,string);
       Driver.closeDriver();

    }









}
