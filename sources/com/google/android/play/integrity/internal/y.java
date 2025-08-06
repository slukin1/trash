package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;

final class y extends r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IBinder f66896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ab f66897b;

    public y(ab abVar, IBinder iBinder) {
        this.f66897b = abVar;
        this.f66896a = iBinder;
    }

    public final void b() {
        ac acVar = this.f66897b.f66862a;
        acVar.f66877o = (IInterface) acVar.f66872j.a(this.f66896a);
        ac.r(this.f66897b.f66862a);
        this.f66897b.f66862a.f66870h = false;
        for (Runnable run : this.f66897b.f66862a.f66867e) {
            run.run();
        }
        this.f66897b.f66862a.f66867e.clear();
    }
}
