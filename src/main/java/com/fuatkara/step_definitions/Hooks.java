package com.fuatkara.step_definitions;
/*
    In the class we will be able to pass pre- & post - conditions to each
    scenario and each step
* */
import com.fuatkara.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit   Yoksa kotta calismaz
    //import org.junit.After;
    //import org.junit.Before;

    @Before(order = 1)
    public void setupScenario(){
        System.out.println("===Setting up browser using cucumber @Before");
    }

    @Before(value="@login", order=2)
    public void setupScenarioForLogins(){
        System.out.println("===This will only apply to scenarios with @login tag");
    }

    @Before(value="@db", order=0)
    public void setupForDatabaseScenarios(){
        System.out.println("===This will only apply to scenarios with @db tag");
    }

    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()){//scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);//byte [] screenshot = We are creating an array of bytes to be able to store our screenshot
            //((TakesScreenshot)Driver.getDriver()) ---> we are downcasting our driver type to TakesScreenshot
            //.getScreenshotAs(OutputType.BYTES); ---> we are returning the screenshot as byte so we can use
            scenario.attach(screenshot, "image/png", scenario.getName());
            //scenario.attach() --> this method is able to attach the screenshot into our report
            //-it accepts 3 arguments
        }
        Driver.closeDriver();
        //System.out.println("===Closing browser using cucumber @After");
        //System.out.println("===Scenario ended/ Take screenshot if failed!");
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("-----> applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("-----> applying tearDown using @AfterStep");
    }

}


