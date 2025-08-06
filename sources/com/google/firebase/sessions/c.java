package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;

public final /* synthetic */ class c implements FirebaseAppLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f67162a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionInitiator f67163b;

    public /* synthetic */ c(Context context, SessionInitiator sessionInitiator) {
        this.f67162a = context;
        this.f67163b = sessionInitiator;
    }

    public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
        FirebaseSessions.m3247_init_$lambda0(this.f67162a, this.f67163b, str, firebaseOptions);
    }
}
