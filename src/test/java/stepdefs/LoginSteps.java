package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonHomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @When("^I go to Amazon login page$")
    public void navigateToLoginPage() {
        System.out.println("flag");
        WebElement funcButton = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(funcButton).perform();
    }

    @When("I enter my email as {string}")
    public void enterEmail(String email) {
        loginPage.enterEmail(email);
    }

    @When("I enter my password as {string}")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the Sign In button")
    public void clickSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("I should be logged in")
    public void verifyLoggedIn() {
        // Add assertions or verifications for successful login
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        // Add assertions or verifications for error message
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}