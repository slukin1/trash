package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFInAppEventType;

public final class bn extends bk {
    public bn(Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    public final g AFInAppEventParameterName(String str) {
        return super.AFInAppEventParameterName(AFKeystoreWrapper(str));
    }
}
