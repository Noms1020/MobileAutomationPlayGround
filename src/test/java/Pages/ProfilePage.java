package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static java.lang.Thread.sleep;

public class ProfilePage {

    AppiumDriver driver;

    Properties config;

    WebDriverWait wait;


    public ProfilePage(AppiumDriver driver, Properties config)
    {
        this.driver = driver;
        this.config = config;

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    private By MenuButtonNativeLocator = By.xpath("//android.widget.Button");
    private By MenuButtonWebLocator = By.xpath("//button[@class='nav-mobile-account']");
    private  By MyProfileNativeLocator = By.xpath("//android.widget.Button[@content-desc=\"My Profile\"]");
    private  By MyProfileWebLocator = By.xpath("//span[text()='My Profile']");
    private By EditProfileNativeLocator = By.xpath("//android.widget.Button[@content-desc=\"Edit Profile\"]");
    private By EditProfileWebLocator = By.xpath("//button[normalize-space()='✏\uFE0F Edit Profile']");
    private By ProfilePictureNativeLocator = By.xpath("//android.view.View[@content-desc=\"NM\"]");
    private By ProfilePictureWebLocator = By.xpath("//input[@id='profilePicture']");
    private By SelectProfilePictureNativeLocator = By.xpath("(//android.widget.ImageView[@resource-id=\"com.google.android.providers.media.module:id/icon_thumbnail\"])[1]");
    //private  By  SelectProfilePictureNativeLocator = By.xpath("//android.widget.ImageView[contains(@content-desc,'IMG_20260927_164704')]");



    private WebElement GetLocators(By nativeLocator, By webLocator)
    {
        String execType = config.getProperty("executionType");

        if (execType.equalsIgnoreCase("nativeApp")) {
            return wait.until(ExpectedConditions.elementToBeClickable(nativeLocator));
        } else if (execType.equalsIgnoreCase("mobileWeb")) {
            return wait.until(ExpectedConditions.elementToBeClickable(webLocator));
        } else {
            throw new RuntimeException("Unsupported executionType: " + execType);
        }
    }

    public void clickMenuButton()
    {
        GetLocators(MenuButtonNativeLocator,MenuButtonWebLocator).click();

    }
    public void clickMyProfileButton()
    {
        GetLocators(MyProfileNativeLocator,MyProfileWebLocator).click();
    }
    public void clickEditProfileButton()
    {
        GetLocators(EditProfileNativeLocator,EditProfileWebLocator).click();
    }

    public void clickProfilePictureButton()
    {
        GetLocators(ProfilePictureNativeLocator,ProfilePictureWebLocator).click();
    }

    public void uploadProfilePicture() throws InterruptedException {
        GetLocators(SelectProfilePictureNativeLocator,ProfilePictureWebLocator).click();

        sleep(5000); // Wait for 2 seconds to ensure the upload is complete
    }
}
