package com.huawei.hms.activity.internal;

import android.app.Activity;
import android.content.Intent;

public interface BusResponseCallback {
    BusResponseResult innerError(Activity activity, int i11, String str);

    BusResponseResult succeedReturn(Activity activity, int i11, Intent intent);
}
