package com.sensorsdata.analytics.android.sdk.autotrack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ScreenAutoTracker;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.SessionRelatedManager;
import com.sensorsdata.analytics.android.sdk.core.SAModuleManager;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus;
import com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBusConstants;
import com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription;
import com.sensorsdata.analytics.android.sdk.core.mediator.ModuleConstants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart;
import com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import com.sensorsdata.analytics.android.sdk.visual.HeatMapService;
import com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public class ActivityLifecycleCallbacks implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String APP_VERSION = "$app_version";
    private static final String EVENT_DURATION = "event_duration";
    private static final String EVENT_TIME = "event_time";
    private static final String LIB_VERSION = "$lib_version";
    private static final String TAG = "SA.ActivityLifecycleCallbacks";
    private static final int TIME_INTERVAL = 2000;
    private final String APP_END_DATA = DbParams.PersistentName.APP_END_DATA;
    private final String APP_RESET_STATE = "app_reset_state";
    private final String APP_START_TIME = DbParams.TABLE_APP_START_TIME;
    private final String ELAPSE_TIME = "elapse_time";
    private final int MESSAGE_CODE_APP_END = 0;
    private final int MESSAGE_CODE_START = 100;
    private final int MESSAGE_CODE_STOP = 200;
    private final int MESSAGE_CODE_TIMER = 300;
    private final String TIME = CrashHianalyticsData.TIME;
    private JSONObject activityProperty = new JSONObject();
    /* access modifiers changed from: private */
    public final JSONObject endDataProperty = new JSONObject();
    private Set<Integer> hashSet = new HashSet();
    private final Context mContext;
    private boolean mDataCollectState;
    private final DbAdapter mDbAdapter;
    private JSONObject mDeepLinkProperty = new JSONObject();
    private final PersistentFirstDay mFirstDay;
    private final PersistentFirstStart mFirstStart;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public final SensorsDataAPI mSensorsDataInstance;
    private int mStartActivityCount;
    /* access modifiers changed from: private */
    public long mStartTime;
    /* access modifiers changed from: private */
    public int mStartTimerCount;
    /* access modifiers changed from: private */
    public long messageReceiveTime = 0;
    private boolean resumeFromBackground = false;

    public ActivityLifecycleCallbacks(SensorsDataAPI sensorsDataAPI, PersistentFirstStart persistentFirstStart, PersistentFirstDay persistentFirstDay, Context context) {
        this.mSensorsDataInstance = sensorsDataAPI;
        this.mFirstStart = persistentFirstStart;
        this.mFirstDay = persistentFirstDay;
        this.mDbAdapter = DbAdapter.getInstance();
        this.mContext = context;
        this.mDataCollectState = AbstractSensorsDataAPI.getConfigOptions().isDataCollectEnable();
        initHandler();
        registerAdvertObserver();
    }

    private void buildScreenProperties(Activity activity) {
        JSONObject buildTitleNoAutoTrackerProperties = AopUtil.buildTitleNoAutoTrackerProperties(activity);
        this.activityProperty = buildTitleNoAutoTrackerProperties;
        SensorsDataUtils.mergeJSONObject(buildTitleNoAutoTrackerProperties, this.endDataProperty);
    }

    private void checkFirstDay() {
        if (this.mFirstDay.get() == null && AbstractSensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
            this.mFirstDay.commit(TimeUtils.formatTime(System.currentTimeMillis(), "yyyy-MM-dd"));
        }
    }

    /* access modifiers changed from: private */
    public void generateAppEndData(long j11, long j12) {
        try {
            if (this.mDataCollectState || this.mSensorsDataInstance.getSAContextManager().isAppStartSuccess()) {
                this.mDataCollectState = true;
                if (AbstractSensorsDataAPI.getConfigOptions().isDataCollectEnable()) {
                    if (this.mStartTime == 0) {
                        this.mStartTime = DbAdapter.getInstance().getAppStartTime();
                    }
                    long j13 = this.mStartTime;
                    if (j13 != 0) {
                        this.endDataProperty.put(EVENT_DURATION, TimeUtils.duration(j13, j12));
                    } else {
                        this.endDataProperty.remove(EVENT_DURATION);
                    }
                    this.endDataProperty.put(DbParams.TABLE_APP_START_TIME, this.mStartTime);
                    long j14 = j11 + 2000;
                    this.endDataProperty.put(EVENT_TIME, j14);
                    if (AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
                        SessionRelatedManager.getInstance().refreshSessionByTimer(j14);
                        JSONObject jSONObject = this.endDataProperty;
                        SessionRelatedManager.getInstance().getClass();
                        jSONObject.put("$event_session_id", SessionRelatedManager.getInstance().getSessionID());
                    }
                    this.endDataProperty.put(APP_VERSION, AppInfoUtils.getAppVersionName(this.mContext));
                    this.endDataProperty.put(LIB_VERSION, SensorsDataAPI.sharedInstance().getSDKVersion());
                    this.mDbAdapter.commitAppExitData(this.endDataProperty.toString());
                }
            }
        } catch (Throwable th2) {
            SALog.d(TAG, th2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void handleStartedMessage(Message message) {
        try {
            int activityCount = this.mDbAdapter.getActivityCount();
            this.mStartActivityCount = activityCount;
            DbAdapter dbAdapter = this.mDbAdapter;
            int i11 = activityCount + 1;
            this.mStartActivityCount = i11;
            dbAdapter.commitActivityCount(i11);
            if (this.mStartActivityCount == 1) {
                if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME) && AbstractSensorsDataAPI.getConfigOptions().isSaveDeepLinkInfo()) {
                    SensorsDataUtils.mergeJSONObject(SAModuleManager.getInstance().getAdvertModuleService().getLatestUtmProperties(), this.endDataProperty);
                }
                this.mHandler.removeMessages(0);
                if (isSessionTimeOut()) {
                    this.mHandler.sendMessage(obtainAppEndMessage(false));
                    checkFirstDay();
                    boolean booleanValue = ((Boolean) this.mFirstStart.get()).booleanValue();
                    try {
                        this.mSensorsDataInstance.appBecomeActive();
                        if (this.resumeFromBackground) {
                            this.mSensorsDataInstance.getRemoteManager().applySDKConfigFromCache();
                            this.mSensorsDataInstance.resumeTrackScreenOrientation();
                        }
                        this.mSensorsDataInstance.getRemoteManager().pullSDKConfigFromServer();
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                    Bundle data = message.getData();
                    try {
                        if (this.mSensorsDataInstance.isAutoTrackEnabled() && !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_START)) {
                            if (booleanValue) {
                                this.mFirstStart.commit(Boolean.FALSE);
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("$resume_from_background", this.resumeFromBackground);
                            jSONObject.put("$is_first_time", booleanValue);
                            SensorsDataUtils.mergeJSONObject(this.activityProperty, jSONObject);
                            JSONObject jSONObject2 = this.mDeepLinkProperty;
                            if (jSONObject2 != null) {
                                SensorsDataUtils.mergeJSONObject(jSONObject2, jSONObject);
                                this.mDeepLinkProperty = null;
                            }
                            long j11 = data.getLong(CrashHianalyticsData.TIME);
                            if (j11 <= 0) {
                                j11 = System.currentTimeMillis();
                            }
                            jSONObject.put(EVENT_TIME, j11);
                            this.mSensorsDataInstance.trackAutoEvent("$AppStart", jSONObject);
                            SensorsDataAPI.sharedInstance().flush();
                        }
                    } catch (Exception e12) {
                        SALog.i(TAG, (Throwable) e12);
                    }
                    updateStartTime(data.getLong("elapse_time"));
                    if (this.resumeFromBackground) {
                        try {
                            HeatMapService.getInstance().resume();
                            VisualizedAutoTrackService.getInstance().resume();
                        } catch (Exception e13) {
                            SALog.printStackTrace(e13);
                        }
                    }
                    this.resumeFromBackground = true;
                }
            }
        } catch (Exception e14) {
            SALog.printStackTrace(e14);
            updateStartTime(SystemClock.elapsedRealtime());
        }
        try {
            int i12 = this.mStartTimerCount;
            this.mStartTimerCount = i12 + 1;
            if (i12 == 0) {
                this.mHandler.sendEmptyMessage(300);
            }
        } catch (Exception e15) {
            SALog.printStackTrace(e15);
        }
    }

    /* access modifiers changed from: private */
    public void handleStoppedMessage(Message message) {
        try {
            int i11 = this.mStartTimerCount - 1;
            this.mStartTimerCount = i11;
            int i12 = 0;
            if (i11 <= 0) {
                this.mHandler.removeMessages(300);
                this.mStartTimerCount = 0;
                this.mStartTime = 0;
            }
            int activityCount = this.mDbAdapter.getActivityCount();
            this.mStartActivityCount = activityCount;
            if (activityCount > 0) {
                i12 = activityCount - 1;
                this.mStartActivityCount = i12;
            }
            this.mStartActivityCount = i12;
            this.mDbAdapter.commitActivityCount(i12);
            if (this.mStartActivityCount <= 0) {
                this.mSensorsDataInstance.flush();
                Bundle data = message.getData();
                generateAppEndData(data.getLong(CrashHianalyticsData.TIME), data.getLong("elapse_time"));
                this.mHandler.sendMessageDelayed(obtainAppEndMessage(true), (long) this.mSensorsDataInstance.getSessionIntervalTime());
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void initHandler() {
        try {
            HandlerThread handlerThread = new HandlerThread("SENSORS_DATA_THREAD");
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i11 = message.what;
                    if (i11 != 0) {
                        if (i11 == 100) {
                            ActivityLifecycleCallbacks.this.handleStartedMessage(message);
                        } else if (i11 == 200) {
                            ActivityLifecycleCallbacks.this.handleStoppedMessage(message);
                        } else if (i11 == 300) {
                            if (ActivityLifecycleCallbacks.this.mSensorsDataInstance.isAutoTrackEnabled() && ActivityLifecycleCallbacks.this.isAutoTrackAppEnd()) {
                                ActivityLifecycleCallbacks.this.generateAppEndData(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                            } else if (!ActivityLifecycleCallbacks.this.mSensorsDataInstance.isAutoTrackEnabled() && ActivityLifecycleCallbacks.this.mStartTime > 0) {
                                long unused = ActivityLifecycleCallbacks.this.mStartTime = 0;
                                DbAdapter.getInstance().commitAppStartTime(ActivityLifecycleCallbacks.this.mStartTime);
                                ActivityLifecycleCallbacks.this.generateAppEndData(System.currentTimeMillis(), SystemClock.elapsedRealtime());
                            }
                            if (ActivityLifecycleCallbacks.this.mStartTimerCount > 0) {
                                ActivityLifecycleCallbacks.this.mHandler.sendEmptyMessageDelayed(300, 2000);
                            }
                        }
                    } else if (ActivityLifecycleCallbacks.this.messageReceiveTime == 0 || SystemClock.elapsedRealtime() - ActivityLifecycleCallbacks.this.messageReceiveTime >= ((long) ActivityLifecycleCallbacks.this.mSensorsDataInstance.getSessionIntervalTime())) {
                        long unused2 = ActivityLifecycleCallbacks.this.messageReceiveTime = SystemClock.elapsedRealtime();
                        Bundle data = message.getData();
                        String string = data.getString(DbParams.PersistentName.APP_END_DATA);
                        if (data.getBoolean("app_reset_state")) {
                            if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
                                SAModuleManager.getInstance().getAdvertModuleService().commitRequestDeferredDeeplink(false);
                            }
                            ActivityLifecycleCallbacks.this.resetState();
                            if (DbAdapter.getInstance().getActivityCount() <= 0) {
                                ActivityLifecycleCallbacks.this.trackAppEnd(string);
                                return;
                            }
                            return;
                        }
                        ActivityLifecycleCallbacks.this.trackAppEnd(string);
                    } else {
                        SALog.i(ActivityLifecycleCallbacks.TAG, "$AppEnd 事件已触发。");
                    }
                }
            };
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* access modifiers changed from: private */
    public boolean isAutoTrackAppEnd() {
        return !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_END);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isSessionTimeOut() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 946656000000(0xdc69183800, double:4.677102080295E-312)
            long r0 = java.lang.Math.max(r0, r2)
            r2 = 0
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r4 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = r4.getAppExitData()     // Catch:{ Exception -> 0x003d }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x003d }
            if (r5 != 0) goto L_0x0044
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x003d }
            r5.<init>(r4)     // Catch:{ Exception -> 0x003d }
            java.lang.String r4 = "event_time"
            long r6 = r5.optLong(r4)     // Catch:{ Exception -> 0x003d }
            r8 = 2000(0x7d0, double:9.88E-321)
            long r6 = r6 - r8
            long r8 = r10.mStartTime     // Catch:{ Exception -> 0x003b }
            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0043
            java.lang.String r2 = "app_start_time"
            long r2 = r5.optLong(r2)     // Catch:{ Exception -> 0x003b }
            r10.updateStartTime(r2)     // Catch:{ Exception -> 0x003b }
            goto L_0x0043
        L_0x003b:
            r2 = move-exception
            goto L_0x0040
        L_0x003d:
            r4 = move-exception
            r6 = r2
            r2 = r4
        L_0x0040:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)
        L_0x0043:
            r2 = r6
        L_0x0044:
            long r0 = r0 - r2
            long r0 = java.lang.Math.abs(r0)
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r10.mSensorsDataInstance
            int r2 = r2.getSessionIntervalTime()
            long r2 = (long) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0056
            r0 = 1
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.autotrack.ActivityLifecycleCallbacks.isSessionTimeOut():boolean");
    }

    private Message obtainAppEndMessage(boolean z11) {
        Message obtain = Message.obtain(this.mHandler);
        obtain.what = 0;
        Bundle bundle = new Bundle();
        bundle.putString(DbParams.PersistentName.APP_END_DATA, DbAdapter.getInstance().getAppExitData());
        bundle.putBoolean("app_reset_state", z11);
        obtain.setData(bundle);
        return obtain;
    }

    private void registerAdvertObserver() {
        if (SAModuleManager.getInstance().hasModuleByName(ModuleConstants.ModuleName.ADVERT_NAME)) {
            SAEventBus.getInstance().register(SAEventBusConstants.Tag.DEEPLINK_LAUNCH, new Subscription<JSONObject>() {
                public void notify(JSONObject jSONObject) {
                    SAModuleManager.getInstance().getAdvertModuleService().removeDeepLinkInfo(ActivityLifecycleCallbacks.this.endDataProperty);
                    SensorsDataUtils.mergeJSONObject(jSONObject, ActivityLifecycleCallbacks.this.endDataProperty);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void resetState() {
        try {
            this.mSensorsDataInstance.stopTrackScreenOrientation();
            this.mSensorsDataInstance.getRemoteManager().resetPullSDKConfigTimer();
            HeatMapService.getInstance().stop();
            VisualizedAutoTrackService.getInstance().stop();
            this.mSensorsDataInstance.appEnterBackground();
            this.resumeFromBackground = true;
            this.mSensorsDataInstance.clearLastScreenUrl();
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void sendActivityHandleMessage(int i11) {
        Message obtainMessage = this.mHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putLong(CrashHianalyticsData.TIME, System.currentTimeMillis());
        bundle.putLong("elapse_time", SystemClock.elapsedRealtime());
        obtainMessage.what = i11;
        obtainMessage.setData(bundle);
        this.mHandler.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    public void trackAppEnd(String str) {
        try {
            if (this.mSensorsDataInstance.isAutoTrackEnabled() && isAutoTrackAppEnd() && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("track_timer")) {
                    jSONObject.put(EVENT_TIME, jSONObject.optLong("track_timer") + 2000);
                    jSONObject.remove("event_timer");
                    jSONObject.remove("track_timer");
                }
                jSONObject.remove(DbParams.TABLE_APP_START_TIME);
                this.mSensorsDataInstance.trackAutoEvent("$AppEnd", jSONObject);
                this.mDbAdapter.commitAppExitData("");
                this.mSensorsDataInstance.flush();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|(1:10)(1:11)|12|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        r6 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r2.commitAppStartTime(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r2 = r5.mDbAdapter;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r6 > 0) goto L_0x001a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0014 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateStartTime(long r6) {
        /*
            r5 = this;
            r0 = 0
            r5.mStartTime = r6     // Catch:{ Exception -> 0x0014 }
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r2 = r5.mDbAdapter     // Catch:{ Exception -> 0x0014 }
            int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x000c
            r3 = r6
            goto L_0x0010
        L_0x000c:
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0014 }
        L_0x0010:
            r2.commitAppStartTime(r3)     // Catch:{ Exception -> 0x0014 }
            goto L_0x0022
        L_0x0014:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r2 = r5.mDbAdapter     // Catch:{ Exception -> 0x0022 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x001b
            goto L_0x001f
        L_0x001b:
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0022 }
        L_0x001f:
            r2.commitAppStartTime(r6)     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.autotrack.ActivityLifecycleCallbacks.updateStartTime(long):void");
    }

    public void addActivity(Activity activity) {
        if (activity != null) {
            this.hashSet.add(Integer.valueOf(activity.hashCode()));
        }
    }

    public boolean hasActivity(Activity activity) {
        if (activity != null) {
            return this.hashSet.contains(Integer.valueOf(activity.hashCode()));
        }
        return false;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity)) {
            SensorsDataUtils.handleSchemeUrl(activity, activity.getIntent());
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        JSONObject trackProperties;
        try {
            buildScreenProperties(activity);
            if (this.mSensorsDataInstance.isAutoTrackEnabled() && !this.mSensorsDataInstance.isActivityAutoTrackAppViewScreenIgnored(activity.getClass()) && !this.mSensorsDataInstance.isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                JSONObject jSONObject = new JSONObject();
                SensorsDataUtils.mergeJSONObject(this.activityProperty, jSONObject);
                if ((activity instanceof ScreenAutoTracker) && (trackProperties = ((ScreenAutoTracker) activity).getTrackProperties()) != null) {
                    SensorsDataUtils.mergeJSONObject(trackProperties, jSONObject);
                }
                this.mSensorsDataInstance.trackViewScreen(SensorsDataUtils.getScreenUrl(activity), SADataHelper.appendLibMethodAutoTrack(jSONObject));
            }
        } catch (Throwable th2) {
            SALog.i(TAG, th2);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && !hasActivity(activity)) {
            if (this.mStartActivityCount == 0) {
                buildScreenProperties(activity);
            }
            sendActivityHandleMessage(100);
            addActivity(activity);
        }
    }

    public void onActivityStopped(Activity activity) {
        if (!SensorsDataDialogUtils.isSchemeActivity(activity) && hasActivity(activity)) {
            sendActivityHandleMessage(200);
            removeActivity(activity);
        }
    }

    public void onNewIntent(Intent intent) {
    }

    public void removeActivity(Activity activity) {
        if (activity != null) {
            this.hashSet.remove(Integer.valueOf(activity.hashCode()));
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        if (TextUtils.isEmpty(DbAdapter.getInstance().getAppExitData())) {
            DbAdapter.getInstance().commitAppStartTime(SystemClock.elapsedRealtime());
        }
        if (AbstractSensorsDataAPI.getConfigOptions().isMultiProcessFlush()) {
            DbAdapter.getInstance().commitSubProcessFlushState(false);
        }
        DbAdapter.getInstance().commitActivityCount(0);
    }
}
