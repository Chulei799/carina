package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserInfo extends AbstractUIObject implements IConstants {

    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
    private ExtendedWebElement userImage;

    @FindBy(xpath = "//*[@class = 'android.widget.TextView' and @text = '%s']")
    private ExtendedWebElement userField;

    public UserInfo(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isImagePresent() {
        return userImage.isElementPresent(FIVE_SECONDS);
    }

    public boolean isUserFieldPresent(String field) {
        return userField.format(field).isElementPresent(FIVE_SECONDS);
    }
}
