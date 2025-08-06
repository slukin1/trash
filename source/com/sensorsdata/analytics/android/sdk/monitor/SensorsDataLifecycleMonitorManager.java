package com.sensorsdata.analytics.android.sdk.monitor;

import com.sensorsdata.analytics.android.sdk.SensorsDataActivityLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.SensorsDataExceptionHandler;
import com.sensorsdata.analytics.android.sdk.autotrack.SAFragmentLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class SensorsDataLifecycleMonitorManager {
    private static SensorsDataLifecycleMonitorManager instance = new SensorsDataLifecycleMonitorManager();
    private SensorsDataActivityLifecycleCallbacks mCallback = new SensorsDataActivityLifecycleCallbacks();

    private SensorsDataLifecycleMonitorManager() {
    }

    public static SensorsDataLifecycleMonitorManager getInstance() {
        return instance;
    }

    public void addActivityLifeCallback(SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mCallback.addActivityLifecycleCallbacks(sAActivityLifecycleCallbacks);
    }

    public void addCrashListener(SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        SensorsDataExceptionHandler.addExceptionListener(sAExceptionListener);
    }

    public void addFragmentLifeCallback(SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        FragmentTrackHelper.addFragmentCallbacks(sAFragmentLifecycleCallbacks);
    }

    public SensorsDataActivityLifecycleCallbacks getCallback() {
        return this.mCallback;
    }

    public void removeActivityLifeCallback(SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        this.mCallback.removeActivityLifecycleCallbacks(sAActivityLifecycleCallbacks);
    }

    public void removeCrashListener(SensorsDataExceptionHandler.SAExceptionListener sAExceptionListener) {
        SensorsDataExceptionHandler.removeExceptionListener(sAExceptionListener);
    }

    public void removeFragmentLifeCallback(SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        FragmentTrackHelper.removeFragmentCallbacks(sAFragmentLifecycleCallbacks);
    }
}
