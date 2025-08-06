package com.hbg.lib.network.otc.core;

import java.io.File;
import rx.Subscriber;

public abstract class FileUploadSubscriber<T> extends Subscriber<T> {

    /* renamed from: b  reason: collision with root package name */
    public File f70566b;

    public abstract void a(int i11);

    public void b(long j11, long j12) {
        a((int) ((j11 * 100) / j12));
    }

    public abstract void c(Throwable th2, File file);

    public abstract void d(File file);

    public abstract void e(T t11, File file);

    public void f(File file) {
        this.f70566b = file;
    }

    public void onCompleted() {
    }

    public void onError(Throwable th2) {
        c(th2, this.f70566b);
    }

    public void onNext(T t11) {
        e(t11, this.f70566b);
    }

    public void onStart() {
        super.onStart();
    }
}
