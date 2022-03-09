package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.android.ChartsPage;
import com.qaprosoft.carina.chulei.mobile.gui.pages.android.MapPage;
import com.qaprosoft.carina.chulei.mobile.gui.pages.android.UIElementsPage;
import com.qaprosoft.carina.chulei.mobile.gui.pages.android.WebViewPage;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.ChartsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.MapPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.UIElementsPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.common.WebViewPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LeftMenu extends AbstractUIObject implements IConstants {

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout")
    private UserInfo userInfo;

    @FindBy(xpath = "//*[@class = 'android.widget.CheckedTextView' and  @text = 'Web View']")
    private ExtendedWebElement webView;

    @FindBy(xpath = "//*[@class = 'android.widget.CheckedTextView' and  @text = 'Charts']")
    private ExtendedWebElement charts;

    @FindBy(xpath = "//*[@class = 'android.widget.CheckedTextView' and  @text = 'Map']")
    private ExtendedWebElement map;

    @FindBy(xpath = "//*[@class = 'android.widget.CheckedTextView' and  @text = 'UI elements']")
    private ExtendedWebElement uiElements;

    public LeftMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isWebViewPresent() {
        return webView.isElementPresent(FIVE_SECONDS);
    }

    public boolean isChartsPresent() {
        return charts.isElementPresent(FIVE_SECONDS);
    }

    public boolean isMapPresent() {
        return map.isElementPresent(FIVE_SECONDS);
    }

    public boolean isUIElementsPresent() {
        return uiElements.isElementPresent(FIVE_SECONDS);
    }

    public boolean isUserInfoPresent() {
        return userInfo.isPresent();
    }

    public boolean isOpened() {
        return isWebViewPresent() || isChartsPresent() || isMapPresent() || isUIElementsPresent();
    }

    public WebViewPageBase clickWebView() {
        webView.click();
        return new WebViewPage(driver);
    }

    public ChartsPageBase clickCharts() {
        charts.click();
        return new ChartsPage(driver);
    }

    public MapPageBase clickMap() {
        map.click();
        return new MapPage(driver);
    }

    public UIElementsPageBase clickUIElements() {
        uiElements.click();
        return new UIElementsPage(driver);
    }
}
