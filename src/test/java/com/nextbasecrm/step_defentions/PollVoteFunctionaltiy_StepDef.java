package com.nextbasecrm.step_defentions;

import com.nextbasecrm.pages.Portal;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class PollVoteFunctionaltiy_StepDef {

    /**
     * Scenario:users hr can select an answer to vote a poll.
     */
    @When("hr user navigate to poll post for vote")
    public void hr_user_navigate_to_poll_post_for_vote() {
        Portal portal = new Portal();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(portal.voteAgainTxt).perform();
   /*     try {
            Robot robot = new Robot();
            robot.mouseWheel(5);
        } catch (AWTException e) {
            e.printStackTrace();
        }*/

    }
    @When("hr user check the box that user like to vote for")
    public void hr_user_check_the_box_that_user_like_to_vote_for() {
        Portal portal = new Portal();
        if(portal.voteAgainTxt.isDisplayed()){
            portal.voteAgainTxt.click();
        }
        portal.pollVoteRadioButtonToCheck.click();
    }
    @When("hr user click on the vote button")
    public void hr_user_click_on_the_vote_button() {
        Portal portal = new Portal();
        portal.voteButton.click();
    }
    @Then("hr user should see \"VOTE AGAIN\" text")
    public void user_should_see_vote_again_text() {
        Portal portal = new Portal();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(portal.voteAgainTxt));
       String actualText =  portal.voteAgainTxt.getText();
       String expectedText =  "VOTE AGAIN";
       Assert.assertEquals(actualText,expectedText);
       portal.voteAgainTxt.click();
       Driver.closeDriver();
    }

    /**
     *   Scenario:users helpdesk can select an answer to vote a poll.
     */
    @And("helpdesk user navigate to poll post for vote")
    public void helpdeskUserNavigateToPollPostForVote() {
        Portal portal = new Portal();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(portal.voteAgainTxt).perform();
    /*    try {
            Robot robot = new Robot();
            robot.mouseWheel(5);
        } catch (AWTException e) {
            e.printStackTrace();
        }*/
    }
    @And("helpdesk user check the box that user like to vote for")
    public void helpdeskUserCheckTheBoxThatUserLikeToVoteFor() {
        Portal portal = new Portal();
        if(portal.voteAgainTxt.isDisplayed()){
            portal.voteAgainTxt.click();
        }
        portal.pollVoteRadioButtonToCheck.click();
    }
    @And("helpdesk user click on the vote button")
    public void helpdeskUserClickOnTheVoteButton() {
        Portal portal = new Portal();
        portal.voteButton.click();

    }
    @Then("helpdesk user should see {string} text")
    public void helpdeskUserShouldSeeText(String arg0) {
        Portal portal = new Portal();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(portal.voteAgainTxt));
        String actualText =  portal.voteAgainTxt.getText();
        String expectedText =  "VOTE AGAIN";
        Assert.assertEquals(actualText,expectedText);
        portal.voteAgainTxt.click();
        Driver.closeDriver();

    }

    /**
     * Scenario:users Marketing can select an answer to vote a poll.
     */
    @And("marketing  user navigate to poll post for vote")
    public void marketingUserNavigateToPollPostForVote() {
        Portal portal = new Portal();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(portal.voteAgainTxt).perform();
    /*    try {
          Robot robot = new Robot();
          robot.mouseWheel(5);
        } catch (AWTException e) {
            e.printStackTrace();
        }
*/

    }
    @And("marketing  user check the box that user like to vote for")
    public void marketingUserCheckTheBoxThatUserLikeToVoteFor() {
        Portal portal = new Portal();
        if(portal.voteAgainTxt.isDisplayed()){
            portal.voteAgainTxt.click();
        }
        portal.pollVoteRadioButtonToCheck.click();
    }
    @And("marketing  user click on the vote button")
    public void marketingUserClickOnTheVoteButton() {
        Portal portal = new Portal();
        portal.voteButton.click();
    }
    @Then("marketing  user should see {string} text")
    public void marketingUserShouldSeeText(String arg0) {
        Portal portal = new Portal();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(portal.voteAgainTxt));
        String actualText =  portal.voteAgainTxt.getText();
        String expectedText =  "VOTE AGAIN";
        Assert.assertEquals(actualText,expectedText);
        portal.voteAgainTxt.click();
        Driver.closeDriver();
    }

    /**
     * Scenario:users Marketing can select an answer to vote a poll.
     */
    @And("marketing user click on vote again button")
    public void marketingUserClickOnVoteAgainButton() {
        Portal portal = new Portal();
        portal.voteAgainTxt.click();
    }
    @Then("marketing user should be able to vote again")
    public void marketingUserShouldBeAbleToVoteAgain() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        Portal portal = new Portal();
        wait.until(ExpectedConditions.visibilityOf(portal.voteButton));
        Assert.assertTrue(portal.voteButton.isEnabled());
        Assert.assertTrue(portal.voteButton.isDisplayed());
        Driver.closeDriver();
    }
    @And("marketing  user navigate to poll post the user created")
    public void marketingUserNavigateToPollPostTheUserCreated() {
        Portal portal = new Portal();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(portal.voteAgainTxt).perform();

    }
    @Then("marketing user should see stop button")
    public void marketingUserShouldSeeStopButton() {
        Portal portal = new Portal();
        Assert.assertTrue(portal.stopVoteForOnlyTheCreaterOfThePoll.isEnabled());
        Assert.assertTrue(portal.stopVoteForOnlyTheCreaterOfThePoll.isDisplayed());

    }
}
