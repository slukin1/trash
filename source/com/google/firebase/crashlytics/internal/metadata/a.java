package com.google.firebase.crashlytics.internal.metadata;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserMetadata f67063b;

    public /* synthetic */ a(UserMetadata userMetadata) {
        this.f67063b = userMetadata;
    }

    public final Object call() {
        return this.f67063b.lambda$setUserId$0();
    }
}
