package com.qaprosoft.carina.chulei.mobile.gui.pages.common;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.chulei.mobile.gui.pages.components.FooterMenu;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage implements IMobileUtils, IConstants {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isImageViewPresent();
    
    public abstract boolean isCarinaLogoPresent();

    public abstract boolean isCarinaTextPresent();

    public abstract boolean isCarinaDescriptionPresent();
    
    public abstract boolean isReadOnGitHubBtnPresent();
    
    public abstract boolean isInstallationGuideBtnPresent();
    
    public abstract boolean isWelcomeToCarinaPresent();

    public abstract FooterMenu getFooterMenu();

    public abstract RightMenuPageBase openRightMenu();

    public abstract LeftMenuPageBase openLeftMenu();
}
