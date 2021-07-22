package com.nextbasecrm.step_defentions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.pages.Authorization;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.ConfiReader;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class MessageFunctionality_StepDefinitions {
    Faker faker = new Faker();
    String data = faker.name().name();

    String  link = "www.facebook.com";

    @Given("hr user is login in to the hr account")
    public void hr_user_is_login_in_to_the_hr_account() {

        Authorization.inputValidCredentials("hrUserName");
        Pages.getAuthorization().loginButton.click();
    }
    @Then("hr Type {string} in the Message box")
    public void hr_type_in_the_message_box(String string) {

        Pages.getStream().messageBox.click();
        Driver.getDriver().switchTo().frame(Pages.getStream().firstIframe);
        Pages.getStream().messageBoxInsideIframeOne.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("hr user click on send")
    public void hr_user_click_on_send() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Pages.getStream().sendMessage).perform();
        Pages.getStream().sendMessage.click();
    }
    @Then("hr user should see the text under activity stream")
    public void hr_user_should_see_the_text_under_activity_stream() {

        BrowserUtils.sleep(1);
        String actualText = Pages.getStream().firstRecentlyPostedMessage.getText();
        String expectedText = data;
        Assert.assertEquals(actualText,expectedText);


    }


    @Given("marketing user is login in to the marketing account")
    public void marketing_user_is_login_in_to_the_hr_account() {

        Authorization.inputValidCredentials("mrUserName");
        Pages.getAuthorization().loginButton.click();

    }
    @Then("marketing Type {string} in the Message box")
    public void marketing_type_in_the_message_box(String string) {

        Pages.getStream().messageBox.click();
        Driver.getDriver().switchTo().frame(Pages.getStream().firstIframe);
        Pages.getStream().messageBoxInsideIframeOne.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("marketing user click on send")
    public void marketing_user_click_on_send() {

        Pages.getStream().sendMessage.click();

    }
    @Then("marketing user should see the text under activity stream")
    public void marketing_user_should_see_the_text_under_activity_stream() {
        BrowserUtils.sleep(1);
        String actualText = Pages.getStream().firstRecentlyPostedMessage.getText();
        String expectedText = data;
        Assert.assertEquals(actualText,expectedText);

    }


    @Given("helpdesk user is login in to the helpdesk account")
    public void helpdesk_user_is_login_in_to_the_hr_account() {
        Authorization.inputValidCredentials("helperUserName");
        Pages.getAuthorization().loginButton.click();
    }
    @Then("helpdesk Type {string} in the Message box")
    public void helpdesk_type_in_the_message_box(String string) {

        Pages.getStream().messageBox.click();
        Driver.getDriver().switchTo().frame(Pages.getStream().firstIframe);
        Pages.getStream().messageBoxInsideIframeOne.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("helpdesk user click on send")
    public void helpdesk_user_click_on_send() {
        Pages.getStream().sendMessage.click();
    }
    @Then("helpdesk user should see the text under activity stream")
    public void helpdesk_user_should_see_the_text_under_activity_stream() {
        BrowserUtils.sleep(1);
        String actualText = Pages.getStream().firstRecentlyPostedMessage.getText();
        String expectedText = data;
        Assert.assertEquals(actualText,expectedText);
    }


    @And("helpdesk should be able to click on cancel button")
    public void helpdeskClickOnCancelButton() {
        Assert.assertTrue(Pages.getStream().messageCancelButton.isEnabled());
        Pages.getStream().messageCancelButton.click();
        Driver.closeDriver();
    }

    @And("helpdesk click on link icon")
    public void helpdeskClickOnLinkIcon() {
        Pages.getStream().AddLinkButton.click();
    }

    @And("helpdesk give a name and link")
    public void helpdeskGiveANameAndLink() {
        Pages.getStream().linkTextBoxToGiveATextToTheLink.sendKeys(data);
        Pages.getStream().linkUrlBoxToGiveAUrlForTheLink.sendKeys(link);
    }

    @And("helpdesk click on save")
    public void helpdeskClickOnSave() {
        Pages.getStream().saveLinkAfterGivingALinkAndName.click();
    }
       //todo fix this problem here, for now it is using the findelement inisde the method. you need to read from pom.
    @Then("helpdesk text should contain href attribute value that match the input")
    public void helpdeskTextShouldContainHrefAttributeValueThatMatchTheInput() {
        BrowserUtils.sleep(2);
      String actualLinkValue = Driver.getDriver().findElement(By.xpath("(//div[@class='workarea-content-paddings']//div[@class='feed-post-text-block-inner-inner'])[1]/a")).getAttribute("href");
      String expectedLinkValue =   link;
      Assert.assertTrue(actualLinkValue.contains(expectedLinkValue));

    }

    @And("helpdesk Type  in the Message box")
    public void helpdeskTypeInTheMessageBox() {
        Pages.getStream().messageBox.click();

    }

    @And("helpdesk save the message")
    public void helpdeskSaveTheMessage() {

        Pages.getStream().sendMessage.click();
    }
}
