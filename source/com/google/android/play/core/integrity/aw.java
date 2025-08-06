package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ad;
import com.google.android.play.integrity.internal.r;

abstract class aw extends r {

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ax f66810f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aw(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(taskCompletionSource);
        this.f66810f = axVar;
    }

    public final void a(Exception exc) {
        if (!(exc instanceof ad)) {
            super.a(exc);
        } else if (ax.g(this.f66810f)) {
            super.a(new StandardIntegrityException(-2, exc));
        } else {
            super.a(new StandardIntegrityException(-9, exc));
        }
    }
}
