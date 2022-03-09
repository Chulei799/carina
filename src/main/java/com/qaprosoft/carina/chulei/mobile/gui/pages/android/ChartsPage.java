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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/toolbar")
    private ToolBar toolBar;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_navigation_view")
    private LeftMenu leftMenu;

    @FindBy(id = "com.solvd.carinademoapplication:id/image_slider")
    private ImageView imageView;

    @FindBy(id = "com.solvd.carinademoapplication:id/fragmentFruitChart")
    private ExtendedWebElement fruitChart;

    @FindBy(id = "com.solvd.carinademoapplication:id/fragmentVennDiagram")
    private ExtendedWebElement vennDiagram;

    @FindBy(id = "com.solvd.carinademoapplication:id/fragmentHiloChart")
    private ExtendedWebElement hiloChart;

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return toolBar.getPageName().equals("Charts");
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
    public boolean isFruitChartPresent() {
        return fruitChart.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isVennDiagramPresent() {
        return vennDiagram.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public boolean isHiloChartPresent() {
        return hiloChart.isElementPresent(FIVE_SECONDS);
    }

    @Override
    public void swipeToVennDiagram() {
        if(fruitChart.isElementPresent(THREE_SECONDS)) {
            swipe(vennDiagram, Direction.DOWN, 10, 500);
        } else if (hiloChart.isElementPresent(THREE_SECONDS)) {
            swipe(vennDiagram, Direction.UP, 10, 500);
        }
    }

    @Override
    public void swipeToHiloDiagram() {
        swipe(hiloChart, Direction.UP, 10, 500);
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
