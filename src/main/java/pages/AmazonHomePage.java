package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
    private WebDriver driver;

    By hamburgerMenu = By.id("nav-hamburger-menu");
    By browsingHistoryLink = By.xpath("//span[contains(text(), 'Browsing history')]");
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "(//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col sg-col-12-of-16'])[1]")
    private WebElement firstSearchResult;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnBrowsingHistoryLink() {
        driver.findElement(hamburgerMenu).click();
        driver.findElement(browsingHistoryLink).click();
    }
    public boolean isBrowsingHistoryPageDisplayed() {
        return driver.getTitle().contains("Browsing History");
    }

    public void searchForProduct() {
        searchBox.sendKeys("pencil");
        searchBox.submit();
    }
    public boolean isProductListedInBrowsingHistory() {
        return driver.getPageSource().contains("pencil");
    }

    public void clickOnFirstSearchResult() {
        firstSearchResult.click();
    }
}
