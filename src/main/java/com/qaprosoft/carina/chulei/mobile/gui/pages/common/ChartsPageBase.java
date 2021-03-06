package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums.LMComponent;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public  abstract class ChartsPageBase extends AbstractPage implements IMobileUtils, IConstants {

    public ChartsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isImageViewPresent();

    public abstract boolean isFruitChartPresent();

    public abstract boolean isVennDiagramPresent();

    public abstract boolean isHiloChartPresent();

    public abstract LeftMenuPageBase openLeftMenu();
}
