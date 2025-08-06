package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserMetadata.SerializeableKeysMap f67064b;

    public /* synthetic */ b(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.f67064b = serializeableKeysMap;
    }

    public final Object call() {
        return this.f67064b.lambda$scheduleSerializationTaskIfNeeded$0();
    }
}
