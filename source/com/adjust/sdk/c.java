package com.adjust.sdk;

import android.content.Context;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13954b;

    public /* synthetic */ c(Context context) {
        this.f13954b = context;
    }

    public final void run() {
        SharedPreferencesManager.getDefaultInstance(this.f13954b).setSendingReferrersAsNotSent();
    }
}
