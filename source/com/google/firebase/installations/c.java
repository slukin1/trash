package com.google.firebase.installations;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FirebaseInstallations f67098b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f67099c;

    public /* synthetic */ c(FirebaseInstallations firebaseInstallations, boolean z11) {
        this.f67098b = firebaseInstallations;
        this.f67099c = z11;
    }

    public final void run() {
        this.f67098b.lambda$doRegistrationOrRefresh$3(this.f67099c);
    }
}
