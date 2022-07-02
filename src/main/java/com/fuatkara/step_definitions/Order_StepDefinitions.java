package com.fuatkara.step_definitions;

import com.fuatkara.pages.BasePage;
import com.fuatkara.pages.OrderPage;
import com.fuatkara.pages.ViewAllOrderPage;
import com.fuatkara.pages.WebTableLoginPage;
import com.fuatkara.utilities.BrowserUtils;
import com.fuatkara.utilities.ConfigurationReader;
import com.fuatkara.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Order_StepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();

    ViewAllOrderPage viewAllOrderPage = new ViewAllOrderPage();


    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        //Getting the page using the URL from configuration.properties
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));

        //Calling our login method to login to web table app
        webTableLoginPage.login();

        //Clicking to "order" link to go order page
        basePage.order.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
    }

//    @When("user enters quantity {string}")
//    public void user_enters_quantity(String string) {
//    }

    @And("user enters quantity {int}")
    public void user_enters_quantity(int quantity) {
        //accepting int argument and sending it using sendKeys() method
        //since sendKeys() method only accepts String, we need to either concat with ""
        //or send String.valueOf(int);
        //orderPage.inputQuantity.sendKeys(String.valueOf(quantity));

        //clear() method will delete whatever is in the input box
        //orderPage.inputQuantity.clear();

        //imitating pressing back_space button from keyboard to delete existing input
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

        orderPage.inputQuantity.sendKeys(quantity+"");
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.inputName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String creditCardNumber) {
        //WebElement selectCreditCard = Driver.getDriver().findElement(By.xpath("//input[@value='American Express']"));
        //selectCreditCard.click();
        BrowserUtils.clickRadioButton(orderPage.cardType, creditCardNumber);
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String enterCardNumber) {
        orderPage.inputCardNumber.sendKeys(enterCardNumber);
    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String exp) {
        orderPage.cardExpInput.sendKeys(exp);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.orderButton.click();
    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        String actualName = viewAllOrderPage.newCustomerCell.getText();

        Assert.assertEquals(expectedName, actualName);
    }
}
