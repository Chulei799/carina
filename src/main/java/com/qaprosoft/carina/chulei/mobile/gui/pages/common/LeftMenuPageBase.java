package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.LMComponent;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LeftMenuPageBase extends AbstractPage implements IConstants {

    public LeftMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isMenuElementPresent(LMComponent page);

    public abstract AbstractPage openPageFromLeftMenu(LMComponent page);
}
