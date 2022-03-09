package com.qaprosoft.carina.chulei.mobile.gui.pages.components;

import com.qaprosoft.carina.chulei.constants.IConstants;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterMenu extends AbstractUIObject implements IConstants {

    @FindBy(xpath = "//*[@resource-id = 'rec407789353']/*[@content-desc = 'zebrunner']")
    private ExtendedWebElement zebrunnerLogo;

    @FindBy(xpath = ".//android.view.View[3]/android.view.View")
    private List<ExtendedWebElement> messengersList;

    @FindBy(xpath = ".//android.widget.ListView/android.view.View")
    private ExtendedWebElement location;

    @FindBy(xpath = "//*[@text = 'support@zebrunner.com']")
    private ExtendedWebElement support;

    @FindBy(xpath = "//*[@text = 'Privacy Policy']")
    private ExtendedWebElement privacyPolicy;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isZebrunnerLogoPresent() {
        return zebrunnerLogo.isElementPresent(FIVE_SECONDS);
    }

    public boolean isMessengerPresent(String messenger) {
        switch (messenger) {
            case FACEBOOK:
                messengersList.get(0).isElementPresent(FIVE_SECONDS);
                return true;
            case TWITTER:
                messengersList.get(1).isElementPresent(FIVE_SECONDS);
                return true;
            case LINKEDIN:
                messengersList.get(2).isElementPresent(FIVE_SECONDS);
                return true;
            case TELEGRAM:
                messengersList.get(3).isElementPresent(FIVE_SECONDS);
                return true;
            default:
                return false;
        }
    }

    public int messengerListSize() {
        return messengersList.size();
    }

    public boolean isLocationPresent() {
        return location.isElementPresent(FIVE_SECONDS);
    }

    public boolean isSupportPresent() {
        return support.isElementPresent(FIVE_SECONDS);
    }

    public boolean isPrivacyPolicyPresent() {
        return privacyPolicy.isElementPresent(FIVE_SECONDS);
    }

    public String getLocationText() {
        return location.getText();
    }

    public boolean clickOnMessenger(String messenger) {
        switch (messenger) {
            case FACEBOOK:
                messengersList.get(0).click();
                return true;
            case TWITTER:
                messengersList.get(1).click();
                return true;
            case LINKEDIN:
                messengersList.get(2).click();
                return true;
            case TELEGRAM:
                messengersList.get(3).click();
                return true;
            default:
                return false;
        }
    }

    public ExtendedWebElement getPrivacyPolicy() {
        return privacyPolicy;
    }
}
