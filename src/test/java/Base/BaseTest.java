package Base;

import Utilities.DriverFactory;
import io.appium.java_client.AppiumDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
//    @AfterClass
//    public void tearDown(){
//        DriverFactory.quitDriver();
//    }


}
