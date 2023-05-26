package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AmazonHomePage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LanguageButtonSteps {

    WebDriver finDriver;

    private AmazonHomePage amazonHomePageLanguage;
    @Given("^I am on the Amazon homepage for language button$")
    public void iAmOnAmazonHomePageForLanguage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");

        finDriver = new ChromeDriver(options);

        finDriver.get("https://www.amazon.com/");

        finDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        amazonHomePageLanguage = new AmazonHomePage(finDriver);
    }
    @When("I click on the language dropdown")
    public void iClickOnLanguageDropdown() {
        WebElement languageDropdown = finDriver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]"));
        languageDropdown.click();
    }

    @When("I select a different language option")
    public void iSelectDifferentLanguageOption() {
        WebElement languageOption = finDriver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/input"));
        languageOption.click();
        WebElement saveButton = finDriver.findElement(By.xpath("//*[@id=\"icp-save-button\"]/span/input"));
        saveButton.click();


    }

    @Then("the website content should be displayed in the selected language")
    public void websiteContentShouldBeDisplayedInSelectedLanguage() {
        String expectedLanguage = "español";
        WebElement languageLabel = finDriver.findElement(By.id("icp-nav-flyout"));
        String actualLanguage = languageLabel.getText();
        assertEquals(expectedLanguage, actualLanguage);
        finDriver.quit();
    }
}

