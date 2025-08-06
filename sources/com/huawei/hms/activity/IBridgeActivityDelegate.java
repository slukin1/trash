package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

public interface IBridgeActivityDelegate {
    int getRequestCode();

    void onBridgeActivityCreate(Activity activity);

    void onBridgeActivityDestroy();

    boolean onBridgeActivityResult(int i11, int i12, Intent intent);

    void onBridgeConfigurationChanged();

    void onKeyUp(int i11, KeyEvent keyEvent);
}
