import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import routetitan.BasePage;
import routetitan.LoginPage;
import routetitan.ProfilePage;
import routetitan.RegistrationPage;

public class RoutetitanTest {
    private WebDriver driver = null;

    private String name = "test_shake";
    private String companyName = "test_routetitan";
    private String email = "test_shake" + System.currentTimeMillis() + "@test.com";
    private String phoneNumber = "99999999";
    private String password = "test_shake12";

    private String emailStable = "test_shake@test.com";
    private String passwordStable = "test_shake43";

    @BeforeSuite
    private void setSystemProperties() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
    }

    @BeforeMethod
    private void createDriverInstance() {
        driver = new ChromeDriver();
        driver.get("https://dev.routetitan.com");
    }


    //to test multiple scenarios DataProvider could be used here
    @Test
    private void testUserCreation() {
        BasePage basePage = new BasePage(driver);
        basePage.waitUntilPageLoads();

        basePage.clickGetStartedButton();

        RegistrationPage reg = new RegistrationPage(driver);
        reg.waitUntilPageLoads();

        reg.createUser(name, companyName, email, phoneNumber, password);

        ProfilePage profile = new ProfilePage(driver);
        profile.waitUntilPageLoads();

        Assert.assertEquals(profile.getLoggedUserName(), name, "User name differs from expected one.");

    }

    @Test
    private void testLoginFunctionality() {
        BasePage basePage = new BasePage(driver);
        basePage.waitUntilPageLoads();

        basePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitUntilPageLoads();

        loginPage.login(emailStable, passwordStable);

        ProfilePage profile = new ProfilePage(driver);
        profile.waitUntilPageLoads();

        Assert.assertEquals(profile.getLoggedUserName(), name, "User name differs from expected one.");
    }

    @AfterMethod
    private void tearDownDriverInstance() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
