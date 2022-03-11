package com.qaprosoft.carina.chulei.web.hdrezka;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.chulei.web.hdrezka.pages.HDRezkaFilmPage;
import com.qaprosoft.carina.chulei.web.hdrezka.pages.HDRezkaHomePage;
import com.qaprosoft.carina.chulei.web.hdrezka.pages.HDRezkaSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HDRezkaWebTest implements IAbstractTest {
    private final static String filmName = "Harry Potter";

    @Test
    public void testSearchFilm() {
        HDRezkaHomePage homePage = new HDRezkaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened!");
        Assert.assertTrue(homePage.isSearchFieldPresent(), "Search field missing!");
        homePage.clickSearchField();
        homePage.setSearchField(filmName);
        HDRezkaSearchPage searchPage = homePage.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page not opened!");
        Assert.assertTrue(searchPage.isFilmPresent(), "Film not present!");
    }

    @Test
    public void testSelectFilm() {
        HDRezkaHomePage homePage = new HDRezkaHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page not opened!");
        Assert.assertTrue(homePage.isSearchFieldPresent(), "Search field missing!");
        homePage.clickSearchField();
        homePage.setSearchField(filmName);
        HDRezkaSearchPage searchPage = homePage.clickSearchButton();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page not opened!");
        Assert.assertTrue(searchPage.isFilmPresent(), "Film not present!");
        HDRezkaFilmPage filmPage =  searchPage.selectFilm();
        Assert.assertTrue(filmPage.isPageOpened(), "Film page not opened!");
        Assert.assertTrue(filmPage.isFilmPlayerPresent(), "Film player not present!");
        filmPage.playFilm();
        Assert.assertTrue(filmPage.isPageOpened(), "Page closed!");
    }
}
