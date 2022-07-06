# Java 8  Selenium  JUnit  Cucumber

<p align="left"> 

<a href="https://www.java.com" target="_blank" rel="noreferrer"> 
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="60" height="60"/> 
</a> 

<a href="https://www.selenium.dev" target="_blank" rel="noreferrer">
  <img src="https://selenium.dev/images/selenium_logo_square_green.png" alt="selenium" width="60" height="60"/> 
</a>    

<a href="https://www.oracle.com/" target="_blank" rel="noreferrer"> 
  <img src="https://lisacrispin.com/wp-content/uploads/2019/01/Screen-Shot-2019-01-17-at-12.13.33-PM.png" alt="oracle" width="60" height="60"/> 
</a>

<a href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPEOYG6Ap6vFoqv5bNXkDvnCa1yAqbDr_f_YQhXa97QwYXvNqWIvnCzpFJJz1ZwcLrwbM&usqp=CAU" rel="noreferrer">
  <img src="https://www.codeaffine.com/wp-content/uploads/2016/02/junit-lambda.png" width="115" height="60"/> 
</a> 
</p>

### selenium-cucumber-java

This repository contains a collection of sample `cydeo-selenium-cucumber` projects and libraries that demonstrate how to
use the tool and develop automation script using the Cucumber BDD framework with Java as programming language.
It generate Allure, HTML and Txt reporters as well. It also generate `screen shots` for your tests if you enable it and
also generate `error shots` for your failed test cases as well.

### Installation (pre-requisites)

1. JDK 1.8+ 
2. Maven 
3. IntelliJ
4. IntelliJ Plugins for
    - Maven
    - Cucumber
5. Browser driver (make sure you have your desired browser driver and class path is set)

### Framework set up

Git:

    git clone https://github.com/BalamiRR/cydeo-selenium-cucumber.git
 
Manually :

Fork / Clone repository from [here](https://github.com/BalamiRR/cydeo-selenium-cucumber/archive/main.zip) or download zip and set
it up in your local workspace.



### Using canned test in the project:

The CukesRunner runner file should contain the path of the feature file and step definition file that we want to execute
Code Implementation of test runner file below:

```
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

```

### Develop automation scripts using BDD approach - Cucumber-Java

There are already many predefined StepDefinitions which is packaged under `/steps/Order_StepDefinitions.java` will help you speed
up your automation development that support both your favorite workaday helpers methods.

Tests are written in the Cucumber framework using the Gherkin Syntax.
Here is one of the scenarios:

```
 Scenario Template: User should be able to place order and order seen in web table
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipcode>"
    And user selects credit card type "<cardType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in first row of the web table

    @femaleScientists
    Examples: Famous female scientists
      | productType | quantity | customerName       | street    | city   | state   | zipcode | cardType | cardNumber       | expDate | expectedName       |
      | MoneyCog    | 2        | Marie Curie        | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Marie Curie        |
      | Familybea   | 3        | Rosalind Franklin  | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Rosalind Franklin  |
      | Screenable  | 4        | List Meitner       | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | List Meitner       |
      | MoneyCog    | 5        | Chien-Shiung Wu    | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Chien-Shiung Wu    |
      | MoneyCog    | 6        | Barbara McClintock | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Barbara McClintock |

    @maleScientist
    Examples: Famous male scientists
      | productType | quantity | customerName          | street    | city   | state   | zipcode | cardType | cardNumber       | expDate | expectedName          |
      | MoneyCog    | 2        | Charles Darwin        | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Charles Darwin        |
      | Familybea   | 3        | Albert Einstein       | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Albert Einstein       |
      | Screenable  | 4        | CV Raman              | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | CV Raman              |
      | MoneyCog    | 5        | Galileo               | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Galileo               |
      | MoneyCog    | 6        | Isaac Newton          | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Isaac Newton          |
      | MoneyCog    | 6        | Arnold Schwarzenegger | London st | London | England | 50505   | Visa     | 1111222233334444 | 12/24   | Arnold Schwarzenegger |
      
     
```


##### HTML Report:

To generate HTML report use  `mvn test -Dcucumber.options="–plugin html:target/cucumber-reports.html"`

##### Txt Report:

To generate a Txt report Use `mvn test -Dcucumber.options="–plugin rerun:target/rerun.txt"`


### THE END
