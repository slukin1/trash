package com.hbg.lib.core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.hbg.lib.core.R$layout;

public class CommonRestartActivity extends EmptyMVPActivity {
    public static void Xf(Activity activity, Intent intent) {
        Intent intent2 = new Intent(activity, CommonRestartActivity.class);
        intent2.putExtra("extra_intent", intent);
        activity.startActivity(intent2);
        activity.finish();
    }

    public int getContentView() {
        return R$layout.activity_common_restart;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Intent intent2 = intent.hasExtra("extra_intent") ? (Intent) intent.getParcelableExtra("extra_intent") : null;
        if (intent2 != null) {
            startActivity(intent2);
        }
        finish();
    }

    public void overridePendingTransition(int i11, int i12) {
        super.overridePendingTransition(0, 0);
    }
}
