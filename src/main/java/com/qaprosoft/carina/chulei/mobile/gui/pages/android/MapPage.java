package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.ChartsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.MapPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ImageView;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.LeftMenu;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ToolBar;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase{

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ToolBar toolBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_navigation_view")
    private LeftMenu leftMenu;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ImageView imageView;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='%s']")
    private ExtendedWebElement zoom;

    @FindBy(xpath = "//android.widget.RelativeLayout[2]/android.widget.ImageView")
    private ExtendedWebElement googleImage;

    @FindBy(xpath = "//*[@content-desc = 'Google Map']")
    private ExtendedWebElement map;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolBar.getPageName().equals("Map");
    }

    @Override
    public boolean isLeftMenuOpened() {
        return leftMenu.isOpened();
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isViewPagerPresent() && imageView.isAllPagerDotsPresent();
    }

    @Override
    public boolean isMapPresent() {
        return map.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isGoogleImagePresent() {
        return googleImage.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isZoomPresent(String option) {
        return zoom.format(option).isElementPresent(FIVE_SECONDS);
    }

    @Override
    public void clickZoom(String option) {
        zoom.format(option).click();
    }

    @Override
    public void openLeftMenu() {
        toolBar.openLeftMenu();
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
