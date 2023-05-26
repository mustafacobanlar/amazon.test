package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.AmazonHomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    public WebDriver newDriver;
    SearchResultPage searchResultPage;

    ProductDetailsPage productDetailsPage;
    public AmazonHomePage thisAmazonHomePage;
    @Given("^I am on the Amazon homepage for login$")
    public void iAmOnAmazonHomePageForLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized");

        newDriver = new ChromeDriver(options);

        newDriver.get("https://www.amazon.com/");

        newDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //thisAmazonHomePage = new AmazonHomePage(newDriver);
    }
    @And("^I go to Amazon login page$")
    public void navigateToLoginPage() throws InterruptedException {
        WebElement signInButton = newDriver.findElement(By.xpath("//*[@id=\"nav-signin-tooltip\"]/a"));
        signInButton.click();
    }

    @When("^I enter my email as (.*)$")
    public void enterEmail(String email) {
        WebElement emailField = newDriver.findElement(By.id("ap_email"));
        emailField.sendKeys(email);
    }

    @When("^I click the continue button$")
    public void clickContinue() {
        WebElement contButton = newDriver.findElement(By.xpath("//*[@id=\"continue\"]"));
        contButton.click();
    }

    @When("^I enter my password as (.*)$")
    public void enterPassword(String password) {
        WebElement passwordFıeld = newDriver.findElement(By.id("ap_password"));
        passwordFıeld.sendKeys(password);
    }

    @When("I click the Sign In button")
    public void clickSignInButton() {
        WebElement signinButton = newDriver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
        signinButton.click();
    }

    @Then("I should be logged in")
    public void verifyLoggedIn() {
        WebElement userAccountElement = newDriver.findElement(By.xpath("//*[@id=\"nav-recently-viewed\"]"));
        Assert.assertTrue("User account element is not displayed", userAccountElement.isDisplayed());
    }

    @Then("^I shouldn't be logged in$")
    public void verifyNotLoggedIn() {
        boolean isElementPresent = newDriver.findElements(By.xpath("//*[@id=\"nav-recently-viewed\"]")).isEmpty();
        Assert.assertTrue("Element should not be present: " + "//*[@id=\"nav-recently-viewed\"]", isElementPresent);
    }

    @When("^I search for (.*) product")
    public void iSearchForProduct(String productName) {
        WebElement searchBox = newDriver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    @And("^I click on the first search result$")
    public void iClickOnFirstSearchResult() {

        WebElement firstResult = newDriver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]//h2//a"));
        firstResult.click();
    }

    @Then("^I should be on the product details page$")
    public void iShouldBeOnProductDetailsPage() {
        productDetailsPage = new ProductDetailsPage(newDriver);

        WebElement productTitle = newDriver.findElement(By.xpath("//div[@id='dp-container']//h1"));
        Assert.assertTrue("Product details page is not displayed", productTitle.isDisplayed());

    }

    @When("^I go back to the homepage$")
    public void iGoBackToHomepage() {
        //driver.get("https://www.amazon.com/");
        newDriver.navigate().back();
    }

    @Then("^the (.*) product should be listed in my browsing history$")
    public void productShouldBeListedInBrowsingHistory(String productName) {
        WebElement browsingHistoryButton = newDriver.findElement(By.xpath("//*[@id=\"nav-recently-viewed\"]"));
        browsingHistoryButton.click();

        Assert.assertTrue("Browsing history page is not displayed", newDriver.getTitle().contains("Browsing History"));

        Assert.assertTrue("Product is not listed in browsing history", newDriver.getPageSource().contains(productName));

    }

}