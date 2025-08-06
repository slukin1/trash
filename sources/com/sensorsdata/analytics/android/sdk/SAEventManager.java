package com.sensorsdata.analytics.android.sdk;

import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import org.json.JSONObject;

public class SAEventManager {
    private static final String TAG = "SA.EventManager";
    private static volatile SAEventManager mSingleton;

    private SAEventManager() {
    }

    public static SAEventManager getInstance() {
        if (mSingleton == null) {
            synchronized (SAEventManager.class) {
                if (mSingleton == null) {
                    mSingleton = new SAEventManager();
                }
            }
        }
        return mSingleton;
    }

    public void trackEvent(EventType eventType, String str, JSONObject jSONObject, String str2) {
        SensorsDataAPI.sharedInstance().trackEvent(eventType, str, jSONObject, str2);
    }

    public void trackQueueEvent(Runnable runnable) {
        TrackTaskManager.getInstance().addTrackEventTask(runnable);
    }

    public void trackTransformQueueEvent(Runnable runnable) {
        SensorsDataAPI.sharedInstance().transformTaskQueue(runnable);
    }

    public void trackEvent(EventType eventType, String str, JSONObject jSONObject, JSONObject jSONObject2, String str2, String str3, String str4) {
        SensorsDataAPI.sharedInstance().trackEvent(eventType, str, jSONObject, jSONObject2, str2, str3, str4);
    }
}
