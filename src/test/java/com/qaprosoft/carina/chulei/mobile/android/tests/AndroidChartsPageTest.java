package com.qaprosoft.carina.chulei.mobile.android.tests;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.ChartsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidChartsPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void allChartsPresentTest() {
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
        softAssert.assertTrue(chartsPage.isFruitChartPresent(), "Fruit chart isn't present!");
        chartsPage.swipeToVennDiagram();
        softAssert.assertTrue(chartsPage.isVennDiagramPresent(), "Venn diagram isn't present!");
        chartsPage.swipeToHiloDiagram();
        softAssert.assertTrue(chartsPage.isHiloChartPresent(), "Hilo chart isn't present!");

        softAssert.assertAll();
    }
}
