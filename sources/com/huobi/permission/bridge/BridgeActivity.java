package com.huobi.permission.bridge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import bq.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import dq.b;

public final class BridgeActivity extends Activity {
    public void onActivityResult(int i11, int i12, Intent intent) {
        a.a(this);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            switch (intent.getIntExtra("KEY_TYPE", -1)) {
                case 1:
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", getPackageName(), (String) null));
                    startActivityForResult(intent2, 1);
                    return;
                case 2:
                    String[] stringArrayExtra = intent.getStringArrayExtra("KEY_PERMISSIONS");
                    if (Build.VERSION.SDK_INT >= 23) {
                        requestPermissions(stringArrayExtra, 2);
                        return;
                    }
                    return;
                case 3:
                    Intent intent3 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent3.setData(Uri.fromParts("package", getPackageName(), (String) null));
                    startActivityForResult(intent3, 3);
                    return;
                case 4:
                    new b(new eq.a(this)).e(4);
                    return;
                case 5:
                    new dq.a(new eq.a(this)).f(5);
                    return;
                case 6:
                    Intent intent4 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent4.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                    startActivityForResult(intent4, 6);
                    return;
                case 7:
                    startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), 7);
                    return;
                case 8:
                    Intent intent5 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent5.setData(Uri.fromParts("package", getPackageName(), (String) null));
                    startActivityForResult(intent5, 8);
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 4) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        a.a(this);
        finish();
    }

    public void startActivityForResult(Intent intent, int i11) {
        super.startActivityForResult(intent, i11);
    }
}
