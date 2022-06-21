package com.fuatkara.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_StepDefinitions {

    //Librarian
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("user enters librarian username");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("user enters librarian password");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("user should see the dashboard");
    }

    //Student
    @When("user enters student username")
    public void userEntersStudentUsername() {
        System.out.println("user enters student password");
    }
    @And("user enters student password")
    public void userEntersStudentPassword() {
        System.out.println("user enters student password");
    }

    //Admin
    @When("user enters admin username")
    public void userEntersAdminUsername() {
        System.out.println("user enters admin username");
    }
    @And("user enters admin password")
    public void userEntersAdminPassword() {
        System.out.println("user enters admin password");
    }

    //
    @Given("user is on the library login page")
    public void userIsOnTheLibraryLoginPage(){
        System.out.println("user is on the library login page");
    }
}
