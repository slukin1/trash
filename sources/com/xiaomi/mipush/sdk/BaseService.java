package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.j;
import java.lang.ref.WeakReference;

public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private a f51275a;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<BaseService> f51276a;

        public a(WeakReference<BaseService> weakReference) {
            this.f51276a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000);
        }

        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what == 1001 && (weakReference = this.f51276a) != null && (baseService = (BaseService) weakReference.get()) != null) {
                b.c("TimeoutHandler " + baseService.toString() + " kill self");
                if (!baseService.a()) {
                    baseService.stopSelf();
                    return;
                }
                b.c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000);
            }
        }
    }

    public abstract boolean a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i11) {
        super.onStart(intent, i11);
        if (this.f51275a == null) {
            this.f51275a = new a(new WeakReference(this));
        }
        this.f51275a.a();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        int onStartCommand = super.onStartCommand(intent, i11, i12);
        if (j.a((Context) this)) {
            return onStartCommand;
        }
        return 2;
    }
}
