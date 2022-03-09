package com.qaprosoft.carina.chulei.mobile.android.tests;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidUIElementsPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    void validateAllUIElementsTest() {
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

        UIElementsPageBase uiElementsPage = webViewPage.openUIElementsPage();
        Assert.assertTrue(uiElementsPage.isPageOpened(), "UIElements page isn't opened!");
        softAssert.assertTrue(uiElementsPage.isImageViewPresent(), "Image view isn't opened!");
        softAssert.assertTrue(uiElementsPage.isImagePresent(), "Image isn't opened!");
        softAssert.assertTrue(uiElementsPage.isViewFieldPresent(FIRST_FIELD), "Lorem ipsum text isn't present!");
        softAssert.assertTrue(uiElementsPage.isViewFieldPresent(SECOND_FIELD), "Dolor sit amet text isn't present!");
        softAssert.assertTrue(uiElementsPage.isTextFieldPresent(), "Text field isn't present!");
        softAssert.assertTrue(uiElementsPage.isEmailFieldPresent(), "Email field isn't present!");
        softAssert.assertTrue(uiElementsPage.isDateFieldPresent(), "Date field isn't present!");
        softAssert.assertTrue(uiElementsPage.isCheckBoxPresent(), "Check box isn't present!");
        uiElementsPage.scrollToSwitchBtn();
        softAssert.assertTrue(uiElementsPage.isSexRadioBtnPresent(MALE), "Male sex isn't present!");
        softAssert.assertTrue(uiElementsPage.isSexRadioBtnPresent(FEMALE), "Female sex isn't present!");
        softAssert.assertTrue(uiElementsPage.isSexRadioBtnPresent(OTHER), "Other sex isn't present!");
        softAssert.assertTrue(uiElementsPage.isProgressBarPresent(FIRST), "First progress bar isn't present!");
        softAssert.assertTrue(uiElementsPage.isProgressBarPresent(SECOND), "Second progress bar isn't present!");
        softAssert.assertTrue(uiElementsPage.isSeekBtnPresent(), "Seek btn isn't present!");
        softAssert.assertTrue(uiElementsPage.isSwitchBtnPresent(), "Switch btn isn't present!");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void setAllUIElementsTest() {
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

        UIElementsPageBase uiElementsPage = webViewPage.openUIElementsPage();
        Assert.assertTrue(uiElementsPage.isPageOpened(), "UIElements page isn't opened!");
        uiElementsPage.setTextField(SOME_TEXT);
        softAssert.assertEquals(uiElementsPage.getTextField(), SOME_TEXT, "Text field not equals!");
        uiElementsPage.setEmailField(SOME_EMAIL);
        softAssert.assertEquals(uiElementsPage.getEmailField(), SOME_EMAIL, "Email field not equals!");
        uiElementsPage.setDateField(SOME_DATE);
        softAssert.assertEquals(uiElementsPage.getDateField(), SOME_DATE, "Date field not equals!");
        softAssert.assertTrue(uiElementsPage.checkCheckBox(true), "Check box isn't checked!");
        uiElementsPage.clickSexRadioBtn(FEMALE);
        softAssert.assertTrue(uiElementsPage.isSexRadioBtnChecked(FEMALE), "Female radio btn isn't checked!");
        uiElementsPage.scrollToSwitchBtn();
        uiElementsPage.clickSexRadioBtn(OTHER);
        softAssert.assertTrue(uiElementsPage.isSexRadioBtnChecked(OTHER), "Other radio btn isn't present!");
        uiElementsPage.swipeSeekBtn(SEVENTY_PERCENTS);
        softAssert.assertTrue(uiElementsPage.checkSwitchBtn(true), "Switch btn isn't checked!");

        softAssert.assertAll();
    }

}
