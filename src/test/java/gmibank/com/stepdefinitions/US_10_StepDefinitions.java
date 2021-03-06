package gmibank.com.stepdefinitions;

import com.github.javafaker.Faker;
import gmibank.com.pages.US_10_Page;
import gmibank.com.utilities.ConfigurationReader;
import gmibank.com.utilities.Driver;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class US_10_StepDefinitions {

    US_10_Page us_10_page = new US_10_Page();
    Faker faker = new Faker();

    @Given("US10 user on the login page {string}")
    public void us10_user_on_the_login_page(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmibank_login_url"));
    }

    @Given("US10 send username to username box {string}")
    public void us10_send_username_to_username_box(String string) {
        us_10_page.username.sendKeys(string);
    }

    @Given("US10 send password to password box {string}")
    public void us10_send_password_to_password_box(String string) {
        us_10_page.password.sendKeys(string);
    }

    @Given("US10 click sign in")
    public void us10_click_sign_in() {
       us_10_page.signInButton.click();
    }

    @Given("US10 click to my operations")
    public void us10_click_to_my_operations() {
       us_10_page.myOperations.click();
    }

    @Given("US10 click to manage customers")
    public void us10_click_to_manage_customers() {
        us_10_page.manageCustomers.click();
    }

    @Given("US10 click to create a new customer")
    public void us10_click_to_create_a_new_customer() {
       us_10_page.createANewCustomer.click();
    }
/*
    @Given("US10 type a valid SSN {string}")
    public void us10_type_a_valid_SSN(String string) {
        us_10_page.ssnBox.sendKeys(string);
    }

    @Given("US10 click search button")
    public void us10_click_search_button() {
        us_10_page.search.click();
    }
*/
    @Given("US10 click save button")
    public void us10_click_save_button() {
       us_10_page.saveButton.click();
    }

    @Given("US10 Verify adress box required message")
    public void us10_Verify_adress_box_required_message() {
        Driver.wait(2);
        String verifyMessage = us_10_page.requiredMessageAdress.getText();
        Assert.assertEquals("This field is required.",verifyMessage);
        System.out.println(verifyMessage);
    }

    @Given("US10 Send adress to adress box")
    public void us10_Send_adress_to_adress_box() {
        String adress = faker.address().fullAddress();
        us_10_page.addressBox.sendKeys(adress);
    }

    @Given("US10 Verify city box required message")
    public void us10_Verify_city_box_required_message() {
        Driver.wait(2);
        String verifyMessage = us_10_page.requiredMessageCity.getText();
        Assert.assertEquals("This field is required.",verifyMessage);
        System.out.println(verifyMessage);
    }

    @Given("US10 Send city name to city box")
    public void us10_Send_city_name_to_city_box() {
        String city = faker.address().city();
        us_10_page.city.sendKeys(city);
    }

    @Given("US10 Select country name to country dropdown")
    public void us10_Select_country_name_to_country_dropdown() {
        Select select = new Select(us_10_page.countryDropdown);
        select.selectByVisibleText("Japan");
    }

    @Given("US10 Send state name to state box")
    public void us10_Send_state_name_to_state_box() {
        String state = faker.address().state();
        us_10_page.stateBox.sendKeys(state);
    }


}
