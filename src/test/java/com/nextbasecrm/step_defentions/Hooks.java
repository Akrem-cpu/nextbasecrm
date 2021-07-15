package com.nextbasecrm.step_defentions;

import com.nextbasecrm.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup(){
        Driver.getDriver().get("https://login2.nextbasecrm.com/");
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
