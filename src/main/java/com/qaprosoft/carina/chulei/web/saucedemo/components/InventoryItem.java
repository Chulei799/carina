package com.qaprosoft.carina.chulei.web.saucedemo.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

public class InventoryItem extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = ".//div[@class=\"inventory_item_img\"]")
    private ExtendedWebElement image;

    @FindBy(xpath = ".//div/div/a/div[@class=\"inventory_item_name\"]")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//div/div/div[@class=\"inventory_item_desc\"]")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = ".//div/div[@class=\"pricebar\"]/div[@class=\"inventory_item_price\"]")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//div/div/div/div/button")
    private ExtendedWebElement addToCartButton;

    public InventoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isImagePresent() {
        return image.isElementPresent();
    }

    public boolean isProductNamePresent() {
        return productName.isElementPresent();
    }

    public boolean isProductDescriptionPresent() {
        return productDescription.isElementPresent();
    }

    public boolean isPricePresent() {
        return price.isElementPresent();
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isElementPresent();
    }

    public boolean isAllPresent() {
        Assert.assertTrue(isImagePresent(), "Image isn't present at Inventory page!");
        //LOGGER.info("Image is found!");
        Assert.assertTrue(isProductNamePresent(), "Product name isn't present at Inventory page!");
        //LOGGER.info(productName.getText());
        Assert.assertTrue(isProductDescriptionPresent(), "Product description isn't present at Inventory page!");
        //LOGGER.info("Description is found!");
        Assert.assertTrue(isPricePresent(), "Price isn't present at Inventory page!");
        //LOGGER.info("Price is found!");
        Assert.assertTrue(isAddToCartButtonPresent(), "Add to cart button isn't present at Inventory page!");
        //LOGGER.info("Add button is found!");
        return isImagePresent() && isProductNamePresent() && isProductDescriptionPresent() && isPricePresent()
                && isAddToCartButtonPresent();
    }

    public String getProductName() {
        return productName.getText();
    }
}
