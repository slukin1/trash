package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class v implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f67149a;

    public /* synthetic */ v(GmsRpc gmsRpc) {
        this.f67149a = gmsRpc;
    }

    public final Object then(Task task) {
        return this.f67149a.lambda$extractResponseWhenComplete$0(task);
    }
}
