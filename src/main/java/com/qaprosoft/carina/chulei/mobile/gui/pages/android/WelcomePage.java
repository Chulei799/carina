package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/carina_logo")
    private ExtendedWebElement logo;

    @FindBy(id = "com.solvd.carinademoapplication:id/next_button")
    private ExtendedWebElement nextBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return logo.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isNextBtnPresent() {
        return nextBtn.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public LoginPageBase clickNextBtn() {
        nextBtn.click(FIVE_SECONDS);
        return new LoginPage(driver);
    }
}
