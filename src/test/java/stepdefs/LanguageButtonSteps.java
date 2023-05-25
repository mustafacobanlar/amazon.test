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
import static org.junit.Assert.assertEquals;

public class LanguageButtonSteps {

    WebDriver driver;
    WebDriverWait wait;

    @When("I click on the language dropdown")
    public void iClickOnLanguageDropdown() {
        WebElement languageDropdown = driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]"));
        languageDropdown.click();
        //WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"icp-language-heading\"]")));
    }

    @When("I select a different language option")
    public void iSelectDifferentLanguageOption() {
        WebElement languageOption = driver.findElement(By.cssSelector("[data-value='es_US']"));
        languageOption.click();
    }

    @Then("the website content should be displayed in the selected language")
    public void websiteContentShouldBeDisplayedInSelectedLanguage() {
        String expectedLanguage = "español";
        WebElement languageLabel = driver.findElement(By.id("icp-nav-flyout"));
        String actualLanguage = languageLabel.getText();
        assertEquals(expectedLanguage, actualLanguage);
        driver.quit();
    }
}

