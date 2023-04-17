package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchResultPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-component-type='s-search-result'][1]//h2//a")
    private WebElement firstResult;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFirstResult() {
        firstResult.click();
    }

}
