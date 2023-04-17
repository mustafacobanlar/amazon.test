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
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");

        // Initialize the WebDriver with the ChromeOptions
        driver = new ChromeDriver(options);

        // Navigate to the Amazon homepage
        driver.get("https://reqres.in/");

        // Set an implicit wait timeout to wait for elements to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}
