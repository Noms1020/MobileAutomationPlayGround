package Base;

import Utilities.DriverFactory;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected AppiumDriver driver;
    protected Properties config;
    protected LoginPage loginPage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void setUpAndLogin() throws IOException {
        config = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/configs/configs.properties");

        config.load(fis);

        DriverFactory.initDriver(config);
        driver = DriverFactory.getDriver();

        loginPage = new LoginPage(driver, config);
        LoginToNdosiAutomation();
        profilePage  = new ProfilePage(driver,config);
    }

    public void LoginToNdosiAutomation() {

        loginPage.clickBurgerMenuButton();
        loginPage.clickSignInButton();
        loginPage.enterEmail(config.getProperty("email"));
        loginPage.enterPassword(config.getProperty("password"));
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isLoginSuccess(),"Login was unsuccessfully"
        );
    }



    public void takeScreenshotAfterTests() {
        try {
            if (driver != null) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = System.getProperty("user.dir") + "/screenshots/test_passed3.png";
                File screenshotDir = new File(System.getProperty("user.dir") + "/screenshots");
                if (!screenshotDir.exists()) {
                    screenshotDir.mkdirs();
                }
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot saved at: " + screenshotPath);
            } else {
                System.out.println("Driver is null. Cannot capture screenshot.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to take screenshot after tests.", e);
        }

    }

    @AfterClass
    public void tearDown(){
        DriverFactory.quitDriver();
    }


}
