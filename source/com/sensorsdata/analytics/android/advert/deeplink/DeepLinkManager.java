package com.sensorsdata.analytics.android.advert.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sensorsdata.analytics.android.advert.SAAdvertConstants;
import com.sensorsdata.analytics.android.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.ServerUrl;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBusConstants;
import com.sensorsdata.analytics.android.sdk.deeplink.SADeepLinkObject;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sumsub.sentry.q;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepLinkManager {
    public static final String IS_ANALYTICS_DEEPLINK = "is_analytics_deeplink";
    private static JSONObject mCacheProperties = null;
    /* access modifiers changed from: private */
    public static SensorsDataDeepLinkCallback mDeepLinkCallback = null;
    private static DeepLinkProcessor mDeepLinkProcessor = null;
    /* access modifiers changed from: private */
    public static SensorsDataDeferredDeepLinkCallback mDeferredDeepLinkCallback = null;
    private static boolean mEnableDeepLinkInstallSource = false;
    private static boolean mIsDeepLink = false;

    public enum DeepLinkType {
        CHANNEL,
        SENSORSDATA
    }

    public interface OnDeepLinkParseFinishCallback {
        void onFinish(DeepLinkType deepLinkType, String str, boolean z11, long j11);
    }

    private static void cacheProperties() {
        if (mCacheProperties == null) {
            mCacheProperties = new JSONObject();
        }
        mergeDeepLinkProperty(mCacheProperties);
    }

    private static DeepLinkProcessor createDeepLink(Intent intent, String str, String str2) {
        if (intent == null) {
            return null;
        }
        if (isSensorsDataDeepLink(intent, new ServerUrl(str).getHost(), NetworkUtils.getHost(str2))) {
            return new SensorsDataDeepLink(intent, str, str2);
        }
        if (isUtmDeepLink(intent)) {
            return new ChannelDeepLink(intent);
        }
        return null;
    }

    public static void enableDeepLinkInstallSource(boolean z11) {
        mEnableDeepLinkInstallSource = z11;
    }

    private static boolean isDeepLink(Intent intent) {
        return Build.VERSION.SDK_INT >= 11 && intent != null && "android.intent.action.VIEW".equals(intent.getAction()) && intent.getData() != null;
    }

    private static boolean isParsedDeepLink(Activity activity) {
        Intent intent;
        try {
            if (!((SensorsDataUtils.isUniApp() && ChannelUtils.isDeepLinkBlackList(activity)) || (intent = activity.getIntent()) == null || intent.getData() == null)) {
                return intent.getBooleanExtra(IS_ANALYTICS_DEEPLINK, false);
            }
        } catch (Throwable th2) {
            SALog.i(SAAdvertConstants.TAG, th2.getMessage());
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r5 = r5.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isSensorsDataDeepLink(android.content.Intent r5, java.lang.String r6, java.lang.String r7) {
        /*
            boolean r0 = isDeepLink(r5)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r5 = r5.getData()
            java.util.List r0 = r5.getPathSegments()
            if (r0 == 0) goto L_0x006e
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x006e
            java.lang.String r5 = r5.getHost()
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "slink"
            boolean r2 = r2.equals(r3)
            java.lang.String r3 = "sensorsdata"
            r4 = 1
            if (r2 == 0) goto L_0x0047
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0046
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 != 0) goto L_0x0046
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.compareMainDomain(r7, r5)
            if (r6 != 0) goto L_0x0045
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x0046
        L_0x0045:
            r1 = r4
        L_0x0046:
            return r1
        L_0x0047:
            java.lang.Object r7 = r0.get(r1)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r0 = "sd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x006e
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x006e
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x006e
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x006d
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L_0x006e
        L_0x006d:
            r1 = r4
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager.isSensorsDataDeepLink(android.content.Intent, java.lang.String, java.lang.String):boolean");
    }

    private static boolean isUtmDeepLink(Intent intent) {
        if (!isDeepLink(intent)) {
            return false;
        }
        Uri data = intent.getData();
        if (data.isOpaque()) {
            SALog.d("ChannelDeepLink", data.toString() + " isOpaque");
            return false;
        }
        Set<String> queryParameterNames = data.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.size() <= 0) {
            return false;
        }
        return ChannelUtils.hasLinkUtmProperties(queryParameterNames);
    }

    public static void mergeCacheProperties(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null && (jSONObject2 = mCacheProperties) != null && jSONObject2.length() != 0) {
            SensorsDataUtils.mergeJSONObject(mCacheProperties, jSONObject);
            mCacheProperties = null;
        }
    }

    public static void mergeDeepLinkProperty(JSONObject jSONObject) {
        try {
            DeepLinkProcessor deepLinkProcessor = mDeepLinkProcessor;
            if (deepLinkProcessor != null) {
                deepLinkProcessor.mergeDeepLinkProperty(jSONObject);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void parseDeepLink(Activity activity, final boolean z11) {
        try {
            if (!isDeepLink(activity.getIntent())) {
                return;
            }
            if (!isParsedDeepLink(activity)) {
                Intent intent = activity.getIntent();
                DeepLinkProcessor createDeepLink = createDeepLink(intent, SensorsDataAPI.sharedInstance().getServerUrl(), AbstractSensorsDataAPI.getConfigOptions().getCustomADChannelUrl());
                mDeepLinkProcessor = createDeepLink;
                if (createDeepLink != null) {
                    ChannelUtils.clearUtm();
                    mIsDeepLink = true;
                    mDeepLinkProcessor.setDeepLinkParseFinishCallback(new OnDeepLinkParseFinishCallback() {
                        public void onFinish(DeepLinkType deepLinkType, String str, boolean z11, long j11) {
                            if (z11) {
                                ChannelUtils.saveDeepLinkInfo();
                            }
                            SAEventBus.getInstance().post(SAEventBusConstants.Tag.DEEPLINK_LAUNCH, ChannelUtils.getLatestUtmProperties());
                            if (deepLinkType == DeepLinkType.SENSORSDATA) {
                                try {
                                    if (DeepLinkManager.mDeferredDeepLinkCallback != null) {
                                        DeepLinkManager.mDeferredDeepLinkCallback.onReceive(new SADeepLinkObject(str, "", z11, j11));
                                    } else if (DeepLinkManager.mDeepLinkCallback != null) {
                                        DeepLinkManager.mDeepLinkCallback.onReceive(str, z11, j11);
                                    }
                                } catch (Exception e11) {
                                    SALog.printStackTrace(e11);
                                }
                            }
                        }
                    });
                    mDeepLinkProcessor.parseDeepLink(intent);
                    cacheProperties();
                    trackDeepLinkLaunchEvent(activity.getApplicationContext(), mDeepLinkProcessor);
                    activity.getIntent().putExtra(IS_ANALYTICS_DEEPLINK, true);
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void requestDeferredDeepLink(Context context, JSONObject jSONObject, String str, String str2, JSONObject jSONObject2, String str3, boolean z11) {
        String str4;
        if (!mIsDeepLink) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                if (jSONObject != null) {
                    if (jSONObject.has("$oaid")) {
                        str2 = jSONObject.optString("$oaid");
                        jSONObject.remove("$oaid");
                    }
                    str4 = ChannelUtils.getDeviceInfo(context, str, str2);
                    if (jSONObject.has("$gaid")) {
                        str4 = String.format("%s##gaid=%s", new Object[]{str4, jSONObject.optString("$gaid")});
                        jSONObject.remove("$gaid");
                    }
                    if (jSONObject.has("$user_agent")) {
                        jSONObject3.put("ua", jSONObject.optString("$user_agent"));
                        jSONObject.remove("$user_agent");
                    }
                    jSONObject3.put("app_parameter", jSONObject.toString());
                } else {
                    str4 = ChannelUtils.getDeviceInfo(context, str, str2);
                }
                jSONObject3.put("ids", Base64Coder.encodeString(str4));
                jSONObject3.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, jSONObject2.optString("$model"));
                jSONObject3.put(q.f30469g, jSONObject2.optString("$os"));
                jSONObject3.put(TPDownloadProxyEnum.USER_OS_VERSION, jSONObject2.optString("$os_version"));
                jSONObject3.put(OptionsBridge.NETWORK_KEY, jSONObject2.optString("$network_type"));
                jSONObject3.put("app_id", jSONObject2.optString("$app_id"));
                jSONObject3.put(Constants.EXTRA_KEY_APP_VERSION, jSONObject2.optString("$app_version"));
                jSONObject3.put("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject3.put("project", new ServerUrl(SensorsDataAPI.sharedInstance().getServerUrl()).getProject());
                DeferredDeepLinkHelper.request(jSONObject3, mDeferredDeepLinkCallback, str3, z11);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static void resetDeepLinkProcessor() {
        mDeepLinkProcessor = null;
    }

    public static void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        mDeepLinkCallback = sensorsDataDeepLinkCallback;
    }

    public static void setDeferredDeepLinkCallback(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        mDeferredDeepLinkCallback = sensorsDataDeferredDeepLinkCallback;
    }

    private static void trackDeepLinkLaunchEvent(final Context context, DeepLinkProcessor deepLinkProcessor) {
        final JSONObject jSONObject = new JSONObject();
        final boolean z11 = (deepLinkProcessor instanceof SensorsDataDeepLink) && mEnableDeepLinkInstallSource;
        try {
            jSONObject.put("$deeplink_url", deepLinkProcessor.getDeepLinkUrl());
            jSONObject.put("$time", new Date(System.currentTimeMillis()));
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
        SensorsDataUtils.mergeJSONObject(ChannelUtils.getLatestUtmProperties(), jSONObject);
        SensorsDataUtils.mergeJSONObject(ChannelUtils.getUtmProperties(), jSONObject);
        SensorsDataAPI.sharedInstance().transformTaskQueue(new Runnable() {
            public void run() {
                if (z11) {
                    try {
                        JSONObject jSONObject = jSONObject;
                        Context context = context;
                        jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(context, SensorsDataUtils.getAndroidID(context), SAOaidHelper.getOAID(context)));
                    } catch (JSONException e11) {
                        SALog.printStackTrace(e11);
                    }
                }
                SensorsDataAPI.sharedInstance().trackInternal("$AppDeeplinkLaunch", jSONObject);
            }
        });
    }
}
