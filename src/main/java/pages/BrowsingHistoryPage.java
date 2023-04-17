package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowsingHistoryPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Browsing History']/..")
    private WebElement browsingHistoryLink;

    public BrowsingHistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBrowsingHistoryLink() {
        browsingHistoryLink.click();
    }

    public boolean isProductInHistory(String product) {
        String xpath = String.format("//span[@class='bxc-grid__title' and text()='%s']", product);
        return driver.findElements(By.xpath(xpath)).size() > 0;
    }
}