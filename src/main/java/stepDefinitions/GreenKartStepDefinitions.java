package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinitions {
    @Given("user is on greencart landing page")
    public void user_is_on_greencart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and finds actual name of the product")
    public void user_searched_with_shortname_and_finds_actual_name_of_the_product(String string) {


    }

    @Then("user searches for the same product with the same shortname in office space")
    public void user_searches_for_the_same_product_with_the_same_shortname_in_office_space() {

    }

}
