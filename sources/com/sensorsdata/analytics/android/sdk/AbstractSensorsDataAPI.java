package com.sensorsdata.analytics.android.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.jumio.core.cdn.CDNDownload;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.aop.push.PushLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.ActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.ActivityPageLeaveCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.FragmentPageLeaveCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.FragmentViewScreenCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.sensorsdata.analytics.android.sdk.core.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.ModuleConstants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.internal.api.FragmentAPI;
import com.sensorsdata.analytics.android.sdk.internal.api.IFragmentAPI;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.internal.rpc.SensorsDataContentObserver;
import com.sensorsdata.analytics.android.sdk.listener.SAEventListener;
import com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener;
import com.sensorsdata.analytics.android.sdk.listener.SAJSListener;
import com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager;
import com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPresetPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SAContextManager;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sensorsdata.analytics.android.sdk.util.ToastUtil;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import com.sumsub.sns.internal.core.common.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class AbstractSensorsDataAPI implements ISensorsDataAPI {
    public static boolean SHOW_DEBUG_INFO_VIEW = true;
    public static final String TAG = "SA.SensorsDataAPI";
    public static final String VERSION = "6.3.5";
    public static SensorsDataGPSLocation mGPSLocation;
    public static boolean mIsMainProcess = false;
    public static SAConfigOptions mSAConfigOptions;
    public static final Map<Context, SensorsDataAPI> sInstanceMap = new HashMap();
    private boolean isTrackEventWithPluginVersion;
    public ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
    public boolean mAutoTrack;
    public List<Integer> mAutoTrackIgnoredActivities;
    public boolean mClearReferrerWhenAppEnd;
    public final Context mContext;
    public String mCookie;
    public String mCurrentScreenTitle;
    public SensorsDataAPI.DebugMode mDebugMode;
    public boolean mDisableDefaultRemoteConfig;
    public boolean mDisableTrackDeviceId;
    public SensorsDataDynamicSuperProperties mDynamicSuperPropertiesCallBack;
    public boolean mEnableNetworkRequest;
    public final PersistentFirstDay mFirstDay;
    public final PersistentFirstStart mFirstStart;
    public IFragmentAPI mFragmentAPI;
    public List<Integer> mHeatMapActivities;
    public List<Class> mIgnoredViewTypeList;
    public JSONObject mLastScreenTrackProperties;
    public String mLastScreenUrl;
    public final Object mLoginIdLock;
    public AnalyticsMessages mMessages;
    public SensorsDataScreenOrientationDetector mOrientationDetector;
    public String mOriginServerUrl;
    public String mReferrerScreenTitle;
    public BaseSensorsDataSDKRemoteManager mRemoteManager;
    public SAContextManager mSAContextManager;
    private CopyOnWriteArrayList<SAJSListener> mSAJSListeners;
    public boolean mSDKConfigInit;
    public SensorsDataEncrypt mSensorsDataEncrypt;
    public String mServerUrl;
    public int mSessionTime;
    public SAStoreManager mStoreManager;
    public final PersistentSuperProperties mSuperProperties;
    public SensorsDataTrackEventCallBack mTrackEventCallBack;
    public TrackTaskManager mTrackTaskManager;
    public TrackTaskManagerThread mTrackTaskManagerThread;
    public final Map<String, EventTimer> mTrackTimer;
    public UserIdentityAPI mUserIdentityAPI;
    public List<Integer> mVisualizedAutoTrackActivities;

    public AbstractSensorsDataAPI(Context context, SAConfigOptions sAConfigOptions, SensorsDataAPI.DebugMode debugMode) {
        this.mLoginIdLock = new Object();
        this.mIgnoredViewTypeList = new ArrayList();
        SensorsDataAPI.DebugMode debugMode2 = SensorsDataAPI.DebugMode.DEBUG_OFF;
        this.mDebugMode = debugMode2;
        this.mEnableNetworkRequest = true;
        this.mClearReferrerWhenAppEnd = false;
        this.mDisableDefaultRemoteConfig = false;
        this.mDisableTrackDeviceId = false;
        this.mSessionTime = CDNDownload.DEFAULT_TIMEOUT;
        this.isTrackEventWithPluginVersion = false;
        this.mContext = context;
        setDebugMode(debugMode);
        String packageName = context.getApplicationContext().getPackageName();
        this.mAutoTrackIgnoredActivities = new ArrayList();
        this.mHeatMapActivities = new ArrayList();
        this.mVisualizedAutoTrackActivities = new ArrayList();
        PersistentLoader.initLoader(context);
        this.mSuperProperties = (PersistentSuperProperties) PersistentLoader.loadPersistent(DbParams.PersistentName.SUPER_PROPERTIES);
        this.mFirstStart = (PersistentFirstStart) PersistentLoader.loadPersistent(DbParams.PersistentName.FIRST_START);
        PersistentFirstDay persistentFirstDay = (PersistentFirstDay) PersistentLoader.loadPersistent(DbParams.PersistentName.FIRST_DAY);
        this.mFirstDay = persistentFirstDay;
        this.mTrackTimer = new HashMap();
        this.mFragmentAPI = new FragmentAPI();
        try {
            mSAConfigOptions = sAConfigOptions.clone();
            SAStoreManager instance = SAStoreManager.getInstance();
            this.mStoreManager = instance;
            instance.registerPlugins(mSAConfigOptions.getStorePlugins(), context);
            this.mStoreManager.upgrade();
            this.mTrackTaskManager = TrackTaskManager.getInstance();
            this.mTrackTaskManagerThread = new TrackTaskManagerThread();
            new Thread(this.mTrackTaskManagerThread, ThreadNameConstants.THREAD_TASK_QUEUE).start();
            SensorsDataExceptionHandler.init();
            initSAConfig(mSAConfigOptions.mServerUrl, packageName);
            this.mSAContextManager = new SAContextManager(context);
            SAModuleManager.getInstance().installService(context, mSAConfigOptions);
            this.mMessages = AnalyticsMessages.getInstance(context, (SensorsDataAPI) this);
            SensorsDataRemoteManager sensorsDataRemoteManager = new SensorsDataRemoteManager((SensorsDataAPI) this);
            this.mRemoteManager = sensorsDataRemoteManager;
            sensorsDataRemoteManager.applySDKConfigFromCache();
            if (mSAConfigOptions.isVisualizedPropertiesEnabled()) {
                VisualPropertiesManager.getInstance().requestVisualConfig(context, (SensorsDataAPI) this);
            }
            if (this.mDebugMode != debugMode2 && mIsMainProcess && SHOW_DEBUG_INFO_VIEW && !isSDKDisabled()) {
                showDebugModeWarning();
            }
            this.mUserIdentityAPI = new UserIdentityAPI(this.mSAContextManager);
            registerLifecycleCallbacks();
            registerObserver();
            if (!mSAConfigOptions.isDisableSDK()) {
                delayInitTask();
            }
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, String.format(Locale.CHINA, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", new Object[]{this.mServerUrl, Integer.valueOf(mSAConfigOptions.mFlushInterval), debugMode}));
            }
            SensorsDataUtils.initUniAppStatus();
            if (mIsMainProcess && SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME) && persistentFirstDay != null && !TextUtils.isEmpty((CharSequence) persistentFirstDay.get())) {
                SAModuleManager.getInstance().getAdvertModuleService().commitRequestDeferredDeeplink(false);
            }
        } catch (Throwable th2) {
            SALog.d(TAG, th2.getMessage());
        }
        registerDefaultPropertiesPlugin();
    }

    private void getCarrier(JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(jSONObject.optString("$carrier")) && mSAConfigOptions.isDataCollectEnable) {
                String carrier = SensorsDataUtils.getCarrier(this.mContext);
                if (!TextUtils.isEmpty(carrier)) {
                    jSONObject.put("$carrier", carrier);
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static SAConfigOptions getConfigOptions() {
        return mSAConfigOptions;
    }

    private JSONArray getPluginVersion() {
        try {
            if (TextUtils.isEmpty(SensorsDataAPI.ANDROID_PLUGIN_VERSION)) {
                return null;
            }
            SALog.i(TAG, "android plugin version: " + SensorsDataAPI.ANDROID_PLUGIN_VERSION);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("android:" + SensorsDataAPI.ANDROID_PLUGIN_VERSION);
            return jSONArray;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    private boolean isEnterDb(String str, JSONObject jSONObject) {
        boolean z11 = true;
        if (this.mTrackEventCallBack != null) {
            SALog.i(TAG, "SDK have set trackEvent callBack");
            try {
                z11 = this.mTrackEventCallBack.onTrackEvent(str, jSONObject);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
            if (z11) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        Object opt = jSONObject.opt(next);
                        if (opt instanceof Date) {
                            jSONObject.put(next, TimeUtils.formatDate((Date) opt, Locale.CHINA));
                        } else {
                            jSONObject.put(next, opt);
                        }
                    }
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
        }
        return z11;
    }

    private static boolean isSDKDisableByLocal() {
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions != null) {
            return sAConfigOptions.isDisableSDK;
        }
        SALog.i(TAG, "SAConfigOptions is null");
        return true;
    }

    public static boolean isSDKDisabled() {
        return isSDKDisableByLocal() || isSDKDisabledByRemote();
    }

    private static boolean isSDKDisabledByRemote() {
        boolean isSDKDisabledByRemote = BaseSensorsDataSDKRemoteManager.isSDKDisabledByRemote();
        if (isSDKDisabledByRemote) {
            SALog.i(TAG, "remote config: SDK is disabled");
        }
        return isSDKDisabledByRemote;
    }

    private void mergerDynamicAndSuperProperties(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject superProperties = getSuperProperties();
        if (jSONObject2 == null) {
            jSONObject2 = getDynamicProperty();
        }
        SensorsDataUtils.mergeJSONObject(SensorsDataUtils.mergeSuperJSONObject(jSONObject2, superProperties), jSONObject);
    }

    private void registerDefaultPropertiesPlugin() {
        SensorsDataPropertyPluginManager.getInstance().registerPropertyPlugin(new SAPresetPropertyPlugin(this.mContext, this.mDisableTrackDeviceId, mSAConfigOptions.isDisableDeviceId()));
    }

    private void registerLifecycleCallbacks() {
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                Application application = (Application) this.mContext.getApplicationContext();
                application.registerActivityLifecycleCallbacks(AppStateManager.getInstance());
                this.mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks((SensorsDataAPI) this, this.mFirstStart, this.mFirstDay, this.mContext);
                SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mActivityLifecycleCallbacks);
                SensorsDataExceptionHandler.addExceptionListener(this.mActivityLifecycleCallbacks);
                FragmentTrackHelper.addFragmentCallbacks(new FragmentViewScreenCallbacks());
                if (mSAConfigOptions.isTrackPageLeave()) {
                    ActivityPageLeaveCallbacks activityPageLeaveCallbacks = new ActivityPageLeaveCallbacks(mSAConfigOptions.mIgnorePageLeave);
                    SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(activityPageLeaveCallbacks);
                    SensorsDataExceptionHandler.addExceptionListener(activityPageLeaveCallbacks);
                    if (mSAConfigOptions.isTrackFragmentPageLeave()) {
                        FragmentPageLeaveCallbacks fragmentPageLeaveCallbacks = new FragmentPageLeaveCallbacks(mSAConfigOptions.mIgnorePageLeave);
                        FragmentTrackHelper.addFragmentCallbacks(fragmentPageLeaveCallbacks);
                        SensorsDataExceptionHandler.addExceptionListener(fragmentPageLeaveCallbacks);
                    }
                }
                if (mSAConfigOptions.isEnableTrackPush()) {
                    SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(new PushLifecycleCallbacks());
                }
                application.registerActivityLifecycleCallbacks(SensorsDataLifecycleMonitorManager.getInstance().getCallback());
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void registerObserver() {
        SensorsDataContentObserver sensorsDataContentObserver = new SensorsDataContentObserver(this.mUserIdentityAPI);
        ContentResolver contentResolver = this.mContext.getContentResolver();
        contentResolver.registerContentObserver(DbParams.getInstance().getDataCollectUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getSessionTimeUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getLoginIdUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getDisableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getEnableSDKUri(), false, sensorsDataContentObserver);
        contentResolver.registerContentObserver(DbParams.getInstance().getUserIdentities(), false, sensorsDataContentObserver);
    }

    private void showDebugModeWarning() {
        try {
            if (this.mDebugMode != SensorsDataAPI.DebugMode.DEBUG_OFF && !TextUtils.isEmpty(this.mServerUrl)) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        String str;
                        AbstractSensorsDataAPI abstractSensorsDataAPI = AbstractSensorsDataAPI.this;
                        SensorsDataAPI.DebugMode debugMode = abstractSensorsDataAPI.mDebugMode;
                        if (debugMode == SensorsDataAPI.DebugMode.DEBUG_ONLY) {
                            str = "现在您打开了 SensorsData SDK 的 'DEBUG_ONLY' 模式，此模式下只校验数据但不导入数据，数据出错时会以 Toast 的方式提示开发者，请上线前一定使用 DEBUG_OFF 模式。";
                        } else {
                            str = debugMode == SensorsDataAPI.DebugMode.DEBUG_AND_TRACK ? "现在您打开了神策 SensorsData SDK 的 'DEBUG_AND_TRACK' 模式，此模式下校验数据并且导入数据，数据出错时会以 Toast 的方式提示开发者，请上线前一定使用 DEBUG_OFF 模式。" : null;
                        }
                        CharSequence appName = AppInfoUtils.getAppName(abstractSensorsDataAPI.mContext);
                        if (!TextUtils.isEmpty(appName)) {
                            str = String.format(Locale.CHINA, "%s：%s", new Object[]{appName, str});
                        }
                        ToastUtil.showLong(AbstractSensorsDataAPI.this.mContext, str);
                    }
                });
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0259: MOVE  (r8v6 org.json.JSONObject) = (r30v0 org.json.JSONObject)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01ba A[Catch:{ Exception -> 0x01eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[SYNTHETIC, Splitter:B:18:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0384 A[Catch:{ Exception -> 0x038e }, LOOP:0: B:208:0x037e->B:210:0x0384, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0398 A[Catch:{ Exception -> 0x03a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[SYNTHETIC, Splitter:B:36:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC, Splitter:B:66:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016a A[Catch:{ Exception -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017c A[Catch:{ Exception -> 0x01ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018e A[SYNTHETIC, Splitter:B:95:0x018e] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0063=Splitter:B:23:0x0063, B:43:0x009b=Splitter:B:43:0x009b} */
    public void trackEventInternal(com.sensorsdata.analytics.android.sdk.internal.beans.EventType r28, java.lang.String r29, org.json.JSONObject r30, org.json.JSONObject r31, org.json.JSONObject r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer r36) throws org.json.JSONException, com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            java.lang.String r6 = "$sf_internal_login_id"
            java.lang.String r7 = "$sf_internal_anonymous_id"
            java.lang.String r8 = "$time"
            java.lang.String r9 = "$token"
            java.lang.String r10 = "$project"
            long r11 = java.lang.System.currentTimeMillis()
            org.json.JSONObject r13 = new org.json.JSONObject
            r13.<init>()
            java.lang.String r14 = "$AppStart"
            java.lang.String r15 = "$lib_version"
            r17 = r11
            java.lang.String r11 = "$lib_detail"
            java.lang.String r12 = "code"
            java.lang.String r2 = "$app_version"
            r19 = r6
            java.lang.String r6 = "$lib_method"
            java.lang.String r20 = "6.3.5"
            if (r4 == 0) goto L_0x00de
            boolean r0 = r4.has(r11)     // Catch:{ Exception -> 0x0044 }
            if (r0 == 0) goto L_0x0041
            java.lang.String r21 = r4.getString(r11)     // Catch:{ Exception -> 0x0044 }
            r4.remove(r11)     // Catch:{ Exception -> 0x003f }
            goto L_0x004a
        L_0x003f:
            r0 = move-exception
            goto L_0x0047
        L_0x0041:
            r21 = 0
            goto L_0x004a
        L_0x0044:
            r0 = move-exception
            r21 = 0
        L_0x0047:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x004a:
            java.lang.String r0 = "$AppEnd"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x00a6 }
            r22 = r11
            java.lang.String r11 = "event_time"
            if (r0 == 0) goto L_0x0088
            long r23 = r4.optLong(r11)     // Catch:{ Exception -> 0x00a4 }
            r25 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r0 <= 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r23 = r17
        L_0x0063:
            java.lang.String r0 = r4.optString(r15)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r16 = r4.optString(r2)     // Catch:{ Exception -> 0x0086 }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0084 }
            if (r17 != 0) goto L_0x0074
            r20 = r0
            goto L_0x0077
        L_0x0074:
            r4.remove(r15)     // Catch:{ Exception -> 0x0084 }
        L_0x0077:
            boolean r0 = android.text.TextUtils.isEmpty(r16)     // Catch:{ Exception -> 0x0084 }
            if (r0 == 0) goto L_0x0080
            r4.remove(r2)     // Catch:{ Exception -> 0x0084 }
        L_0x0080:
            r4.remove(r11)     // Catch:{ Exception -> 0x0084 }
            goto L_0x00b0
        L_0x0084:
            r0 = move-exception
            goto L_0x00ad
        L_0x0086:
            r0 = move-exception
            goto L_0x00ab
        L_0x0088:
            boolean r0 = r14.equals(r3)     // Catch:{ Exception -> 0x00a4 }
            if (r0 == 0) goto L_0x009f
            long r23 = r4.optLong(r11)     // Catch:{ Exception -> 0x00a4 }
            r25 = 0
            int r0 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r0 <= 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r23 = r17
        L_0x009b:
            r4.remove(r11)     // Catch:{ Exception -> 0x0086 }
            goto L_0x00a1
        L_0x009f:
            r23 = r17
        L_0x00a1:
            r16 = 0
            goto L_0x00b0
        L_0x00a4:
            r0 = move-exception
            goto L_0x00a9
        L_0x00a6:
            r0 = move-exception
            r22 = r11
        L_0x00a9:
            r23 = r17
        L_0x00ab:
            r16 = 0
        L_0x00ad:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x00b0:
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r30, r31)
            boolean r0 = r28.isTrack()
            if (r0 == 0) goto L_0x00d0
            java.lang.String r0 = r4.optString(r6)
            java.lang.String r11 = "autoTrack"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x00c9
            r13.put(r6, r11)
            goto L_0x00d3
        L_0x00c9:
            r13.put(r6, r12)
            r5.put(r6, r12)
            goto L_0x00d3
        L_0x00d0:
            r13.put(r6, r12)
        L_0x00d3:
            r17 = r14
            r6 = r16
            r14 = r20
            r16 = r21
            r11 = r23
            goto L_0x00f5
        L_0x00de:
            r22 = r11
            r13.put(r6, r12)
            boolean r0 = r28.isTrack()
            if (r0 == 0) goto L_0x00ec
            r5.put(r6, r12)
        L_0x00ec:
            r11 = r17
            r6 = 0
            r16 = 0
            r17 = r14
            r14 = r20
        L_0x00f5:
            if (r36 == 0) goto L_0x010f
            java.lang.String r0 = r36.duration()     // Catch:{ Exception -> 0x010b }
            double r3 = java.lang.Double.parseDouble(r0)     // Catch:{ Exception -> 0x010b }
            r20 = 0
            int r0 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x010f
            java.lang.String r0 = "event_duration"
            r5.put(r0, r3)     // Catch:{ Exception -> 0x010b }
            goto L_0x010f
        L_0x010b:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x010f:
            java.lang.String r0 = "$lib"
            java.lang.String r3 = "Android"
            r13.put(r0, r3)
            r13.put(r15, r14)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0125
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager
            r0.addKeyIfExist(r13, r2)
            goto L_0x0128
        L_0x0125:
            r13.put(r2, r6)
        L_0x0128:
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties r0 = r1.mSuperProperties
            java.lang.Object r0 = r0.get()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            if (r0 == 0) goto L_0x013f
            boolean r3 = r0.has(r2)
            if (r3 == 0) goto L_0x013f
            java.lang.Object r0 = r0.get(r2)
            r13.put(r2, r0)
        L_0x013f:
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.security.SecureRandom r0 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0152 }
            r0.<init>()     // Catch:{ Exception -> 0x0152 }
            java.lang.String r3 = "_track_id"
            int r0 = r0.nextInt()     // Catch:{ Exception -> 0x0152 }
            r2.put(r3, r0)     // Catch:{ Exception -> 0x0152 }
        L_0x0152:
            java.lang.String r0 = "time"
            r2.put(r0, r11)
            java.lang.String r3 = r28.getEventType()
            java.lang.String r4 = "type"
            r2.put(r4, r3)
            java.lang.String r3 = r27.getAnonymousId()
            boolean r4 = r5.has(r10)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x0176
            java.lang.String r4 = "project"
            java.lang.String r6 = r5.optString(r10)     // Catch:{ Exception -> 0x01ed }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x01ed }
            r5.remove(r10)     // Catch:{ Exception -> 0x01ed }
        L_0x0176:
            boolean r4 = r5.has(r9)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x0188
            java.lang.String r4 = "token"
            java.lang.String r6 = r5.optString(r9)     // Catch:{ Exception -> 0x01ed }
            r2.put(r4, r6)     // Catch:{ Exception -> 0x01ed }
            r5.remove(r9)     // Catch:{ Exception -> 0x01ed }
        L_0x0188:
            boolean r4 = r5.has(r8)     // Catch:{ Exception -> 0x01ed }
            if (r4 == 0) goto L_0x01b0
            java.lang.Object r4 = r5.opt(r8)     // Catch:{ Exception -> 0x01a9 }
            boolean r6 = r4 instanceof java.util.Date     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x01ad
            r6 = r4
            java.util.Date r6 = (java.util.Date) r6     // Catch:{ Exception -> 0x01a9 }
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.isDateValid((java.util.Date) r6)     // Catch:{ Exception -> 0x01a9 }
            if (r6 == 0) goto L_0x01ad
            java.util.Date r4 = (java.util.Date) r4     // Catch:{ Exception -> 0x01a9 }
            long r11 = r4.getTime()     // Catch:{ Exception -> 0x01a9 }
            r2.put(r0, r11)     // Catch:{ Exception -> 0x01a9 }
            goto L_0x01ad
        L_0x01a9:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x01ed }
        L_0x01ad:
            r5.remove(r8)     // Catch:{ Exception -> 0x01ed }
        L_0x01b0:
            java.lang.String r0 = "$PlanPopupDisplay"
            r4 = r29
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01e6
            boolean r0 = r5.has(r7)     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01c7
            java.lang.String r3 = r5.optString(r7)     // Catch:{ Exception -> 0x01eb }
            r5.remove(r7)     // Catch:{ Exception -> 0x01eb }
        L_0x01c7:
            r6 = r19
            boolean r0 = r5.has(r6)     // Catch:{ Exception -> 0x01eb }
            if (r0 == 0) goto L_0x01d7
            java.lang.String r7 = r5.optString(r6)     // Catch:{ Exception -> 0x01eb }
            r5.remove(r6)     // Catch:{ Exception -> 0x01e4 }
            goto L_0x01d9
        L_0x01d7:
            r7 = r34
        L_0x01d9:
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01e4 }
            if (r0 != 0) goto L_0x01e1
            r0 = r7
            goto L_0x01f8
        L_0x01e1:
            r0 = r7
            r7 = r3
            goto L_0x01f8
        L_0x01e4:
            r0 = move-exception
            goto L_0x01f2
        L_0x01e6:
            r7 = r33
            r0 = r34
            goto L_0x01f8
        L_0x01eb:
            r0 = move-exception
            goto L_0x01f0
        L_0x01ed:
            r0 = move-exception
            r4 = r29
        L_0x01f0:
            r7 = r34
        L_0x01f2:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            r0 = r7
            r7 = r33
        L_0x01f8:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "distinct_id"
            if (r6 == 0) goto L_0x0208
            java.lang.String r6 = r27.getAnonymousId()
            r2.put(r8, r6)
            goto L_0x020b
        L_0x0208:
            r2.put(r8, r7)
        L_0x020b:
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 != 0) goto L_0x0216
            java.lang.String r6 = "login_id"
            r2.put(r6, r0)
        L_0x0216:
            java.lang.String r0 = "anonymous_id"
            r2.put(r0, r3)
            java.lang.String r0 = "identities"
            r3 = r32
            r2.put(r0, r3)
            java.lang.String r0 = "lib"
            r2.put(r0, r13)
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r0 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK
            java.lang.String r3 = "event"
            r6 = r28
            if (r6 == r0) goto L_0x0247
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r0 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_BIND
            if (r6 == r0) goto L_0x0247
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r0 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND
            if (r6 != r0) goto L_0x0238
            goto L_0x0247
        L_0x0238:
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r0 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP
            if (r6 != r0) goto L_0x0253
            r2.put(r3, r4)
            java.lang.String r0 = "original_id"
            r3 = r35
            r2.put(r0, r3)
            goto L_0x0253
        L_0x0247:
            r2.put(r3, r4)
            boolean r0 = r1.isFirstDay(r11)
            java.lang.String r3 = "$is_first_day"
            r5.put(r3, r0)
        L_0x0253:
            boolean r0 = r1.mAutoTrack
            r3 = 0
            r7 = 1
            if (r0 == 0) goto L_0x02a3
            r8 = r30
            if (r8 == 0) goto L_0x02a3
            boolean r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.isAutoTrackType(r29)
            if (r0 == 0) goto L_0x02a3
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$AutoTrackEventType r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType.autoTrackEventTypeFromEventName(r29)
            if (r0 == 0) goto L_0x02a3
            boolean r0 = r1.isAutoTrackEventTypeIgnored((com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType) r0)
            if (r0 != 0) goto L_0x02a3
            java.lang.String r0 = "$screen_name"
            boolean r0 = r8.has(r0)
            if (r0 == 0) goto L_0x02a3
            java.lang.String r0 = "$screen_name"
            java.lang.String r0 = r8.getString(r0)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto L_0x02a3
            java.lang.String r8 = "\\|"
            java.lang.String[] r0 = r0.split(r8)
            int r8 = r0.length
            if (r8 <= 0) goto L_0x02a3
            r8 = 4
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r0 = r0[r3]
            r8[r3] = r0
            java.lang.String r0 = ""
            r8[r7] = r0
            r9 = 2
            r8[r9] = r0
            r9 = 3
            r8[r9] = r0
            java.lang.String r0 = "%s##%s##%s##%s"
            java.lang.String r16 = java.lang.String.format(r0, r8)
        L_0x02a3:
            boolean r0 = android.text.TextUtils.isEmpty(r16)
            if (r0 == 0) goto L_0x02de
            java.lang.Exception r0 = new java.lang.Exception
            r0.<init>()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            int r8 = r0.length
            if (r8 <= r7) goto L_0x02de
            r0 = r0[r3]
            r8 = 4
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r9 = r0.getClassName()
            r8[r3] = r9
            java.lang.String r3 = r0.getMethodName()
            r8[r7] = r3
            r3 = 2
            java.lang.String r9 = r0.getFileName()
            r8[r3] = r9
            r3 = 3
            int r0 = r0.getLineNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r8[r3] = r0
            java.lang.String r0 = "%s##%s##%s##%s"
            java.lang.String r16 = java.lang.String.format(r0, r8)
        L_0x02de:
            r0 = r16
            r3 = r22
            r13.put(r3, r0)
            boolean r0 = r28.isTrack()
            if (r0 == 0) goto L_0x035e
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = mSAConfigOptions
            boolean r0 = r0.isDisableDeviceId()
            java.lang.String r3 = "$anonymization_id"
            java.lang.String r8 = "$device_id"
            if (r0 == 0) goto L_0x0306
            boolean r0 = r5.has(r3)
            if (r0 == 0) goto L_0x0302
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager
            r0.addKeyIfExist(r5, r3)
        L_0x0302:
            r5.remove(r8)
            goto L_0x0314
        L_0x0306:
            boolean r0 = r5.has(r8)
            if (r0 == 0) goto L_0x0311
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager
            r0.addKeyIfExist(r5, r8)
        L_0x0311:
            r5.remove(r3)
        L_0x0314:
            com.sensorsdata.analytics.android.sdk.SessionRelatedManager r0 = com.sensorsdata.analytics.android.sdk.SessionRelatedManager.getInstance()     // Catch:{ Exception -> 0x031c }
            r0.handleEventOfSession(r4, r5, r11)     // Catch:{ Exception -> 0x031c }
            goto L_0x0320
        L_0x031c:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0320:
            boolean r0 = r1.isEnterDb(r4, r5)
            if (r0 != 0) goto L_0x033d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            java.lang.String r2 = " event can not enter database"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "SA.SensorsDataAPI"
            com.sensorsdata.analytics.android.sdk.SALog.d(r2, r0)
            return
        L_0x033d:
            boolean r0 = r1.isTrackEventWithPluginVersion
            if (r0 != 0) goto L_0x035e
            java.lang.String r0 = "$lib_plugin_version"
            boolean r0 = r5.has(r0)
            if (r0 != 0) goto L_0x035e
            org.json.JSONArray r0 = r27.getPluginVersion()
            if (r0 != 0) goto L_0x0352
            r1.isTrackEventWithPluginVersion = r7
            goto L_0x035e
        L_0x0352:
            java.lang.String r3 = "$lib_plugin_version"
            r5.put(r3, r0)     // Catch:{ Exception -> 0x035a }
            r1.isTrackEventWithPluginVersion = r7     // Catch:{ Exception -> 0x035a }
            goto L_0x035e
        L_0x035a:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x035e:
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(r31)
            java.lang.String r0 = "properties"
            r2.put(r0, r5)
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager     // Catch:{ Exception -> 0x038e }
            java.util.List r0 = r0.getEventListenerList()     // Catch:{ Exception -> 0x038e }
            if (r0 == 0) goto L_0x0392
            boolean r0 = r28.isTrack()     // Catch:{ Exception -> 0x038e }
            if (r0 == 0) goto L_0x0392
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager     // Catch:{ Exception -> 0x038e }
            java.util.List r0 = r0.getEventListenerList()     // Catch:{ Exception -> 0x038e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x038e }
        L_0x037e:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x038e }
            if (r3 == 0) goto L_0x0392
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x038e }
            com.sensorsdata.analytics.android.sdk.listener.SAEventListener r3 = (com.sensorsdata.analytics.android.sdk.listener.SAEventListener) r3     // Catch:{ Exception -> 0x038e }
            r3.trackEvent(r2)     // Catch:{ Exception -> 0x038e }
            goto L_0x037e
        L_0x038e:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0392:
            boolean r0 = r28.isTrack()     // Catch:{ Exception -> 0x03a0 }
            if (r0 == 0) goto L_0x03a4
            com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor r0 = com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance()     // Catch:{ Exception -> 0x03a0 }
            r0.callTrack(r2)     // Catch:{ Exception -> 0x03a0 }
            goto L_0x03a4
        L_0x03a0:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x03a4:
            com.sensorsdata.analytics.android.sdk.AnalyticsMessages r0 = r1.mMessages
            java.lang.String r3 = r28.getEventType()
            r0.enqueueEventMessage(r3, r2)
            r3 = r17
            boolean r0 = r3.equals(r4)
            if (r0 == 0) goto L_0x03ba
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r0 = r1.mSAContextManager
            r0.setAppStartSuccess(r7)
        L_0x03ba:
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r0 == 0) goto L_0x03de
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "track event:\n"
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "SA.SensorsDataAPI"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r2, (java.lang.String) r0)
        L_0x03de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.trackEventInternal(com.sensorsdata.analytics.android.sdk.internal.beans.EventType, java.lang.String, org.json.JSONObject, org.json.JSONObject, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String, com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer):void");
    }

    private void transformEventTaskQueue(EventType eventType, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, String str2, String str3, String str4, EventTimer eventTimer) {
        String str5 = str;
        JSONObject jSONObject4 = jSONObject2;
        try {
            if (!jSONObject4.has("$time") && !"$AppStart".equals(str5) && !"$AppEnd".equals(str5)) {
                jSONObject4.put("$time", new Date(System.currentTimeMillis()));
            }
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
        final EventType eventType2 = eventType;
        final String str6 = str;
        final JSONObject jSONObject5 = jSONObject;
        final JSONObject jSONObject6 = jSONObject2;
        final JSONObject jSONObject7 = jSONObject3;
        final String str7 = str2;
        final String str8 = str3;
        final EventTimer eventTimer2 = eventTimer;
        final String str9 = str4;
        this.mTrackTaskManager.transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    if (eventType2.isTrack()) {
                        JSONUtils.mergeDistinctProperty(SensorsDataPropertyPluginManager.getInstance().properties(str6, eventType2, jSONObject5), jSONObject6);
                    }
                    JSONObject jSONObject = jSONObject7;
                    if (!(jSONObject == null || eventType2 == EventType.TRACK_ID_UNBIND)) {
                        AbstractSensorsDataAPI.this.mUserIdentityAPI.updateIdentities(jSONObject);
                    }
                    if ("$SignUp".equals(str6)) {
                        AbstractSensorsDataAPI abstractSensorsDataAPI = AbstractSensorsDataAPI.this;
                        abstractSensorsDataAPI.trackEventInternal(eventType2, str6, jSONObject5, jSONObject6, jSONObject7, str7, str8, abstractSensorsDataAPI.getAnonymousId(), eventTimer2);
                        return;
                    }
                    AbstractSensorsDataAPI.this.trackEventInternal(eventType2, str6, jSONObject5, jSONObject6, jSONObject7, str7, str8, str9, eventTimer2);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    private void transformH5TaskQueue(String str) {
        try {
            final JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("properties");
            if (optJSONObject != null && !optJSONObject.has("$time")) {
                optJSONObject.put("$time", System.currentTimeMillis());
            }
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "track H5, isDataCollectEnable = false, eventInfo = " + JSONUtils.formatJson(str));
            }
            this.mTrackTaskManager.transformTaskQueue(new Runnable() {
                public void run() {
                    try {
                        AbstractSensorsDataAPI.this.trackEventH5(jSONObject.toString());
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void transformItemTaskQueue(String str, String str2, String str3, long j11, JSONObject jSONObject) {
        if (SALog.isLogEnabled()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("track item, isDataCollectEnable = false, itemType = ");
            String str4 = str;
            sb2.append(str);
            sb2.append(",itemId = ");
            String str5 = str2;
            sb2.append(str2);
            SALog.i(TAG, sb2.toString());
        } else {
            String str6 = str;
            String str7 = str2;
        }
        final String str8 = str;
        final String str9 = str2;
        final String str10 = str3;
        final long j12 = j11;
        final JSONObject jSONObject2 = jSONObject;
        this.mTrackTaskManager.transformTaskQueue(new Runnable() {
            public void run() {
                try {
                    AbstractSensorsDataAPI.this.trackItemEvent(str8, str9, str10, j12, jSONObject2);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public boolean _trackEventFromH5(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String optString = new JSONObject(str).optString("server_url");
            if (TextUtils.isEmpty(optString) || !new ServerUrl(optString).check(new ServerUrl(this.mServerUrl))) {
                return false;
            }
            trackEventFromH5(str);
            return true;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return false;
    }

    public void addEventListener(SAEventListener sAEventListener) {
        this.mSAContextManager.addEventListener(sAEventListener);
    }

    public void addFunctionListener(final SAFunctionListener sAFunctionListener) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                TrackMonitor.getInstance().addFunctionListener(sAFunctionListener);
            }
        });
    }

    public void addSAJSListener(SAJSListener sAJSListener) {
        try {
            if (this.mSAJSListeners == null) {
                this.mSAJSListeners = new CopyOnWriteArrayList<>();
            }
            if (!this.mSAJSListeners.contains(sAJSListener)) {
                this.mSAJSListeners.add(sAJSListener);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void appBecomeActive() {
        EventTimer eventTimer;
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry next : this.mTrackTimer.entrySet()) {
                    if (!(next == null || (eventTimer = (EventTimer) next.getValue()) == null)) {
                        eventTimer.setStartTime(SystemClock.elapsedRealtime());
                    }
                }
            } catch (Exception e11) {
                SALog.i(TAG, "appBecomeActive error:" + e11.getMessage());
            }
        }
    }

    public void appEnterBackground() {
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry next : this.mTrackTimer.entrySet()) {
                    if (next != null) {
                        if (!"$AppEnd".equals(next.getKey())) {
                            EventTimer eventTimer = (EventTimer) next.getValue();
                            if (eventTimer != null && !eventTimer.isPaused()) {
                                eventTimer.setEventAccumulatedDuration(((eventTimer.getEventAccumulatedDuration() + SystemClock.elapsedRealtime()) - eventTimer.getStartTime()) - ((long) getSessionIntervalTime()));
                                eventTimer.setStartTime(SystemClock.elapsedRealtime());
                            }
                        }
                    }
                }
            } catch (Exception e11) {
                SALog.i(TAG, "appEnterBackground error:" + e11.getMessage());
            }
        }
    }

    public void applySAConfigOptions() {
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            SensorsDataExceptionHandler.enableAppCrash();
        }
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions.mAutoTrackEventType != 0) {
            this.mAutoTrack = true;
        }
        if (sAConfigOptions.mInvokeLog) {
            enableLog(sAConfigOptions.mLogEnabled);
        }
        enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
        SAConfigOptions sAConfigOptions2 = mSAConfigOptions;
        if (!sAConfigOptions2.mVisualizedEnabled && sAConfigOptions2.mVisualizedPropertiesEnabled) {
            SALog.i(TAG, "当前已开启可视化全埋点自定义属性（enableVisualizedProperties），可视化全埋点采集开关已失效！");
            mSAConfigOptions.enableVisualizedAutoTrack(true);
        }
    }

    public void delayExecution(Activity activity) {
        if (this.mActivityLifecycleCallbacks != null) {
            SensorsDataLifecycleMonitorManager.getInstance().getCallback().onActivityCreated(activity, (Bundle) null);
            SensorsDataLifecycleMonitorManager.getInstance().getCallback().onActivityStarted(activity);
        }
        if (SALog.isLogEnabled()) {
            SALog.i(TAG, "SDK init success by：" + activity.getClass().getName());
        }
    }

    public void delayInitTask() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    AbstractSensorsDataAPI.this.registerNetworkListener();
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void enableAutoTrack(int i11) {
        if (i11 > 0 && i11 <= 15) {
            try {
                this.mAutoTrack = true;
                SAConfigOptions sAConfigOptions = mSAConfigOptions;
                sAConfigOptions.setAutoTrackEventType(i11 | sAConfigOptions.mAutoTrackEventType);
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public SensorsDataAPI.DebugMode getDebugMode() {
        return this.mDebugMode;
    }

    public JSONObject getDynamicProperty() {
        try {
            SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties = this.mDynamicSuperPropertiesCallBack;
            if (sensorsDataDynamicSuperProperties == null) {
                return null;
            }
            JSONObject dynamicSuperProperties = sensorsDataDynamicSuperProperties.getDynamicSuperProperties();
            SADataHelper.assertPropertyTypes(dynamicSuperProperties);
            return dynamicSuperProperties;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    public BaseSensorsDataSDKRemoteManager getRemoteManager() {
        return this.mRemoteManager;
    }

    public SAContextManager getSAContextManager() {
        return this.mSAContextManager;
    }

    public SensorsDataEncrypt getSensorsDataEncrypt() {
        return this.mSensorsDataEncrypt;
    }

    public void handleJsMessage(WeakReference<View> weakReference, String str) {
        CopyOnWriteArrayList<SAJSListener> copyOnWriteArrayList = this.mSAJSListeners;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<SAJSListener> it2 = this.mSAJSListeners.iterator();
            while (it2.hasNext()) {
                SAJSListener next = it2.next();
                if (next != null) {
                    try {
                        next.onReceiveJSMessage(weakReference, str);
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            }
        }
    }

    public void initSAConfig(String str, String str2) {
        Bundle appInfoBundle = AppInfoUtils.getAppInfoBundle(this.mContext);
        if (mSAConfigOptions == null) {
            this.mSDKConfigInit = false;
            mSAConfigOptions = new SAConfigOptions(str);
        } else {
            this.mSDKConfigInit = true;
        }
        SAConfigOptions sAConfigOptions = mSAConfigOptions;
        if (sAConfigOptions.mEnableEncrypt) {
            this.mSensorsDataEncrypt = new SensorsDataEncrypt(this.mContext, sAConfigOptions.mPersistentSecretKey, sAConfigOptions.getEncryptors());
        }
        DbAdapter.getInstance(this.mContext, str2, this.mSensorsDataEncrypt);
        this.mTrackTaskManager.setDataCollectEnable(mSAConfigOptions.isDataCollectEnable);
        SAConfigOptions sAConfigOptions2 = mSAConfigOptions;
        if (sAConfigOptions2.mInvokeLog) {
            enableLog(sAConfigOptions2.mLogEnabled);
        } else {
            enableLog(appInfoBundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", this.mDebugMode != SensorsDataAPI.DebugMode.DEBUG_OFF));
        }
        SALog.setDisableSDK(mSAConfigOptions.isDisableSDK);
        setServerUrl(str);
        if (mSAConfigOptions.mEnableTrackAppCrash) {
            SensorsDataExceptionHandler.enableAppCrash();
        }
        SAConfigOptions sAConfigOptions3 = mSAConfigOptions;
        if (sAConfigOptions3.mFlushInterval == 0) {
            sAConfigOptions3.setFlushInterval(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushInterval", DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS));
        }
        SAConfigOptions sAConfigOptions4 = mSAConfigOptions;
        if (sAConfigOptions4.mFlushBulkSize == 0) {
            sAConfigOptions4.setFlushBulkSize(appInfoBundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100));
        }
        SAConfigOptions sAConfigOptions5 = mSAConfigOptions;
        if (sAConfigOptions5.mMaxCacheSize == 0) {
            sAConfigOptions5.setMaxCacheSize(33554432);
        }
        this.mAutoTrack = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.AutoTrack", false);
        int i11 = mSAConfigOptions.mAutoTrackEventType;
        if (i11 != 0) {
            enableAutoTrack(i11);
            this.mAutoTrack = true;
        }
        SAConfigOptions sAConfigOptions6 = mSAConfigOptions;
        if (!sAConfigOptions6.mInvokeHeatMapEnabled) {
            sAConfigOptions6.mHeatMapEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.HeatMap", false);
        }
        SAConfigOptions sAConfigOptions7 = mSAConfigOptions;
        if (!sAConfigOptions7.mInvokeVisualizedEnabled) {
            sAConfigOptions7.mVisualizedEnabled = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.VisualizedAutoTrack", false);
        }
        enableTrackScreenOrientation(mSAConfigOptions.mTrackScreenOrientationEnabled);
        SHOW_DEBUG_INFO_VIEW = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.ShowDebugInfoView", true);
        this.mDisableDefaultRemoteConfig = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableDefaultRemoteConfig", false);
        if (mSAConfigOptions.isDataCollectEnable) {
            mIsMainProcess = AppInfoUtils.isMainProcess(this.mContext, appInfoBundle);
        }
        this.mDisableTrackDeviceId = appInfoBundle.getBoolean("com.sensorsdata.analytics.android.DisableTrackDeviceId", false);
    }

    public boolean isDisableDefaultRemoteConfig() {
        return this.mDisableDefaultRemoteConfig;
    }

    public boolean isFirstDay(long j11) {
        String str = (String) this.mFirstDay.get();
        if (str == null) {
            return true;
        }
        try {
            return str.equals(TimeUtils.formatTime(j11, "yyyy-MM-dd"));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return true;
        }
    }

    public void registerNetworkListener() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                NetworkUtils.registerNetworkListener(AbstractSensorsDataAPI.this.mContext);
            }
        });
    }

    public void removeEventListener(SAEventListener sAEventListener) {
        this.mSAContextManager.removeEventListener(sAEventListener);
    }

    public void removeFunctionListener(final SAFunctionListener sAFunctionListener) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    TrackMonitor.getInstance().removeFunctionListener(sAFunctionListener);
                }
            });
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void removeSAJSListener(SAJSListener sAJSListener) {
        try {
            CopyOnWriteArrayList<SAJSListener> copyOnWriteArrayList = this.mSAJSListeners;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.contains(sAJSListener)) {
                this.mSAJSListeners.remove(sAJSListener);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void setDebugMode(SensorsDataAPI.DebugMode debugMode) {
        this.mDebugMode = debugMode;
        if (debugMode == SensorsDataAPI.DebugMode.DEBUG_OFF) {
            enableLog(false);
            SALog.setDebug(false);
            this.mServerUrl = this.mOriginServerUrl;
            return;
        }
        enableLog(true);
        SALog.setDebug(true);
        setServerUrl(this.mOriginServerUrl);
    }

    public void setRemoteManager(BaseSensorsDataSDKRemoteManager baseSensorsDataSDKRemoteManager) {
        this.mRemoteManager = baseSensorsDataSDKRemoteManager;
    }

    public void trackAutoEvent(String str, JSONObject jSONObject) {
        trackAutoEvent(str, jSONObject, (ViewNode) null);
    }

    public void trackEvent(EventType eventType, String str, JSONObject jSONObject, String str2) {
        trackEvent(eventType, str, jSONObject, (JSONObject) null, getDistinctId(), getLoginId(), str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0222 A[Catch:{ Exception -> 0x02a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x025b A[Catch:{ Exception -> 0x02a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c9 A[Catch:{ Exception -> 0x02a0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackEventH5(java.lang.String r14) {
        /*
            r13 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x02a0 }
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = mSAConfigOptions     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = r0.isDataCollectEnable     // Catch:{ Exception -> 0x02a0 }
            if (r0 != 0) goto L_0x0011
            r13.transformH5TaskQueue(r14)     // Catch:{ Exception -> 0x02a0 }
            return
        L_0x0011:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x02a0 }
            r0.<init>(r14)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r14 = "_hybrid_h5"
            r1 = 1
            r0.put(r14, r1)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r14 = "type"
            java.lang.String r14 = r0.getString(r14)     // Catch:{ Exception -> 0x02a0 }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r2 = r14.toUpperCase(r2)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r2 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.valueOf(r2)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r3 = "distinct_id"
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r4 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP     // Catch:{ Exception -> 0x02a0 }
            if (r2 != r4) goto L_0x003e
            java.lang.String r3 = "original_id"
            java.lang.String r4 = r13.getAnonymousId()     // Catch:{ Exception -> 0x02a0 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0057
        L_0x003e:
            java.lang.String r4 = r13.getLoginId()     // Catch:{ Exception -> 0x02a0 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x02a0 }
            if (r4 != 0) goto L_0x0050
            java.lang.String r4 = r13.getLoginId()     // Catch:{ Exception -> 0x02a0 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0057
        L_0x0050:
            java.lang.String r4 = r13.getAnonymousId()     // Catch:{ Exception -> 0x02a0 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x02a0 }
        L_0x0057:
            java.lang.String r3 = "anonymous_id"
            java.lang.String r4 = r13.getAnonymousId()     // Catch:{ Exception -> 0x02a0 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x02a0 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r5 = "time"
            r0.put(r5, r3)     // Catch:{ Exception -> 0x02a0 }
            java.security.SecureRandom r5 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0077 }
            r5.<init>()     // Catch:{ Exception -> 0x0077 }
            java.lang.String r6 = "_track_id"
            int r5 = r5.nextInt()     // Catch:{ Exception -> 0x0077 }
            r0.put(r6, r5)     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            java.lang.String r5 = "properties"
            org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(r5)     // Catch:{ Exception -> 0x02a0 }
            if (r5 != 0) goto L_0x0087
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x02a0 }
            r5.<init>()     // Catch:{ Exception -> 0x02a0 }
        L_0x0087:
            java.lang.String r6 = "lib"
            org.json.JSONObject r6 = r0.optJSONObject(r6)     // Catch:{ Exception -> 0x02a0 }
            if (r6 == 0) goto L_0x00b3
            com.sensorsdata.analytics.android.sdk.util.SAContextManager r7 = r13.mSAContextManager     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r8 = "$app_version"
            r7.addKeyIfExist(r6, r8)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties r7 = r13.mSuperProperties     // Catch:{ Exception -> 0x02a0 }
            java.lang.Object r7 = r7.get()     // Catch:{ Exception -> 0x02a0 }
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x00b3
            java.lang.String r8 = "$app_version"
            boolean r8 = r7.has(r8)     // Catch:{ Exception -> 0x02a0 }
            if (r8 == 0) goto L_0x00b3
            java.lang.String r8 = "$app_version"
            java.lang.String r9 = "$app_version"
            java.lang.Object r7 = r7.get(r9)     // Catch:{ Exception -> 0x02a0 }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x00b3:
            java.lang.String r6 = "event"
            java.lang.String r6 = r0.optString(r6)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager r7 = com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager.getInstance()     // Catch:{ Exception -> 0x02a0 }
            r8 = 0
            org.json.JSONObject r7 = r7.properties(r6, r2, r8)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x00f3
            java.util.Iterator r8 = r7.keys()     // Catch:{ Exception -> 0x02a0 }
        L_0x00c8:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x02a0 }
            if (r9 == 0) goto L_0x00f3
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x02a0 }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x02a0 }
            if (r10 != 0) goto L_0x00c8
            java.lang.String r10 = "$lib"
            boolean r10 = r10.equals(r9)     // Catch:{ Exception -> 0x02a0 }
            if (r10 != 0) goto L_0x00c8
            java.lang.String r10 = "$lib_version"
            boolean r10 = r10.equals(r9)     // Catch:{ Exception -> 0x02a0 }
            if (r10 == 0) goto L_0x00eb
            goto L_0x00c8
        L_0x00eb:
            java.lang.Object r10 = r7.opt(r9)     // Catch:{ Exception -> 0x02a0 }
            r5.put(r9, r10)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x00c8
        L_0x00f3:
            boolean r7 = r2.isTrack()     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x0143
            r13.getCarrier(r5)     // Catch:{ Exception -> 0x02a0 }
            android.content.Context r7 = r13.mContext     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r7 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(r7)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r8 = "$wifi"
            java.lang.String r9 = "WIFI"
            boolean r9 = r9.equals(r7)     // Catch:{ Exception -> 0x02a0 }
            r5.put(r8, r9)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r8 = "$network_type"
            r5.put(r8, r7)     // Catch:{ Exception -> 0x02a0 }
            org.json.JSONObject r7 = r13.getDynamicProperty()     // Catch:{ Exception -> 0x02a0 }
            r13.mergerDynamicAndSuperProperties(r5, r7)     // Catch:{ Exception -> 0x02a0 }
            boolean r7 = r2.isTrack()     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x0128
            java.lang.String r7 = "$is_first_day"
            boolean r8 = r13.isFirstDay(r3)     // Catch:{ Exception -> 0x02a0 }
            r5.put(r7, r8)     // Catch:{ Exception -> 0x02a0 }
        L_0x0128:
            com.sensorsdata.analytics.android.sdk.core.SAModuleManager r7 = com.sensorsdata.analytics.android.sdk.core.SAModuleManager.getInstance()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r8 = "sensors_analytics_module_advertisement"
            boolean r7 = r7.hasModuleByName(r8)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x0143
            com.sensorsdata.analytics.android.sdk.core.SAModuleManager r7 = com.sensorsdata.analytics.android.sdk.core.SAModuleManager.getInstance()     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertModuleProtocol r7 = r7.getAdvertModuleService()     // Catch:{ Exception -> 0x02a0 }
            org.json.JSONObject r7 = r7.getLatestUtmProperties()     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r7, r5)     // Catch:{ Exception -> 0x02a0 }
        L_0x0143:
            java.lang.String r7 = "_nocache"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x0150
            java.lang.String r7 = "_nocache"
            r0.remove(r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x0150:
            java.lang.String r7 = "server_url"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x015d
            java.lang.String r7 = "server_url"
            r0.remove(r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x015d:
            java.lang.String r7 = "_flush_time"
            boolean r7 = r0.has(r7)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x016a
            java.lang.String r7 = "_flush_time"
            r0.remove(r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x016a:
            java.lang.String r7 = "$project"
            boolean r7 = r5.has(r7)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x0182
            java.lang.String r7 = "project"
            java.lang.String r8 = "$project"
            java.lang.String r8 = r5.optString(r8)     // Catch:{ Exception -> 0x02a0 }
            r0.put(r7, r8)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r7 = "$project"
            r5.remove(r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x0182:
            java.lang.String r7 = "$token"
            boolean r7 = r5.has(r7)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x019a
            java.lang.String r7 = "token"
            java.lang.String r8 = "$token"
            java.lang.String r8 = r5.optString(r8)     // Catch:{ Exception -> 0x02a0 }
            r0.put(r7, r8)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r7 = "$token"
            r5.remove(r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x019a:
            java.lang.String r7 = "$time"
            boolean r7 = r5.has(r7)     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x01c3
            java.lang.String r7 = "$time"
            long r7 = r5.getLong(r7)     // Catch:{ Exception -> 0x01b6 }
            boolean r9 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.isDateValid((long) r7)     // Catch:{ Exception -> 0x01b6 }
            if (r9 == 0) goto L_0x01be
            java.lang.String r3 = "time"
            r0.put(r3, r7)     // Catch:{ Exception -> 0x01b4 }
            goto L_0x01bd
        L_0x01b4:
            r3 = move-exception
            goto L_0x01ba
        L_0x01b6:
            r7 = move-exception
            r11 = r3
            r3 = r7
            r7 = r11
        L_0x01ba:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ Exception -> 0x02a0 }
        L_0x01bd:
            r3 = r7
        L_0x01be:
            java.lang.String r7 = "$time"
            r5.remove(r7)     // Catch:{ Exception -> 0x02a0 }
        L_0x01c3:
            boolean r7 = r2.isTrack()     // Catch:{ Exception -> 0x02a0 }
            if (r7 == 0) goto L_0x0216
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(r6)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.SessionRelatedManager r7 = com.sensorsdata.analytics.android.sdk.SessionRelatedManager.getInstance()     // Catch:{ Exception -> 0x01d4 }
            r7.handleEventOfSession(r6, r5, r3)     // Catch:{ Exception -> 0x01d4 }
            goto L_0x01d8
        L_0x01d4:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ Exception -> 0x02a0 }
        L_0x01d8:
            boolean r3 = r13.isEnterDb(r6, r5)     // Catch:{ Exception -> 0x02a0 }
            if (r3 != 0) goto L_0x01f5
            java.lang.String r14 = "SA.SensorsDataAPI"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a0 }
            r0.<init>()     // Catch:{ Exception -> 0x02a0 }
            r0.append(r6)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r1 = " event can not enter database"
            r0.append(r1)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.SALog.d(r14, r0)     // Catch:{ Exception -> 0x02a0 }
            return
        L_0x01f5:
            boolean r3 = r13.isTrackEventWithPluginVersion     // Catch:{ Exception -> 0x02a0 }
            if (r3 != 0) goto L_0x0216
            java.lang.String r3 = "$lib_plugin_version"
            boolean r3 = r5.has(r3)     // Catch:{ Exception -> 0x02a0 }
            if (r3 != 0) goto L_0x0216
            org.json.JSONArray r3 = r13.getPluginVersion()     // Catch:{ Exception -> 0x02a0 }
            if (r3 != 0) goto L_0x020a
            r13.isTrackEventWithPluginVersion = r1     // Catch:{ Exception -> 0x02a0 }
            goto L_0x0216
        L_0x020a:
            java.lang.String r4 = "$lib_plugin_version"
            r5.put(r4, r3)     // Catch:{ Exception -> 0x0212 }
            r13.isTrackEventWithPluginVersion = r1     // Catch:{ Exception -> 0x0212 }
            goto L_0x0216
        L_0x0212:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)     // Catch:{ Exception -> 0x02a0 }
        L_0x0216:
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(r5)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r1 = "properties"
            r0.put(r1, r5)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType r1 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP     // Catch:{ Exception -> 0x02a0 }
            if (r2 != r1) goto L_0x025b
            java.lang.Object r1 = r13.mLoginIdLock     // Catch:{ Exception -> 0x02a0 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI r3 = r13.mUserIdentityAPI     // Catch:{ all -> 0x0258 }
            boolean r2 = r3.mergeH5Identities(r2, r0)     // Catch:{ all -> 0x0258 }
            if (r2 == 0) goto L_0x0256
            com.sensorsdata.analytics.android.sdk.AnalyticsMessages r2 = r13.mMessages     // Catch:{ all -> 0x0258 }
            r2.enqueueEventMessage(r14, r0)     // Catch:{ all -> 0x0258 }
            boolean r14 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ all -> 0x0258 }
            if (r14 == 0) goto L_0x0256
            java.lang.String r14 = "SA.SensorsDataAPI"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0258 }
            r2.<init>()     // Catch:{ all -> 0x0258 }
            java.lang.String r3 = "track event:\n"
            r2.append(r3)     // Catch:{ all -> 0x0258 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0258 }
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r0)     // Catch:{ all -> 0x0258 }
            r2.append(r0)     // Catch:{ all -> 0x0258 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0258 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r14, (java.lang.String) r0)     // Catch:{ all -> 0x0258 }
        L_0x0256:
            monitor-exit(r1)     // Catch:{ all -> 0x0258 }
            goto L_0x02a4
        L_0x0258:
            r14 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0258 }
            throw r14     // Catch:{ Exception -> 0x02a0 }
        L_0x025b:
            java.lang.String r1 = r13.getLoginId()     // Catch:{ Exception -> 0x02a0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x02a0 }
            if (r1 != 0) goto L_0x026e
            java.lang.String r1 = "login_id"
            java.lang.String r3 = r13.getLoginId()     // Catch:{ Exception -> 0x02a0 }
            r0.put(r1, r3)     // Catch:{ Exception -> 0x02a0 }
        L_0x026e:
            com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI r1 = r13.mUserIdentityAPI     // Catch:{ Exception -> 0x02a0 }
            boolean r1 = r1.mergeH5Identities(r2, r0)     // Catch:{ Exception -> 0x02a0 }
            if (r1 == 0) goto L_0x02a4
            com.sensorsdata.analytics.android.sdk.AnalyticsMessages r1 = r13.mMessages     // Catch:{ Exception -> 0x02a0 }
            r1.enqueueEventMessage(r14, r0)     // Catch:{ Exception -> 0x02a0 }
            boolean r14 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ Exception -> 0x02a0 }
            if (r14 == 0) goto L_0x02a4
            java.lang.String r14 = "SA.SensorsDataAPI"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a0 }
            r1.<init>()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r2 = "track event from H5:\n"
            r1.append(r2)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r0)     // Catch:{ Exception -> 0x02a0 }
            r1.append(r0)     // Catch:{ Exception -> 0x02a0 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x02a0 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r14, (java.lang.String) r0)     // Catch:{ Exception -> 0x02a0 }
            goto L_0x02a4
        L_0x02a0:
            r14 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r14)
        L_0x02a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.trackEventH5(java.lang.String):void");
    }

    public void trackInternal(String str, JSONObject jSONObject) {
        trackInternal(str, jSONObject, (ViewNode) null);
    }

    public void trackItemEvent(String str, String str2, String str3, long j11, JSONObject jSONObject) {
        try {
            boolean assertPropertyKey = SADataHelper.assertPropertyKey(str);
            SADataHelper.assertPropertyTypes(jSONObject);
            SADataHelper.assertItemId(str2);
            if (!mSAConfigOptions.isDataCollectEnable) {
                transformItemTaskQueue(str, str2, str3, j11, jSONObject);
                return;
            }
            String str4 = null;
            if (jSONObject != null && jSONObject.has("$project")) {
                str4 = (String) jSONObject.get("$project");
                jSONObject.remove("$project");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("$lib", n0.f32119g);
            jSONObject2.put("$lib_version", "6.3.5");
            jSONObject2.put("$lib_method", "code");
            this.mSAContextManager.addKeyIfExist(jSONObject2, "$app_version");
            JSONObject jSONObject3 = (JSONObject) this.mSuperProperties.get();
            if (jSONObject3 != null && jSONObject3.has("$app_version")) {
                jSONObject2.put("$app_version", jSONObject3.get("$app_version"));
            }
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            if (stackTrace.length > 1) {
                StackTraceElement stackTraceElement = stackTrace[0];
                String format = String.format("%s##%s##%s##%s", new Object[]{stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber())});
                if (!TextUtils.isEmpty(format)) {
                    jSONObject2.put("$lib_detail", format);
                }
            }
            JSONObject jSONObject4 = new JSONObject();
            if (assertPropertyKey) {
                jSONObject4.put("item_type", str);
            }
            jSONObject4.put(FirebaseAnalytics.Param.ITEM_ID, str2);
            jSONObject4.put("type", str3);
            jSONObject4.put(CrashHianalyticsData.TIME, j11);
            jSONObject4.put("properties", TimeUtils.formatDate(jSONObject));
            jSONObject4.put("lib", jSONObject2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject4.put("project", str4);
            }
            this.mMessages.enqueueEventMessage(str3, jSONObject4);
            SALog.i(TAG, "track event:\n" + JSONUtils.formatJson(jSONObject4.toString()));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void trackTimerState(String str, boolean z11) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final String str2 = str;
        final boolean z12 = z11;
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                boolean z11;
                try {
                    SADataHelper.assertEventName(str2);
                    synchronized (AbstractSensorsDataAPI.this.mTrackTimer) {
                        EventTimer eventTimer = AbstractSensorsDataAPI.this.mTrackTimer.get(str2);
                        if (!(eventTimer == null || eventTimer.isPaused() == (z11 = z12))) {
                            eventTimer.setTimerState(z11, elapsedRealtime);
                        }
                    }
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public void transformTaskQueue(final Runnable runnable) {
        if (!mSAConfigOptions.isDataCollectEnable) {
            this.mTrackTaskManager.addTrackEventTask(new Runnable() {
                public void run() {
                    AbstractSensorsDataAPI.this.mTrackTaskManager.transformTaskQueue(runnable);
                }
            });
        } else {
            this.mTrackTaskManager.addTrackEventTask(runnable);
        }
    }

    public void unregisterNetworkListener() {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                NetworkUtils.unregisterNetworkListener(AbstractSensorsDataAPI.this.mContext);
            }
        });
    }

    public void trackAutoEvent(String str, JSONObject jSONObject, ViewNode viewNode) {
        trackInternal(str, SADataHelper.appendLibMethodAutoTrack(jSONObject), viewNode);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|(7:4|c|9|10|11|(1:15)|16)(1:22)|23|(2:25|(1:31))|32|33|(2:35|(2:41|42))|43|44|(9:46|(1:48)|49|50|51|(1:53)|57|58|(1:60))(2:64|(1:66))|67|(6:69|(1:71)|72|73|77|78)(2:79|88)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:80|81|82) */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0163, code lost:
        throw new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException("Unexpected property");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0090 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x015c */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a3 A[Catch:{ JSONException -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e8 A[Catch:{ JSONException -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f5 A[Catch:{ JSONException -> 0x015c }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0146 A[Catch:{ JSONException -> 0x015c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trackEvent(com.sensorsdata.analytics.android.sdk.internal.beans.EventType r13, java.lang.String r14, org.json.JSONObject r15, org.json.JSONObject r16, java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            r12 = this;
            r11 = r12
            r2 = r13
            r0 = r14
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0164 }
            r3 = 0
            if (r1 != 0) goto L_0x003b
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer> r1 = r11.mTrackTimer     // Catch:{ Exception -> 0x0164 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x0164 }
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer> r4 = r11.mTrackTimer     // Catch:{ all -> 0x0038 }
            java.lang.Object r4 = r4.get(r14)     // Catch:{ all -> 0x0038 }
            com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer r4 = (com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer) r4     // Catch:{ all -> 0x0038 }
            java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer> r5 = r11.mTrackTimer     // Catch:{ all -> 0x0038 }
            r5.remove(r14)     // Catch:{ all -> 0x0038 }
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = "_SATimer"
            boolean r1 = r14.endsWith(r1)     // Catch:{ Exception -> 0x0164 }
            if (r1 == 0) goto L_0x0035
            int r1 = r14.length()     // Catch:{ Exception -> 0x0164 }
            r5 = 45
            if (r1 <= r5) goto L_0x0035
            r1 = 0
            int r6 = r14.length()     // Catch:{ Exception -> 0x0164 }
            int r6 = r6 - r5
            java.lang.String r0 = r14.substring(r1, r6)     // Catch:{ Exception -> 0x0164 }
        L_0x0035:
            r10 = r4
            r4 = r0
            goto L_0x003d
        L_0x0038:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ Exception -> 0x0164 }
        L_0x003b:
            r4 = r0
            r10 = r3
        L_0x003d:
            boolean r0 = r13.isTrack()     // Catch:{ Exception -> 0x0164 }
            if (r0 == 0) goto L_0x0057
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(r4)     // Catch:{ Exception -> 0x0164 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0164 }
            if (r0 != 0) goto L_0x0057
            com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager r0 = r11.mRemoteManager     // Catch:{ Exception -> 0x0164 }
            if (r0 == 0) goto L_0x0057
            boolean r0 = r0.ignoreEvent(r4)     // Catch:{ Exception -> 0x0164 }
            if (r0 == 0) goto L_0x0057
            return
        L_0x0057:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x015c }
            r0.<init>()     // Catch:{ JSONException -> 0x015c }
            boolean r1 = r13.isTrack()     // Catch:{ JSONException -> 0x015c }
            if (r1 == 0) goto L_0x0090
            r12.getCarrier(r0)     // Catch:{ JSONException -> 0x015c }
            com.sensorsdata.analytics.android.sdk.core.SAModuleManager r1 = com.sensorsdata.analytics.android.sdk.core.SAModuleManager.getInstance()     // Catch:{ JSONException -> 0x015c }
            java.lang.String r5 = "sensors_analytics_module_advertisement"
            boolean r1 = r1.hasModuleByName(r5)     // Catch:{ JSONException -> 0x015c }
            if (r1 == 0) goto L_0x0090
            java.lang.String r1 = "$AppEnd"
            boolean r1 = r1.equals(r4)     // Catch:{ JSONException -> 0x015c }
            if (r1 != 0) goto L_0x0090
            java.lang.String r1 = "$AppDeeplinkLaunch"
            boolean r1 = r1.equals(r4)     // Catch:{ JSONException -> 0x015c }
            if (r1 != 0) goto L_0x0090
            com.sensorsdata.analytics.android.sdk.core.SAModuleManager r1 = com.sensorsdata.analytics.android.sdk.core.SAModuleManager.getInstance()     // Catch:{ Exception -> 0x0090 }
            com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertModuleProtocol r1 = r1.getAdvertModuleService()     // Catch:{ Exception -> 0x0090 }
            org.json.JSONObject r1 = r1.getLatestUtmProperties()     // Catch:{ Exception -> 0x0090 }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeJSONObject(r1, r0)     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager r1 = com.sensorsdata.analytics.android.sdk.plugin.property.SensorsDataPropertyPluginManager.getInstance()     // Catch:{ JSONException -> 0x015c }
            r5 = r15
            org.json.JSONObject r1 = r1.properties(r4, r13, r15)     // Catch:{ JSONException -> 0x015c }
            org.json.JSONObject r6 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.mergeSuperJSONObject(r1, r0)     // Catch:{ JSONException -> 0x015c }
            boolean r0 = r13.isTrack()     // Catch:{ JSONException -> 0x015c }
            if (r0 == 0) goto L_0x00e8
            r0 = r16
            r12.mergerDynamicAndSuperProperties(r6, r0)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r0 = r11.mReferrerScreenTitle     // Catch:{ JSONException -> 0x015c }
            if (r0 == 0) goto L_0x00b1
            java.lang.String r1 = "$referrer_title"
            r6.put(r1, r0)     // Catch:{ JSONException -> 0x015c }
        L_0x00b1:
            android.content.Context r0 = r11.mContext     // Catch:{ JSONException -> 0x015c }
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(r0)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r1 = "$wifi"
            java.lang.String r7 = "WIFI"
            boolean r7 = r7.equals(r0)     // Catch:{ JSONException -> 0x015c }
            r6.put(r1, r7)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r1 = "$network_type"
            r6.put(r1, r0)     // Catch:{ JSONException -> 0x015c }
            com.sensorsdata.analytics.android.sdk.SensorsDataGPSLocation r0 = mGPSLocation     // Catch:{ Exception -> 0x00cf }
            if (r0 == 0) goto L_0x00d3
            r0.toJSON(r6)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ JSONException -> 0x015c }
        L_0x00d3:
            java.lang.String r0 = r12.getScreenOrientation()     // Catch:{ Exception -> 0x00e3 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x00e3 }
            if (r1 != 0) goto L_0x00ef
            java.lang.String r1 = "$screen_orientation"
            r6.put(r1, r0)     // Catch:{ Exception -> 0x00e3 }
            goto L_0x00ef
        L_0x00e3:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ JSONException -> 0x015c }
            goto L_0x00ef
        L_0x00e8:
            boolean r0 = r13.isProfile()     // Catch:{ JSONException -> 0x015c }
            if (r0 != 0) goto L_0x00ef
            return
        L_0x00ef:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = mSAConfigOptions     // Catch:{ JSONException -> 0x015c }
            boolean r0 = r0.isDataCollectEnable     // Catch:{ JSONException -> 0x015c }
            if (r0 != 0) goto L_0x0146
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ JSONException -> 0x015c }
            if (r0 == 0) goto L_0x0121
            java.lang.String r0 = "SA.SensorsDataAPI"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x015c }
            r1.<init>()     // Catch:{ JSONException -> 0x015c }
            java.lang.String r7 = "track event, isDataCollectEnable = false, eventName = "
            r1.append(r7)     // Catch:{ JSONException -> 0x015c }
            r1.append(r4)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r7 = ",property = "
            r1.append(r7)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r7 = r6.toString()     // Catch:{ JSONException -> 0x015c }
            java.lang.String r7 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r7)     // Catch:{ JSONException -> 0x015c }
            r1.append(r7)     // Catch:{ JSONException -> 0x015c }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x015c }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ JSONException -> 0x015c }
        L_0x0121:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0131 }
            com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI r1 = r11.mUserIdentityAPI     // Catch:{ Exception -> 0x0131 }
            org.json.JSONObject r1 = r1.getIdentities(r13)     // Catch:{ Exception -> 0x0131 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0131 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0131 }
            goto L_0x0136
        L_0x0131:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ JSONException -> 0x015c }
            r0 = r3
        L_0x0136:
            r1 = r12
            r2 = r13
            r3 = r4
            r4 = r15
            r5 = r6
            r6 = r0
            r7 = r17
            r8 = r18
            r9 = r19
            r1.transformEventTaskQueue(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ JSONException -> 0x015c }
            return
        L_0x0146:
            com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI r0 = r11.mUserIdentityAPI     // Catch:{ JSONException -> 0x015c }
            org.json.JSONObject r0 = r0.getIdentities(r13)     // Catch:{ JSONException -> 0x015c }
            r1 = r12
            r2 = r13
            r3 = r4
            r4 = r15
            r5 = r6
            r6 = r0
            r7 = r17
            r8 = r18
            r9 = r19
            r1.trackEventInternal(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ JSONException -> 0x015c }
            goto L_0x0168
        L_0x015c:
            com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException     // Catch:{ Exception -> 0x0164 }
            java.lang.String r1 = "Unexpected property"
            r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0164 }
            throw r0     // Catch:{ Exception -> 0x0164 }
        L_0x0164:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.trackEvent(com.sensorsdata.analytics.android.sdk.internal.beans.EventType, java.lang.String, org.json.JSONObject, org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public void trackInternal(final String str, final JSONObject jSONObject, final ViewNode viewNode) {
        this.mTrackTaskManager.addTrackEventTask(new Runnable() {
            public void run() {
                try {
                    if (viewNode != null && AbstractSensorsDataAPI.getConfigOptions().isVisualizedPropertiesEnabled()) {
                        VisualPropertiesManager.getInstance().mergeVisualProperties(VisualPropertiesManager.VisualEventType.APP_CLICK, jSONObject, viewNode);
                    }
                    AbstractSensorsDataAPI.this.trackEvent(EventType.TRACK, str, jSONObject, (String) null);
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
        });
    }

    public AbstractSensorsDataAPI() {
        this.mLoginIdLock = new Object();
        this.mIgnoredViewTypeList = new ArrayList();
        this.mDebugMode = SensorsDataAPI.DebugMode.DEBUG_OFF;
        this.mEnableNetworkRequest = true;
        this.mClearReferrerWhenAppEnd = false;
        this.mDisableDefaultRemoteConfig = false;
        this.mDisableTrackDeviceId = false;
        this.mSessionTime = CDNDownload.DEFAULT_TIMEOUT;
        this.isTrackEventWithPluginVersion = false;
        this.mContext = null;
        this.mMessages = null;
        this.mSuperProperties = null;
        this.mFirstStart = null;
        this.mFirstDay = null;
        this.mTrackTimer = null;
        this.mSensorsDataEncrypt = null;
    }
}
