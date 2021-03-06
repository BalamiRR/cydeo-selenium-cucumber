package com.fuatkara.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber "
        },
        features = "src/main/resources/features",
        glue = "com/fuatkara/step_definitions",
        dryRun = false, // if we dont want to open our browser, so write true
        tags="@smoke",
        publish = true
        //tags="@employee"  //sadece employee icerenleri gosterir
        //tags="@employee and @admin"   //or da diyebiliriz. o zaman hepsini gosterir
        //tags="@Regression and not @student"
)
public class CukesRunner {


}
