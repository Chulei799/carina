package com.qaprosoft.carina.chulei.web.hdrezka.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.chulei.web.hdrezka.components.InlineItem;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class HDRezkaSearchPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final static String specificPageUrl = "https://rezka.ag/search/?do=search&subaction=search&q=";
    private String filmName;

    @FindBy(xpath = "//*[@id=\"main\"]/div[4]/div[2]/div/div[1]/div")
    private List<InlineItem> inlineItemList;

    public HDRezkaSearchPage(WebDriver driver, String filmName) {
        super(driver);
        this.filmName = filmName;
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(specificPageUrl + filmName.replace(" ", "+"));
    }

    public boolean isFilmPresent() {
        return !inlineItemList.isEmpty();
    }

    public HDRezkaFilmPage selectFilm() {
        LOGGER.info("Films found: " + inlineItemList.size());
        for(InlineItem inlineItem : inlineItemList) {
            LOGGER.info(inlineItem.getFilmName());
        }
        int n = RandomUtils.nextInt(0, inlineItemList.size());
        String url = inlineItemList.get(n).getUrl();
        LOGGER.info(url);
        inlineItemList.get(n).clickLink();
        return new HDRezkaFilmPage(driver, url);
    }
}
