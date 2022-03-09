package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RightMenu extends AbstractUIObject implements IConstants {

    @FindBy(xpath = "//android.view.View/android.view.View/android.view.View/android.view.View[2]")
    private ExtendedWebElement openBtn;

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

    public RightMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isOpenBtnPresent() {
        return openBtn.isElementPresent();
    }

    public boolean isLogoPresent() {
        return logo.isElementPresent();
    }

    public boolean isReadOnGitHubPresent() {
        return readOnGitHub.isElementPresent(FIVE_SECONDS);
    }

    public boolean isInstallationGuidePresent() {
        return installationGuide.isElementPresent(FIVE_SECONDS);
    }

    public boolean isGoToZebrunnerPresent() {
        return goToZebrunner.isElementPresent(FIVE_SECONDS);
    }

    public boolean isDonatePresent() {
        return donate.isElementPresent(FIVE_SECONDS);
    }

    public boolean isContactUsPresent() {
        return contactUs.isElementPresent(FIVE_SECONDS);
    }

    public boolean isOpened() {
        return isLogoPresent();
    }

    public void clickRightMenu() {
        openBtn.click();
    }
}
