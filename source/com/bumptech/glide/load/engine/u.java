package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public boolean f63933a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f63934b = new Handler(Looper.getMainLooper(), new a());

    public static final class a implements Handler.Callback {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((r) message.obj).recycle();
            return true;
        }
    }

    public synchronized void a(r<?> rVar, boolean z11) {
        if (!this.f63933a) {
            if (!z11) {
                this.f63933a = true;
                rVar.recycle();
                this.f63933a = false;
            }
        }
        this.f63934b.obtainMessage(1, rVar).sendToTarget();
    }
}
