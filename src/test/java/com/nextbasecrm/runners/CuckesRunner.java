package com.nextbasecrm.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "com/nextbasecrm/step_defentions",
        tags = "@wip",
        plugin = "html:target/report.html",
        dryRun =  false

)

public class CuckesRunner  {

}

