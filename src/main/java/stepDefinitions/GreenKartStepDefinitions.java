package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinitions {
    public WebDriver driver;


    @Given("user is on Greencart landing page")
    public void user_is_on_Greencart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "C:/bin/chrome-win64/chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("user searched with shortname {string} and finds actual name of the product")
    public void user_searched_with_shortname_and_finds_actual_name_of_the_product(String shortname) {

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        String productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(productName + "is extracted from home page");
    }

    @Then("user searches for {string} shortname in office space")
    public void user_searches_for_shortname_in_office_space(String shortname) {

        driver.findElement(By.linkText("Top Deals")).click();

        //Get all windows
        Set<String> set1 = driver.getWindowHandles();
        Iterator<String> iterator1 = set1.iterator();

        //Select and switch to child window
        String childWindow = iterator1.next();
        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        String offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

}
