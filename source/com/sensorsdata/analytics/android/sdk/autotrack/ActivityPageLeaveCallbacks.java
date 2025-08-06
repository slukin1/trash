package com.sensorsdata.analytics.android.sdk.autotrack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.autotrack.utils.AutoTrackUtils;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityPageLeaveCallbacks implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String START_TIME = "sa_start_time";
    private final String DIALOG_ACTIVITY = "com.sensorsdata.sf.ui.view.DialogActivity";
    private List<Class<?>> mIgnoreList;
    private final boolean mIsEmpty;
    private final HashMap<Integer, JSONObject> mResumedActivities = new HashMap<>();

    public ActivityPageLeaveCallbacks(List<Class<?>> list) {
        if (list == null || list.isEmpty()) {
            this.mIsEmpty = true;
            return;
        }
        this.mIgnoreList = list;
        this.mIsEmpty = false;
    }

    private boolean ignorePage(Object obj) {
        if (!this.mIsEmpty) {
            return this.mIgnoreList.contains(obj.getClass());
        }
        return false;
    }

    private void trackActivityStart(Activity activity) {
        try {
            if (!"com.sensorsdata.sf.ui.view.DialogActivity".equals(activity.getClass().getCanonicalName())) {
                JSONObject buildTitleAndScreenName = AopUtil.buildTitleAndScreenName(activity);
                String screenUrl = SensorsDataUtils.getScreenUrl(activity);
                buildTitleAndScreenName.put("$url", screenUrl);
                String lastScreenUrl = AutoTrackUtils.getLastScreenUrl();
                if (!buildTitleAndScreenName.has("$referrer") && !TextUtils.isEmpty(lastScreenUrl)) {
                    buildTitleAndScreenName.put("$referrer", lastScreenUrl);
                }
                buildTitleAndScreenName.put(START_TIME, SystemClock.elapsedRealtime());
                this.mResumedActivities.put(Integer.valueOf(activity.hashCode()), buildTitleAndScreenName);
                AutoTrackUtils.setLastScreenUrl(screenUrl);
            }
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void trackAppPageLeave(JSONObject jSONObject) {
        try {
            long optLong = jSONObject.optLong(START_TIME);
            jSONObject.remove(START_TIME);
            double duration = TimeUtils.duration(optLong, SystemClock.elapsedRealtime());
            if (duration >= 0.05d) {
                jSONObject.put("event_duration", duration);
                SensorsDataAPI.sharedInstance().trackInternal("$AppPageLeave", jSONObject);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        String str;
        long j11;
        try {
            int hashCode = activity.hashCode();
            if (this.mResumedActivities.containsKey(Integer.valueOf(hashCode))) {
                JSONObject jSONObject = this.mResumedActivities.get(Integer.valueOf(hashCode));
                if (jSONObject == null) {
                    str = "";
                } else {
                    str = jSONObject.optString("$referrer");
                }
                if (jSONObject == null) {
                    j11 = 0;
                } else {
                    j11 = jSONObject.optLong(START_TIME);
                }
                JSONObject buildTitleAndScreenName = AopUtil.buildTitleAndScreenName(activity);
                buildTitleAndScreenName.put(START_TIME, j11);
                buildTitleAndScreenName.put("$url", SensorsDataUtils.getScreenUrl(activity));
                if (!TextUtils.isEmpty(str)) {
                    buildTitleAndScreenName.put("$referrer", str);
                }
                trackAppPageLeave(buildTitleAndScreenName);
                this.mResumedActivities.remove(Integer.valueOf(hashCode));
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (!ignorePage(activity)) {
            trackActivityStart(activity);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            Iterator<Integer> it2 = this.mResumedActivities.keySet().iterator();
            while (it2.hasNext()) {
                JSONObject jSONObject = this.mResumedActivities.get(Integer.valueOf(it2.next().intValue()));
                if (jSONObject != null) {
                    trackAppPageLeave(jSONObject);
                    it2.remove();
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
