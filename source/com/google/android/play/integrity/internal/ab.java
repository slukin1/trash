package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class ab implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ac f66862a;

    public /* synthetic */ ab(ac acVar, aa aaVar) {
        this.f66862a = acVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f66862a.f66865c.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        ac acVar = this.f66862a;
        acVar.c().post(new y(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f66862a.f66865c.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        ac acVar = this.f66862a;
        acVar.c().post(new z(this));
    }
}
