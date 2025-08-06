package com.sensorsdata.analytics.android.advert;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.advert.monitor.SensorsDataAdvertActivityLifeCallback;
import com.sensorsdata.analytics.android.advert.oaid.SAOaidHelper;
import com.sensorsdata.analytics.android.advert.plugin.SAAdvertPluginManager;
import com.sensorsdata.analytics.android.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.advert.utils.SAAdvertScanHelper;
import com.sensorsdata.analytics.android.advert.utils.SAAdvertUtils;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SAEventManager;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.mediator.ModuleConstants;
import com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertModuleProtocol;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAScanListener;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class SAAdvertProtocolImpl implements SAAdvertModuleProtocol, SAScanListener {
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mEnable = false;
    /* access modifiers changed from: private */
    public boolean mEnableDeepLinkInstallSource;
    private SensorsDataAdvertActivityLifeCallback mLifecycleCallback;
    /* access modifiers changed from: private */
    public SAConfigOptions mOptions;
    private SAAdvertPluginManager mPluginManager;

    private void delayInitTask() {
        SAEventManager.getInstance().trackQueueEvent(new Runnable() {
            public void run() {
                try {
                    if (SAAdvertProtocolImpl.this.mOptions.isSaveDeepLinkInfo()) {
                        ChannelUtils.loadUtmByLocal();
                    } else {
                        ChannelUtils.clearLocalUtm();
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    private void init() {
        this.mPluginManager = new SAAdvertPluginManager();
        ChannelUtils.setSourceChannelKeys(this.mOptions.channelSourceKeys);
        if (!this.mOptions.isDisableSDK()) {
            setModuleState(true);
        }
        if (!AppInfoUtils.isMainProcess(this.mContext, (Bundle) null)) {
            return;
        }
        if (!ChannelUtils.isExistRequestDeferredDeeplink()) {
            ChannelUtils.commitRequestDeferredDeeplink(true);
        } else {
            ChannelUtils.commitRequestDeferredDeeplink(false);
        }
    }

    private void registerLifeCallback() {
        if (this.mLifecycleCallback == null) {
            this.mLifecycleCallback = new SensorsDataAdvertActivityLifeCallback(this.mOptions);
        }
        SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mLifecycleCallback);
    }

    private void unregisterLifecycleCallback() {
        if (this.mLifecycleCallback != null) {
            SensorsDataLifecycleMonitorManager.getInstance().removeActivityLifeCallback(this.mLifecycleCallback);
        }
    }

    public void commitRequestDeferredDeeplink(boolean z11) {
        ChannelUtils.commitRequestDeferredDeeplink(z11);
    }

    public void enableDeepLinkInstallSource(boolean z11) {
        this.mEnableDeepLinkInstallSource = z11;
        DeepLinkManager.enableDeepLinkInstallSource(z11);
    }

    public JSONObject getLatestUtmProperties() {
        return ChannelUtils.getLatestUtmProperties();
    }

    public String getModuleName() {
        return ModuleConstants.ModuleName.ADVERT_NAME;
    }

    public boolean handlerScanUri(Activity activity, Uri uri) {
        return SAAdvertScanHelper.scanHandler(activity, uri);
    }

    public void install(Context context, SAConfigOptions sAConfigOptions) {
        this.mContext = context;
        this.mOptions = sAConfigOptions;
        init();
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public JSONObject mergeChannelEventProperties(String str, JSONObject jSONObject) {
        return this.mOptions.isAutoAddChannelCallbackEvent() ? ChannelUtils.checkOrSetChannelCallbackEvent(str, jSONObject, this.mContext) : jSONObject;
    }

    public void removeDeepLinkInfo(JSONObject jSONObject) {
        ChannelUtils.removeDeepLinkInfo(jSONObject);
    }

    public void requestDeferredDeepLink(final JSONObject jSONObject) {
        if (isEnable()) {
            SAEventManager.getInstance().trackQueueEvent(new Runnable() {
                public void run() {
                    try {
                        if (ChannelUtils.isRequestDeferredDeeplink()) {
                            DeepLinkManager.requestDeferredDeepLink(SAAdvertProtocolImpl.this.mContext, jSONObject, SAAdvertUtils.getAndroidId(SAAdvertProtocolImpl.this.mContext), SAOaidHelper.getOAID(SAAdvertProtocolImpl.this.mContext), SensorsDataAPI.sharedInstance().getPresetProperties(), SAAdvertProtocolImpl.this.mOptions.getCustomADChannelUrl(), SAAdvertProtocolImpl.this.mOptions.isSaveDeepLinkInfo());
                            ChannelUtils.commitRequestDeferredDeeplink(false);
                        }
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        }
    }

    public void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        DeepLinkManager.setDeepLinkCallback(sensorsDataDeepLinkCallback);
    }

    public void setDeepLinkCompletion(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        DeepLinkManager.setDeferredDeepLinkCallback(sensorsDataDeferredDeepLinkCallback);
    }

    public void setModuleState(boolean z11) {
        if (this.mEnable != z11) {
            if (z11) {
                delayInitTask();
                registerLifeCallback();
                this.mPluginManager.registerPlugin();
            } else {
                unregisterLifecycleCallback();
                this.mPluginManager.unregisterPlugin();
            }
            this.mEnable = z11;
        }
    }

    public void trackAppInstall(JSONObject jSONObject, boolean z11) {
        trackInstallation("$AppInstall", jSONObject, z11);
    }

    public void trackChannelEvent(String str) {
        trackChannelEvent(str, (JSONObject) null);
    }

    public void trackDeepLinkLaunch(String str) {
        trackDeepLinkLaunch(str, (String) null);
    }

    public void trackInstallation(String str, JSONObject jSONObject, boolean z11) {
        if (isEnable()) {
            try {
                if (AppInfoUtils.isMainProcess(this.mContext, (Bundle) null)) {
                    final JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject != null) {
                        SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
                    }
                    SADataHelper.addTimeProperty(jSONObject2);
                    final String loginId = SensorsDataAPI.sharedInstance().getLoginId();
                    final boolean z12 = z11;
                    final String str2 = str;
                    SensorsDataAPI.sharedInstance().transformTaskQueue(new Runnable() {
                        public void run() {
                            String str;
                            String str2;
                            try {
                                if (SAAdvertUtils.isFirstTrackInstallation(z12)) {
                                    boolean z11 = false;
                                    try {
                                        if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                                            ChannelUtils.mergeUtmByMetaData(SAAdvertProtocolImpl.this.mContext, jSONObject2);
                                        }
                                        if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                                            String androidId = SAAdvertUtils.getAndroidId(SAAdvertProtocolImpl.this.mContext);
                                            if (jSONObject2.has("$oaid")) {
                                                str2 = jSONObject2.optString("$oaid");
                                                str = ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, androidId, str2);
                                                SALog.i(SAAdvertConstants.TAG, "properties has oaid " + str2);
                                            } else {
                                                str2 = SAOaidHelper.getOAID(SAAdvertProtocolImpl.this.mContext);
                                                str = ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, androidId, str2);
                                            }
                                            if (jSONObject2.has("$gaid")) {
                                                str = String.format("%s##gaid=%s", new Object[]{str, jSONObject2.optString("$gaid")});
                                            }
                                            z11 = ChannelUtils.isGetDeviceInfo(SAAdvertProtocolImpl.this.mContext, androidId, str2);
                                            jSONObject2.put("$ios_install_source", str);
                                        }
                                        if (jSONObject2.has("$oaid")) {
                                            jSONObject2.remove("$oaid");
                                        }
                                        if (jSONObject2.has("$gaid")) {
                                            jSONObject2.remove("$gaid");
                                        }
                                        boolean z12 = z12;
                                        if (z12) {
                                            jSONObject2.put("$ios_install_disable_callback", z12);
                                        }
                                    } catch (Exception e11) {
                                        SALog.printStackTrace(e11);
                                    }
                                    String distinctId = SensorsDataAPI.sharedInstance().getDistinctId();
                                    SAEventManager.getInstance().trackEvent(EventType.TRACK, str2, jSONObject2, (JSONObject) null, distinctId, loginId, (String) null);
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject2.remove("$ios_install_disable_callback");
                                    SensorsDataUtils.mergeJSONObject(jSONObject2, jSONObject);
                                    jSONObject.put("$first_visit_time", new Date());
                                    SAEventManager.getInstance().trackEvent(EventType.PROFILE_SET_ONCE, (String) null, jSONObject, (JSONObject) null, distinctId, loginId, (String) null);
                                    SAAdvertUtils.setTrackInstallation(z12);
                                    ChannelUtils.saveCorrectTrackInstallation(z11);
                                }
                                SensorsDataAPI.sharedInstance().flush();
                            } catch (Exception e12) {
                                SALog.printStackTrace(e12);
                            }
                        }
                    });
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void trackAppInstall(JSONObject jSONObject) {
        trackAppInstall(jSONObject, false);
    }

    public void trackChannelEvent(final String str, JSONObject jSONObject) {
        if (isEnable()) {
            if (this.mOptions.isAutoAddChannelCallbackEvent()) {
                SensorsDataAPI.sharedInstance().track(str, jSONObject);
                return;
            }
            final JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
            }
            SADataHelper.addTimeProperty(jSONObject2);
            SensorsDataAPI.sharedInstance().transformTaskQueue(new Runnable() {
                public void run() {
                    try {
                        jSONObject2.put("$is_channel_callback_event", ChannelUtils.isFirstChannelEvent(str));
                        if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                            ChannelUtils.mergeUtmByMetaData(SAAdvertProtocolImpl.this.mContext, jSONObject2);
                        }
                        if (!ChannelUtils.hasUtmProperties(jSONObject2)) {
                            if (jSONObject2.has("$oaid")) {
                                String optString = jSONObject2.optString("$oaid");
                                jSONObject2.put("$channel_device_info", ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, SAAdvertUtils.getAndroidId(SAAdvertProtocolImpl.this.mContext), optString));
                                SALog.i(SAAdvertConstants.TAG, "properties has oaid " + optString);
                            } else {
                                jSONObject2.put("$channel_device_info", ChannelUtils.getDeviceInfo(SAAdvertProtocolImpl.this.mContext, SAAdvertUtils.getAndroidId(SAAdvertProtocolImpl.this.mContext), SAOaidHelper.getOAID(SAAdvertProtocolImpl.this.mContext)));
                            }
                        }
                        if (jSONObject2.has("$oaid")) {
                            jSONObject2.remove("$oaid");
                        }
                    } catch (Exception e11) {
                        try {
                            SALog.printStackTrace(e11);
                        } catch (Exception e12) {
                            SALog.printStackTrace(e12);
                            return;
                        }
                    }
                    SAEventManager.getInstance().trackEvent(EventType.TRACK, str, jSONObject2, (String) null);
                }
            });
        }
    }

    public void trackDeepLinkLaunch(String str, final String str2) {
        if (isEnable()) {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("$deeplink_url", str);
                jSONObject.put("$time", new Date(System.currentTimeMillis()));
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
            SensorsDataAPI.sharedInstance().transformTaskQueue(new Runnable() {
                public void run() {
                    if (SAAdvertProtocolImpl.this.mEnableDeepLinkInstallSource) {
                        try {
                            JSONObject jSONObject = jSONObject;
                            Context access$200 = SAAdvertProtocolImpl.this.mContext;
                            String androidId = SAAdvertUtils.getAndroidId(SAAdvertProtocolImpl.this.mContext);
                            String str = str2;
                            if (str == null) {
                                str = SAOaidHelper.getOAID(SAAdvertProtocolImpl.this.mContext);
                            }
                            jSONObject.put("$ios_install_source", ChannelUtils.getDeviceInfo(access$200, androidId, str));
                        } catch (JSONException e11) {
                            SALog.printStackTrace(e11);
                        }
                    }
                    SensorsDataAPI.sharedInstance().trackInternal("$AppDeeplinkLaunch", jSONObject);
                }
            });
        }
    }

    public void trackAppInstall() {
        trackAppInstall((JSONObject) null, false);
    }

    public void trackInstallation(String str, JSONObject jSONObject) {
        trackInstallation(str, jSONObject, false);
    }

    public void trackInstallation(String str) {
        trackInstallation(str, (JSONObject) null, false);
    }
}
