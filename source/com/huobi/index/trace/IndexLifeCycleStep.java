package com.huobi.index.trace;

public enum IndexLifeCycleStep {
    AppStart("AppStart", 0),
    AppLaunch("AppLaunch", 1),
    AppHomePage("AppHomePage", 2),
    AppHomePageDone("AppHomePageDone", 3),
    AppEnterBackground("AppEnterBackground", 4),
    AppEnterForgeground("AppEnterForgeground", 5);
    
    public final int index;
    public final String name;

    private IndexLifeCycleStep(String str, int i11) {
        this.name = str;
        this.index = i11;
    }
}
