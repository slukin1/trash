package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

final class zzjr implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzq zzc;
    public final /* synthetic */ zzcf zzd;
    public final /* synthetic */ zzjz zze;

    public zzjr(zzjz zzjz, String str, String str2, zzq zzq, zzcf zzcf) {
        this.zze = zzjz;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = zzcf;
    }

    public final void run() {
        zzgd zzgd;
        ArrayList arrayList = new ArrayList();
        try {
            zzjz zzjz = this.zze;
            zzej zzh = zzjz.zzb;
            if (zzh == null) {
                zzjz.zzt.zzaA().zzd().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzgd = this.zze.zzt;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzlp.zzH(zzh.zzf(this.zza, this.zzb, this.zzc));
                this.zze.zzQ();
                zzgd = this.zze.zzt;
            }
        } catch (RemoteException e11) {
            this.zze.zzt.zzaA().zzd().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e11);
            zzgd = this.zze.zzt;
        } catch (Throwable th2) {
            this.zze.zzt.zzv().zzR(this.zzd, arrayList);
            throw th2;
        }
        zzgd.zzv().zzR(this.zzd, arrayList);
    }
}
