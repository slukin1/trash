package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f66959a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f66960b;

    public /* synthetic */ b(FirebaseApp firebaseApp, Context context) {
        this.f66959a = firebaseApp;
        this.f66960b = context;
    }

    public final Object get() {
        return this.f66959a.lambda$new$0(this.f66960b);
    }
}
