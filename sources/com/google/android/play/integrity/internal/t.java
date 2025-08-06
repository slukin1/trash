package com.google.android.play.integrity.internal;

import android.os.IBinder;

public final /* synthetic */ class t implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f66891a;

    public /* synthetic */ t(ac acVar) {
        this.f66891a = acVar;
    }

    public final void binderDied() {
        ac.k(this.f66891a);
    }
}
