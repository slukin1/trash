package com.google.firebase.installations;

import java.util.concurrent.Callable;

public final /* synthetic */ class e implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f67102b;

    public /* synthetic */ e(FirebaseInstallations firebaseInstallations) {
        this.f67102b = firebaseInstallations;
    }

    public final Object call() {
        return this.f67102b.deleteFirebaseInstallationId();
    }
}
