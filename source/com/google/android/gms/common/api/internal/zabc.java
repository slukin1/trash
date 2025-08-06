package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class zabc extends zaq {
    public final /* synthetic */ zabe zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zabc(zabe zabe, Looper looper) {
        super(looper);
        this.zaa = zabe;
    }

    public final void handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 1) {
            zabe.zaj(this.zaa);
        } else if (i11 != 2) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("Unknown message id: ");
            sb2.append(i11);
            Log.w("GoogleApiClientImpl", sb2.toString());
        } else {
            zabe.zai(this.zaa);
        }
    }
}
