package com.qaprosoft.carina.chulei.web.saucedemo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.chulei.web.saucedemo.pages.HomePageDemo;
import com.qaprosoft.carina.chulei.web.saucedemo.pages.InventoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyWebTest implements IAbstractTest {
    private static final String rightUserName = "standard_user";
    private static final String rightPassword = "secret_sauce";
    private static final String wrongUserName = "wrong";
    private static final String wrongPassword = "wrong";

    @Test
    public void testHomeTitle() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isTitlePresent(), "Home page title isn't present!");
    }

    @Test
    public void testRightAccess() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page not opened!");
        Assert.assertTrue(homePageDemo.isUserNamePresent(), "Home page user field isn't present!");
        Assert.assertTrue(homePageDemo.isPasswordPresent(), "Home page password field isn't present!");
        homePageDemo.setUserField(rightUserName);
        homePageDemo.setPasswordField(rightPassword);
        homePageDemo.clickLoginButton();
        Assert.assertFalse(homePageDemo.isUserFieldErrorIconPresent(), "Home page error user field isn't present!");
    }

    @Test
    public void testWrongAccess() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page not opened!");
        Assert.assertTrue(homePageDemo.isUserNamePresent(), "Home page user field isn't present!");
        Assert.assertTrue(homePageDemo.isPasswordPresent(), "Home page password field isn't present!");
        homePageDemo.setUserField(wrongUserName);
        homePageDemo.setPasswordField(wrongPassword);
        homePageDemo.clickLoginButton();
        Assert.assertTrue(homePageDemo.isUserFieldErrorIconPresent(), "Home page error user field isn't present!");
    }

    @Test
    public void testRightPosition() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page not opened!");
        Assert.assertTrue(homePageDemo.isUserNamePresent(), "Home page user field isn't present!");
        Assert.assertTrue(homePageDemo.isPasswordPresent(), "Home page password field isn't present!");
        Assert.assertTrue(homePageDemo.isAllElementAtRightPlace(), "User field below password field!");
    }

    @Test
    public void testCardInfo() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        Assert.assertTrue(homePageDemo.isPageOpened(), "Home page not opened!");
        InventoryPage inventoryPage = homePageDemo.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page isn't opened(By URL check)");
        Assert.assertTrue(inventoryPage.isEveryCardHasAllInfo());
    }

    @Test
    public void testMenu() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        InventoryPage inventoryPage = homePageDemo.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page isn't opened(By URL check)");
        Assert.assertTrue(inventoryPage.isAToZPresent(), "A To Z option isn't present");
        Assert.assertTrue(inventoryPage.isZToAPresent(), "Z To A option isn't present");
        Assert.assertTrue(inventoryPage.isLowToHighPresent(), "Low To High option isn't present");
        Assert.assertTrue(inventoryPage.isHighToLowPresent(), "High To Low option isn't present");
    }

    @Test
    public void testSelectOption() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        InventoryPage inventoryPage = homePageDemo.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page isn't opened(By URL check)");
        Assert.assertTrue(inventoryPage.isZToAPresent(), "Z To A option isn't present");
        inventoryPage.selectZToA();
        Assert.assertTrue(inventoryPage.isZToASelected(), "Z to A option isn't selected!");
    }

    @Test
    public void testAlphabeticCorrect() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        InventoryPage inventoryPage = homePageDemo.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page isn't opened(By URL check)");
        Assert.assertTrue(inventoryPage.isAToZPresent(), "A To Z option isn't present");
        inventoryPage.selectAToZ();
        Assert.assertTrue(inventoryPage.isCardNamesSortedAToZ(), "Card names are in wrong alphabetic order!");
    }

    @Test
    public void testInventoryPageOpened() {
        HomePageDemo homePageDemo = new HomePageDemo(getDriver());
        homePageDemo.open();
        InventoryPage inventoryPage = homePageDemo.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page isn't opened(By URL check)");
    }
}