package com.facebook.login;

public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DIALOG_ONLY(false, true, true, false, true, true),
    DEVICE_AUTH(false, false, false, true, false, false);
    
    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    private LoginBehavior(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.allowsGetTokenAuth = z11;
        this.allowsKatanaAuth = z12;
        this.allowsWebViewAuth = z13;
        this.allowsDeviceAuth = z14;
        this.allowsCustomTabAuth = z15;
        this.allowsFacebookLiteAuth = z16;
    }

    public boolean allowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    public boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    public boolean allowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }

    public boolean allowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    public boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    public boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
