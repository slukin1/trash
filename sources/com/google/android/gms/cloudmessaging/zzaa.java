package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

final class zzaa extends zzf {
    public final /* synthetic */ Rpc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaa(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
    }

    public final void handleMessage(Message message) {
        Rpc.zzc(this.zza, message);
    }
}
