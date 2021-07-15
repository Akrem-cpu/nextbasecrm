package com.nextbasecrm.step_defentions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PollCreationFunctionaltiy {
    Faker faker = new Faker();
    String title = faker.lorem().word();
    String question = faker.lorem().word();
    List<String > options = new ArrayList<>(Arrays.asList("happy","sad"));

    /**
     *     Scenario:users  hr create a poll with Q/A
     */
    @When("hr click on poll")
    public void hr_click_on_poll() {
        ActivityStream stream = new ActivityStream();
        stream.poll.click();

    }
    @When("hr write a title")
    public void hr_write_a_title() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.firstIframe);
        stream.messageBoxInsideIframeOne.sendKeys(title);
        Driver.getDriver().switchTo().defaultContent();
    }
    @When("hr write the question")
    public void hr_write_the_question() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        ActivityStream stream = new ActivityStream();
        wait.until(ExpectedConditions.visibilityOf(stream.questionBoxForPollCreation));
        stream.questionBoxForPollCreation.sendKeys(question);

    }
    @When("hr give the options")
    public void hr_give_the_options() {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.listOfVoteAnswerForPollCreation.get(0)));
        for (int i = 0; i < 2 ; i++) {
            stream.listOfVoteAnswerForPollCreation.get(i).sendKeys(options.get(i));
        }
       Assert.assertTrue(stream.multipleChoiceAllowButtonForPollCreation.isDisplayed());
    }
    @Then("hr should see the created poll")
    public void hr_should_see_the_created_poll() {
        ActivityStream stream = new ActivityStream();
        BrowserUtils.sleep(1);
        String expectedPollTitle = title;
        String actualPollTitle = stream.firstRecentlyPostedMessage.getText();
        Assert.assertEquals(expectedPollTitle,actualPollTitle);
        Driver.closeDriver();
    }



    /**
     *   Scenario:users  marketing create a poll with Q/A
     */
    @And("marketing click on poll")
    public void marketingClickOnPoll() {
        ActivityStream stream = new ActivityStream();
        stream.poll.click();
    }
    @And("marketing write a title")
    public void marketingWriteATitle() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.firstIframe);
        stream.messageBoxInsideIframeOne.sendKeys(title);
        Driver.getDriver().switchTo().defaultContent();
    }
    @And("marketing write the question")
    public void marketingWriteTheQuestion() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        ActivityStream stream = new ActivityStream();
        wait.until(ExpectedConditions.visibilityOf(stream.questionBoxForPollCreation));
        stream.questionBoxForPollCreation.sendKeys(question);
    }
    @And("marketing give the options")
    public void marketingGiveTheOptions() {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.listOfVoteAnswerForPollCreation.get(0)));
        for (int i = 0; i < 2 ; i++) {
            stream.listOfVoteAnswerForPollCreation.get(i).sendKeys(options.get(i));
        }
        Assert.assertTrue(stream.multipleChoiceAllowButtonForPollCreation.isDisplayed());
    }
    @Then("marketing should see the created poll")
    public void marketingShouldSeeTheCreatedPoll() {
        ActivityStream stream = new ActivityStream();
        BrowserUtils.sleep(1);
        String expectedPollTitle = title;
        String actualPollTitle = stream.firstRecentlyPostedMessage.getText();
        Assert.assertEquals(expectedPollTitle,actualPollTitle);
        Driver.closeDriver();
    }

    /**
     * Scenario:users  helpdesk create a poll with Q/A
     */
    @When("helpdesk click on poll")
    public void helpdesk_click_on_poll() {
        ActivityStream stream = new ActivityStream();
        stream.poll.click();
    }
    @When("helpdesk write a title")
    public void helpdesk_write_a_title() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.firstIframe);
        stream.messageBoxInsideIframeOne.sendKeys(title);
        Driver.getDriver().switchTo().defaultContent();
    }
    @When("helpdesk write the question")
    public void helpdesk_write_the_question() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        ActivityStream stream = new ActivityStream();
        wait.until(ExpectedConditions.visibilityOf(stream.questionBoxForPollCreation));
        stream.questionBoxForPollCreation.sendKeys(question);
    }
    @When("helpdesk give the options")
    public void helpdesk_give_the_options() {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.listOfVoteAnswerForPollCreation.get(0)));
        for (int i = 0; i < 2 ; i++) {
            stream.listOfVoteAnswerForPollCreation.get(i).sendKeys(options.get(i));
        }
        Assert.assertTrue(stream.multipleChoiceAllowButtonForPollCreation.isDisplayed());
    }
    @Then("helpdesk should see the created poll")
    public void helpdesk_should_see_the_created_poll() {
        ActivityStream stream = new ActivityStream();
        BrowserUtils.sleep(1);
        String expectedPollTitle = title;
        String actualPollTitle = stream.firstRecentlyPostedMessage.getText();
        Assert.assertEquals(expectedPollTitle,actualPollTitle);
        Driver.closeDriver();
    }

    /**
     * Scenario: users get error message The message title is not specified
     *
     */
    @Then("helpdesk should see {string} error Message")
    public void helpdeskShouldSeeErrorMessage(String arg0) {
        ActivityStream stream = new ActivityStream();
        String actualText = stream.errorMessageWhenTryingToCreatingPollWithOutTitle.getText();
      Assert.assertEquals(arg0,actualText);

    }

    /**
     * users check ""allow multiple Choice"" while create a poll
     */
    @And("helpdesk click on multiple answer check box")
    public void helpdeskClickOnMultipleAnswerCheckBox() {
        ActivityStream stream = new ActivityStream();
        Assert.assertFalse(stream.multipleChoiceAllowButtonForPollCreation.isSelected());
        stream.multipleChoiceAllowButtonForPollCreation.click();
    }
    @Then("helpdesk should see multiple answer check box selected")
    public void helpdeskShouldSeeMultipleAnswerCheckBoxSelected() {
        ActivityStream stream = new ActivityStream();
        Assert.assertTrue(stream.multipleChoiceAllowButtonForPollCreation.isSelected());
    }


    @And("helpdesk click on add question")
    public void helpdeskClickOnAddQuestion() {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.addQuestionWhenCreatingPoll));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(stream.addQuestionWhenCreatingPoll).perform();
        stream.addQuestionWhenCreatingPoll.click();
    }

    @Then("helpdesk user should see extra box for question")
    public void helpdeskUserShouldSeeExtraBoxForQuestion() {
        ActivityStream stream = new ActivityStream();
        Integer expectedBoxNumber = 2;
        Integer actualBoxNumber = stream.allAddedQuestionWhenCreatedAPoll.size();
        Assert.assertEquals(actualBoxNumber,expectedBoxNumber);
    }
}
