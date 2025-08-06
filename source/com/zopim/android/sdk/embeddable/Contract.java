package com.zopim.android.sdk.embeddable;

public final class Contract {
    public static final String ACTION_CREATE_REQUEST = "zopim.action.CREATE_REQUEST";
    public static final String EXTRA_EMAIL = "com.zopim.EXTRA_EMAIL";
    public static final String EXTRA_MESSAGE = "com.zopim.EXTRA_MESSAGE";
    public static final String EXTRA_NAME = "com.zopim.EXTRA_NAME";

    public static String getChatSdkVersionName() {
        return "1.4.1";
    }
}
