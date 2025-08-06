package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f67092a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f67093b;

    public /* synthetic */ b(Context context, String str) {
        this.f67092a = context;
        this.f67093b = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.lambda$new$2(this.f67092a, this.f67093b);
    }
}
