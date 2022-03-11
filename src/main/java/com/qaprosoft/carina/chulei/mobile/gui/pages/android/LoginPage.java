package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.solvd.carinademoapplication:id/backButton")
    private ExtendedWebElement backBtn;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and @text = 'CARINA']")
    private ExtendedWebElement carinaTextView;

    @FindBy(id = "com.solvd.carinademoapplication:id/name")
    private ExtendedWebElement nameField;

    @FindBy(id = "com.solvd.carinademoapplication:id/password")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@class = 'android.widget.RadioButton' and @text = '%s']")
    private ExtendedWebElement sexRadioBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/checkbox")
    private ExtendedWebElement checkBox;

    @FindBy(id = "com.solvd.carinademoapplication:id/login_button")
    private ExtendedWebElement signUpBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isBackBtnPresent() {
        return backBtn.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isCarinaTextViewPresent() {
        return carinaTextView.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isNameFieldPresent() {
        return nameField.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isSexRadioBtnPresent(String sex) {
        return sexRadioBtn.format(sex).isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isPrivacyPolicyCheckBoxPresent() {
        return checkBox.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isSignUpBtnPresent() {
        return signUpBtn.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public WelcomePageBase clickBackBtn() {
        backBtn.click(FIVE_SECONDS);
        return initPage(driver, WelcomePageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return isNameFieldPresent();
    }

    @Override
    public String getCarinaViewText() {
        return carinaTextView.getText();
    }

    @Override
    public String getNameText() {
        return nameField.getText();
    }

    @Override
    public void setNameField(String name) {
        nameField.type(name);
    }

    @Override
    public String getPasswordText() {
        return passwordField.getText();
    }

    @Override
    public void setPasswordField(String password) {
        passwordField.type(password);
    }

    @Override
    public boolean isSexSelected(String sex) {
        return sexRadioBtn.format(sex).isChecked();
    }

    @Override
    public void selectSex(String sex) {
        sexRadioBtn.format(sex).click(FIVE_SECONDS);
    }

    @Override
    public boolean isPrivacyPolicyCheckBoxChecked() {
        return checkBox.isChecked();
    }

    @Override
    public boolean checkPrivacyPolicyCheckBox(boolean checked) {
        if(checked) {
            checkBox.check();
        } else {
            checkBox.uncheck();
        }
        return checkBox.isChecked();
    }

    @Override
    public boolean isSignUpBtnActive() {
        return Boolean.parseBoolean(signUpBtn.getAttribute("enabled"));
    }

    @Override
    public WebViewPageBase signUp() {
        signUpBtn.click(FIVE_SECONDS);
        return initPage(driver, WebViewPageBase.class);
    }
}
