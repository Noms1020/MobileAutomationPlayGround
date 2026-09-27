package Tests;

import org.testng.annotations.Test;

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
    public void clickSelectProfilePictureTest()
    {
        profilePage.uploadProfilePicture();
    }
}
