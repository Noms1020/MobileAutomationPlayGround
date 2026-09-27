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
}
