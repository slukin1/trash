package com.engagelab.privates.common.component;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.engagelab.privates.common.binder.MTMessenger;
import com.engagelab.privates.common.log.MTCommonLog;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class MTCommonService extends Service {
    private static final String TAG = "MTCommonService";

    public final IBinder onBind(Intent intent) {
        return MTMessenger.getInstance().getBinder();
    }

    public final void onCreate() {
        MTCommonLog.i(TAG, "onService create");
        MTMessenger.getInstance().initOnRemoteProcess(getApplicationContext());
    }

    public final void onDestroy() {
        MTCommonLog.i(TAG, "onService destroy");
    }

    public final int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        return 2;
    }

    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
