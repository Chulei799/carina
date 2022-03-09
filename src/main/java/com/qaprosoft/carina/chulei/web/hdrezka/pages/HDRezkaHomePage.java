package com.qaprosoft.carina.chulei.web.hdrezka.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HDRezkaHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private String filmName;

    @FindBy(id = "search-field")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//*[@id=\"search\"]/button")
    private ExtendedWebElement searchButton;

    public HDRezkaHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldPresent() {
        return searchField.isElementPresent();
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void setSearchField(String filmName) {
        searchField.type(filmName);
        this.filmName = filmName;
    }

    public HDRezkaSearchPage clickSearchButton() {
        searchButton.click();
        return new HDRezkaSearchPage(driver, filmName);
    }
}
