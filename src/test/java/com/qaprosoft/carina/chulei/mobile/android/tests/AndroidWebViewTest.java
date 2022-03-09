package com.qaprosoft.carina.chulei.mobile.android.tests;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.*;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.FMComponent;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.RMComponent;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidWebViewTest implements IAbstractTest, IMobileUtils, IConstants {

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void openAllPagesTest() {
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

        ChartsPageBase chartsPage = webViewPage.openChartsPage();
        Assert.assertTrue(chartsPage.isPageOpened(), "Charts page isn't opened!");
        chartsPage.openLeftMenu();
        softAssert.assertTrue(chartsPage.isLeftMenuOpened(), "Left menu isn't opened(Charts)!");

        MapPageBase mapPage = chartsPage.openMapPage();
        softAssert.assertTrue(mapPage.isPageOpened(), "Map page isn't opened!");
        mapPage.openLeftMenu();
        softAssert.assertTrue(mapPage.isLeftMenuOpened(), "Left menu isn't opened(Map)!");

        UIElementsPageBase uiElementsPage = mapPage.openUIElementsPage();
        softAssert.assertTrue(uiElementsPage.isPageOpened(), "UIElements page isn't opened!");
        uiElementsPage.openLeftMenu();
        softAssert.assertTrue(uiElementsPage.isLeftMenuOpened(), "Left menu isn't opened(UIElements)");

        webViewPage = uiElementsPage.openWebViewPage();
        softAssert.assertTrue(webViewPage.isPageOpened(), "Web View page isn't opened!");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void rightMenuElementsTest() {
        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");

        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");

        loginPage.setNameField(USER_NAME);
        loginPage.setPasswordField(USER_PASS);
        loginPage.selectSex(MALE);
        loginPage.checkPrivacyPolicyCheckBox(true);

        //RM is a Right Menu
        WebViewPageBase webViewPage = loginPage.signUp();
        Assert.assertTrue(webViewPage.isPageOpened(), "Web View page isn't opened!");
        webViewPage.rightMenu(OPEN);
        softAssert.assertTrue(webViewPage.isRightMenuOpened(), "Right menu isn't opened!");
        softAssert.assertTrue(webViewPage.isRMElemPresent(RMComponent.LOGO), "Logo isn't present!");
        softAssert.assertTrue(webViewPage.isRMElemPresent(RMComponent.READ_ON_GITHUB), "Read on github isn't present!");
        softAssert.assertTrue(webViewPage.isRMElemPresent(RMComponent.INSTALLATION_GUIDE), "Installation guide isn't present!");
        softAssert.assertTrue(webViewPage.isRMElemPresent(RMComponent.GO_TO_ZEBRUNNER), "Go to zebrunner isn't present!");
        softAssert.assertTrue(webViewPage.isRMElemPresent(RMComponent.DONATE), "Donate isn't present!");
        softAssert.assertTrue(webViewPage.isRMElemPresent(RMComponent.CONTACT_US), "Contact us isn't present!");
        webViewPage.rightMenu(CLOSE);

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void footerMenuElementsTest() {
        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");

        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");

        loginPage.setNameField(USER_NAME);
        loginPage.setPasswordField(USER_PASS);
        loginPage.selectSex(MALE);
        loginPage.checkPrivacyPolicyCheckBox(true);

        //FM is a Footer Menu
        WebViewPageBase webViewPage = loginPage.signUp();
        Assert.assertTrue(webViewPage.isPageOpened(), "Web View page isn't opened!");
        webViewPage.swipeToPrivacyPolicy();
        softAssert.assertTrue(webViewPage.isFooterMenuPresent(), "Footer menu isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.LOGO), "Zebrunner logo isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.FACEBOOK), "Facebook isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.TWITTER), "Twitter isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.LINKEDIN), "LinkedIn isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.TELEGRAM), "Telegram isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.LOCATION), "Location isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.SUPPORT), "Support isn't present!");
        softAssert.assertTrue(webViewPage.isFMElemPresent(FMComponent.PRIVACY_POLICY), "Privacy policy isn't present!");

        softAssert.assertAll();
    }
}
