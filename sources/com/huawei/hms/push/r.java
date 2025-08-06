package com.huawei.hms.push;

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

public class r {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ServiceConnection f38434a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Messenger f38435b = null;

    public class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f38436a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f38437b;

        public a(Bundle bundle, Context context) {
            this.f38436a = bundle;
            this.f38437b = context;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            HMSLog.i("RemoteService", "remote service onConnected");
            Messenger unused = r.this.f38435b = new Messenger(iBinder);
            Message obtain = Message.obtain();
            obtain.setData(this.f38436a);
            try {
                r.this.f38435b.send(obtain);
            } catch (RemoteException unused2) {
                HMSLog.i("RemoteService", "remote service message send failed");
            }
            HMSLog.i("RemoteService", "remote service unbindservice");
            this.f38437b.unbindService(r.this.f38434a);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            HMSLog.i("RemoteService", "remote service onDisconnected");
            Messenger unused = r.this.f38435b = null;
        }
    }

    public boolean a(Context context, Bundle bundle, Intent intent) {
        Context applicationContext = context.getApplicationContext();
        this.f38434a = new a(bundle, applicationContext);
        HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.f38434a, 1);
    }
}
