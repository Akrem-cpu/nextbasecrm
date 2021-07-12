package com.nextbasecrm.step_defentions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.Authorization;
import com.nextbasecrm.pages.Portal;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfiReader;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MessageFunctionality_StepDefinitions {
    Faker faker = new Faker();
    String data = faker.name().name();

    @Given("hr user is login in to the hr account")
    public void hr_user_is_login_in_to_the_hr_account() {
       Driver.getDriver().get(ConfiReader.getProperty("env"));
        Authorization aPage = new  Authorization();
        Authorization.inputValidCredentials("hrUserName");
        aPage.loginButton.click();
    }
    @Then("hr Type {string} in the Message box")
    public void hr_type_in_the_message_box(String string) {
        Portal page = new Portal();
        page.messageBox.click();
        Driver.getDriver().switchTo().frame(page.firstIframe);
        page.messageBoxInsideIframeOne.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("hr user click on send")
    public void hr_user_click_on_send() {
        Portal page = new Portal();
        page.sendMessage.click();
    }
    @Then("hr user should see the text under activity stream")
    public void hr_user_should_see_the_text_under_activity_stream() {
        Portal page = new Portal();
        BrowserUtils.sleep(1);
        String actualText = page.firstPostedMessage.getText();
        String expectedText = data;
        Assert.assertEquals(actualText,expectedText);
        Driver.closeDriver();

    }


    @Given("marketing user is login in to the hr account")
    public void marketing_user_is_login_in_to_the_hr_account() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
        Authorization aPage = new  Authorization();
        Authorization.inputValidCredentials("mrUserName");
        aPage.loginButton.click();

    }
    @Then("marketing Type {string} in the Message box")
    public void marketing_type_in_the_message_box(String string) {
        Portal page = new Portal();
        page.messageBox.click();
        Driver.getDriver().switchTo().frame(page.firstIframe);
        page.messageBoxInsideIframeOne.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("marketing user click on send")
    public void marketing_user_click_on_send() {
        Portal page = new Portal();
        page.sendMessage.click();

    }
    @Then("marketing user should see the text under activity stream")
    public void marketing_user_should_see_the_text_under_activity_stream() {
        Portal page = new Portal();
        BrowserUtils.sleep(1);
        String actualText = page.firstPostedMessage.getText();
        String expectedText = data;
        Assert.assertEquals(actualText,expectedText);
        Driver.closeDriver();
    }


    @Given("helpdesk user is login in to the hr account")
    public void helpdesk_user_is_login_in_to_the_hr_account() {
        Driver.getDriver().get(ConfiReader.getProperty("env"));
        Authorization aPage = new  Authorization();
        Authorization.inputValidCredentials("helperUserName");
        aPage.loginButton.click();
    }
    @Then("helpdesk Type {string} in the Message box")
    public void helpdesk_type_in_the_message_box(String string) {
        Portal page = new Portal();
        page.messageBox.click();
        Driver.getDriver().switchTo().frame(page.firstIframe);
        page.messageBoxInsideIframeOne.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("helpdesk user click on send")
    public void helpdesk_user_click_on_send() {
        Portal page = new Portal();
        page.sendMessage.click();
    }
    @Then("helpdesk user should see the text under activity stream")
    public void helpdesk_user_should_see_the_text_under_activity_stream() {
        Portal page = new Portal();
        BrowserUtils.sleep(1);
        String actualText = page.firstPostedMessage.getText();
        String expectedText = data;
        Assert.assertEquals(actualText,expectedText);
        Driver.closeDriver();
    }


    @And("helpdesk should be able to click on cancel button")
    public void helpdeskClickOnCancelButton() {
        Portal page = new Portal();
        Assert.assertTrue(page.messageCancelButton.isEnabled());
        page.messageCancelButton.click();
    }
}
