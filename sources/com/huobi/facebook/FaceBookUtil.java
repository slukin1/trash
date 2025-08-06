package com.huobi.facebook;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;

public class FaceBookUtil {
    public static void a(Context context) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        newLogger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION);
        newLogger.flush();
    }
}
