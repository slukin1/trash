package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class zzr implements Handler.Callback {
    public final /* synthetic */ zzs zza;

    public /* synthetic */ zzr(zzs zzs, zzq zzq) {
        this.zza = zzs;
    }

    public final boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            synchronized (this.zza.zzb) {
                zzo zzo = (zzo) message.obj;
                zzp zzp = (zzp) this.zza.zzb.get(zzo);
                if (zzp != null && zzp.zzi()) {
                    if (zzp.zzj()) {
                        zzp.zzg("GmsClientSupervisor");
                    }
                    this.zza.zzb.remove(zzo);
                }
            }
            return true;
        } else if (i11 != 1) {
            return false;
        } else {
            synchronized (this.zza.zzb) {
                zzo zzo2 = (zzo) message.obj;
                zzp zzp2 = (zzp) this.zza.zzb.get(zzo2);
                if (zzp2 != null && zzp2.zza() == 3) {
                    String valueOf = String.valueOf(zzo2);
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                    ComponentName zzb = zzp2.zzb();
                    if (zzb == null) {
                        zzb = zzo2.zza();
                    }
                    if (zzb == null) {
                        String zzc = zzo2.zzc();
                        Preconditions.checkNotNull(zzc);
                        zzb = new ComponentName(zzc, "unknown");
                    }
                    zzp2.onServiceDisconnected(zzb);
                }
            }
            return true;
        }
    }
}
