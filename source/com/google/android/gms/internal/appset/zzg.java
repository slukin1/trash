package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.appset.zza;

public final class zzg extends zza {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(zza zza, zzf zzf) throws RemoteException {
        Parcel zza2 = zza();
        zzc.zzb(zza2, zza);
        zzc.zzc(zza2, zzf);
        zzb(1, zza2);
    }
}
