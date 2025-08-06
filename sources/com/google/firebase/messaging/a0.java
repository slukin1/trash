package com.google.firebase.messaging;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesQueue f67107b;

    public /* synthetic */ a0(SharedPreferencesQueue sharedPreferencesQueue) {
        this.f67107b = sharedPreferencesQueue;
    }

    public final void run() {
        this.f67107b.syncState();
    }
}
