package com.qaprosoft.carina.chulei.web.hdrezka.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HDRezkaFilmPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "cdnplayer")
    private ExtendedWebElement player;

    public HDRezkaFilmPage(WebDriver driver, String url) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(url);
    }

    public boolean isFilmPlayerPresent() {
        return player.isElementPresent();
    }

    public void playFilm() {
        player.click();
    }

}
