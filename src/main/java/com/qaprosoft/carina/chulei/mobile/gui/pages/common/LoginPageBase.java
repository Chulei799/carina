package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage implements IConstants {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isBackBtnPresent();

    public abstract boolean isCarinaTextViewPresent();

    public abstract boolean isNameFieldPresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract boolean isSexRadioBtnPresent(String sex);

    public abstract boolean isPrivacyPolicyCheckBoxPresent();

    public abstract boolean isSignUpBtnPresent();

    public abstract WelcomePageBase clickBackBtn();

    public abstract String getCarinaViewText();

    public abstract String getNameText();

    public abstract void setNameField(String name);

    public abstract String getPasswordText();

    public abstract void setPasswordField(String password);

    public abstract boolean isSexSelected(String sex);

    public abstract void selectSex(String sex);

    public abstract boolean isPrivacyPolicyCheckBoxChecked();

    public abstract boolean checkPrivacyPolicyCheckBox(boolean checked);

    public abstract boolean isSignUpBtnActive();

    public abstract WebViewPageBase signUp();
}
