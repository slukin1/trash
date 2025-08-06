package com.huawei.hms.utils;

import android.content.Intent;
import android.os.Build;

public class IntentUtil {
    public static Intent modifyIntentBehaviorsSafe(Intent intent) {
        if (intent == null) {
            return null;
        }
        String action = intent.getAction();
        if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action) || "android.media.action.IMAGE_CAPTURE".equals(action) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(action) || "android.media.action.VIDEO_CAPTURE".equals(action)) {
            intent.setAction("android.intent.action.VIEW");
        }
        int flags = intent.getFlags();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            flags &= -129;
        }
        if (i11 >= 19) {
            flags &= -65;
        }
        intent.setFlags(flags & -2 & -3);
        return intent;
    }
}
