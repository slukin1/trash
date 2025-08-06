package com.huawei.hms.push;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f38393a;

    public interface a {
        void a(Message message);
    }

    public f(a aVar) {
        this.f38393a = new WeakReference<>(aVar);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = (a) this.f38393a.get();
        if (aVar != null) {
            aVar.a(message);
        }
    }
}
