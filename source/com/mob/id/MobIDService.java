package com.mob.id;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.mob.MobSDK;
import com.mob.mgs.impl.e;
import com.mob.mgs.impl.g;
import com.mob.tools.proguard.ClassKeeper;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class MobIDService extends Service implements ClassKeeper {
    private void a(Intent intent) {
        g.a(this, intent, false);
    }

    public IBinder onBind(Intent intent) {
        a(intent);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        try {
            MobSDK.init(getApplicationContext());
            e.a().a("[MobGod] MobIDService onCreate");
        } catch (Throwable unused) {
        }
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        if (intent != null) {
            a(intent);
        }
        return super.onStartCommand(intent, i11, i12);
    }
}
