package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

@SuppressLint({"HandlerLeak"})
final class zac extends zaq {
    public final /* synthetic */ GoogleApiAvailability zaa;
    private final Context zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.zaa = googleApiAvailability;
        this.zab = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        int i11 = message.what;
        if (i11 != 1) {
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Don't know how to handle this message: ");
            sb2.append(i11);
            Log.w("GoogleApiAvailability", sb2.toString());
            return;
        }
        int isGooglePlayServicesAvailable = this.zaa.isGooglePlayServicesAvailable(this.zab);
        if (this.zaa.isUserResolvableError(isGooglePlayServicesAvailable)) {
            this.zaa.showErrorNotification(this.zab, isGooglePlayServicesAvailable);
        }
    }
}
