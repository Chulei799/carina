package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ToolBar extends AbstractUIObject implements IConstants {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement leftMenuBtn;

    @FindBy(xpath = "//android.widget.TextView")
    private ExtendedWebElement pageName;

    public ToolBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPageNamePresent() {
        return pageName.isElementPresent(FIVE_SECONDS);
    }

    public boolean isLeftMenuBtnPresent() {
        return leftMenuBtn.isElementPresent(FIVE_SECONDS);
    }

    public boolean isPresent() {
        return isPageNamePresent() && isLeftMenuBtnPresent();
    }

    public String getPageName() {
        return pageName.getText();
    }

    public void openLeftMenu() {
        leftMenuBtn.click(FIVE_SECONDS);
    }
}
