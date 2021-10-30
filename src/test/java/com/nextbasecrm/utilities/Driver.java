package com.nextbasecrm.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Driver {


    private Driver(){}


    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();


    public static WebDriver getDriver(){

        if (driverPool.get() == null){
             synchronized (Driver.class) {

                 String browserType = ConfiReader.getProperty("browser");


                 switch (browserType) {
                     case "chrome":
                         ChromeOptions options = new ChromeOptions();
                         options.setHeadless(false);
                         WebDriverManager.chromedriver().setup();
                         driverPool.set(new ChromeDriver(options));
                         driverPool.get().manage().window().maximize();
                         driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                         break;

                 }
             }
        }


        return  driverPool.get();


    }


    public static void closeDriver(){
        if( driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
          
        }
    }


}
