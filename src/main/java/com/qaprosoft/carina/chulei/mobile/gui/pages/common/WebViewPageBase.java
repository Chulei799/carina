package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.FMComponent;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.RMComponent;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage implements IMobileUtils, IConstants {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLeftMenuOpened();

    public abstract boolean isRightMenuOpened();

    public abstract boolean isImageViewPresent();

    public abstract boolean isRMElemPresent(RMComponent component);

    public abstract boolean isFMElemPresent(FMComponent component);

    public abstract void openLeftMenu();

    public abstract void rightMenu(String operation);

    public abstract void swipeToPrivacyPolicy();

    public abstract boolean isFooterMenuPresent();

    public abstract void clickOnFooterMenuMessenger(String messenger);

    public abstract WebViewPageBase openWebViewPage();

    public abstract ChartsPageBase openChartsPage();

    public abstract MapPageBase openMapPage();

    public abstract UIElementsPageBase openUIElementsPage();
}
