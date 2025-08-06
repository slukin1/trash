package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import com.sensorsdata.analytics.android.sdk.core.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.ModuleConstants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI;
import com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.SAContextManager;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataAPI extends AbstractSensorsDataAPI {
    public static String ANDROID_PLUGIN_VERSION = "3.4.0";
    public static final String MIN_PLUGIN_VERSION = "3.4.0";
    public static final String VERSION = "6.3.5";
    public static final int VTRACK_SUPPORTED_MIN_API = 16;

    public enum AutoTrackEventType {
        APP_START(1),
        APP_END(2),
        APP_CLICK(4),
        APP_VIEW_SCREEN(8);
        
        /* access modifiers changed from: private */
        public final int eventValue;

        private AutoTrackEventType(int i11) {
            this.eventValue = i11;
        }

        public static String autoTrackEventName(int i11) {
            return i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 8 ? "" : "$AppViewScreen" : AopConstants.APP_CLICK_EVENT_NAME : "$AppEnd" : "$AppStart";
        }

        public static AutoTrackEventType autoTrackEventTypeFromEventName(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -618659154:
                    if (str.equals("$AppViewScreen")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -441870274:
                    if (str.equals("$AppEnd")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 562530347:
                    if (str.equals(AopConstants.APP_CLICK_EVENT_NAME)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 577537797:
                    if (str.equals("$AppStart")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return APP_VIEW_SCREEN;
                case 1:
                    return APP_END;
                case 2:
                    return APP_CLICK;
                case 3:
                    return APP_START;
                default:
                    return null;
            }
        }

        public static boolean isAutoTrackType(String str) {
            if (!TextUtils.isEmpty(str)) {
                str.hashCode();
                char c11 = 65535;
                switch (str.hashCode()) {
                    case -618659154:
                        if (str.equals("$AppViewScreen")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -441870274:
                        if (str.equals("$AppEnd")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 562530347:
                        if (str.equals(AopConstants.APP_CLICK_EVENT_NAME)) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 577537797:
                        if (str.equals("$AppStart")) {
                            c11 = 3;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        return true;
                }
            }
            return false;
        }

        public int getEventValue() {
            return this.eventValue;
        }
    }

    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);
        
        private final boolean debugMode;
        private final boolean debugWriteData;

        private DebugMode(boolean z11, boolean z12) {
            this.debugMode = z11;
            this.debugWriteData = z12;
        }

        public boolean isDebugMode() {
            return this.debugMode;
        }

        public boolean isDebugWriteData() {
            return this.debugWriteData;
        }
    }

    public final class NetworkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 16;
        public static final int TYPE_ALL = 255;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_WIFI = 8;

        public NetworkType() {
        }
    }

    public SensorsDataAPI() {
    }

    public static void disableSDK() {
        SALog.i(AbstractSensorsDataAPI.TAG, "call static function disableSDK");
        try {
            SensorsDataAPI sharedInstance = sharedInstance();
            if (!(sharedInstance instanceof SensorsDataAPIEmptyImplementation) && AbstractSensorsDataAPI.getConfigOptions() != null) {
                if (!AbstractSensorsDataAPI.getConfigOptions().isDisableSDK) {
                    if (!SensorsDataContentObserver.isDisableFromObserver) {
                        sharedInstance.track("$AppDataTrackingClose");
                        sharedInstance.flush();
                    }
                    sharedInstance.unregisterNetworkListener();
                    sharedInstance.clearTrackTimer();
                    SAModuleManager.getInstance().setModuleState(false);
                    DbAdapter.getInstance().commitAppStartTime(0);
                    AbstractSensorsDataAPI.getConfigOptions().disableSDK(true);
                    SALog.setDisableSDK(true);
                    if (!SensorsDataContentObserver.isDisableFromObserver) {
                        sharedInstance.getContext().getContentResolver().notifyChange(DbParams.getInstance().getDisableSDKUri(), (ContentObserver) null);
                    }
                    SensorsDataContentObserver.isDisableFromObserver = false;
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void enableSDK() {
        SALog.i(AbstractSensorsDataAPI.TAG, "call static function enableSDK");
        try {
            SensorsDataAPI sDKInstance = getSDKInstance();
            if (!(sDKInstance instanceof SensorsDataAPIEmptyImplementation) && AbstractSensorsDataAPI.getConfigOptions() != null) {
                if (AbstractSensorsDataAPI.getConfigOptions().isDisableSDK) {
                    AbstractSensorsDataAPI.getConfigOptions().disableSDK(false);
                    SAModuleManager.getInstance().setModuleState(true);
                    try {
                        SALog.setDisableSDK(false);
                        sDKInstance.enableLog(SALog.isLogEnabled());
                        SALog.i(AbstractSensorsDataAPI.TAG, "enableSDK, enable log");
                        if (sDKInstance.mFirstDay.get() == null) {
                            sDKInstance.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), "yyyy-MM-dd"));
                        }
                        sDKInstance.delayInitTask();
                        if (AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                            VisualPropertiesManager.getInstance().requestVisualConfig();
                        }
                        sDKInstance.getRemoteManager().pullSDKConfigFromServer();
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                    if (!SensorsDataContentObserver.isEnableFromObserver) {
                        sDKInstance.getContext().getContentResolver().notifyChange(DbParams.getInstance().getEnableSDKUri(), (ContentObserver) null);
                    }
                    SensorsDataContentObserver.isEnableFromObserver = false;
                }
            }
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    private static SensorsDataAPI getInstance(Context context, DebugMode debugMode, SAConfigOptions sAConfigOptions) {
        SensorsDataAPI sensorsDataAPI;
        if (context == null) {
            return new SensorsDataAPIEmptyImplementation();
        }
        Map<Context, SensorsDataAPI> map = AbstractSensorsDataAPI.sInstanceMap;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            sensorsDataAPI = map.get(applicationContext);
            if (sensorsDataAPI == null) {
                sensorsDataAPI = new SensorsDataAPI(applicationContext, sAConfigOptions, debugMode);
                map.put(applicationContext, sensorsDataAPI);
                if (context instanceof Activity) {
                    sensorsDataAPI.delayExecution((Activity) context);
                }
            }
        }
        return sensorsDataAPI;
    }

    private static SensorsDataAPI getSDKInstance() {
        Map<Context, SensorsDataAPI> map = AbstractSensorsDataAPI.sInstanceMap;
        synchronized (map) {
            if (map.size() > 0) {
                Iterator<SensorsDataAPI> it2 = map.values().iterator();
                if (it2.hasNext()) {
                    SensorsDataAPI next = it2.next();
                    return next;
                }
            }
            SensorsDataAPIEmptyImplementation sensorsDataAPIEmptyImplementation = new SensorsDataAPIEmptyImplementation();
            return sensorsDataAPIEmptyImplementation;
        }
    }

    public static SensorsDataAPI sharedInstance(Context context) {
        if (AbstractSensorsDataAPI.isSDKDisabled()) {
            return new SensorsDataAPIEmptyImplementation();
        }
        if (context == null) {
            return new SensorsDataAPIEmptyImplementation();
        }
        Map<Context, SensorsDataAPI> map = AbstractSensorsDataAPI.sInstanceMap;
        synchronized (map) {
            SensorsDataAPI sensorsDataAPI = map.get(context.getApplicationContext());
            if (sensorsDataAPI != null) {
                return sensorsDataAPI;
            }
            SALog.i(AbstractSensorsDataAPI.TAG, "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
            SensorsDataAPIEmptyImplementation sensorsDataAPIEmptyImplementation = new SensorsDataAPIEmptyImplementation();
            return sensorsDataAPIEmptyImplementation;
        }
    }

    public static void startWithConfigOptions(Context context, SAConfigOptions sAConfigOptions) {
        if (context == null || sAConfigOptions == null) {
            throw new NullPointerException("Context、SAConfigOptions 不可以为 null");
        }
        SensorsDataAPI instance = getInstance(context, DebugMode.DEBUG_OFF, sAConfigOptions);
        if (!instance.mSDKConfigInit) {
            instance.applySAConfigOptions();
        }
    }

    public /* bridge */ /* synthetic */ void addEventListener(SAEventListener sAEventListener) {
        super.addEventListener(sAEventListener);
    }

    public /* bridge */ /* synthetic */ void addFunctionListener(SAFunctionListener sAFunctionListener) {
        super.addFunctionListener(sAFunctionListener);
    }

    public void addHeatMapActivities(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (Class next : list) {
                        if (next != null) {
                            int hashCode = next.hashCode();
                            if (!this.mHeatMapActivities.contains(Integer.valueOf(hashCode))) {
                                this.mHeatMapActivities.add(Integer.valueOf(hashCode));
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void addHeatMapActivity(Class<?> cls) {
        if (cls != null) {
            try {
                this.mHeatMapActivities.add(Integer.valueOf(cls.hashCode()));
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public /* bridge */ /* synthetic */ void addSAJSListener(SAJSListener sAJSListener) {
        super.addSAJSListener(sAJSListener);
    }

    public void addVisualizedAutoTrackActivities(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    for (Class next : list) {
                        if (next != null) {
                            int hashCode = next.hashCode();
                            if (!this.mVisualizedAutoTrackActivities.contains(Integer.valueOf(hashCode))) {
                                this.mVisualizedAutoTrackActivities.add(Integer.valueOf(hashCode));
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void addVisualizedAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            try {
                this.mVisualizedAutoTrackActivities.add(Integer.valueOf(cls.hashCode()));
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public /* bridge */ /* synthetic */ void appBecomeActive() {
        super.appBecomeActive();
    }

    public /* bridge */ /* synthetic */ void appEnterBackground() {
        super.appEnterBackground();
    }

    public void bind(final String str, final String str2) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (SensorsDataAPI.this.mUserIdentityAPI.bindBack(str, str2)) {
                            SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                            sensorsDataAPI.trackEvent(EventType.TRACK_ID_BIND, IUserIdentityAPI.BIND_ID, (JSONObject) null, sensorsDataAPI.getAnonymousId());
                        }
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void clearGPSLocation() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    AbstractSensorsDataAPI.mGPSLocation = null;
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void clearLastScreenUrl() {
        if (this.mClearReferrerWhenAppEnd) {
            this.mLastScreenUrl = null;
        }
    }

    public void clearReferrerWhenAppEnd() {
        this.mClearReferrerWhenAppEnd = true;
    }

    public void clearSuperProperties() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                synchronized (SensorsDataAPI.this.mSuperProperties) {
                    SensorsDataAPI.this.mSuperProperties.commit(new JSONObject());
                }
            }
        });
    }

    public void clearTrackTimer() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        SensorsDataAPI.this.mTrackTimer.clear();
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void deleteAll() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.mMessages.deleteAll();
            }
        });
    }

    public void disableAutoTrack(List<AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (AbstractSensorsDataAPI.mSAConfigOptions.mAutoTrackEventType != 0) {
                    for (AutoTrackEventType next : list) {
                        int access$000 = AbstractSensorsDataAPI.mSAConfigOptions.mAutoTrackEventType | next.eventValue;
                        SAConfigOptions sAConfigOptions = AbstractSensorsDataAPI.mSAConfigOptions;
                        int i11 = sAConfigOptions.mAutoTrackEventType;
                        if (access$000 == i11) {
                            sAConfigOptions.setAutoTrackEventType(next.eventValue ^ i11);
                        }
                    }
                    if (AbstractSensorsDataAPI.mSAConfigOptions.mAutoTrackEventType == 0) {
                        this.mAutoTrack = false;
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void enableAutoTrack(List<AutoTrackEventType> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.mAutoTrack = true;
                    for (AutoTrackEventType access$000 : list) {
                        SAConfigOptions sAConfigOptions = AbstractSensorsDataAPI.mSAConfigOptions;
                        sAConfigOptions.setAutoTrackEventType(access$000.eventValue | sAConfigOptions.mAutoTrackEventType);
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void enableAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.enableAutoTrackFragment(cls);
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.enableAutoTrackFragments(list);
    }

    @Deprecated
    public void enableDataCollect() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    if (!AbstractSensorsDataAPI.mSAConfigOptions.isDataCollectEnable) {
                        SensorsDataAPI.this.mContext.getContentResolver().notifyChange(DbParams.getInstance().getDataCollectUri(), (ContentObserver) null);
                    }
                    AbstractSensorsDataAPI.mSAConfigOptions.isDataCollectEnable = true;
                    AbstractSensorsDataAPI.mIsMainProcess = AppInfoUtils.isMainProcess(SensorsDataAPI.this.mContext, (Bundle) null);
                    SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                    sensorsDataAPI.mUserIdentityAPI.enableDataCollect(sensorsDataAPI.mSAContextManager.getAndroidId());
                    SensorsDataAPI.this.mTrackTaskManager.setDataCollectEnable(true);
                    if (SensorsDataAPI.this.mFirstDay.get() == null) {
                        SensorsDataAPI.this.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), "yyyy-MM-dd"));
                    }
                    try {
                        TrackMonitor.getInstance().callEnableDataCollect();
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
            flush();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void enableDeepLinkInstallSource(boolean z11) {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().enableDeepLinkInstallSource(z11);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void enableLog(boolean z11) {
        SALog.setEnableLog(z11);
    }

    public void enableNetworkRequest(boolean z11) {
        this.mEnableNetworkRequest = z11;
    }

    public void enableTrackScreenOrientation(boolean z11) {
        if (z11) {
            try {
                if (this.mOrientationDetector == null) {
                    this.mOrientationDetector = new SensorsDataScreenOrientationDetector(this.mContext, 3);
                }
                this.mOrientationDetector.enable();
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        } else {
            SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector = this.mOrientationDetector;
            if (sensorsDataScreenOrientationDetector != null) {
                sensorsDataScreenOrientationDetector.disable();
                this.mOrientationDetector = null;
            }
        }
    }

    public void flush() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.mMessages.flush();
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void flushScheduled() {
        try {
            this.mMessages.flushScheduled();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void flushSync() {
        flush();
    }

    public String getAnonymousId() {
        try {
            return this.mUserIdentityAPI.getAnonymousId();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public String getCookie(boolean z11) {
        if (!z11) {
            return this.mCookie;
        }
        try {
            return URLDecoder.decode(this.mCookie, "UTF-8");
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ DebugMode getDebugMode() {
        return super.getDebugMode();
    }

    public String getDistinctId() {
        try {
            return this.mUserIdentityAPI.getDistinctId();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public int getFlushBulkSize() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mFlushBulkSize;
    }

    public int getFlushInterval() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mFlushInterval;
    }

    public int getFlushNetworkPolicy() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mNetworkTypePolicy;
    }

    public JSONObject getIdentities() {
        return this.mUserIdentityAPI.getIdentities();
    }

    public List<Class> getIgnoredViewTypeList() {
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new ArrayList();
        }
        return this.mIgnoredViewTypeList;
    }

    public JSONObject getLastScreenTrackProperties() {
        return this.mLastScreenTrackProperties;
    }

    public String getLastScreenUrl() {
        return this.mLastScreenUrl;
    }

    public String getLoginId() {
        try {
            return this.mUserIdentityAPI.getLoginId();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public long getMaxCacheSize() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mMaxCacheSize;
    }

    public JSONObject getPresetProperties() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = this.mSAContextManager.getPresetProperties();
            jSONObject.put("$is_first_day", isFirstDay(System.currentTimeMillis()));
            return jSONObject;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return jSONObject;
        }
    }

    public /* bridge */ /* synthetic */ BaseSensorsDataSDKRemoteManager getRemoteManager() {
        return super.getRemoteManager();
    }

    public /* bridge */ /* synthetic */ SAContextManager getSAContextManager() {
        return super.getSAContextManager();
    }

    public String getSDKVersion() {
        return "6.3.5";
    }

    public String getScreenOrientation() {
        try {
            SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector = this.mOrientationDetector;
            if (sensorsDataScreenOrientationDetector != null) {
                return sensorsDataScreenOrientationDetector.getOrientation();
            }
            return null;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ SensorsDataEncrypt getSensorsDataEncrypt() {
        return super.getSensorsDataEncrypt();
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    public int getSessionIntervalTime() {
        return this.mSessionTime;
    }

    public JSONObject getSuperProperties() {
        JSONObject jSONObject;
        synchronized (this.mSuperProperties) {
            try {
                jSONObject = new JSONObject(((JSONObject) this.mSuperProperties.get()).toString());
            } catch (JSONException e11) {
                SALog.printStackTrace(e11);
                return new JSONObject();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jSONObject;
    }

    public void identify(final String str) {
        try {
            SADataHelper.assertDistinctId(str);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mUserIdentityAPI.identify(str);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            for (Class next : list) {
                if (next != null) {
                    int hashCode = next.hashCode();
                    if (!this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                        this.mAutoTrackIgnoredActivities.add(Integer.valueOf(hashCode));
                    }
                }
            }
        }
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                int hashCode = cls.hashCode();
                if (!this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.add(Integer.valueOf(hashCode));
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.ignoreAutoTrackFragment(cls);
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.ignoreAutoTrackFragments(list);
    }

    public void ignoreView(View view) {
        if (view != null) {
            view.setTag(R.id.sensors_analytics_tag_view_ignored, "1");
        }
    }

    public void ignoreViewType(Class cls) {
        if (cls != null) {
            if (this.mIgnoredViewTypeList == null) {
                this.mIgnoredViewTypeList = new ArrayList();
            }
            if (!this.mIgnoredViewTypeList.contains(cls)) {
                this.mIgnoredViewTypeList.add(cls);
            }
        }
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        List<Integer> list = this.mAutoTrackIgnoredActivities;
        if ((list != null && list.contains(Integer.valueOf(cls.hashCode()))) || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
            return true;
        }
        if (cls.getAnnotation(SensorsDataIgnoreTrackAppClick.class) != null) {
            return true;
        }
        return false;
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        List<Integer> list = this.mAutoTrackIgnoredActivities;
        if ((list != null && list.contains(Integer.valueOf(cls.hashCode()))) || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
            return true;
        }
        if (cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreen.class) != null) {
            return true;
        }
        return false;
    }

    public boolean isAutoTrackEnabled() {
        Boolean isAutoTrackEnabled;
        if (AbstractSensorsDataAPI.isSDKDisabled()) {
            return false;
        }
        BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager = this.mRemoteManager;
        if (baseSensorsDataSDKRemoteManager == null || (isAutoTrackEnabled = baseSensorsDataSDKRemoteManager.isAutoTrackEnabled()) == null) {
            return this.mAutoTrack;
        }
        return isAutoTrackEnabled.booleanValue();
    }

    public boolean isAutoTrackEventTypeIgnored(AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType == null) {
            return false;
        }
        return isAutoTrackEventTypeIgnored(autoTrackEventType.eventValue);
    }

    public boolean isDebugMode() {
        return this.mDebugMode.isDebugMode();
    }

    public /* bridge */ /* synthetic */ boolean isDisableDefaultRemoteConfig() {
        return super.isDisableDefaultRemoteConfig();
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        return this.mFragmentAPI.isFragmentAutoTrackAppViewScreen(cls);
    }

    public boolean isHeatMapActivity(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            return this.mHeatMapActivities.size() == 0 || this.mHeatMapActivities.contains(Integer.valueOf(cls.hashCode()));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public boolean isHeatMapEnabled() {
        return AbstractSensorsDataAPI.mSAConfigOptions.mHeatMapEnabled;
    }

    public boolean isNetworkRequestEnable() {
        return this.mEnableNetworkRequest;
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mFragmentAPI.isTrackFragmentAppViewScreenEnabled();
    }

    public boolean isVisualizedAutoTrackActivity(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            return this.mVisualizedAutoTrackActivities.size() == 0 || this.mVisualizedAutoTrackActivities.contains(Integer.valueOf(cls.hashCode()));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public boolean isVisualizedAutoTrackEnabled() {
        SAConfigOptions sAConfigOptions = AbstractSensorsDataAPI.mSAConfigOptions;
        return sAConfigOptions.mVisualizedEnabled || sAConfigOptions.mVisualizedPropertiesEnabled;
    }

    public void itemDelete(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.trackItemEvent(str, str2, EventType.ITEM_DELETE.getEventType(), System.currentTimeMillis(), (JSONObject) null);
            }
        });
    }

    public void itemSet(final String str, final String str2, JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.trackItemEvent(str, str2, EventType.ITEM_SET.getEventType(), System.currentTimeMillis(), cloneJsonObject);
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void login(String str) {
        login(str, (JSONObject) null);
    }

    public void loginWithKey(String str, String str2) {
        loginWithKey(str, str2, (JSONObject) null);
    }

    public void logout() {
        synchronized (this.mLoginIdLock) {
            this.mUserIdentityAPI.updateLoginId((String) null, (String) null);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.mUserIdentityAPI.logout();
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        }
    }

    public void profileAppend(final String str, final String str2) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, jSONArray);
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_APPEND, (String) null, jSONObject, (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profileDelete() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_DELETE, (String) null, (JSONObject) null, (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profileIncrement(final Map<String, ? extends Number> map) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_INCREMENT, (String) null, new JSONObject(map), (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profilePushId(final String str, final String str2) {
        transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    if (SADataHelper.assertPropertyKey(str)) {
                        String str = SensorsDataAPI.this.getDistinctId() + str2;
                        if (!TextUtils.equals(DbAdapter.getInstance().getPushId("distinctId_" + str), str)) {
                            SensorsDataAPI.this.profileSet(str, str2);
                            DbAdapter.getInstance().commitPushID("distinctId_" + str, str);
                        }
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profileSet(JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET, (String) null, cloneJsonObject, (String) null);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void profileSetOnce(JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET_ONCE, (String) null, cloneJsonObject, (String) null);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void profileUnset(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_UNSET, (String) null, new JSONObject().put(str, true), (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profileUnsetPushId(final String str) {
        transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    if (SADataHelper.assertPropertyKey(str)) {
                        String distinctId = SensorsDataAPI.this.getDistinctId();
                        String str = "distinctId_" + str;
                        String pushId = DbAdapter.getInstance().getPushId(str);
                        if (!TextUtils.isEmpty(pushId) && pushId.startsWith(distinctId)) {
                            SensorsDataAPI.this.profileUnset(str);
                            DbAdapter.getInstance().removePushId(str);
                        }
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void registerDynamicSuperProperties(SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
        this.mDynamicSuperPropertiesCallBack = sensorsDataDynamicSuperProperties;
    }

    public void registerSuperProperties(JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (cloneJsonObject != null) {
                            synchronized (SensorsDataAPI.this.mSuperProperties) {
                                SensorsDataAPI.this.mSuperProperties.commit(SensorsDataUtils.mergeSuperJSONObject(cloneJsonObject, (JSONObject) SensorsDataAPI.this.mSuperProperties.get()));
                            }
                        }
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public /* bridge */ /* synthetic */ void removeEventListener(SAEventListener sAEventListener) {
        super.removeEventListener(sAEventListener);
    }

    public /* bridge */ /* synthetic */ void removeFunctionListener(SAFunctionListener sAFunctionListener) {
        super.removeFunctionListener(sAFunctionListener);
    }

    public /* bridge */ /* synthetic */ void removeSAJSListener(SAJSListener sAJSListener) {
        super.removeSAJSListener(sAJSListener);
    }

    public void removeTimer(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertEventName(str);
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        SensorsDataAPI.this.mTrackTimer.remove(str);
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void requestDeferredDeepLink(JSONObject jSONObject) {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().requestDeferredDeepLink(jSONObject);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void resetAnonymousId() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    SensorsDataAPI.this.mUserIdentityAPI.resetAnonymousId();
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void resumeAutoTrackActivities(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                for (Class next : list) {
                    if (next != null) {
                        int hashCode = next.hashCode();
                        if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                            this.mAutoTrackIgnoredActivities.remove(Integer.valueOf(hashCode));
                        }
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void resumeAutoTrackActivity(Class<?> cls) {
        if (cls != null) {
            if (this.mAutoTrackIgnoredActivities == null) {
                this.mAutoTrackIgnoredActivities = new ArrayList();
            }
            try {
                int hashCode = cls.hashCode();
                if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(hashCode))) {
                    this.mAutoTrackIgnoredActivities.remove(Integer.valueOf(hashCode));
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragment(cls);
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
        this.mFragmentAPI.resumeIgnoredAutoTrackFragments(list);
    }

    public void resumeTrackScreenOrientation() {
        try {
            SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector = this.mOrientationDetector;
            if (sensorsDataScreenOrientationDetector != null) {
                sensorsDataScreenOrientationDetector.enable();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void setCookie(String str, boolean z11) {
        if (z11) {
            try {
                this.mCookie = URLEncoder.encode(str, "UTF-8");
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        } else {
            this.mCookie = str;
        }
    }

    public /* bridge */ /* synthetic */ void setDebugMode(DebugMode debugMode) {
        super.setDebugMode(debugMode);
    }

    @Deprecated
    public void setDeepLinkCallback(SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().setDeepLinkCallback(sensorsDataDeepLinkCallback);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void setDeepLinkCompletion(SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        if (sensorsDataDeferredDeepLinkCallback != null && SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().setDeepLinkCompletion(sensorsDataDeferredDeepLinkCallback);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void setFlushBulkSize(int i11) {
        if (i11 < 0) {
            SALog.i(AbstractSensorsDataAPI.TAG, "The value of flushBulkSize is invalid");
        }
        AbstractSensorsDataAPI.mSAConfigOptions.setFlushBulkSize(i11);
    }

    public void setFlushInterval(int i11) {
        AbstractSensorsDataAPI.mSAConfigOptions.setFlushInterval(i11);
    }

    public void setFlushNetworkPolicy(int i11) {
        AbstractSensorsDataAPI.mSAConfigOptions.setNetworkTypePolicy(i11);
    }

    public void setGPSLocation(double d11, double d12) {
        setGPSLocation(d11, d12, (String) null);
    }

    public void setMaxCacheSize(long j11) {
        AbstractSensorsDataAPI.mSAConfigOptions.setMaxCacheSize(j11);
    }

    public /* bridge */ /* synthetic */ void setRemoteManager(BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        super.setRemoteManager(baseSensorsDataSDKRemoteManager);
    }

    public void setServerUrl(String str) {
        setServerUrl(str, false);
    }

    public void setSessionIntervalTime(int i11) {
        if (DbAdapter.getInstance() == null) {
            SALog.i(AbstractSensorsDataAPI.TAG, "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
        } else if (i11 < 10000 || i11 > 300000) {
            SALog.i(AbstractSensorsDataAPI.TAG, "SessionIntervalTime:" + i11 + " is invalid, session interval time is between 10s and 300s.");
        } else if (i11 != this.mSessionTime) {
            this.mSessionTime = i11;
            DbAdapter.getInstance().commitSessionIntervalTime(i11);
        }
    }

    public void setTrackEventCallBack(SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
        this.mTrackEventCallBack = sensorsDataTrackEventCallBack;
    }

    public void setViewActivity(View view, Activity activity) {
        if (view != null && activity != null) {
            try {
                view.setTag(R.id.sensors_analytics_tag_view_activity, activity);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void setViewFragmentName(View view, String str) {
        if (view != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    view.setTag(R.id.sensors_analytics_tag_view_fragment_name2, str);
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void setViewID(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            view.setTag(R.id.sensors_analytics_tag_view_id, str);
        }
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
        if (view != null && jSONObject != null) {
            view.setTag(R.id.sensors_analytics_tag_view_properties, jSONObject);
        }
    }

    public void showUpWebView(WebView webView, boolean z11) {
        showUpWebView(webView, z11, (JSONObject) null);
    }

    @Deprecated
    public void showUpX5WebView(Object obj, JSONObject jSONObject, boolean z11, boolean z12) {
        Method method;
        try {
            if (Build.VERSION.SDK_INT < 17 && !z11) {
                SALog.d(AbstractSensorsDataAPI.TAG, "For applications targeted to API level JELLY_BEAN or below, this feature NOT SUPPORTED");
            } else if (obj != null && (method = obj.getClass().getMethod("addJavascriptInterface", new Class[]{Object.class, String.class})) != null) {
                method.invoke(obj, new Object[]{new AppWebViewInterface(this.mContext, jSONObject, z12), "SensorsData_APP_JS_Bridge"});
                SensorsDataAutoTrackHelper.addWebViewVisualInterface((View) obj);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void startTrackThread() {
        TrackTaskManagerThread trackTaskManagerThread = this.mTrackTaskManagerThread;
        if (trackTaskManagerThread == null || trackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread = new TrackTaskManagerThread();
            new Thread(this.mTrackTaskManagerThread).start();
            SALog.i(AbstractSensorsDataAPI.TAG, "Data collection thread has been started");
        }
    }

    public void stopTrackScreenOrientation() {
        try {
            SensorsDataScreenOrientationDetector sensorsDataScreenOrientationDetector = this.mOrientationDetector;
            if (sensorsDataScreenOrientationDetector != null) {
                sensorsDataScreenOrientationDetector.disable();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void stopTrackThread() {
        TrackTaskManagerThread trackTaskManagerThread = this.mTrackTaskManagerThread;
        if (trackTaskManagerThread != null && !trackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread.stop();
            SALog.i(AbstractSensorsDataAPI.TAG, "Data collection thread has been stopped");
        }
    }

    public void track(final String str, JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            final JSONObject dynamicProperty = getDynamicProperty();
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    JSONObject jSONObject = cloneJsonObject;
                    if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
                        jSONObject = SAModuleManager.getInstance().getAdvertModuleService().mergeChannelEventProperties(str, cloneJsonObject);
                    }
                    SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                    sensorsDataAPI.trackEvent(EventType.TRACK, str, jSONObject, dynamicProperty, sensorsDataAPI.getDistinctId(), SensorsDataAPI.this.getLoginId(), (String) null);
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void trackAppInstall(JSONObject jSONObject, boolean z11) {
        trackInstallation("$AppInstall", jSONObject, z11);
    }

    public /* bridge */ /* synthetic */ void trackAutoEvent(String str, JSONObject jSONObject) {
        super.trackAutoEvent(str, jSONObject);
    }

    public void trackChannelEvent(String str) {
        trackChannelEvent(str, (JSONObject) null);
    }

    public void trackDeepLinkLaunch(String str) {
        trackDeepLinkLaunch(str, (String) null);
    }

    public void trackEventFromH5(String str, boolean z11) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z11) {
                    String optString = jSONObject.optString("server_url");
                    if (TextUtils.isEmpty(optString) || !new ServerUrl(optString).check(new ServerUrl(this.mServerUrl))) {
                        return;
                    }
                }
                trackEventFromH5(str);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void trackFragmentAppViewScreen() {
        this.mFragmentAPI.trackFragmentAppViewScreen();
    }

    public void trackInstallation(String str, JSONObject jSONObject, boolean z11) {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().trackInstallation(str, jSONObject, z11);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public /* bridge */ /* synthetic */ void trackInternal(String str, JSONObject jSONObject) {
        super.trackInternal(str, jSONObject);
    }

    @Deprecated
    public void trackTimer(String str, TimeUnit timeUnit) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final String str2 = str;
        final TimeUnit timeUnit2 = timeUnit;
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SADataHelper.assertEventName(str2);
                    synchronized (SensorsDataAPI.this.mTrackTimer) {
                        SensorsDataAPI.this.mTrackTimer.put(str2, new EventTimer(timeUnit2, elapsedRealtime));
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void trackTimerEnd(String str, JSONObject jSONObject) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            final String str2 = str;
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    if (str2 != null) {
                        synchronized (SensorsDataAPI.this.mTrackTimer) {
                            EventTimer eventTimer = SensorsDataAPI.this.mTrackTimer.get(str2);
                            if (eventTimer != null) {
                                eventTimer.setEndTime(elapsedRealtime);
                            }
                        }
                    }
                    try {
                        JSONObject jSONObject = cloneJsonObject;
                        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
                            jSONObject = SAModuleManager.getInstance().getAdvertModuleService().mergeChannelEventProperties(str2, cloneJsonObject);
                        }
                        SensorsDataAPI.this.trackEvent(EventType.TRACK, str2, jSONObject, (String) null);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void trackTimerPause(String str) {
        trackTimerState(str, true);
    }

    public void trackTimerResume(String str) {
        trackTimerState(str, false);
    }

    public String trackTimerStart(String str) {
        try {
            String format = String.format("%s_%s_%s", new Object[]{str, UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_"), "SATimer"});
            TimeUnit timeUnit = TimeUnit.SECONDS;
            trackTimer(format, timeUnit);
            trackTimer(str, timeUnit);
            return format;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return "";
        }
    }

    public void trackViewAppClick(View view) {
        trackViewAppClick(view, (JSONObject) null);
    }

    @Deprecated
    public void trackViewScreen(final String str, JSONObject jSONObject) {
        try {
            final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (!TextUtils.isEmpty(str) || cloneJsonObject != null) {
                            String str = str;
                            JSONObject jSONObject = new JSONObject();
                            SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                            sensorsDataAPI.mLastScreenTrackProperties = cloneJsonObject;
                            String str2 = sensorsDataAPI.mLastScreenUrl;
                            if (str2 != null) {
                                jSONObject.put("$referrer", str2);
                            }
                            SensorsDataAPI sensorsDataAPI2 = SensorsDataAPI.this;
                            sensorsDataAPI2.mReferrerScreenTitle = sensorsDataAPI2.mCurrentScreenTitle;
                            JSONObject jSONObject2 = cloneJsonObject;
                            if (jSONObject2 != null) {
                                if (jSONObject2.has(AopConstants.TITLE)) {
                                    SensorsDataAPI.this.mCurrentScreenTitle = cloneJsonObject.getString(AopConstants.TITLE);
                                } else {
                                    SensorsDataAPI.this.mCurrentScreenTitle = null;
                                }
                                if (cloneJsonObject.has("$url")) {
                                    str = cloneJsonObject.optString("$url");
                                }
                            }
                            jSONObject.put("$url", str);
                            SensorsDataAPI.this.mLastScreenUrl = str;
                            JSONObject jSONObject3 = cloneJsonObject;
                            if (jSONObject3 != null) {
                                SensorsDataUtils.mergeJSONObject(jSONObject3, jSONObject);
                            }
                            SensorsDataAPI.this.trackEvent(EventType.TRACK, "$AppViewScreen", jSONObject, (String) null);
                        }
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public /* bridge */ /* synthetic */ void transformTaskQueue(Runnable runnable) {
        super.transformTaskQueue(runnable);
    }

    public void unbind(final String str, final String str2) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (SensorsDataAPI.this.mUserIdentityAPI.unbindBack(str, str2)) {
                            SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                            sensorsDataAPI.trackEvent(EventType.TRACK_ID_UNBIND, IUserIdentityAPI.UNBIND_ID, (JSONObject) null, sensorsDataAPI.getAnonymousId());
                        }
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void unregisterSuperProperty(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    synchronized (SensorsDataAPI.this.mSuperProperties) {
                        JSONObject jSONObject = (JSONObject) SensorsDataAPI.this.mSuperProperties.get();
                        jSONObject.remove(str);
                        SensorsDataAPI.this.mSuperProperties.commit(jSONObject);
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public SensorsDataAPI(Context context, SAConfigOptions sAConfigOptions, DebugMode debugMode) {
        super(context, sAConfigOptions, debugMode);
    }

    public void ignoreView(View view, boolean z11) {
        if (view != null) {
            view.setTag(R.id.sensors_analytics_tag_view_ignored, z11 ? "1" : "0");
        }
    }

    public boolean isAutoTrackEventTypeIgnored(int i11) {
        Boolean isAutoTrackEventTypeIgnored;
        BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager = this.mRemoteManager;
        if (baseSensorsDataSDKRemoteManager == null || (isAutoTrackEventTypeIgnored = baseSensorsDataSDKRemoteManager.isAutoTrackEventTypeIgnored(i11)) == null) {
            int i12 = AbstractSensorsDataAPI.mSAConfigOptions.mAutoTrackEventType;
            return (i11 | i12) != i12;
        }
        if (isAutoTrackEventTypeIgnored.booleanValue()) {
            SALog.i(AbstractSensorsDataAPI.TAG, "remote config: " + AutoTrackEventType.autoTrackEventName(i11) + " is ignored by remote config");
        }
        return isAutoTrackEventTypeIgnored.booleanValue();
    }

    public void login(String str, JSONObject jSONObject) {
        loginWithKey(LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str, jSONObject);
    }

    public void loginWithKey(final String str, final String str2, JSONObject jSONObject) {
        try {
            if (SensorsDataContentObserver.isLoginFromObserver) {
                SensorsDataContentObserver.isLoginFromObserver = false;
                return;
            }
            synchronized (this.mLoginIdLock) {
                final JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
                if (!LoginIDAndKey.isInValidLogin(str, str2, this.mUserIdentityAPI.getIdentitiesInstance().getLoginIDKey(), this.mUserIdentityAPI.getIdentitiesInstance().getLoginId(), getAnonymousId())) {
                    this.mUserIdentityAPI.updateLoginId(str, str2);
                }
                this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                    public void run() {
                        try {
                            if (SensorsDataAPI.this.mUserIdentityAPI.loginWithKeyBack(str, str2)) {
                                SensorsDataAPI sensorsDataAPI = SensorsDataAPI.this;
                                sensorsDataAPI.trackEvent(EventType.TRACK_SIGNUP, "$SignUp", cloneJsonObject, sensorsDataAPI.getAnonymousId());
                            }
                        } catch (Exception e11) {
                            SALog.printStackTrace(e11);
                        }
                    }
                });
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void profileAppend(final String str, final Set<String> set) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : set) {
                        jSONArray.put(put);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, jSONArray);
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_APPEND, (String) null, jSONObject, (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profileIncrement(final String str, final Number number) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_INCREMENT, (String) null, new JSONObject().put(str, number), (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void setGPSLocation(double d11, double d12, String str) {
        try {
            final double d13 = d11;
            final double d14 = d12;
            final String str2 = str;
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    try {
                        if (AbstractSensorsDataAPI.mGPSLocation == null) {
                            AbstractSensorsDataAPI.mGPSLocation = new SensorsDataGPSLocation();
                        }
                        AbstractSensorsDataAPI.mGPSLocation.setLatitude((long) (d13 * Math.pow(10.0d, 6.0d)));
                        AbstractSensorsDataAPI.mGPSLocation.setLongitude((long) (d14 * Math.pow(10.0d, 6.0d)));
                        AbstractSensorsDataAPI.mGPSLocation.setCoordinate(SADataHelper.assertPropertyValue(str2));
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void setServerUrl(final String str, boolean z11) {
        int lastIndexOf;
        if (z11) {
            try {
                BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager = this.mRemoteManager;
                if (baseSensorsDataSDKRemoteManager != null) {
                    try {
                        baseSensorsDataSDKRemoteManager.requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            } catch (Exception e12) {
                SALog.printStackTrace(e12);
                return;
            }
        }
        if (!TextUtils.equals(str, this.mOriginServerUrl) && AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
            try {
                VisualPropertiesManager.getInstance().requestVisualConfig();
            } catch (Exception e13) {
                SALog.printStackTrace(e13);
            }
        }
        this.mOriginServerUrl = str;
        if (TextUtils.isEmpty(str)) {
            this.mServerUrl = str;
            SALog.i(AbstractSensorsDataAPI.TAG, "Server url is null or empty.");
            return;
        }
        final Uri parse = Uri.parse(str);
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                String host = parse.getHost();
                if (!TextUtils.isEmpty(host) && host.contains("_")) {
                    SALog.i(AbstractSensorsDataAPI.TAG, "Server url " + str + " contains '_' is not recommend，see details: https://en.wikipedia.org/wiki/Hostname");
                }
            }
        });
        if (this.mDebugMode != DebugMode.DEBUG_OFF) {
            String path = parse.getPath();
            if (!TextUtils.isEmpty(path) && (lastIndexOf = path.lastIndexOf(47)) != -1) {
                this.mServerUrl = parse.buildUpon().path(path.substring(0, lastIndexOf) + "/debug").build().toString();
                return;
            }
            return;
        }
        this.mServerUrl = str;
    }

    public void showUpWebView(WebView webView, boolean z11, boolean z12) {
        showUpWebView(webView, (JSONObject) null, z11, z12);
    }

    public void trackAppInstall(JSONObject jSONObject) {
        trackAppInstall(jSONObject, false);
    }

    public void trackChannelEvent(String str, JSONObject jSONObject) {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().trackChannelEvent(str, jSONObject);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void trackDeepLinkLaunch(String str, String str2) {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            try {
                SAModuleManager.getInstance().getAdvertModuleService().trackDeepLinkLaunch(str, str2);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public /* bridge */ /* synthetic */ void trackInternal(String str, JSONObject jSONObject, ViewNode viewNode) {
        super.trackInternal(str, jSONObject, viewNode);
    }

    public void trackViewAppClick(View view, JSONObject jSONObject) {
        if (view != null) {
            try {
                JSONObject cloneJsonObject = JSONUtils.cloneJsonObject(jSONObject);
                if (cloneJsonObject == null) {
                    cloneJsonObject = new JSONObject();
                }
                if (AopUtil.injectClickInfo(view, cloneJsonObject, true)) {
                    trackInternal(AopConstants.APP_CLICK_EVENT_NAME, cloneJsonObject, AopUtil.addViewPathProperties(AopUtil.getActivityFromContext(view.getContext(), view), view, cloneJsonObject));
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void setViewID(Dialog dialog, String str) {
        if (dialog != null) {
            try {
                if (!TextUtils.isEmpty(str) && dialog.getWindow() != null) {
                    dialog.getWindow().getDecorView().setTag(R.id.sensors_analytics_tag_view_id, str);
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    @Deprecated
    public void showUpWebView(WebView webView, JSONObject jSONObject, boolean z11, boolean z12) {
        if (Build.VERSION.SDK_INT < 17 && !z11) {
            SALog.d(AbstractSensorsDataAPI.TAG, "For applications targeted to API level JELLY_BEAN or below, this feature NOT SUPPORTED");
        } else if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new AppWebViewInterface(this.mContext, jSONObject, z12, webView), "SensorsData_APP_JS_Bridge");
            SensorsDataAutoTrackHelper.addWebViewVisualInterface(webView);
        }
    }

    public void trackAppInstall() {
        trackAppInstall((JSONObject) null, false);
    }

    public void profileSet(final String str, final Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET, (String) null, new JSONObject().put(str, obj), (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void profileSetOnce(final String str, final Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    SensorsDataAPI.this.trackEvent(EventType.PROFILE_SET_ONCE, (String) null, new JSONObject().put(str, obj), (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void trackInstallation(String str, JSONObject jSONObject) {
        trackInstallation(str, jSONObject, false);
    }

    public void trackViewScreen(final Activity activity) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    Activity activity = activity;
                    if (activity != null) {
                        SensorsDataAPI.this.trackViewScreen(SensorsDataUtils.getScreenUrl(activity), AopUtil.buildTitleAndScreenName(activity));
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void track(String str) {
        track(str, (JSONObject) null);
    }

    public void trackInstallation(String str) {
        trackInstallation(str, (JSONObject) null, false);
    }

    public void trackTimerEnd(String str) {
        trackTimerEnd(str, (JSONObject) null);
    }

    public void trackViewScreen(final Object obj) {
        Class<?> cls;
        Class<?> cls2;
        if (obj != null) {
            Class<?> cls3 = null;
            try {
                cls = Class.forName("androidx.fragment.app.Fragment");
            } catch (Exception unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName("android.app.Fragment");
            } catch (Exception unused2) {
                cls2 = null;
            }
            try {
                cls3 = Class.forName("androidx.fragment.app.Fragment");
            } catch (Exception unused3) {
            }
            if ((cls != null && cls.isInstance(obj)) || ((cls2 != null && cls2.isInstance(obj)) || (cls3 != null && cls3.isInstance(obj)))) {
                this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001e, code lost:
                        r2 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r5.getClass().getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class);
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r8 = this;
                            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a7 }
                            r0.<init>()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r1 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r1 = r1.getCanonicalName()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r2 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r3 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
                            boolean r2 = r2.isAnnotationPresent(r3)     // Catch:{ Exception -> 0x00a7 }
                            r3 = 0
                            if (r2 == 0) goto L_0x0033
                            java.lang.Object r2 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class<com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle> r4 = com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle.class
                            java.lang.annotation.Annotation r2 = r2.getAnnotation(r4)     // Catch:{ Exception -> 0x00a7 }
                            com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle r2 = (com.sensorsdata.analytics.android.sdk.SensorsDataFragmentTitle) r2     // Catch:{ Exception -> 0x00a7 }
                            if (r2 == 0) goto L_0x0033
                            java.lang.String r2 = r2.title()     // Catch:{ Exception -> 0x00a7 }
                            goto L_0x0034
                        L_0x0033:
                            r2 = r3
                        L_0x0034:
                            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00a7 }
                            r5 = 11
                            if (r4 < r5) goto L_0x007a
                            r4 = 0
                            java.lang.Object r5 = r5     // Catch:{ Exception -> 0x0056 }
                            java.lang.Class r5 = r5.getClass()     // Catch:{ Exception -> 0x0056 }
                            java.lang.String r6 = "getActivity"
                            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0056 }
                            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch:{ Exception -> 0x0056 }
                            if (r5 == 0) goto L_0x0056
                            java.lang.Object r6 = r5     // Catch:{ Exception -> 0x0056 }
                            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0056 }
                            java.lang.Object r5 = r5.invoke(r6, r7)     // Catch:{ Exception -> 0x0056 }
                            android.app.Activity r5 = (android.app.Activity) r5     // Catch:{ Exception -> 0x0056 }
                            r3 = r5
                        L_0x0056:
                            if (r3 == 0) goto L_0x007a
                            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a7 }
                            if (r5 == 0) goto L_0x0062
                            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getActivityTitle(r3)     // Catch:{ Exception -> 0x00a7 }
                        L_0x0062:
                            java.util.Locale r5 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r6 = "%s|%s"
                            r7 = 2
                            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Class r3 = r3.getClass()     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r3 = r3.getCanonicalName()     // Catch:{ Exception -> 0x00a7 }
                            r7[r4] = r3     // Catch:{ Exception -> 0x00a7 }
                            r3 = 1
                            r7[r3] = r1     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r1 = java.lang.String.format(r5, r6, r7)     // Catch:{ Exception -> 0x00a7 }
                        L_0x007a:
                            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a7 }
                            if (r3 != 0) goto L_0x0085
                            java.lang.String r3 = "$title"
                            r0.put(r3, r2)     // Catch:{ Exception -> 0x00a7 }
                        L_0x0085:
                            java.lang.String r2 = "$screen_name"
                            r0.put(r2, r1)     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r1 = r5     // Catch:{ Exception -> 0x00a7 }
                            boolean r2 = r1 instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker     // Catch:{ Exception -> 0x00a7 }
                            if (r2 == 0) goto L_0x009b
                            com.sensorsdata.analytics.android.sdk.ScreenAutoTracker r1 = (com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) r1     // Catch:{ Exception -> 0x00a7 }
                            org.json.JSONObject r1 = r1.getTrackProperties()     // Catch:{ Exception -> 0x00a7 }
                            if (r1 == 0) goto L_0x009b
                            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r1, r0)     // Catch:{ Exception -> 0x00a7 }
                        L_0x009b:
                            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this     // Catch:{ Exception -> 0x00a7 }
                            java.lang.Object r2 = r5     // Catch:{ Exception -> 0x00a7 }
                            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getScreenUrl(r2)     // Catch:{ Exception -> 0x00a7 }
                            r1.trackViewScreen(r2, r0)     // Catch:{ Exception -> 0x00a7 }
                            goto L_0x00ab
                        L_0x00a7:
                            r0 = move-exception
                            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
                        L_0x00ab:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass16.run():void");
                    }
                });
            }
        }
    }

    public void setViewID(Object obj, String str) {
        Class<?> cls;
        Method method;
        Window window;
        if (obj != null) {
            Class<?> cls2 = null;
            try {
                cls = Class.forName("androidx.appcompat.app.AlertDialog");
            } catch (Exception unused) {
                cls = null;
            }
            try {
                cls2 = Class.forName("androidx.appcompat.app.AlertDialog");
            } catch (Exception unused2) {
            }
            if (cls == null) {
                cls = cls2;
            }
            if (cls != null) {
                try {
                    if (cls.isInstance(obj) && !TextUtils.isEmpty(str) && (method = obj.getClass().getMethod("getWindow", new Class[0])) != null && (window = (Window) method.invoke(obj, new Object[0])) != null) {
                        window.getDecorView().setTag(R.id.sensors_analytics_tag_view_id, str);
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
    }

    public void disableAutoTrack(AutoTrackEventType autoTrackEventType) {
        if (autoTrackEventType != null) {
            try {
                int i11 = AbstractSensorsDataAPI.mSAConfigOptions.mAutoTrackEventType;
                if (i11 != 0) {
                    int access$000 = i11 | autoTrackEventType.eventValue;
                    if (access$000 == autoTrackEventType.eventValue) {
                        AbstractSensorsDataAPI.mSAConfigOptions.setAutoTrackEventType(0);
                    } else {
                        AbstractSensorsDataAPI.mSAConfigOptions.setAutoTrackEventType(autoTrackEventType.eventValue ^ access$000);
                    }
                    if (AbstractSensorsDataAPI.mSAConfigOptions.mAutoTrackEventType == 0) {
                        this.mAutoTrack = false;
                    }
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    @Deprecated
    public void showUpWebView(WebView webView, boolean z11, JSONObject jSONObject) {
        showUpWebView(webView, jSONObject, z11, false);
    }

    public void showUpX5WebView(Object obj, boolean z11) {
        if (obj != null) {
            try {
                Method method = obj.getClass().getMethod("addJavascriptInterface", new Class[]{Object.class, String.class});
                if (method != null) {
                    method.invoke(obj, new Object[]{new AppWebViewInterface(this.mContext, (JSONObject) null, z11, (View) obj), "SensorsData_APP_JS_Bridge"});
                    SensorsDataAutoTrackHelper.addWebViewVisualInterface((View) obj);
                }
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public void trackEventFromH5(final String str) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                SensorsDataAPI.this.trackEventH5(str);
            }
        });
    }

    public static SensorsDataAPI sharedInstance() {
        if (AbstractSensorsDataAPI.isSDKDisabled()) {
            return new SensorsDataAPIEmptyImplementation();
        }
        return getSDKInstance();
    }

    public void showUpX5WebView(Object obj) {
        showUpX5WebView(obj, false);
    }
}
