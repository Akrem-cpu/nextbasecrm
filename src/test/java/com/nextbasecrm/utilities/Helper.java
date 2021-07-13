package com.nextbasecrm.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
    public static void highlightElement(WebDriver driver , WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');" , element);

        BrowserUtils.sleep(2);

        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');" , element);



    }
}
