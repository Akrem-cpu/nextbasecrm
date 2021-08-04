package com.nextbasecrm.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.function.Function;

public class BrowserUtils {

    public static void sleep(int second) {

        second*=1000;

        try {

            Thread.sleep(second);

        } catch (InterruptedException e) {

            System.out.println("something happened in the sleep method");

        }

    }

    public static WebDriverWait waitFor(){
        return new WebDriverWait(Driver.getDriver(),15);
    }
    public static void waitUntilTitle(String title){
      waitFor().until(ExpectedConditions.titleIs(title));

    }
    public static WebElement fluentWait(WebElement ele){

        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return ele;
            }
        });

     if (ele.isDisplayed()){
         return ele;
     }
     throw new NoSuchElementException("element found");


    }

}
