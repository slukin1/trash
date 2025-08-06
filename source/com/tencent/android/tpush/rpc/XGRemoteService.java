package com.tencent.android.tpush.rpc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.service.b;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.SERVICESCHECK})
public class XGRemoteService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a.C0750a f69488a = new d();

    public IBinder onBind(Intent intent) {
        b.b(getApplicationContext());
        return this.f69488a;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        return 2;
    }
}
