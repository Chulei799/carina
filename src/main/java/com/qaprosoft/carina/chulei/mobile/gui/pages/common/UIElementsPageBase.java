package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class UIElementsPageBase extends AbstractPage implements IConstants, IMobileUtils {

    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLeftMenuOpened();

    public abstract boolean isImageViewPresent();

    public abstract boolean isImagePresent();

    public abstract boolean isViewFieldPresent(String fieldName);

    public abstract boolean isTextFieldPresent();

    public abstract boolean isEmailFieldPresent();

    public abstract boolean isDateFieldPresent();

    public abstract boolean isCheckBoxPresent();

    public abstract boolean isSexRadioBtnPresent(String sex);

    public abstract boolean isProgressBarPresent(int n);

    public abstract boolean isSeekBtnPresent();

    public abstract boolean isSwitchBtnPresent();

    public abstract void setTextField(String text);

    public abstract void setEmailField(String email);

    public abstract void setDateField(String date);

    public abstract String getTextField();

    public abstract String getEmailField();

    public abstract String getDateField();

    public abstract void clickSexRadioBtn(String sex);

    public abstract boolean isSexRadioBtnChecked(String sex);

    public abstract void swipeSeekBtn(String percent);

    public abstract boolean checkSwitchBtn(boolean checked);

    public abstract boolean checkCheckBox(boolean checked);

    public abstract void scrollToSwitchBtn();

    public abstract void scrollToUserImage();

    public abstract void openLeftMenu();

    public abstract WebViewPageBase openWebViewPage();

    public abstract ChartsPageBase openChartsPage();

    public abstract MapPageBase openMapPage();

    public abstract UIElementsPageBase openUIElementsPage();
}
