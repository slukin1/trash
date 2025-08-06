package com.huawei.hms.update.note;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.support.log.HMSLog;

public class DoNothingResolution implements IBridgeActivityDelegate {
    public int getRequestCode() {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution getRequestCode>");
        return 0;
    }

    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("DoNothingResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        activity.setResult(30);
        activity.finish();
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityDestroy>");
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeActivityResult>");
        return false;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onBridgeConfigurationChanged>");
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("DoNothingResolution", "<DoNothingResolution onKeyUp>");
    }
}
