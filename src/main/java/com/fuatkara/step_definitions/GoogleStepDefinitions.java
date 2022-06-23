package com.fuatkara.step_definitions;
import com.fuatkara.pages.GoogleSearchPage;
import com.fuatkara.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user types apple and clicks enter")
    public void user_types_and_clicks_enter2(){
        googleSearchPage.searchBox.sendKeys("Apple" + Keys.ENTER);
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String string) {
        googleSearchPage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String expectedTitle = string + "Recherche Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not as expected", expectedTitle, actualTitle);
    }

    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String expectedTitle = "Apple - Recherche Google";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts firs arg as expected, second arg as actual
        Assert.assertEquals("Title is not as expected" ,expectedTitle, actualTitle);

        //Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    //================
    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
        WebElement toutAccepter = Driver.getDriver().findElement(By.xpath("//div[@class='QS5gu sy4vM']"));
        toutAccepter.click();
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals(expectedTitle, actualTitle);

        //Assert.assertTrue(actualTitle.equals(expectedTitle));
        Driver.closeDriver();
    }

    @Then("User should see {string} in the result")
    public void userShouldSeeInTheResult(String expectedCapital) {
        String actualValue = googleSearchPage.getCapital();
        Assert.assertEquals(expectedCapital,actualValue);
    }

}
