package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.o;
import com.google.android.play.integrity.internal.q;

final class ac extends o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ad f66776a;

    /* renamed from: b  reason: collision with root package name */
    private final q f66777b = new q("OnRequestIntegrityTokenCallback");

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f66778c;

    public ac(ad adVar, TaskCompletionSource taskCompletionSource) {
        this.f66776a = adVar;
        this.f66778c = taskCompletionSource;
    }

    public final void b(Bundle bundle) {
        PendingIntent pendingIntent;
        this.f66776a.f66779a.v(this.f66778c);
        this.f66777b.c("onRequestIntegrityToken", new Object[0]);
        int i11 = bundle.getInt("error");
        if (i11 != 0) {
            this.f66778c.trySetException(new IntegrityServiceException(i11, (Throwable) null));
            return;
        }
        String string = bundle.getString("token");
        if (string == null) {
            this.f66778c.trySetException(new IntegrityServiceException(-100, (Throwable) null));
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent", PendingIntent.class);
        } else {
            pendingIntent = (PendingIntent) bundle.getParcelable("dialog.intent");
        }
        TaskCompletionSource taskCompletionSource = this.f66778c;
        a aVar = new a();
        aVar.c(string);
        aVar.b(this.f66777b);
        aVar.a(pendingIntent);
        taskCompletionSource.trySetResult(aVar.d());
    }
}
