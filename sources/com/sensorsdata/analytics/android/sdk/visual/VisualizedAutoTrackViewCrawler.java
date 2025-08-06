package com.sensorsdata.analytics.android.sdk.visual;

import android.app.Activity;
import com.sensorsdata.analytics.android.sdk.SALog;

class VisualizedAutoTrackViewCrawler extends AbstractViewCrawler {
    private VisualDebugHelper mVisualDebugHelper;

    public VisualizedAutoTrackViewCrawler(Activity activity, String str, String str2, String str3, VisualDebugHelper visualDebugHelper) {
        super(activity, str, str2, str3, AbstractViewCrawler.TYPE_VISUAL);
        this.mVisualDebugHelper = visualDebugHelper;
    }

    public void startUpdates() {
        try {
            super.startUpdates();
            VisualDebugHelper visualDebugHelper = this.mVisualDebugHelper;
            if (visualDebugHelper != null) {
                visualDebugHelper.stopMonitor();
                this.mVisualDebugHelper.startMonitor();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public void stopUpdates(boolean z11) {
        try {
            super.stopUpdates(z11);
            VisualDebugHelper visualDebugHelper = this.mVisualDebugHelper;
            if (visualDebugHelper != null) {
                visualDebugHelper.stopMonitor();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
