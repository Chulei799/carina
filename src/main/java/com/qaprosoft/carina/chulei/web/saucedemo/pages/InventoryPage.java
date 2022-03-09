package com.qaprosoft.carina.chulei.web.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.chulei.web.saucedemo.components.InventoryItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class InventoryPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String specificPageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[@class=\"inventory_item\"]")
    private List<InventoryItem> inventoryList;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/span")
    private ExtendedWebElement select;

    @FindBy(xpath = ".//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[1]")
    private ExtendedWebElement optionAToZ;

    @FindBy(xpath = ".//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private ExtendedWebElement optionZToA;

    @FindBy(xpath = ".//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private ExtendedWebElement optionLowToHigh;

    @FindBy(xpath = ".//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")
    private ExtendedWebElement optionHighToLow;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private ExtendedWebElement cart;

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL(specificPageUrl);
    }

    public boolean isEveryCardHasAllInfo() {
        for(InventoryItem inventoryItem : inventoryList) {
            if(!inventoryItem.isAllPresent()) {
                return false;
            }
            //LOGGER.info("Card ends!");
        }
        return true;
    }

    public boolean isAToZPresent() {
        return optionAToZ.isElementPresent();
    }

    public boolean isZToAPresent() {
        return optionZToA.isElementPresent();
    }

    public boolean isLowToHighPresent() {
        return optionLowToHigh.isElementPresent();
    }

    public boolean isHighToLowPresent() {
        return optionHighToLow.isElementPresent();
    }

    public boolean isAllOptionsPresent() {
        return isAToZPresent() && isZToAPresent() && isLowToHighPresent() && isHighToLowPresent();
    }

    public boolean isAToZSelected() {
        return select.getText().equalsIgnoreCase("Name (A to Z)");
    }

    public boolean isZToASelected() {
        return select.getText().equalsIgnoreCase("Name (Z to A)");
    }

    public boolean isLowToHighSelected() {
        return select.getText().equalsIgnoreCase("Price (low to high)");
    }

    public boolean isHighToLowSelected() {
        return select.getText().equalsIgnoreCase("Price (high to low)");
    }

    public void selectAToZ() {
        if(!isAToZSelected()) {
            optionAToZ.click();
        }
    }

    public void selectZToA() {
        if(!isZToASelected()) {
            optionZToA.click();
        }
    }

    public void selectLowToHigh() {
        if(!isLowToHighSelected()) {
            optionLowToHigh.click();
        }
    }

    public void selectHighToLow() {
        if(!isHighToLowSelected()) {
            optionHighToLow.click();
        }
    }

    public boolean isCardNamesSortedAToZ() {
        for(int i = 0; i < inventoryList.size() - 1; i++) {
            String first = inventoryList.get(i).getProductName().toLowerCase();
            String second = inventoryList.get(i + 1).getProductName().toLowerCase();
            if (first.compareToIgnoreCase(second) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isCartPresent() {
        return cart.isElementPresent();
    }

    public CartPage viewCart() {
        cart.click();
        return new CartPage(driver);
    }
}
