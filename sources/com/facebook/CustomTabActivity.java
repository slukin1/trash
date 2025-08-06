package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import s1.a;

public class CustomTabActivity extends Activity {
    public static final String CUSTOM_TAB_REDIRECT_ACTION;
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public static final String DESTROY_ACTION;
    private BroadcastReceiver closeReceiver;

    static {
        Class<CustomTabActivity> cls = CustomTabActivity.class;
        CUSTOM_TAB_REDIRECT_ACTION = cls.getSimpleName() + ".action_customTabRedirect";
        DESTROY_ACTION = cls.getSimpleName() + ".action_destroy";
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            a.b(this).d(intent2);
            this.closeReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    CustomTabActivity.this.finish();
                }
            };
            a.b(this).c(this.closeReceiver, new IntentFilter(DESTROY_ACTION));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    public void onDestroy() {
        a.b(this).e(this.closeReceiver);
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
