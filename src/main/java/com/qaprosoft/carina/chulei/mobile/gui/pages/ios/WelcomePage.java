package com.qaprosoft.carina.chulei.mobile.gui.pages.ios;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {


    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isNextBtnPresent() {
        return false;
    }

    @Override
    public LoginPageBase clickNextBtn() {
        return null;
    }
}
