package com.zopim.android.sdk.api;

interface ChatServiceApi extends ChatApi, BreadcrumbsApi {
    void clearPushToken();

    boolean isRunning();

    void setPushToken(String str);
}
