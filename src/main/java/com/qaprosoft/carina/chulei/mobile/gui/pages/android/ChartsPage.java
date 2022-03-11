package com.qaprosoft.carina.chulei.mobile.gui.pages.android;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.*;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.ImageView;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    @FindBy(xpath = "//*[@resource-id = 'com.solvd.carinademoapplication:id/toolbar']//android.widget.TextView")
    private ExtendedWebElement pageName;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private ExtendedWebElement leftMenuBtn;

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement pageContent;

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
        return pageContent.isElementPresent(THREE_SECONDS);
    }

    @Override
    public boolean isImageViewPresent() {
        return imageView.isViewPagerPresent() && imageView.isAllPagerDotsPresent();
    }

    @Override
    public boolean isFruitChartPresent() {
        return swipe(fruitChart, Direction.DOWN, 10, 500);
    }

    @Override
    public boolean isVennDiagramPresent() {
        return swipe(vennDiagram, Direction.VERTICAL, 10, 500);
    }

    @Override
    public boolean isHiloChartPresent() {
        return swipe(hiloChart, Direction.UP, 10, 500);
    }

    @Override
    public LeftMenuPageBase openLeftMenu() {
        leftMenuBtn.click(ONE_SECOND);
        return initPage(getDriver(), LeftMenuPageBase.class);
    }
}
