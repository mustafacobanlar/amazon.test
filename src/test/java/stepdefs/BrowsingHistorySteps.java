package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import stepdefs.LoginSteps;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.concurrent.TimeUnit;


public class BrowsingHistorySteps {

    /*private AmazonHomePage amazonHomePage;
    private SearchResultPage searchResultPage;
    private ProductDetailsPage productDetailsPage;

    LoginSteps LoginSteps;
    WebDriver myDriver = LoginSteps.getNewDriver();

    @Given("^I navigate to Amazon homepage$")
    public void iNavigateToAmazonHomePage() {
        myDriver.get("https://www.amazon.com/");
    }

    @When("^I search for pencil product")
    public void iSearchForProduct() {
        amazonHomePage.searchForProduct();
    }

    @And("^I click on the first search result$")
    public void iClickOnFirstSearchResult() {

        searchResultPage = new SearchResultPage(myDriver);

        searchResultPage.clickOnFirstResult();
    }

    @Then("^I should be on the product details page$")
    public void iShouldBeOnProductDetailsPage() {
        productDetailsPage = new ProductDetailsPage(myDriver);

        Assert.assertTrue("Product details page is not displayed", productDetailsPage.isProductDetailsPageDisplayed());

    }

    @When("^I go back to the homepage$")
    public void iGoBackToHomepage() {
        //driver.get("https://www.amazon.com/");
        myDriver.navigate().back();
    }

    @Then("^the product should be listed in my browsing history$")
    public void productShouldBeListedInBrowsingHistory() {
        amazonHomePage.clickOnBrowsingHistoryLink();

        Assert.assertTrue("Browsing history page is not displayed", amazonHomePage.isBrowsingHistoryPageDisplayed());


        Assert.assertTrue("Product is not listed in browsing history", amazonHomePage.isProductListedInBrowsingHistory());

    }*/
}
