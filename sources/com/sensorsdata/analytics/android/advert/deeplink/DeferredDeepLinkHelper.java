package com.sensorsdata.analytics.android.advert.deeplink;

import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.deeplink.SADeepLinkObject;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.network.HttpMethod;
import com.sensorsdata.analytics.android.sdk.network.RequestHelper;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.Locale;
import org.json.JSONObject;

public class DeferredDeepLinkHelper {
    public static void request(JSONObject jSONObject, SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback, String str, boolean z11) {
        final long currentTimeMillis = System.currentTimeMillis();
        boolean z12 = !TextUtils.isEmpty(str) && (str.startsWith(DomainTool.DOMAIN_PREFIX_HTTP) || str.startsWith(DomainTool.DOMAIN_PREFIX));
        if (z12 || (!TextUtils.isEmpty(SensorsDataAPI.sharedInstance().getServerUrl()) && SensorsDataAPI.sharedInstance().getServerUrl().startsWith("http"))) {
            HttpMethod httpMethod = HttpMethod.POST;
            if (!z12) {
                str = SensorsDataAPI.sharedInstance().getServerUrl();
            }
            RequestHelper.Builder jsonData = new RequestHelper.Builder(httpMethod, NetworkUtils.getRequestUrl(str, "slink/ddeeplink")).jsonData(jSONObject.toString());
            final boolean z13 = z11;
            final JSONObject jSONObject2 = jSONObject;
            final SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback2 = sensorsDataDeferredDeepLinkCallback;
            jsonData.callback(new HttpCallback.JsonCallback() {
                private String adChannel;
                private String adSlinkId;
                private String errorMsg;
                private boolean isSuccess = false;
                private String parameter;

                public void onAfter() {
                    if (z13) {
                        ChannelUtils.saveDeepLinkInfo();
                    }
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(this.parameter)) {
                            jSONObject.put("$deeplink_options", this.parameter);
                        }
                        if (!TextUtils.isEmpty(this.errorMsg)) {
                            jSONObject.put("$deeplink_match_fail_reason", this.errorMsg);
                        }
                        if (!TextUtils.isEmpty(this.adChannel)) {
                            jSONObject.put("$ad_deeplink_channel_info", this.adChannel);
                        }
                        if (!TextUtils.isEmpty(this.adSlinkId)) {
                            jSONObject.put("$ad_slink_id", this.adSlinkId);
                        }
                        jSONObject.put("$ad_app_match_type", "deferred deeplink");
                        jSONObject.put("$event_duration", String.format(Locale.CHINA, "%.3f", new Object[]{Float.valueOf(((float) currentTimeMillis) / 1000.0f)}));
                        jSONObject.put("$ad_device_info", jSONObject2.get("ids"));
                        SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback = sensorsDataDeferredDeepLinkCallback2;
                        if (sensorsDataDeferredDeepLinkCallback != null) {
                            try {
                                if (sensorsDataDeferredDeepLinkCallback.onReceive(new SADeepLinkObject(this.parameter, this.adChannel, this.isSuccess, currentTimeMillis)) && this.isSuccess) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("$deeplink_options", this.parameter);
                                    if (!TextUtils.isEmpty(this.adSlinkId)) {
                                        jSONObject2.put("$ad_slink_id", this.adSlinkId);
                                    }
                                    SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject2);
                                    SensorsDataAPI.sharedInstance().trackInternal("$AdAppDeferredDeepLinkJump", jSONObject2);
                                }
                            } catch (Exception e11) {
                                SALog.printStackTrace(e11);
                            }
                        } else if (this.isSuccess) {
                            jSONObject.put("$deeplink_match_fail_reason", "未调用 setDeepLinkCompletion 方法设置回调函数");
                        }
                        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
                        SensorsDataAPI.sharedInstance().trackInternal("$AppDeeplinkMatchedResult", jSONObject);
                    } catch (Exception e12) {
                        SALog.printStackTrace(e12);
                    }
                }

                public void onFailure(int i11, String str) {
                    this.errorMsg = str;
                }

                public void onResponse(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        this.errorMsg = "response is null";
                    } else if (jSONObject.optInt("code") == 0) {
                        this.isSuccess = true;
                        ChannelUtils.parseParams(JSONUtils.json2Map(jSONObject.optJSONObject("channel_params")));
                        this.parameter = jSONObject.optString("parameter");
                        this.adChannel = jSONObject.optString("ad_channel");
                        this.adSlinkId = jSONObject.optString("ad_slink_id");
                    } else {
                        this.errorMsg = jSONObject.optString(RemoteMessageConst.MessageBody.MSG);
                    }
                }
            }).execute();
        }
    }
}
