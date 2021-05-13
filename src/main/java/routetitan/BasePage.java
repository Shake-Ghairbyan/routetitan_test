package routetitan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[text()='Get started']")
    WebElement getStarted;

    @FindBy(xpath = "//*[text()='Login']")
    WebElement login;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGetStartedButton() {
        getStarted.click();
    }

    public void clickLogin() {
        login.click();
    }

    public void waitUntilPageLoads() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(getStarted));
    }
}
