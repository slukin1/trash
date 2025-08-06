package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

final class zzja implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzq zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzcf zze;
    public final /* synthetic */ zzjz zzf;

    public zzja(zzjz zzjz, String str, String str2, zzq zzq, boolean z11, zzcf zzcf) {
        this.zzf = zzjz;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = z11;
        this.zze = zzcf;
    }

    public final void run() {
        Throwable th2;
        Bundle bundle;
        RemoteException e11;
        Bundle bundle2 = new Bundle();
        try {
            zzjz zzjz = this.zzf;
            zzej zzh = zzjz.zzb;
            if (zzh == null) {
                zzjz.zzt.zzaA().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzt.zzv().zzS(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzlk> zzh2 = zzh.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh2 != null) {
                for (zzlk zzlk : zzh2) {
                    String str = zzlk.zze;
                    if (str != null) {
                        bundle.putString(zzlk.zzb, str);
                    } else {
                        Long l11 = zzlk.zzd;
                        if (l11 != null) {
                            bundle.putLong(zzlk.zzb, l11.longValue());
                        } else {
                            Double d11 = zzlk.zzg;
                            if (d11 != null) {
                                bundle.putDouble(zzlk.zzb, d11.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.zzf.zzQ();
                this.zzf.zzt.zzv().zzS(this.zze, bundle);
            } catch (RemoteException e12) {
                e11 = e12;
                try {
                    this.zzf.zzt.zzaA().zzd().zzc("Failed to get user properties; remote exception", this.zza, e11);
                    this.zzf.zzt.zzv().zzS(this.zze, bundle);
                } catch (Throwable th3) {
                    th2 = th3;
                    bundle2 = bundle;
                    this.zzf.zzt.zzv().zzS(this.zze, bundle2);
                    throw th2;
                }
            }
        } catch (RemoteException e13) {
            bundle = bundle2;
            e11 = e13;
            this.zzf.zzt.zzaA().zzd().zzc("Failed to get user properties; remote exception", this.zza, e11);
            this.zzf.zzt.zzv().zzS(this.zze, bundle);
        } catch (Throwable th4) {
            th2 = th4;
            this.zzf.zzt.zzv().zzS(this.zze, bundle2);
            throw th2;
        }
    }
}
