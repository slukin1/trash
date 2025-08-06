package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class z implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestDeduplicator f67156a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f67157b;

    public /* synthetic */ z(RequestDeduplicator requestDeduplicator, String str) {
        this.f67156a = requestDeduplicator;
        this.f67157b = str;
    }

    public final Object then(Task task) {
        return this.f67156a.lambda$getOrStartGetTokenRequest$0(this.f67157b, task);
    }
}
