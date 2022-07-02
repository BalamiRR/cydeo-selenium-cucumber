package com.fuatkara.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt"
        },
        features = "src/main/resources/features",
        glue = "com/fuatkara/step_definitions",
        dryRun = false, // if we dont want to open our browser, so write true
        tags=""
        //tags="@employee"  //sadece employee icerenleri gosterir
        //tags="@employee and @admin"   //or da diyebiliriz. o zaman hepsini gosterir
        //tags="@Regression and not @student"
)
public class CukesRunner {


}
