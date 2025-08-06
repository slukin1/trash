package com.mob.guard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

@Deprecated
public class MobTranPullLockActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getIntent() != null) {
                for (int addFlags : getIntent().getIntArrayExtra("fg")) {
                    getWindow().addFlags(addFlags);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onResume() {
        try {
            if (((PowerManager) getSystemService("power")).isScreenOn()) {
                finish();
            }
        } catch (Throwable unused) {
        }
        super.onResume();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            finish();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
