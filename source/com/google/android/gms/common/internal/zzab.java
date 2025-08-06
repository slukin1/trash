package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzab extends zza implements IGmsCallbacks {
    public zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void onPostInitComplete(int i11, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i11);
        zza.writeStrongBinder(iBinder);
        zzc.zzc(zza, bundle);
        zzC(1, zza);
    }

    public final void zzb(int i11, Bundle bundle) throws RemoteException {
        throw null;
    }

    public final void zzc(int i11, IBinder iBinder, zzk zzk) throws RemoteException {
        throw null;
    }
}
