package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.RMComponent;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RightMenuPageBase extends AbstractPage implements IConstants {

    public RightMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoPresent();

    public abstract boolean isMenuElementPresent(RMComponent component);

    public abstract boolean isOpenBtnPresent();

    public abstract void clickRightMenu();
}
