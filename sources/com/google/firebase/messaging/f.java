package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Callable;

public final /* synthetic */ class f implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f67124b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f67125c;

    public /* synthetic */ f(Context context, Intent intent) {
        this.f67124b = context;
        this.f67125c = intent;
    }

    public final Object call() {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(this.f67124b, this.f67125c));
    }
}
