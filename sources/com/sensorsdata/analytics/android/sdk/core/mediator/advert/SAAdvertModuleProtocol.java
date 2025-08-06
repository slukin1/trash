package com.sensorsdata.analytics.android.sdk.core.mediator.advert;

import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;
import org.json.JSONObject;

public interface SAAdvertModuleProtocol extends SAModuleProtocol, SAAdvertAPIProtocol {
    void commitRequestDeferredDeeplink(boolean z11);

    JSONObject getLatestUtmProperties();

    JSONObject mergeChannelEventProperties(String str, JSONObject jSONObject);

    void removeDeepLinkInfo(JSONObject jSONObject);
}
