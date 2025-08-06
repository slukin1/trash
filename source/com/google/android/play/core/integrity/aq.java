package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.ag;
import com.google.android.play.integrity.internal.r;

final class aq extends r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f66796a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ax f66797b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aq(ax axVar, TaskCompletionSource taskCompletionSource, Context context) {
        super(taskCompletionSource);
        this.f66797b = axVar;
        this.f66796a = context;
    }

    public final void b() {
        this.f66797b.f66814d.trySetResult(Boolean.valueOf(ag.a(this.f66796a)));
    }
}
