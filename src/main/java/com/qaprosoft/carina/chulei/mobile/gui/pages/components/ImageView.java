package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ImageView extends AbstractUIObject implements IConstants {

    @FindBy(id = "com.solvd.carinademoapplication:id/view_pager")
    private ExtendedWebElement viewPager;

    @FindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.ImageView")
    private List<ExtendedWebElement> pagerDots;

    public ImageView(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isViewPagerPresent() {
        return viewPager.isElementPresent(FIVE_SECONDS);
    }

    public boolean isPagerDotPresent(int n) {
        if(n < pagerDots.size()) {
            return pagerDots.get(n).isElementPresent(FIVE_SECONDS);
        } else {
            return false;
        }
    }

    public boolean isAllPagerDotsPresent() {
        return isPagerDotPresent(0) && isPagerDotPresent(1) && isPagerDotPresent(2) && isPagerDotPresent(3)
                && isPagerDotPresent(4);
    }
}
