package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FooterMenu extends AbstractUIObject implements IConstants, IMobileUtils {

    @FindBy(xpath = "//*[@resource-id = 'rec407789353']")
    private ExtendedWebElement footerMenuContent;

    @FindBy(xpath = "//*[@resource-id = 'rec407789353']/*[@content-desc = 'zebrunner']")
    private ExtendedWebElement zebrunnerLogo;

    @FindBy(xpath = "//*[@resource-id = 'Layer_1']")
    private List<ExtendedWebElement> messengersList;

    @FindBy(xpath = "//*[@resource-id = 'rec407789353']//*[contains(@text, 'Zebrunner, Inc')]")
    private ExtendedWebElement location;

    @FindBy(xpath = "//*[@text = 'support@zebrunner.com']")
    private ExtendedWebElement support;

    @FindBy(xpath = "//*[@text = 'Privacy Policy']")
    private ExtendedWebElement privacyPolicy;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isFooterMenuPresent() {
        return swipe(footerMenuContent, Direction.UP, THIRTY_SWIPES, FAST_SWIPES);
    }

    public boolean isZebrunnerLogoPresent() {
        return swipe(zebrunnerLogo, Direction.UP, THIRTY_SWIPES, FAST_SWIPES);
    }

    public boolean isMessengerPresent(int index) {
        if(!swipe(privacyPolicy, Direction.UP, THIRTY_SWIPES, FAST_SWIPES)) {
            Assert.fail("FooterMenu | Privacy policy isn't present!");
        }
        if(messengersList.isEmpty() || index >= messengersList.size()) {
            Assert.fail("FooterMenu | List empty or index > then list size!");
        }
        return messengersList.get(index).isElementPresent(THREE_SECONDS);
    }

    public boolean isLocationPresent() {
        return swipe(location, Direction.UP, THIRTY_SWIPES, FAST_SWIPES);
    }

    public boolean isSupportPresent() {
        return swipe(support, Direction.UP, THIRTY_SWIPES, FAST_SWIPES);
    }

    public boolean isPrivacyPolicyPresent() {
        return swipe(privacyPolicy, Direction.UP, THIRTY_SWIPES, FAST_SWIPES);
    }

    public void clickOnMessenger(int index) {
        if(!swipe(privacyPolicy, Direction.UP, THIRTY_SWIPES, FAST_SWIPES)) {
            Assert.fail("FooterMenu | Privacy policy isn't present!");
        }
        if(messengersList.isEmpty() || index >= messengersList.size()) {
            Assert.fail("FooterMenu | List empty or index > then list size!");
        }
        messengersList.get(index).click(ONE_SECOND);
    }
}
