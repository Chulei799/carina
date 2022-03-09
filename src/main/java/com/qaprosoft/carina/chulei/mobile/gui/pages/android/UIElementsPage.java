package com.qaprosoft.carina.chulei.mobile.gui.pages.android;


import com.qaprosoft.carina.chulei.mobile.gui.pages.common.ChartsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.MapPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ImageView;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.LeftMenu;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ToolBar;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ToolBar toolBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_navigation_view")
    private LeftMenu leftMenu;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ImageView imageView;

    @FindBy(id = "com.solvd.carinademoapplication:id/imageView")
    private ExtendedWebElement image;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and @text = '%s']")
    private ExtendedWebElement viewField;

    @FindBy(id = "com.solvd.carinademoapplication:id/editText")
    private ExtendedWebElement textField;

    @FindBy(id = "com.solvd.carinademoapplication:id/editText2")
    private ExtendedWebElement emailField;

    @FindBy(id = "com.solvd.carinademoapplication:id/editText3")
    private ExtendedWebElement dateField;

    @FindBy(id = "com.solvd.carinademoapplication:id/checkBox2")
    private ExtendedWebElement checkBox;

    @FindBy(xpath = "//*[@class = 'android.widget.RadioButton' and @text = '%s']")
    private ExtendedWebElement sexRadioBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/progressBar")
    private ExtendedWebElement firstProgressBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/progressBar2")
    private ExtendedWebElement secondProgressBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/seekBar")
    private ExtendedWebElement seekBar;

    @FindBy(xpath = "//*[@class = 'android.widget.Switch' and @text = 'Enable']")
    private ExtendedWebElement switchBtn;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolBar.getPageName().equals("UI elements");
    }

    @Override
    public boolean isLeftMenuOpened() {
        return leftMenu.isOpened();
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isViewPagerPresent() && imageView.isAllPagerDotsPresent();
    }

    @Override
    public boolean isImagePresent() {
        return image.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isViewFieldPresent(String fieldName) {
        return viewField.format(fieldName).isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isTextFieldPresent() {
        return textField.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isEmailFieldPresent() {
        return emailField.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isDateFieldPresent() {
        return dateField.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isCheckBoxPresent() {
        return checkBox.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isSexRadioBtnPresent(String sex) {
        return sexRadioBtn.format(sex).isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isProgressBarPresent(int n) {
        switch (n) {
            case 1:
                return firstProgressBar.isElementPresent(FIVE_SECONDS);
            case 2:
                return secondProgressBar.isElementPresent(FIVE_SECONDS);
            default:
                return false;
        }
    }

    @Override
    public boolean isSeekBtnPresent() {
        return seekBar.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isSwitchBtnPresent() {
        return switchBtn.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public void setTextField(String text) {
        textField.type(text);
    }

    @Override
    public void setEmailField(String email) {
        emailField.type(email);
    }

    @Override
    public void setDateField(String date) {
        dateField.type(date);
    }

    @Override
    public String getTextField() {
        return textField.getText();
    }

    @Override
    public String getEmailField() {
        return emailField.getText();
    }

    @Override
    public String getDateField() {
        return dateField.getText();
    }

    @Override
    public void clickSexRadioBtn(String sex) {
        sexRadioBtn.format(sex).click(FIVE_SECONDS);
    }

    @Override
    public boolean isSexRadioBtnChecked(String sex) {
        return sexRadioBtn.format(sex).isChecked();
    }

    @Override
    public void swipeSeekBtn(String percent) {
        seekBar.type(percent);
    }

    @Override
    public boolean checkSwitchBtn(boolean checked) {
        if(checked) {
            switchBtn.check();
        } else {
            switchBtn.uncheck();
        }
        return switchBtn.isChecked();
    }

    @Override
    public boolean checkCheckBox(boolean checked) {
        if(checked) {
            checkBox.check();
        } else {
            checkBox.uncheck();
        }
        return checkBox.isChecked();
    }

    @Override
    public void scrollToSwitchBtn() {
        swipe(switchBtn);
    }

    @Override
    public void scrollToUserImage() {
        swipe(image);
    }

    @Override
    public void openLeftMenu() {
        toolBar.openLeftMenu();
    }

    @Override
    public WebViewPageBase openWebViewPage() {
        leftMenu.clickWebView();
        return new WebViewPage(driver);
    }

    @Override
    public ChartsPageBase openChartsPage() {
        leftMenu.clickCharts();
        return new ChartsPage(driver);
    }

    @Override
    public MapPageBase openMapPage() {
        leftMenu.clickMap();
        return new MapPage(driver);
    }

    @Override
    public UIElementsPageBase openUIElementsPage() {
        leftMenu.clickUIElements();
        return new UIElementsPage(driver);
    }
}
