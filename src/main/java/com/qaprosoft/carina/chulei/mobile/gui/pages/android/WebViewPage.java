package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.ChartsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.MapPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.*;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.FMComponent;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.RMComponent;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ToolBar toolBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_navigation_view")
    private LeftMenu leftMenu;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ImageView imageView;

    @FindBy(xpath = "//*[@resource-id = 'rec42972268']//android.view.View[2]")
    private RightMenu rightMenu;

    @FindBy(xpath = "//*[@resource-id = 'rec407789353']")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//android.widget.Image")
    private ExtendedWebElement carinaLogo;

    @FindBy(xpath = "//*[@class = 'android.view.View' and @text = 'CARINA']")
    private ExtendedWebElement carinaText;

    @FindBy(xpath = "//*[contains(@text, 'Java Framework ')]")
    private ExtendedWebElement carinaDescription;

    @FindBy(xpath = "//android.view.View[@content-desc='Read on GitHub']")
    private ExtendedWebElement readOnGitHubBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Installation Guide']")
    private ExtendedWebElement installationGuideBtn;

    @FindBy(xpath = "//*[@text = 'Welcome to CARINA']")
    private ExtendedWebElement welcomeToCarina;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolBar.getPageName().equals("Web View");
    }

    @Override
    public boolean isLeftMenuOpened() {
        return leftMenu.isOpened();
    }

    @Override
    public boolean isRightMenuOpened() {
        return rightMenu.isOpened();
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isViewPagerPresent() && imageView.isAllPagerDotsPresent();
    }

    @Override
    public boolean isRMElemPresent(RMComponent component) {
        switch (component) {
            case LOGO:
                return rightMenu.isLogoPresent();
            case READ_ON_GITHUB:
                return rightMenu.isReadOnGitHubPresent();
            case INSTALLATION_GUIDE:
                return rightMenu.isInstallationGuidePresent();
            case GO_TO_ZEBRUNNER:
                return rightMenu.isGoToZebrunnerPresent();
            case DONATE:
                return rightMenu.isDonatePresent();
            case CONTACT_US:
                return rightMenu.isContactUsPresent();
            default:
                return false;
        }
    }

    @Override
    public boolean isFMElemPresent(FMComponent component) {
        switch (component) {
            case LOGO:
                return footerMenu.isZebrunnerLogoPresent();
            case FACEBOOK:
                return footerMenu.isMessengerPresent(FACEBOOK);
            case TWITTER:
                return footerMenu.isMessengerPresent(TWITTER);
            case LINKEDIN:
                return footerMenu.isMessengerPresent(LINKEDIN);
            case TELEGRAM:
                return footerMenu.isMessengerPresent(TELEGRAM);
            case LOCATION:
                return footerMenu.isLocationPresent();
            case SUPPORT:
                return footerMenu.isSupportPresent();
            case PRIVACY_POLICY:
                return footerMenu.isPrivacyPolicyPresent();
            default:
                return false;
        }
    }

    @Override
    public void openLeftMenu() {
        toolBar.openLeftMenu();
    }

    @Override
    public void rightMenu(String operation) {
        if(operation.equals(OPEN)) {
            if(!rightMenu.isOpened()) {
                rightMenu.clickRightMenu();
            }
        }
        if(operation.equals(CLOSE)) {
            if(rightMenu.isOpened()) {
                rightMenu.clickRightMenu();
            }
        }
    }

    @Override
    public void swipeToPrivacyPolicy() {
        if(!footerMenu.isPrivacyPolicyPresent()) {
            swipe(footerMenu.getPrivacyPolicy(), Direction.UP, 50, 500);
        }
    }

    @Override
    public boolean isFooterMenuPresent() {
        return footerMenu.isZebrunnerLogoPresent();
    }

    @Override
    public void clickOnFooterMenuMessenger(String messenger) {
        footerMenu.clickOnMessenger(messenger);
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
