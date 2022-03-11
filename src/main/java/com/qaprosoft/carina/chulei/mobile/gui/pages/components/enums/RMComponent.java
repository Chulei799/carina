package com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums;

public enum RMComponent {
    LOGO("Logo"),
    READ_ON_GITHUB("Read on github"),
    INSTALLATION_GUIDE("Installation guide"),
    GO_TO_ZEBRUNNER("Go to zebrunner"),
    DONATE("Donate"),
    CONTACT_US("Contact us");

    String name;

    RMComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}