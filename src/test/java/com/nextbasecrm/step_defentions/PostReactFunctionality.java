package com.nextbasecrm.step_defentions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostReactFunctionality {
    /**
     *  hr users click Like button for any post
     */

    @When("hr user click on like button for the first post user see")
    public void hr_user_click_on_like_button_for_the_first_post_user_see() {
        ActivityStream stream = new ActivityStream();
        if(!stream.firstPostToLikeComfrmation.isDisplayed()){
            stream.likeButtonForTheFirstPost.click();
        }
    }
    @Then("hr user should be able to see a thumps up with {string} text")
    public void hr_user_should_be_able_to_see_a_thumps_up_with_text(String string) {
        ActivityStream stream = new ActivityStream();
        String actualText = stream.firstPostToLikeComfrmation.getText();
        Assert.assertTrue(actualText.contains(string));


    }

    /**
     * Scenario: marketing users click Like button for any post
     */
    @When("marketing user click on like button for the first post user see")
    public void marketing_user_click_on_like_button_for_the_first_post_user_see() {
        ActivityStream stream = new ActivityStream();
        if(!stream.firstPostToLikeComfrmation.isDisplayed()){
            stream.likeButtonForTheFirstPost.click();
        }



    }
    @Then("marketing user should be able to see a thumps up with {string} text")
    public void marketing_user_should_be_able_to_see_a_thumps_up_with_text(String string) {
        ActivityStream stream = new ActivityStream();
        String actualText = stream.firstPostToLikeComfrmation.getText();
        Assert.assertTrue(actualText.contains(string));

    }

    /**
     *  Scenario: helpdesk users click Like button for any post
     */
    @When("helpdesk user click on like button for the first post user see")
    public void helpdesk_user_click_on_like_button_for_the_first_post_user_see() {
        ActivityStream stream = new ActivityStream();
        if(!stream.firstPostToLikeComfrmation.isDisplayed()){
            stream.likeButtonForTheFirstPost.click();
        }
    }
    @Then("helpdesk user should be able to see a thumps up with {string} text")
    public void helpdesk_user_should_be_able_to_see_a_thumps_up_with_text(String string) {
        ActivityStream stream = new ActivityStream();
        String actualText = stream.firstPostToLikeComfrmation.getText();
        Assert.assertTrue(actualText.contains(string));

    }


    /**
     * Scenario:  users are able to follow a post by clicking Follow button
     */

    @When("helpdesk user click on follow button")
    public void helpdesk_user_click_on_follow_button() {
        ActivityStream stream = new ActivityStream();
        if(stream.followButtonOnTheFirstMostRecentPost.getText().equals("Unfollow")){
            stream.followButtonOnTheFirstMostRecentPost.click();
        }
        stream.followButtonOnTheFirstMostRecentPost.click();
    }
    @Then("helpdesk should see {string} text")
    public void helpdesk_should_see_text(String string) {
        ActivityStream stream = new ActivityStream();
        String actualText = stream.followButtonOnTheFirstMostRecentPost.getText();
        Assert.assertEquals("there is diff b/n actual and expected this is the actual"+actualText,string,actualText);
    }

    /**
     * Scenario: users can see who are the people viewed a post with eye icon
     */
    @When("helpdesk user click on the view icon")
    public void helpdesk_user_click_on_the_view_icon() {
        ActivityStream stream = new ActivityStream();
        stream.viewIconForTheMostRecentPost.click();
    }
    @Then("helpdesk should see the people who viewed the post")
    public void helpdesk_should_see_the_people_who_viewed_the_post() {
        ActivityStream stream = new ActivityStream();
       new  WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.peopleThatSeenThePostOnlyLoadOnThePageAfterYouClickOnTheViewButton));
       Assert.assertTrue(stream.peopleThatSeenThePostOnlyLoadOnThePageAfterYouClickOnTheViewButton.isDisplayed());
    }

    /**
     Scenario: users click star icon to save a post as favorite
     */
    @When("helpdesk user click the star icon to save the post to favorites")
    public void helpdesk_user_click_the_star_icon_to_save_the_post_to_favorites() {
      ActivityStream stream = new ActivityStream();
      String checkUp = stream.addToFavoritesButtonForRecentPost.getAttribute("title");
      if(checkUp.equals("Remove from favorites")){
          stream.addToFavoritesButtonForRecentPost.click();
      }
      stream.addToFavoritesButtonForRecentPost.click();
    }
    @Then("helpdesk user should see the post added to favorites post")
    public void helpdesk_user_should_see_the_post_added_to_favorites_post() {
        ActivityStream stream = new ActivityStream();
        BrowserUtils.sleep(1);
        String actualText = stream.addToFavoritesButtonForRecentPost.getAttribute("title");
        String expectedText = "Remove from favorites";
        Assert.assertEquals(actualText,expectedText);

    }

    /**
     *  Scenario: users can write comment to a post
     */

    @When("helpdesk user click on the comment box")
    public void helpdesk_user_click_on_the_comment_box() {
        ActivityStream stream = new ActivityStream();
        stream.commentBoxOnTheMostRecentPost.click();
    }
    @Then("helpdesk user write a comment")
    public void helpdesk_user_write_a_comment() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.iframeForCommentText);
        stream.textBoxInsideCommentIframe.sendKeys(new Faker().name().fullName());
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("helpdesk user click on send button")
    public void helpdesk_user_click_on_send_button() {
        ActivityStream stream = new ActivityStream();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(stream.sendCommentForTheMostRecentPost).perform();
        new WebDriverWait(Driver.getDriver(),14).until(ExpectedConditions.visibilityOf(stream.sendCommentForTheMostRecentPost));
        stream.sendCommentForTheMostRecentPost.click();
    }
    @Then("helpdesk user should see the comment")
    public void helpdesk_user_should_see_the_comment() {
        ActivityStream stream = new ActivityStream();
        Assert.assertTrue(stream.firstCommentButtonForMostRecentPost.isDisplayed());
    }
    /**
     *    Scenario: users cancel a comment with Cancel button
     */

    @Then("helpdesk user click cancel button")
    public void helpdesk_user_click_cancel_button() {
        ActivityStream stream = new ActivityStream();
       new  WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.visibilityOf(stream.cancelButtonForCommentForRecentPost));
        new Actions(Driver.getDriver()).moveToElement(stream.cancelButtonForCommentForRecentPost).perform();
        stream.cancelButtonForCommentForRecentPost.click();
    }
    @Then("helpdesk user should see the comment canceled")
    public void helpdesk_user_should_see_the_comment_canceled() {
        ActivityStream stream = new ActivityStream();
        new  WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.invisibilityOf(stream.cancelButtonForCommentForRecentPost));
        Assert.assertFalse(stream.sendCommentForTheMostRecentPost.isDisplayed());
    }


}
