package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.i;

final class ar extends aw {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f66798a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f66799b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ax f66800c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ar(ax axVar, TaskCompletionSource taskCompletionSource, long j11, TaskCompletionSource taskCompletionSource2) {
        super(axVar, taskCompletionSource);
        this.f66800c = axVar;
        this.f66798a = j11;
        this.f66799b = taskCompletionSource2;
    }

    public final void b() {
        if (ax.g(this.f66800c)) {
            super.a(new StandardIntegrityException(-2, (Throwable) null));
            return;
        }
        try {
            ax axVar = this.f66800c;
            ((i) axVar.f66811a.e()).d(ax.b(axVar, this.f66798a), new av(this.f66800c, this.f66799b));
        } catch (RemoteException e11) {
            this.f66800c.f66812b.b(e11, "warmUpIntegrityToken(%s)", Long.valueOf(this.f66798a));
            this.f66799b.trySetException(new StandardIntegrityException(-100, e11));
        }
    }
}
