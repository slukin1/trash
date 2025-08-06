package com.facebook.internal.instrument;

import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;

public class InstrumentManager {
    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new FeatureManager.Callback() {
                public void onCompleted(boolean z11) {
                    if (z11) {
                        CrashHandler.enable();
                    }
                }
            });
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() {
                public void onCompleted(boolean z11) {
                    if (z11) {
                        ErrorReportHandler.enable();
                    }
                }
            });
        }
    }
}
