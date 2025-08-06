package com.huobi.kalle.cookie.db;

public enum Where$Options {
    EQUAL(" = "),
    NO_EQUAL(" != "),
    BIGGER(" > "),
    SMALLER(" < ");
    
    /* access modifiers changed from: private */
    public String value;

    private Where$Options(String str) {
        this.value = str;
    }
}
