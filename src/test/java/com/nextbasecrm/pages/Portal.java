package com.nextbasecrm.pages;

import com.nextbasecrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Portal {
    public Portal(){
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
    public WebElement firstPostedMessage;

     @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement messageCancelButton;




}
