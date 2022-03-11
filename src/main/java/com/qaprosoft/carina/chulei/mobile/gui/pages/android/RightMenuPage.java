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

    @FindBy(xpath = "//android.view.View[@content-desc='Read on GitHub']/android.widget.TextView")
    private ExtendedWebElement readOnGitHub;

    @FindBy(xpath = "//android.view.View[@content-desc='Installation Guide']/android.widget.TextView")
    private ExtendedWebElement installationGuide;

    @FindBy(xpath = "//android.view.View[@content-desc='Go to Zebrunner']/android.widget.TextView")
    private ExtendedWebElement goToZebrunner;

    @FindBy(xpath = "//android.view.View[@content-desc='Donate']/android.widget.TextView")
    private ExtendedWebElement donate;

    @FindBy(xpath = "//android.view.View[@content-desc='Contact Us']/android.widget.TextView")
    private ExtendedWebElement contactUs;

    public RightMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isMenuElementPresent(RMComponent component) {
        switch (component) {
            case LOGO:
                return logo.isElementPresent(THREE_SECONDS);
            case GO_TO_ZEBRUNNER:
                return goToZebrunner.isElementPresent(THREE_SECONDS);
            case INSTALLATION_GUIDE:
                return installationGuide.isElementPresent(THREE_SECONDS);
            case READ_ON_GITHUB:
                return readOnGitHub.isElementPresent(THREE_SECONDS);
            case DONATE:
                return donate.isElementPresent(THREE_SECONDS);
            case CONTACT_US:
                return contactUs.isElementPresent(THREE_SECONDS);
        }
        Assert.fail("Right menu | No such component!");
        return false;
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
