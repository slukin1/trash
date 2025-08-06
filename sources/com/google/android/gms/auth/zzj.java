package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

final class zzj implements zzk {
    public final /* synthetic */ String zza;

    public zzj(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zzg = zze.zzb(iBinder).zzg(this.zza);
        Object unused = zzl.zzj(zzg);
        String string = zzg.getString("Error");
        Intent intent = (Intent) zzg.getParcelable("userRecoveryIntent");
        zzby zza2 = zzby.zza(string);
        if (zzby.SUCCESS.equals(zza2)) {
            return Boolean.TRUE;
        }
        if (zzby.zzb(zza2)) {
            zzl.zzd.w("isUserRecoverableError status: ".concat(String.valueOf(zza2)), new Object[0]);
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
