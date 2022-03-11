package com.qaprosoft.carina.chulei.mobile.gui.pages.android;


import com.qaprosoft.carina.chulei.mobile.gui.pages.common.LeftMenuPageBase;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.UserInfo;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.LMComponent;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LeftMenuPageBase.class)
public class LeftMenuPage extends LeftMenuPageBase {

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout")
    private UserInfo userInfo;

    @FindBy(xpath = "//*[@class = 'android.widget.CheckedTextView' and  @text = '%s']")
    private ExtendedWebElement menuName;

    @FindBy(id = "com.solvd.carinademoapplication:id/design_navigation_view")
    private ExtendedWebElement menuContent;

    public LeftMenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return menuContent.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isMenuElementPresent(LMComponent page) {
        return menuName.format(page.getName()).isElementPresent(ONE_SECOND);
    }

    @Override
    public AbstractPage openPageFromLeftMenu(LMComponent page) {
        menuName.format(page.getName()).click(THREE_SECONDS);
        return initPage(getDriver(), page.getPageClass());
    }
}
