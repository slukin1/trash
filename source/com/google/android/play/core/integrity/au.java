package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.q;

final class au extends at {

    /* renamed from: c  reason: collision with root package name */
    private final q f66808c = new q("OnRequestIntegrityTokenCallback");

    public au(ax axVar, TaskCompletionSource taskCompletionSource) {
        super(axVar, taskCompletionSource);
    }

    public final void c(Bundle bundle) throws RemoteException {
        PendingIntent pendingIntent;
        super.c(bundle);
        this.f66808c.c("onRequestExpressIntegrityToken", new Object[0]);
        int i11 = bundle.getInt("error");
        if (i11 != 0) {
            this.f66806a.trySetException(new StandardIntegrityException(i11, (Throwable) null));
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent", PendingIntent.class);
        } else {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        }
        TaskCompletionSource taskCompletionSource = this.f66806a;
        b bVar = new b();
        bVar.c(bundle.getString("token"));
        bVar.b(this.f66808c);
        bVar.a(pendingIntent);
        taskCompletionSource.trySetResult(bVar.d());
    }
}
