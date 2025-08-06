package com.sensorsdata.analytics.android.sdk.dialog;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation;
import com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreen;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;

@SensorsDataIgnoreTrackAppViewScreen
public class SchemeActivity extends Activity {
    public static final String SCHEME_ACTIVITY_SIGN = "#*#scheme_activity_sign#*#";
    private static final String TAG = "SA.SchemeActivity";
    public static boolean isPopWindow = false;
    private boolean isStartApp = false;

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SALog.i(TAG, "onCreate");
        try {
            requestWindowFeature(1);
            if (Build.VERSION.SDK_INT >= 14) {
                setTheme(16974123);
            } else {
                setTheme(16973836);
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        if (SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) {
            SensorsDataDialogUtils.startLaunchActivity(this);
        } else {
            SensorsDataUtils.handleSchemeUrl(this, getIntent());
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (SensorsDataAPI.sharedInstance() instanceof SensorsDataAPIEmptyImplementation) {
            SensorsDataDialogUtils.startLaunchActivity(this);
        } else {
            SensorsDataUtils.handleSchemeUrl(this, getIntent());
        }
    }

    public void onPause() {
        super.onPause();
        SALog.i(TAG, "onPause");
        if (isPopWindow) {
            isPopWindow = false;
            this.isStartApp = true;
        }
    }

    public void onResume() {
        super.onResume();
        SALog.i(TAG, "onResume");
        if (this.isStartApp) {
            this.isStartApp = false;
            SensorsDataDialogUtils.startLaunchActivity(this);
        }
    }
}
