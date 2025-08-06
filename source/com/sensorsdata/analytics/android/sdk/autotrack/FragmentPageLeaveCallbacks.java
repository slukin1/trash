package com.sensorsdata.analytics.android.sdk.autotrack;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.autotrack.utils.AutoTrackUtils;
import com.sensorsdata.analytics.android.sdk.util.AopUtil;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentPageLeaveCallbacks implements SAFragmentLifecycleCallbacks, SensorsDataExceptionHandler.SAExceptionListener {
    private static final String START_TIME = "sa_start_time";
    private List<Class<?>> mIgnoreList;
    private final boolean mIsEmpty;
    private final HashMap<Integer, JSONObject> mResumedFragments = new HashMap<>();

    public FragmentPageLeaveCallbacks(List<Class<?>> list) {
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

    private void trackAppPageLeave(Object obj) {
        long j11;
        String str;
        try {
            int hashCode = obj.hashCode();
            if (this.mResumedFragments.containsKey(Integer.valueOf(hashCode))) {
                JSONObject jSONObject = this.mResumedFragments.get(Integer.valueOf(hashCode));
                if (jSONObject == null) {
                    j11 = 0;
                } else {
                    j11 = jSONObject.optLong(START_TIME);
                }
                if (jSONObject == null) {
                    str = "";
                } else {
                    str = jSONObject.optString("$referrer");
                }
                JSONObject jSONObject2 = new JSONObject();
                AopUtil.getScreenNameAndTitleFromFragment(jSONObject2, obj, (Activity) null);
                jSONObject2.put(START_TIME, j11);
                jSONObject2.put("$url", SensorsDataUtils.getScreenUrl(obj));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("$referrer", str);
                }
                this.mResumedFragments.remove(Integer.valueOf(hashCode));
                trackPageLeaveEvent(jSONObject2);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void trackFragmentStart(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(START_TIME, SystemClock.elapsedRealtime());
            String screenUrl = SensorsDataUtils.getScreenUrl(obj);
            jSONObject.put("$url", screenUrl);
            String lastScreenUrl = AutoTrackUtils.getLastScreenUrl();
            if (!TextUtils.isEmpty(lastScreenUrl)) {
                jSONObject.put("$referrer", lastScreenUrl);
            }
            AopUtil.getScreenNameAndTitleFromFragment(jSONObject, obj, (Activity) null);
            this.mResumedFragments.put(Integer.valueOf(obj.hashCode()), jSONObject);
            AutoTrackUtils.setLastScreenUrl(screenUrl);
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
    }

    private void trackPageLeaveEvent(JSONObject jSONObject) {
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

    public void onCreate(Object obj) {
    }

    public void onHiddenChanged(Object obj, boolean z11) {
        if (ignorePage(obj)) {
            return;
        }
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    public void onPause(Object obj) {
        try {
            if (this.mResumedFragments.containsKey(Integer.valueOf(obj.hashCode()))) {
                trackAppPageLeave(obj);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void onResume(Object obj) {
        if (!ignorePage(obj) && SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        }
    }

    public void onStart(Object obj) {
    }

    public void onStop(Object obj) {
    }

    public void onViewCreated(Object obj, View view, Bundle bundle) {
    }

    public void setUserVisibleHint(Object obj, boolean z11) {
        if (ignorePage(obj)) {
            return;
        }
        if (SAFragmentUtils.isFragmentVisible(obj)) {
            trackFragmentStart(obj);
        } else {
            trackAppPageLeave(obj);
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            Iterator<Integer> it2 = this.mResumedFragments.keySet().iterator();
            while (it2.hasNext()) {
                JSONObject jSONObject = this.mResumedFragments.get(Integer.valueOf(it2.next().intValue()));
                if (jSONObject != null) {
                    trackPageLeaveEvent(jSONObject);
                    it2.remove();
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
