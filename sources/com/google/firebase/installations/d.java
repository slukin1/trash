package com.google.firebase.installations;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f67100b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f67101c;

    public /* synthetic */ d(FirebaseInstallations firebaseInstallations, boolean z11) {
        this.f67100b = firebaseInstallations;
        this.f67101c = z11;
    }

    public final void run() {
        this.f67100b.lambda$getToken$2(this.f67101c);
    }
}
