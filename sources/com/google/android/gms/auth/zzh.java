package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

final class zzh implements zzk {
    public final /* synthetic */ String zza;
    public final /* synthetic */ Bundle zzb;

    public zzh(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zzd = zze.zzb(iBinder).zzd(this.zza, this.zzb);
        Object unused = zzl.zzj(zzd);
        String string = zzd.getString("Error");
        if (zzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
