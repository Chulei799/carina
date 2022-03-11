package com.qaprosoft.carina.chulei.mobile.gui.pages.components.enums;

import com.qaprosoft.carina.chulei.mobile.gui.pages.common.*;
import com.qaprosoft.carina.core.gui.AbstractPage;

public enum LMComponent {
    WEB_VIEW("Web View", WebViewPageBase.class),
    CHARTS("Charts", ChartsPageBase.class),
    MAP("Map", MapPageBase.class),
    UI_ELEMENTS("UI elements", UIElementsPageBase.class);

    private String name;
    private Class<? extends AbstractPage> pageClass;

    LMComponent(String name, Class<? extends AbstractPage> pageClass) {
        this.name = name;
        this.pageClass = pageClass;
    }

    public String getName() {
        return name;
    }

    public Class<? extends AbstractPage> getPageClass() {
        return this.pageClass;
    }
}
