package com.sensorsdata.analytics.android.advert.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class ChannelDeepLink extends AbsDeepLink {
    public ChannelDeepLink(Intent intent) {
        super(intent);
    }

    public void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            jSONObject.put("$deeplink_url", getDeepLinkUrl());
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
    }

    public void parseDeepLink(Intent intent) {
        Set<String> queryParameterNames;
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (data.isOpaque()) {
                SALog.d("ChannelDeepLink", data.toString() + " isOpaque");
            } else if (Build.VERSION.SDK_INT >= 11 && (queryParameterNames = data.getQueryParameterNames()) != null && queryParameterNames.size() > 0) {
                HashMap hashMap = new HashMap();
                for (String next : queryParameterNames) {
                    String queryParameter = data.getQueryParameter(next);
                    if (TextUtils.isEmpty(queryParameter)) {
                        queryParameter = "";
                    }
                    hashMap.put(next, queryParameter);
                }
                ChannelUtils.parseParams(hashMap);
                DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback = this.mCallBack;
                if (onDeepLinkParseFinishCallback != null) {
                    onDeepLinkParseFinishCallback.onFinish(DeepLinkManager.DeepLinkType.CHANNEL, (String) null, true, 0);
                }
            }
        }
    }
}
