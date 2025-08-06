package com.facebook;

import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Random;

public class FacebookException extends RuntimeException {
    public static final long serialVersionUID = 1;

    public FacebookException() {
    }

    public String toString() {
        return getMessage();
    }

    public FacebookException(final String str) {
        super(str);
        Random random = new Random();
        if (str != null && FacebookSdk.isInitialized() && random.nextInt(100) > 50) {
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new FeatureManager.Callback() {
                public void onCompleted(boolean z11) {
                    if (z11) {
                        try {
                            ErrorReportHandler.save(str);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public FacebookException(String str, Throwable th2) {
        super(str, th2);
    }

    public FacebookException(Throwable th2) {
        super(th2);
    }
}
