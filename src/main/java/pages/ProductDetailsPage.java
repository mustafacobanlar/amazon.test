package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='dp-container']//h1")
    private WebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isProductDetailsPageDisplayed() {
        // verify that the product title element is displayed
        return productTitle.isDisplayed();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}