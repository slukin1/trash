package com.huawei.hms.opendevice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.huawei.hms.support.log.HMSLog;

public class k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ServiceConnection f38318a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Messenger f38319b = null;

    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f38320a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f38321b;

        public a(Bundle bundle, Context context) {
            this.f38320a = bundle;
            this.f38321b = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            Messenger unused = k.this.f38319b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f38320a);
            try {
                k.this.f38319b.send(obtain);
            } catch (RemoteException unused2) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f38321b.unbindService(k.this.f38318a);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            Messenger unused = k.this.f38319b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f38318a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f38318a, 1);
    }
}
