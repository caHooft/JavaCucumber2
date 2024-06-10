package stepDefinitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinitions {
    public WebDriver driver;
    public String landingPageProductName;
    public String offerPageProductName;


    @Given("user is on Greencart landing page")
    public void user_is_on_Greencart_landing_page() {
        //Cursus example opens testing for Chrome 115 but does not do any steps
        System.setProperty("webdriver.chrome.driver", "C:/bin/chrome-win64/chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        //******** old webdriver c:\bin\chromedriver.exe Trying to use the webdriver from POM here but takes static path old webdriver
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");


        //********* Opens testing for Chrome 115 but does not do any steps V2
        //System.setProperty("webdriver.chrome.driver", "C:/bin/chrome-win64/chrome.exe");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments(new String[] { "--ignore-certificate-errors" });
        //driver = (WebDriver)new ChromeDriver(options);
        //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //******* Opens testing for Chrome 115 but does not do any steps V3
        //System.setProperty("webdriver.chrome.driver", "C:/bin/chrome-win64/chrome.exe"); //115 chromedriver.exe
        //ChromeOptions options = new ChromeOptions();
        //options.setBinary("C:/bin/chrome-win64/chrome.exe"); //115 chrome.exe
        //WebDriver driver = new ChromeDriver(options);
        //driver.get("https://www.google.com");
    }

    @When("user searched with shortname {string} and finds actual name of the product")
    public void user_searched_with_shortname_and_finds_actual_name_of_the_product(String shortname) throws InterruptedException {

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        Thread.sleep(2000);
        String landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + "is extracted from home page");
    }

    @Then("user searches for {string} shortname in offers space")
    public void user_searches_for_shortname_in_offers_space(String shortname) throws InterruptedException {

        driver.findElement(By.linkText("Top Deals")).click();

        //Get all windows
        Set<String> set1 = driver.getWindowHandles();
        Iterator<String> iterator1 = set1.iterator();

        //Select and switch to child window
        String childWindow = iterator1.next();
        driver.switchTo().window(childWindow);

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        Thread.sleep(2000);
        String offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
    }

    @And("validate product name in offers page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {

        Assert.assertEquals(offerPageProductName, landingPageProductName);

    }
}
