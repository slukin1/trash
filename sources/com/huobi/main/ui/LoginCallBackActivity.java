package com.huobi.main.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import gj.a;
import pro.huobi.R;

public class LoginCallBackActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a.b().c()) {
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        }
        zn.a.d().c();
        finish();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
