package com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums;

public enum RMComponent {
    READ_ON_GITHUB("Read on GitHub"),
    INSTALLATION_GUIDE("Installation Guide"),
    GO_TO_ZEBRUNNER("Go to Zebrunner"),
    DONATE("Donate"),
    CONTACT_US("Contact Us");

    String name;

    RMComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}