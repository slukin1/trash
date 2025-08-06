package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zaq;

final class zacz extends zaq {
    public final /* synthetic */ zada zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacz(zada zada, Looper looper) {
        super(looper);
        this.zaa = zada;
    }

    public final void handleMessage(Message message) {
        String str;
        int i11 = message.what;
        if (i11 == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.zaa.zae) {
                zada zada = (zada) Preconditions.checkNotNull(this.zaa.zab);
                if (pendingResult == null) {
                    zada.zaj(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacp) {
                    zada.zaj(((zacp) pendingResult).zaa());
                } else {
                    zada.zai(pendingResult);
                }
            }
        } else if (i11 != 1) {
            StringBuilder sb2 = new StringBuilder(70);
            sb2.append("TransformationResultHandler received unknown message type: ");
            sb2.append(i11);
            Log.e("TransformedResultImpl", sb2.toString());
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            if (valueOf.length() != 0) {
                str = "Runtime exception on the transformation worker thread: ".concat(valueOf);
            } else {
                str = new String("Runtime exception on the transformation worker thread: ");
            }
            Log.e("TransformedResultImpl", str);
            throw runtimeException;
        }
    }
}
