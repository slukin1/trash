package com.sensorsdata.analytics.android.advert.deeplink;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.ServerUrl;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class SensorsDataDeepLink extends AbsDeepLink {
    /* access modifiers changed from: private */
    public String adSlinkId;
    private String customADChannelUrl;
    /* access modifiers changed from: private */
    public String errorMsg;
    /* access modifiers changed from: private */
    public String pageParams;
    private String project;
    private String serverUrl;
    /* access modifiers changed from: private */
    public boolean success;

    public SensorsDataDeepLink(Intent intent, String str, String str2) {
        super(intent);
        this.serverUrl = str;
        this.customADChannelUrl = str2;
        this.project = new ServerUrl(str).getProject();
    }

    private String getSlinkRequestUrl() {
        return !TextUtils.isEmpty(this.customADChannelUrl) ? NetworkUtils.getRequestUrl(this.customADChannelUrl, "slink/config/query") : "";
    }

    private boolean isSlink(Uri uri, String str) {
        List<String> pathSegments;
        if (TextUtils.isEmpty(str) || (pathSegments = uri.getPathSegments()) == null || pathSegments.isEmpty() || !pathSegments.get(0).equals("slink")) {
            return false;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        if (NetworkUtils.compareMainDomain(str, host) || host.equals(DbParams.DATABASE_NAME)) {
            return true;
        }
        return false;
    }

    public String getRequestUrl() {
        int lastIndexOf;
        if (TextUtils.isEmpty(this.serverUrl) || (lastIndexOf = this.serverUrl.lastIndexOf("/")) == -1) {
            return "";
        }
        return this.serverUrl.substring(0, lastIndexOf) + "/sdk/deeplink/param";
    }

    public void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            jSONObject.put("$deeplink_url", getDeepLinkUrl());
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void parseDeepLink(Intent intent) {
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String lastPathSegment = data.getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment)) {
                final long currentTimeMillis = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put("key", lastPathSegment);
                hashMap.put("system_type", "ANDROID");
                hashMap.put("project", this.project);
                new RequestHelper.Builder(HttpMethod.GET, isSlink(data, NetworkUtils.getHost(this.customADChannelUrl)) ? getSlinkRequestUrl() : getRequestUrl()).params(hashMap).callback(new HttpCallback.JsonCallback() {
                    public void onAfter() {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.pageParams)) {
                                jSONObject.put("$deeplink_options", SensorsDataDeepLink.this.pageParams);
                            }
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                jSONObject.put("$deeplink_match_fail_reason", SensorsDataDeepLink.this.errorMsg);
                            }
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.adSlinkId)) {
                                jSONObject.put("$ad_slink_id", SensorsDataDeepLink.this.adSlinkId);
                            }
                            jSONObject.put("$deeplink_url", SensorsDataDeepLink.this.getDeepLinkUrl());
                            jSONObject.put("$event_duration", String.format(Locale.CHINA, "%.3f", new Object[]{Float.valueOf(((float) currentTimeMillis) / 1000.0f)}));
                        } catch (JSONException e11) {
                            SALog.printStackTrace(e11);
                        }
                        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
                        SensorsDataDeepLink sensorsDataDeepLink = SensorsDataDeepLink.this;
                        DeepLinkManager.OnDeepLinkParseFinishCallback onDeepLinkParseFinishCallback = sensorsDataDeepLink.mCallBack;
                        if (onDeepLinkParseFinishCallback != null) {
                            onDeepLinkParseFinishCallback.onFinish(DeepLinkManager.DeepLinkType.SENSORSDATA, sensorsDataDeepLink.pageParams, SensorsDataDeepLink.this.success, currentTimeMillis);
                        }
                        SensorsDataAPI.sharedInstance().trackInternal("$AppDeeplinkMatchedResult", jSONObject);
                    }

                    public void onFailure(int i11, String str) {
                        String unused = SensorsDataDeepLink.this.errorMsg = str;
                        boolean unused2 = SensorsDataDeepLink.this.success = false;
                    }

                    public void onResponse(JSONObject jSONObject) {
                        if (jSONObject != null) {
                            boolean unused = SensorsDataDeepLink.this.success = true;
                            ChannelUtils.parseParams(JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
                            String unused2 = SensorsDataDeepLink.this.pageParams = jSONObject.optString("page_params");
                            String unused3 = SensorsDataDeepLink.this.errorMsg = jSONObject.optString("errorMsg");
                            if (TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                String unused4 = SensorsDataDeepLink.this.errorMsg = jSONObject.optString("error_msg");
                            }
                            String unused5 = SensorsDataDeepLink.this.adSlinkId = jSONObject.optString("ad_slink_id");
                            if (!TextUtils.isEmpty(SensorsDataDeepLink.this.errorMsg)) {
                                boolean unused6 = SensorsDataDeepLink.this.success = false;
                                return;
                            }
                            return;
                        }
                        boolean unused7 = SensorsDataDeepLink.this.success = false;
                    }
                }).execute();
            }
        }
    }
}
