package com.qaprosoft.carina.chulei.mobile.gui.pages.android;


import com.qaprosoft.carina.chulei.mobile.gui.pages.common.*;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(xpath = "//*[@resource-id = 'com.solvd.carinademoapplication:id/toolbar']//android.widget.TextView")
    private ExtendedWebElement pageName;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement leftMenuBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement pageContent;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ExtendedWebElement imageView;

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
    private ExtendedWebElement cycleProgressBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/progressBar2")
    private ExtendedWebElement lineProgressBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/seekBar")
    private ExtendedWebElement seekBar;

    @FindBy(xpath = "//*[@class = 'android.widget.Switch' and @text = 'Enable']")
    private ExtendedWebElement switchBtn;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return pageContent.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isImagePresent() {
        return swipe(image, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isViewFieldPresent(String fieldName) {
        return viewField.format(fieldName).isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isTextFieldPresent() {
        return swipe(textField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isEmailFieldPresent() {
        return swipe(emailField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isDateFieldPresent() {
        return swipe(dateField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isCheckBoxPresent() {
        return swipe(checkBox, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isSexRadioBtnPresent(String sex) {
        ExtendedWebElement element = sexRadioBtn.format(sex);
        return swipe(element, Direction.VERTICAL, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isCycleProgressBarPresent() {
        return swipe(cycleProgressBar, Direction.UP, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isLineProgressBarPresent() {
        return swipe(lineProgressBar, Direction.UP, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isSeekBarPresent() {
        return swipe(seekBar, Direction.UP, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public boolean isSwitchBtnPresent() {
        return swipe(switchBtn, Direction.UP, FIVE_SWIPES, SLOW_SWIPES);
    }

    @Override
    public void setTextField(String text) {
        swipe(textField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        textField.type(text);
    }

    @Override
    public void setEmailField(String email) {
        swipe(emailField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        emailField.type(email);
    }

    @Override
    public void setDateField(String date) {
        swipe(dateField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        dateField.type(date);
    }

    @Override
    public String getTextField() {
        swipe(textField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        return textField.getText();
    }

    @Override
    public String getEmailField() {
        swipe(emailField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        return emailField.getText();
    }

    @Override
    public String getDateField() {
        swipe(dateField, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        return dateField.getText();
    }

    @Override
    public void clickSexRadioBtn(String sex) {
        ExtendedWebElement element = sexRadioBtn.format(sex);
        swipe(element, Direction.VERTICAL, FIVE_SWIPES, SLOW_SWIPES);
        sexRadioBtn.format(sex).click(THREE_SECONDS);
    }

    @Override
    public boolean isSexRadioBtnChecked(String sex) {
        ExtendedWebElement element = sexRadioBtn.format(sex);
        swipe(element, Direction.VERTICAL, FIVE_SWIPES, SLOW_SWIPES);
        return sexRadioBtn.format(sex).isChecked();
    }

    @Override
    public void swipeSeekBar(String percent) {
        swipe(seekBar, Direction.UP, FIVE_SWIPES, SLOW_SWIPES);
        seekBar.type(percent);
    }

    @Override
    public boolean checkSwitchBtn(boolean checked) {
        swipe(switchBtn, Direction.UP, FIVE_SWIPES, SLOW_SWIPES);
        if(checked) {

            switchBtn.check();
        } else {
            switchBtn.uncheck();
        }
        return switchBtn.isChecked();
    }

    @Override
    public boolean checkCheckBox(boolean checked) {
        swipe(checkBox, Direction.DOWN, FIVE_SWIPES, SLOW_SWIPES);
        if(checked) {
            checkBox.check();
        } else {
            checkBox.uncheck();
        }
        return checkBox.isChecked();
    }
    
    @Override
    public LeftMenuPageBase openLeftMenu() {
        leftMenuBtn.click(ONE_SECOND);
        return initPage(getDriver(), LeftMenuPageBase.class);
    }
}
