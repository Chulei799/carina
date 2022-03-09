package com.qaprosoft.carina.chulei.mobile.android.tests;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidLoginPageTest implements IAbstractTest, IMobileUtils, IConstants {

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void validationUIElementsTest() {
        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");
        softAssert.assertTrue(welcomePage.isNextBtnPresent(), "Next button isn't present!");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");
        softAssert.assertFalse(loginPage.isSignUpBtnActive(), "Sign Up button should not be available!");
        softAssert.assertTrue(loginPage.isBackBtnPresent(), "Back button isn't present!");
        softAssert.assertTrue(loginPage.isCarinaTextViewPresent(), "Carina Text View isn't present!");
        softAssert.assertTrue(loginPage.isNameFieldPresent(), "Name field isn't present!");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field isn't present!");
        softAssert.assertTrue(loginPage.isSexRadioBtnPresent(MALE), "Male RadioButton isn't present!");
        softAssert.assertTrue(loginPage.isSexRadioBtnPresent(FEMALE), "Female RadioButton isn't present!");
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxPresent(), "Privacy Policy Box isn't present!");
        softAssert.assertTrue(loginPage.isSignUpBtnPresent(), "Sign Up button isn't present!");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void validationBackBtnTest() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");
        Assert.assertTrue(loginPage.isBackBtnPresent(), "Back button isn't present!");
        welcomePage = loginPage.clickBackBtn();
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened when you go back!");
    }

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void validationRadioButtonsTest() {
        SoftAssert softAssert = new SoftAssert();

        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");
        softAssert.assertTrue(loginPage.isSexRadioBtnPresent(MALE), "Male RadioBtn isn't present!");
        softAssert.assertFalse(loginPage.isSexSelected(MALE), "Male RadioBtn should not be selected!");
        softAssert.assertTrue(loginPage.isSexRadioBtnPresent(FEMALE), "Female RadioBtn isn't present!");
        softAssert.assertFalse(loginPage.isSexSelected(FEMALE), "Female RadioBtn should not be selected!");

        loginPage.selectSex(MALE);
        softAssert.assertTrue(loginPage.isSexSelected(MALE), "Male RadioBtn isn't selected!");
        softAssert.assertFalse(loginPage.isSexSelected(FEMALE), "Female RadioBtn should not be selected!");
        loginPage.selectSex(FEMALE);
        softAssert.assertTrue(loginPage.isSexSelected(FEMALE), "Female RadioBtn isn't selected!");
        softAssert.assertFalse(loginPage.isSexSelected(MALE), "Male RadioBtn should not be selected!");
        loginPage.selectSex(MALE);
        softAssert.assertTrue(loginPage.isSexSelected(MALE), "Male RadioBtn isn't selected!");
        softAssert.assertFalse(loginPage.isSexSelected(FEMALE), "Female RadioBtn should not be selected!");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "chulei799")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void loginValidationTest() {
        SoftAssert softAssert = new SoftAssert();
        
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened!");
        LoginPageBase loginPage = welcomePage.clickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page isn't opened!");

        softAssert.assertTrue(loginPage.isNameFieldPresent(), "Name field isn't present!");
        softAssert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field isn't present!");
        softAssert.assertTrue(loginPage.isSexRadioBtnPresent(MALE), "Male RadioButton isn't present!");
        softAssert.assertTrue(loginPage.isSexRadioBtnPresent(FEMALE), "Female RadioButton isn't present!");
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxPresent(), "Privacy Policy Box isn't present!");
        softAssert.assertTrue(loginPage.isSignUpBtnPresent(), "Sign Up button isn't present!");

        //Scenario 0: Try to check and uncheck Privacy Policy
        loginPage.checkPrivacyPolicyCheckBox(true);
        softAssert.assertTrue(loginPage.isPrivacyPolicyCheckBoxChecked(), "Privacy Policy box not checked!");
        loginPage.checkPrivacyPolicyCheckBox(false);
        softAssert.assertFalse(loginPage.isPrivacyPolicyCheckBoxChecked(), "Privacy Policy box checked, but should not!");

        //Scenario 1: Try login without enter user name
        loginPage.setPasswordField(USER_PASS);
        loginPage.selectSex(MALE);
        loginPage.checkPrivacyPolicyCheckBox(true);
        softAssert.assertFalse(loginPage.isSignUpBtnActive(), "Sign Up button should not be available," +
                                                                    " if user name not entered!");

        //Scenario 2: Try login without enter password
        welcomePage = loginPage.clickBackBtn();
        loginPage = welcomePage.clickNextBtn();
        loginPage.setNameField(USER_NAME);
        loginPage.selectSex(MALE);
        loginPage.checkPrivacyPolicyCheckBox(true);
        softAssert.assertFalse(loginPage.isSignUpBtnActive(), "Sign Up button should not be available," +
                                                                    " if password not entered!");

        //Scenario 3: Try login without select sex
        welcomePage = loginPage.clickBackBtn();
        loginPage = welcomePage.clickNextBtn();
        loginPage.setNameField(USER_NAME);
        loginPage.setPasswordField(USER_PASS);
        loginPage.checkPrivacyPolicyCheckBox(true);
        softAssert.assertFalse(loginPage.isSignUpBtnActive(), "Sign Up button should not be available," +
                                                                    " if sex not selected!");

        //Scenario 4: Try login without agree with Privacy Policy
        welcomePage = loginPage.clickBackBtn();
        loginPage = welcomePage.clickNextBtn();
        loginPage.setNameField(USER_NAME);
        loginPage.setPasswordField(USER_PASS);
        loginPage.selectSex(MALE);
        softAssert.assertFalse(loginPage.isSignUpBtnActive(), "Sign Up button should not be available," +
                                                                    " if privacy policy not accepted!");

        //Scenario 5: All fields entered and selected
        welcomePage = loginPage.clickBackBtn();
        loginPage = welcomePage.clickNextBtn();
        loginPage.setNameField(USER_NAME);
        loginPage.setPasswordField(USER_PASS);
        loginPage.selectSex(MALE);
        loginPage.checkPrivacyPolicyCheckBox(true);
        softAssert.assertTrue(loginPage.isSignUpBtnActive(), "Sign Up button should be available!");

        softAssert.assertAll();
    }
}
