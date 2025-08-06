package com.hbg.module.libkt.provider;

import com.google.firebase.analytics.FirebaseAnalytics;

public enum JumpPageScheme {
    SETTING("setting"),
    LOGIN(FirebaseAnalytics.Event.LOGIN);
    
    private String pageName;

    private JumpPageScheme(String str) {
        this.pageName = str;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final void setPageName(String str) {
        this.pageName = str;
    }
}
