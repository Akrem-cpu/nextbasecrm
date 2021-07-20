package com.nextbasecrm.step_defentions;

import com.github.javafaker.Faker;
import com.nextbasecrm.pages.ActivityStream;
import com.nextbasecrm.utilities.BrowserUtils;
import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Eventfuctionaltiy_StepDefinitions {
    String data = new Faker().name().firstName();
    String actualStartTime ;
    String actualEndTime;


    /**
     * Scenario: hr users send event.
     */
    @When("hr user click on event")
    public void hr_user_click_on_event() {
        ActivityStream stream = new ActivityStream();
        stream.event.click();
    }
    @When("hr user give need filed")
    public void hr_user_give_need_filed() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.firstIframe);
        stream.textBoxInsideCommentIframe.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("hr user should see the event created")
    public void hr_user_should_see_the_event_created() {
        BrowserUtils.sleep(1);
        ActivityStream stream = new ActivityStream();
        Assert.assertTrue(stream.mostRecentPostedEvent.isDisplayed());
        Assert.assertTrue(stream.mostRecentPostedEvent.getText().contains(data));

    }
    /**
     *  Scenario: marketing users send event.
     */


    @When("marketing user click on event")
    public void marketing_user_click_on_event() {
        Pages.getStream().event.click();
    }
    @When("marketing user give need filed")
    public void marketing_user_give_need_filed() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.firstIframe);
        stream.textBoxInsideCommentIframe.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("marketing user should see the event created")
    public void marketing_user_should_see_the_event_created() {
        BrowserUtils.sleep(1);
        ActivityStream stream = new ActivityStream();
        Assert.assertTrue(stream.mostRecentPostedEvent.isDisplayed());
        Assert.assertTrue(stream.mostRecentPostedEvent.getText().contains(data));
    }

    /**
     *     Scenario: helpdesk users send event.
     */
    @When("helpdesk user click on event")
    public void helpdesk_user_click_on_event() {
        ActivityStream stream = new ActivityStream();
        stream.event.click();
    }
    @When("helpdesk user give need filed")
    public void helpdesk_user_give_need_filed() {
        ActivityStream stream = new ActivityStream();
        Driver.getDriver().switchTo().frame(stream.firstIframe);
        stream.textBoxInsideCommentIframe.sendKeys(data);
        Driver.getDriver().switchTo().defaultContent();
    }
    @Then("helpdesk user should see the event created")
    public void helpdesk_user_should_see_the_event_created() {
        BrowserUtils.sleep(1);
        ActivityStream stream = new ActivityStream();
        Assert.assertTrue(stream.mostRecentPostedEvent.isDisplayed());
        Assert.assertTrue(stream.mostRecentPostedEvent.getText().contains(data));
    }

    /**
     *  Scenario:users can cancel events with CANCEL button
     */

    @Then("helpdesk user should see the event removed")
    public void helpdesk_user_should_see_the_event_removed() {
        ActivityStream stream = new ActivityStream();
        stream.cancelButton.click();
        Assert.assertFalse(stream.sendMessage.isDisplayed());
    }


    /**
     *  users can check modify event tarting and ending time
     */

    @When("helpdesk user click on event start Time")
    public void helpdesk_user_click_on_event_start_date() {
    ActivityStream stream = new ActivityStream();
    stream.startTimeBoxForEvenCreation.click();

    }
    @And("helpdesk user give the time needed{string}")
    public void helpdeskUserGiveTheDateNeeded(String arg0) {
        ActivityStream stream = new ActivityStream();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.visibilityOf(stream.startTimeBoxForEvenCreation));
        stream.startTimeBoxTOChangeTime.clear();
        stream.startTimeBoxTOChangeTime.sendKeys(arg0+ Keys.ENTER);
        this.actualStartTime = stream.timeTextForStartTime.getText();
        String a = Driver.getDriver().findElement(By.xpath("//div[@class='bxc-title'][1]")).getAttribute("innerText");
    }
    @And("helpdesk user click on set time for the start time")
    public void helpdeskUserClickOnSetTime() {
        ActivityStream stream = new ActivityStream();
        stream.setStartTimeForEventCreation.click();
    }


    @When("helpdesk user clicks on the event end time")
    public void helpdesk_user_clicks_on_the_even_date() {
        ActivityStream stream = new ActivityStream();
        stream.endTimeBoxForEventCreation.click();


    }
    @And("helpdesk user clicks on give date needed{string}")
    public void helpdeskUserClicksOnGiveDateNeeded(String arg0) {
        ActivityStream stream = new ActivityStream();
        stream.endTimeBoxToChangeTime.clear();
        stream.endTimeBoxToChangeTime.sendKeys(arg0+Keys.ENTER);
        this.actualEndTime =stream.timeTextForEndTime.getText();

    }
    @And("helpdesk user click on set time for the end time")
    public void helpdeskUserClickOnSetTimeForTheEndTime() {
        ActivityStream stream = new ActivityStream();
        stream.setEndTimeForEvenCreation.click();

    }


    @Then("helpdesk user should see the date changed start time {string} end time {string}")
    public void helpdeskUserShouldSeeTheDateChangedStartTimeEndTime(String arg0, String arg1) {
        ActivityStream stream = new ActivityStream();
        System.out.println(actualStartTime +" actual = expected =" +arg0);
        System.out.println(actualStartTime +" actual = expected =" +arg1);
        Assert.assertTrue(actualStartTime.contains(arg0));
        Assert.assertTrue(actualEndTime.contains(arg1));




    }

    /**
     * users can chekc ""All day""
     */
    @And("helpdesk user click on all day check box")
    public void helpdeskUserClickOnAllDayCheckBox() {
        Pages.getStream().allDayButtonForEventCreation.click();
    }

    @Then("helpdesk user should see time disapear from the page")
    public void helpdeskUserShouldSeeTimeDisapearFromThePage() {
        Assert.assertFalse(Pages.getStream().endTimeBoxForEventCreation.isDisplayed());
        Assert.assertFalse(Pages.getStream().startTimeBoxForEvenCreation.isDisplayed());

    }
}
