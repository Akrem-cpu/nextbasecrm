package com.nextbasecrm.step_defentions;

import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PollVoteFunctionaltiy_StepDef {
    /**
     *  Scenario:users  hr  can select an answer to vote a poll.
     */
    @When("hr user check the box that user like to vote for")
    public void hr_user_check_the_box_that_user_like_to_vote_for() {
       ActivityStream stream = new ActivityStream();
       stream.firstOptionToSelectFromThePollVote.click();
    }
    @When("hr user click on the vote button")
    public void hr_user_click_on_the_vote_button() {
        ActivityStream stream = new ActivityStream();
        stream.voteButton.click();
    }
    @Then("hr user should see {string} text")
    public void hr_user_should_see_text(String string) {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.voteAgainTxt));
        String actualText = stream.voteAgainTxt.getText();
        Assert.assertEquals(actualText,string);

    }

    /**
     *  Scenario:users marketing can select an answer to vote a poll.
     */
    @Given("marketing user check the box that user like to vote for")
    public void marketing_user_check_the_box_that_user_like_to_vote_for() {
        ActivityStream stream = new ActivityStream();
        stream.firstOptionToSelectFromThePollVote.click();
    }
    @When("marketing user click on the vote button")
    public void marketing_user_click_on_the_vote_button() {
        ActivityStream stream = new ActivityStream();
        stream.voteButton.click();
    }
    @Then("marketing user should see {string} text")
    public void marketing_user_should_see_text(String string) {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.voteAgainTxt));
        String actualText = stream.voteAgainTxt.getText();
        Assert.assertEquals(actualText,string);

    }

    /**
     *  Scenario:users helpdesk can select an answer to vote a poll.
     */
    @Given("helpdesk  user check the box that user like to vote for")
    public void helpdesk_user_check_the_box_that_user_like_to_vote_for() {
        ActivityStream stream = new ActivityStream();
        stream.firstOptionToSelectFromThePollVote.click();
    }
    @Given("helpdesk user click on the vote button")
    public void helpdesk_user_click_on_the_vote_button() {
        ActivityStream stream = new ActivityStream();
        stream.voteButton.click();
    }
    @Then("helpdesk  user should see {string} text")
    public void helpdesk_user_should_see_text(String string) {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.voteAgainTxt));
        String actualText = stream.voteAgainTxt.getText();
        Assert.assertEquals(actualText,string);
    }

    /**
     * Scenario:users helpdesk can select an answer to vote a poll.
     */
    @And("helpdesk user click on the VOTE AGAIN button")
    public void helpdeskUserClickOnTheVOTEAGAINButton() {
        ActivityStream stream = new ActivityStream();
        stream.voteAgainTxt.click();
    }
    @Then("helpdesk should see {string} button")
    public void helpdeskShouldSeeButton(String arg0) {
        ActivityStream stream = new ActivityStream();
        new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.voteButton));
        String actualText = stream.voteButton.getText();
        Assert.assertTrue(stream.voteButton.isEnabled());
        Assert.assertEquals(actualText,arg0);
    }

    /**
     * Scenario:only vote owner stop the poll with STOP button
     * @param arg0
     */

    @Then("marketing user should see {string} text on the poll that user created")
    public void marketingUserShouldSeeTextOnThePollThatUserCreated(String arg0) {
        ActivityStream stream = new ActivityStream();
        String actualText = stream.stopVoteForOnlyTheCreaterOfThePoll.getText();
        Assert.assertEquals(actualText,arg0);
        stream.stopVoteForOnlyTheCreaterOfThePoll.click();
    }
}
