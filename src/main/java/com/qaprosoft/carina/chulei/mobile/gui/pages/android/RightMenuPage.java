package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.RightMenuPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.RMComponent;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RightMenuPageBase.class)
public class RightMenuPage extends RightMenuPageBase {

    @FindBy(xpath = "//*[@resource-id = 'rec42972268']/android.view.View/android.view.View/android.view.View[2]")
    private ExtendedWebElement openBtn;

    @FindBy(xpath = "//*[@resource-id = 'nav42972268']")
    private ExtendedWebElement pageView;

    @FindBy(xpath = "//android.view.View[@content-desc='www.carina-core']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//android.view.View[@content-desc='%s']/android.widget.TextView")
    private ExtendedWebElement menuElement;

    public RightMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {
        return logo.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isMenuElementPresent(RMComponent component) {
        return menuElement.format(component.getName()).isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isOpenBtnPresent() {
        return openBtn.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isPageOpened() {
        return pageView.isElementPresent(THREE_SECONDS);
    }

    @Override
    public void clickRightMenu() {
        openBtn.click(ONE_SECOND);
    }
}
