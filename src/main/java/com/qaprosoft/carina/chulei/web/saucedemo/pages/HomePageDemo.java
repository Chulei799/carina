package com.qaprosoft.carina.chulei.web.saucedemo.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePageDemo extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(className = "login_logo")
    private ExtendedWebElement title;

    @FindBy(id = "user-name")
    private ExtendedWebElement userField;

    @FindBy(id = "password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private ExtendedWebElement userFieldErrorIcon;

    public HomePageDemo(WebDriver driver) {
        super(driver);
    }

    public boolean isTitlePresent() {
        return title.isElementPresent();
    }

    public boolean isUserNamePresent() {
        return userField.isElementPresent();
    }

    public boolean isPasswordPresent() {
        return passwordField.isElementPresent();
    }

    public boolean isUserFieldErrorIconPresent() {
        return userFieldErrorIcon.isElementPresent();
    }

    public HomePageDemo setUserField(String userName) {
        userField.type(userName);
        return this;
    }

    public HomePageDemo setPasswordField(String password) {
        passwordField.type(password);
        return this;
    }

    public boolean isUserFieldUnderPasswordField() {
        Point userFieldLocation = userField.getLocation();
        Point passwordFieldLocation = passwordField.getLocation();
        if (userFieldLocation.getY() < passwordFieldLocation.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPasswordFieldUnderLoginButton() {
        Point passwordFieldLocation = passwordField.getLocation();
        Point loginButtonLocation = loginButton.getLocation();
        if (loginButtonLocation.getY() > passwordFieldLocation.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAllElementAtRightPlace() {
        return isUserFieldUnderPasswordField() && isPasswordFieldUnderLoginButton();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public InventoryPage login() {
        setUserField("standard_user");
        setPasswordField("secret_sauce");
        loginButton.click();
        return new InventoryPage(driver);
    }
}
