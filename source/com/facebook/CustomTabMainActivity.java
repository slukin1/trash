package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.internal.CustomTab;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import s1.a;

public class CustomTabMainActivity extends Activity {
    public static final String EXTRA_CHROME_PACKAGE;
    public static final String EXTRA_PARAMS;
    public static final String EXTRA_URL;
    private static final String OAUTH_DIALOG = "oauth";
    public static final String REFRESH_ACTION;
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    static {
        Class<CustomTabMainActivity> cls = CustomTabMainActivity.class;
        EXTRA_PARAMS = cls.getSimpleName() + ".extra_params";
        EXTRA_CHROME_PACKAGE = cls.getSimpleName() + ".extra_chromePackage";
        EXTRA_URL = cls.getSimpleName() + ".extra_url";
        REFRESH_ACTION = cls.getSimpleName() + ".action_refresh";
    }

    private void sendResult(int i11, Intent intent) {
        a.b(this).e(this.redirectReceiver);
        if (intent != null) {
            setResult(i11, intent);
        } else {
            setResult(i11);
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        if (str.equals(getIntent().getAction())) {
            setResult(0);
            finish();
        } else if (bundle == null) {
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            new CustomTab(OAUTH_DIALOG, bundleExtra).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
            this.shouldCloseCustomTab = false;
            this.redirectReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    Intent intent2 = new Intent(CustomTabMainActivity.this, CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    String str = CustomTabMainActivity.EXTRA_URL;
                    intent2.putExtra(str, intent.getStringExtra(str));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                }
            };
            a.b(this).c(this.redirectReceiver, new IntentFilter(str));
        }
    }

    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        if (REFRESH_ACTION.equals(intent.getAction())) {
            a.b(this).d(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION.equals(intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, (Intent) null);
        }
        this.shouldCloseCustomTab = true;
    }
}
