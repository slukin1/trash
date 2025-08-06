package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

final class u extends r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f66892a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r f66893b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ac f66894c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(ac acVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, r rVar) {
        super(taskCompletionSource);
        this.f66894c = acVar;
        this.f66892a = taskCompletionSource2;
        this.f66893b = rVar;
    }

    public final void b() {
        synchronized (this.f66894c.f66869g) {
            ac.o(this.f66894c, this.f66892a);
            if (this.f66894c.f66875m.getAndIncrement() > 0) {
                this.f66894c.f66865c.c("Already connected to the service.", new Object[0]);
            }
            ac.q(this.f66894c, this.f66893b);
        }
    }
}
