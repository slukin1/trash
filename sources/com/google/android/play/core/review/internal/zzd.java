package com.google.android.play.core.review.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzd extends zza implements zzf {
    public zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    public final void zzc(String str, Bundle bundle, zzh zzh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, bundle);
        zzc.zzd(zza, zzh);
        zzb(2, zza);
    }
}
