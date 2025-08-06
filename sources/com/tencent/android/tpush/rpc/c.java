package com.tencent.android.tpush.rpc;

import android.content.ServiceConnection;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.rpc.b;

public class c extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private ServiceConnection f69493a;

    public void a(ServiceConnection serviceConnection) {
        this.f69493a = serviceConnection;
    }

    public void a() {
        try {
            if (com.tencent.android.tpush.service.b.e() != null) {
                com.tencent.android.tpush.service.b.e().unbindService(this.f69493a);
                this.f69493a = null;
            }
        } catch (Throwable th2) {
            TLogger.e("ITaskCallbackImpl", "unBind", th2);
        }
    }
}
