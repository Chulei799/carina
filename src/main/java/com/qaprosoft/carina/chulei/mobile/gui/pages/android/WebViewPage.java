package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LeftMenuPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.RightMenuPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.FooterMenu;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ImageView;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//*[@resource-id = 'com.solvd.carinademoapplication:id/toolbar']//android.widget.TextView")
    private ExtendedWebElement pageName;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement leftMenuBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ImageView imageView;

    @FindBy(xpath = "//*[@resource-id = 'allrecords']")
    private ExtendedWebElement scrollView;

    @FindBy(xpath = "//*[@resource-id = 'rec42972268']//android.view.View[2]")
    private ExtendedWebElement rightMenuBtn;

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
        return waitUntil(ExpectedConditions.visibilityOf(carinaLogo.getElement()), 20);
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isViewPagerPresent() && imageView.isAllPagerDotsPresent();
    }

    @Override
    public boolean isCarinaLogoPresent() {
        return swipe(carinaLogo, scrollView, Direction.DOWN, 40, 500);
    }

    @Override
    public boolean isCarinaTextPresent() {
        return swipe(carinaText, scrollView, Direction.DOWN, 40, 500);
    }

    @Override
    public boolean isCarinaDescriptionPresent() {
        return swipe(carinaDescription, scrollView, Direction.DOWN, 40, 500);
    }

    @Override
    public boolean isReadOnGitHubBtnPresent() {
        return swipe(readOnGitHubBtn, scrollView, Direction.VERTICAL, 40, 500);
    }

    @Override
    public boolean isInstallationGuideBtnPresent() {
        return swipe(installationGuideBtn, scrollView, Direction.VERTICAL, 40, 500);
    }

    @Override
    public boolean isWelcomeToCarinaPresent() {
        return swipe(welcomeToCarina, scrollView, Direction.VERTICAL, 40, 500);
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    @Override
    public RightMenuPageBase openRightMenu() {
        rightMenuBtn.click(ONE_SECOND);
        return initPage(getDriver(), RightMenuPageBase.class);
    }

    @Override
    public LeftMenuPageBase openLeftMenu() {
        leftMenuBtn.click(THREE_SECONDS);
        return initPage(getDriver(), LeftMenuPageBase.class);
    }
}
