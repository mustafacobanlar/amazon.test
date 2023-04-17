package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AmazonSteps {

    WebDriver driver;

    @Given("I am on the Amazon homepage")
    public void iAmOnTheAmazonHomepage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mustafa.cobanlar\\chrome_driver\\chromedriver.exe");

        // Disable certain Chrome features
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");

        // Initialize the WebDriver with the ChromeOptions
        driver = new ChromeDriver(options);

        // Navigate to the Amazon homepage
        driver.get("https://www.amazon.com/");

        // Set an implicit wait timeout to wait for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I search for a product")
    public void iSearchForAProduct() {
        // Find the search box and enter a search term
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");

        // Click the search button
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
        searchButton.click();
    }

    @Then("I should see the search results")
    public void iShouldSeeTheSearchResults() {
        // Verify that the search results page is displayed
        WebElement resultHeader = driver.findElement(By.xpath("//div[@class='a-section a-text-center s-result-info-bar']"));
        assert resultHeader.isDisplayed();
    }

    @Then("I should see the product details page")
    public void iShouldSeeTheProductDetailsPage() {
        // Click on the first product in the search results
        WebElement firstProduct = driver.findElement(By.xpath("(//a[@class='a-link-normal a-text-normal'])[1]"));
        firstProduct.click();

        // Verify that the product details page is displayed
        WebElement productTitle = driver.findElement(By.id("productTitle"));
        assert productTitle.isDisplayed();
    }

    @Then("I should see the add to cart button")
    public void iShouldSeeTheAddToCartButton() {
        // Verify that the add to cart button is displayed
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        assert addToCartButton.isDisplayed();
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        // Close the browser
        driver.quit();
    }
}
