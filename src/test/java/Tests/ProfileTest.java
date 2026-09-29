package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;

public class ProfileTest extends Base.BaseTest {

    @Test
    public void clickMenuButtonTest()
    {
        profilePage.clickMenuButton();
    }
    @Test(dependsOnMethods = "clickMenuButtonTest")
    public void clickMyProfileButtonTest()
    {
        profilePage.clickMyProfileButton();
    }
    @Test(dependsOnMethods = "clickMyProfileButtonTest")
    public void clickEditProfileButtonTest()
    {
        profilePage.clickEditProfileButton();
    }
    @Test(dependsOnMethods = "clickEditProfileButtonTest")
    public void clickProfilePictureTest()
    {
        profilePage.clickProfilePictureButton();
    }
    @Test(dependsOnMethods = "clickProfilePictureTest")
    public void clickSelectProfilePictureTest() throws InterruptedException {
        profilePage.uploadProfilePicture();
        takeScreenshotAfterTests();

    }


}
