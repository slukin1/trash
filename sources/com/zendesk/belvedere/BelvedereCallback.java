package com.zendesk.belvedere;

import android.os.Handler;
import android.os.Looper;

public abstract class BelvedereCallback<E> {
    private boolean canceled = false;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f52732b;

        public a(Object obj) {
            this.f52732b = obj;
        }

        public void run() {
            BelvedereCallback.this.success(this.f52732b);
        }
    }

    public void cancel() {
        this.canceled = true;
    }

    public void internalSuccess(E e11) {
        if (!this.canceled) {
            new Handler(Looper.getMainLooper()).post(new a(e11));
        }
    }

    public abstract void success(E e11);
}
