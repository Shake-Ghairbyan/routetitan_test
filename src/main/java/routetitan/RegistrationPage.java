package routetitan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@class='MuiFormControl-root MuiTextField-root jss57']")
    WebElement inputField;

    @FindBy(name = "fullName")
    WebElement fullNameInput;

    @FindBy(name = "companyName")
    WebElement companyNameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(xpath = "//*[@type='tel']")
    WebElement phoneNumberInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//*[text()='Create account']")
    WebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createUser(String name, String companyName, String email, String phoneNumber, String password) {
        fullNameInput.sendKeys(name);
        companyNameInput.sendKeys(companyName);
        emailInput.sendKeys(email);
        phoneNumberInput.sendKeys(phoneNumber);
        passwordInput.sendKeys(password);
        createAccountButton.click();
    }

    public void waitUntilPageLoads() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(createAccountButton));
    }

}
