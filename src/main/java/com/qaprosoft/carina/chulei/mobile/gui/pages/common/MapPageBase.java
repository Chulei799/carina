package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MapPageBase extends AbstractPage implements IConstants {

    public MapPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLeftMenuOpened();

    public abstract boolean isImageViewPresent();

    public abstract boolean isMapPresent();

    public abstract boolean isGoogleImagePresent();

    public abstract boolean isZoomPresent(String option);

    public abstract void clickZoom(String option);

    public abstract void openLeftMenu();

    public abstract WebViewPageBase openWebViewPage();

    public abstract ChartsPageBase openChartsPage();

    public abstract MapPageBase openMapPage();

    public abstract UIElementsPageBase openUIElementsPage();
}
