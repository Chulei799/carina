package com.qaprosoft.carina.chulei.mobile.android.tests;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.*;
import com.qaprosoft.carina.chulei.mobile.gui.pages.android.LeftMenuPage;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.FooterMenu;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.FMComponent;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.LMComponent;
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
        LeftMenuPageBase leftMenuPage = webViewPage.openLeftMenu();
        softAssert.assertTrue(leftMenuPage.isPageOpened(), "Left menu isn't opened(Web View)!");

        for(LMComponent lmComponent : LMComponent.values()) {
            softAssert.assertTrue(leftMenuPage.isMenuElementPresent(lmComponent), lmComponent.getName() + " page isn't present!");
        }

        ChartsPageBase chartsPage = (ChartsPageBase) leftMenuPage.openPageFromLeftMenu(LMComponent.CHARTS);
        Assert.assertTrue(chartsPage.isPageOpened(), "Charts page isn't opened!");
        leftMenuPage = chartsPage.openLeftMenu();
        softAssert.assertTrue(leftMenuPage.isPageOpened(), "Left menu isn't opened(Charts)!");

        MapPageBase mapPage = (MapPageBase) leftMenuPage.openPageFromLeftMenu(LMComponent.MAP);
        softAssert.assertTrue(mapPage.isPageOpened(), "Map page isn't opened!");
        leftMenuPage = mapPage.openLeftMenu();
        softAssert.assertTrue(leftMenuPage.isPageOpened(), "Left menu isn't opened(Map)!");

        UIElementsPageBase uiElementsPage = (UIElementsPageBase) leftMenuPage.openPageFromLeftMenu(LMComponent.UI_ELEMENTS);
        softAssert.assertTrue(uiElementsPage.isPageOpened(), "UIElements page isn't opened!");
        leftMenuPage = uiElementsPage.openLeftMenu();
        softAssert.assertTrue(leftMenuPage.isPageOpened(), "Left menu isn't opened(UIElements)");

        webViewPage = (WebViewPageBase) leftMenuPage.openPageFromLeftMenu(LMComponent.WEB_VIEW);
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
        RightMenuPageBase rightMenu = webViewPage.openRightMenu();
        softAssert.assertTrue(rightMenu.isPageOpened(), "Right menu isn't opened!");
        for(RMComponent component : RMComponent.values()) {
            softAssert.assertTrue(rightMenu.isMenuElementPresent(component), component.getName() + " isn't present!");
        }
        webViewPage.openRightMenu();

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
        FooterMenu footerMenu = webViewPage.getFooterMenu();
        softAssert.assertTrue(footerMenu.isFooterMenuPresent(), "Footer menu isn't present!");
        softAssert.assertTrue(footerMenu.isZebrunnerLogoPresent(), "Zebrunner logo isn't present!");
        softAssert.assertTrue(footerMenu.isMessengerPresent(FACEBOOK), "Facebook isn't present!");
        softAssert.assertTrue(footerMenu.isMessengerPresent(TWITTER), "Twitter isn't present!");
        softAssert.assertTrue(footerMenu.isMessengerPresent(LINKEDIN), "LinkedIn isn't present!");
        softAssert.assertTrue(footerMenu.isMessengerPresent(TELEGRAM), "Telegram isn't present!");
        softAssert.assertTrue(footerMenu.isLocationPresent(), "Location isn't present!");
        softAssert.assertTrue(footerMenu.isSupportPresent(), "Support isn't present!");
        softAssert.assertTrue(footerMenu.isPrivacyPolicyPresent(), "Privacy policy isn't present!");

        softAssert.assertAll();
    }
}
