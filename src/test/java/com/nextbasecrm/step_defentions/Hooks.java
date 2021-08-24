package com.nextbasecrm.step_defentions;

import com.nextbasecrm.utilities.Driver;
import com.nextbasecrm.utilities.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.sql.*;

public class Hooks {
    @Before
    public void setup(){
        Driver.getDriver().get("https://login2.nextbasecrm.com/");
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenShot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot,"image/png",scenario.getName());
        }


       if(Pages.getStream() !=null){
           Pages.closeStream();
       }
       if(Pages.getAuthorization() != null){
           Pages.closeAuthorization();
       }

        Driver.closeDriver();



    }
}
