package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.*;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ImageView;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase{

    @FindBy(xpath = "//*[@resource-id = 'com.solvd.carinademoapplication:id/toolbar']//android.widget.TextView")
    private ExtendedWebElement pageName;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement leftMenuBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement pageContent;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ImageView imageView;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='%s']")
    private ExtendedWebElement zoom;

    @FindBy(xpath = "//android.widget.RelativeLayout[2]/android.widget.ImageView")
    private ExtendedWebElement googleImage;

    @FindBy(xpath = "//*[@content-desc = 'Google Map']")
    private ExtendedWebElement map;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return pageContent.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isViewPagerPresent() && imageView.isAllPagerDotsPresent();
    }

    @Override
    public boolean isMapPresent() {
        return map.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isGoogleImagePresent() {
        return googleImage.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isZoomPresent(String option) {
        return zoom.format(option).isElementPresent(FIVE_SECONDS);
    }

    @Override
    public void clickZoom(String option) {
        zoom.format(option).click();
    }

    @Override
    public LeftMenuPageBase openLeftMenu() {
        leftMenuBtn.click(ONE_SECOND);
        return initPage(getDriver(), LeftMenuPageBase.class);
    }
}
