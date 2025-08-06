package com.sensorsdata.analytics.android.advert.deeplink;

import android.content.Intent;
import com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager;

public abstract class AbsDeepLink implements DeepLinkProcessor {
    private String deepLinkUrl;
    public DeepLinkManager.OnDeepLinkParseFinishCallback mCallBack;

    public AbsDeepLink(Intent intent) {
        if (intent != null && intent.getData() != null) {
            setDeepLinkUrl(intent.getData().toString());
        }
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public void setDeepLinkParseFinishCallback(DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback) {
        this.mCallBack = onDeepLinkParseFinishCallback;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }
}
