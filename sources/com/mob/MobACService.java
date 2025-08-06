package com.mob;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.mob.apc.a.a;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class MobACService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f26828a = new a(this);

    public boolean a(Intent intent) {
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        return this.f26828a.a(intent);
    }

    public void onCreate() {
        super.onCreate();
        this.f26828a.a();
    }

    public void onDestroy() {
        this.f26828a.b();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        return this.f26828a.a(intent, i11, i12);
    }

    public boolean onUnbind(Intent intent) {
        return this.f26828a.b(intent);
    }

    public int a(Intent intent, int i11, int i12) {
        return super.onStartCommand(intent, i11, i12);
    }
}
