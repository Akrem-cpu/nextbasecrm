package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityStream {
    public ActivityStream(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='user-block']")
    public WebElement userInfDiv;
    @FindBy(xpath = "//span[.='Log out']")
    public WebElement Logout;
     @FindBy(xpath = "//div[@class='feed-add-post-micro']")
    public WebElement messageBox;
     @FindBy(className = "bx-editor-iframe")
    public WebElement firstIframe;

     @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageBoxInsideIframeOne;

     @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendMessage;

     @FindBy (xpath = "(//div[@class='workarea-content-paddings']//div[@class='feed-post-text-block-inner-inner'])[1]")
    public WebElement firstRecentlyPostedMessage;

     @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement messageCancelButton;

     @FindBy(xpath = "//span[@title='Link']")
    public WebElement AddLinkButton;


     @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveLinkAfterGivingALinkAndName;

     @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement linkTextBoxToGiveATextToTheLink;

     @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement linkUrlBoxToGiveAUrlForTheLink;

     @FindBy(xpath = "(//div[@class='workarea-content-paddings']//div[@class='feed-post-text-block-inner-inner'])[1]/a")
    public WebElement linkInsideThePostedText;
     @FindBy(xpath = "//div[@class='workarea-content-paddings']/div[3]/div[2]/div[1]//span[.='happy']")
     public WebElement firstOptionToSelectFromThePollVote;

    @FindBy(xpath = "//div[@class='workarea-content-paddings']/div[3]/div[2]/div[1]//button[.='Vote']")
    public WebElement voteButton;

    @FindBy(xpath = "//div[@class='workarea-content-paddings']/div[3]/div[2]/div[1]")
    public WebElement firstRecentPostedPoll;

    @FindBy(xpath = "//div[@class='workarea-content-paddings']/div[3]/div[2]/div[1]//button[.='Vote again']")
    public WebElement voteAgainTxt;

    @FindBy(xpath = "//div[@class='workarea-content-paddings']/div[3]/div[2]/div[1]//button[.='Stop']")
    public WebElement stopVoteForOnlyTheCreaterOfThePoll;

    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-vote']")
    public WebElement poll;

    @FindBy(xpath = "//input[@id='question_0']")
    public WebElement questionBoxForPollCreation;

    @FindBy(xpath = "//ol[@class='vote-answers']//li//input[contains(@placeholder,'Answer')]")
    public List<WebElement> listOfVoteAnswerForPollCreation;

    @FindBy(xpath = "//div[@class='vote-checkbox-wrap']/input")
    public WebElement multipleChoiceAllowButtonForPollCreation;


    @FindBy(xpath = "//span[.='The message title is not specified']")
    public WebElement errorMessageWhenTryingToCreatingPollWithOutTitle;

    @FindBy(xpath = "//span[@class='feed-new-message-inf-text']")
    public WebElement moreEvent;

    @FindBy(xpath = "//a[.='Add question']")
    public WebElement addQuestionWhenCreatingPoll;

    @FindBy(xpath = "//div[@class='vote-fields']//li[@class='vote-question']")
    public List<WebElement> allAddedQuestionWhenCreatedAPoll;

}
