package com.nextbasecrm.step_defentions;

import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Helper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.swing.*;

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






}
