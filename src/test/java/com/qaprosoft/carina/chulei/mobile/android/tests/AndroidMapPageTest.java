package com.qaprosoft.carina.chulei.mobile.android.tests;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.MapPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidMapPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void allElementsPresentAndClickZoomTest() {
        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");

        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");

        loginPage.setNameField(USER_NAME);
        loginPage.setPasswordField(USER_PASS);
        loginPage.selectSex(MALE);
        loginPage.checkPrivacyPolicyCheckBox(true);

        WebViewPageBase webViewPage = loginPage.signUp();
        Assert.assertTrue(webViewPage.isPageOpened(), "Web View page isn't opened!");
        webViewPage.openLeftMenu();
        softAssert.assertTrue(webViewPage.isLeftMenuOpened(), "Left menu isn't opened(Web View)!");

        MapPageBase mapPage = webViewPage.openMapPage();
        Assert.assertTrue(mapPage.isPageOpened(), "Map page isn't opened!");
        softAssert.assertTrue(mapPage.isImageViewPresent(), "Image view isn't present!");
        softAssert.assertTrue(mapPage.isMapPresent(), "Map isn't present!");
        softAssert.assertTrue(mapPage.isGoogleImagePresent(), "Google image isn't present!");
        softAssert.assertTrue(mapPage.isZoomPresent(ZOOM_IN), "Zoom in isn't present!");
        softAssert.assertTrue(mapPage.isZoomPresent(ZOOM_OUT), "Zoom out isn't present!");
        mapPage.clickZoom(ZOOM_IN);
        mapPage.clickZoom(ZOOM_OUT);

        softAssert.assertAll();
    }
}
