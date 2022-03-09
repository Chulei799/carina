package com.qaprosoft.carina.chulei.web.hdrezka.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class InlineItem extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = ".//div[2]/a")
    private ExtendedWebElement link;

    public InlineItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLinkPresent() {
        return link.isElementPresent();
    }

    public void clickLink() {
        link.click();
    }

    public String getFilmName() {
        return link.getText();
    }

    public String getUrl() {
        return link.getAttribute("href");
    }
}
