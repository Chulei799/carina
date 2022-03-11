package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage implements IMobileUtils, IConstants {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isNextBtnPresent();

    public abstract LoginPageBase clickNextBtn();
}
