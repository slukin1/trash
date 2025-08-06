package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.i;

final class as extends aw {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f66801a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f66802b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f66803c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f66804d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ax f66805e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public as(ax axVar, TaskCompletionSource taskCompletionSource, String str, long j11, long j12, TaskCompletionSource taskCompletionSource2) {
        super(axVar, taskCompletionSource);
        this.f66805e = axVar;
        this.f66801a = str;
        this.f66802b = j11;
        this.f66803c = j12;
        this.f66804d = taskCompletionSource2;
    }

    public final void b() {
        if (ax.g(this.f66805e)) {
            super.a(new StandardIntegrityException(-2, (Throwable) null));
            return;
        }
        try {
            ax axVar = this.f66805e;
            ((i) axVar.f66811a.e()).c(ax.a(axVar, this.f66801a, this.f66802b, this.f66803c), new au(this.f66805e, this.f66804d));
        } catch (RemoteException e11) {
            this.f66805e.f66812b.b(e11, "requestExpressIntegrityToken(%s, %s)", this.f66801a, Long.valueOf(this.f66802b));
            this.f66804d.trySetException(new StandardIntegrityException(-100, e11));
        }
    }
}
