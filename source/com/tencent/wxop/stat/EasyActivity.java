package com.tencent.wxop.stat;

import android.app.Activity;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class EasyActivity extends Activity {
    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onPause() {
        super.onPause();
        e.m(this);
    }

    public void onResume() {
        super.onResume();
        e.l(this);
    }
}
