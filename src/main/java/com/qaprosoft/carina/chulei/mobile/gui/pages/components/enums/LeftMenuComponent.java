package com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums;

public enum LeftMenuComponent {
    WEB_VIEW("Web View"),
    CHARTS("Charts"),
    MAP("Map"),
    UI_ELEMENTS("UI elements");

    private String name;

    LeftMenuComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
