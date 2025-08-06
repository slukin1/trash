package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

final class zzfs implements zzr {
    public final /* synthetic */ zzfu zza;

    public zzfs(zzfu zzfu) {
        this.zza = zzfu;
    }

    public final void zza(int i11, String str, List list, boolean z11, boolean z12) {
        zzer zzer;
        int i12 = i11 - 1;
        if (i12 == 0) {
            zzer = this.zza.zzt.zzaA().zzc();
        } else if (i12 != 1) {
            if (i12 == 3) {
                zzer = this.zza.zzt.zzaA().zzj();
            } else if (i12 != 4) {
                zzer = this.zza.zzt.zzaA().zzi();
            } else if (z11) {
                zzer = this.zza.zzt.zzaA().zzm();
            } else if (!z12) {
                zzer = this.zza.zzt.zzaA().zzl();
            } else {
                zzer = this.zza.zzt.zzaA().zzk();
            }
        } else if (z11) {
            zzer = this.zza.zzt.zzaA().zzh();
        } else if (!z12) {
            zzer = this.zza.zzt.zzaA().zze();
        } else {
            zzer = this.zza.zzt.zzaA().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzer.zzb(str, list.get(0));
        } else if (size == 2) {
            zzer.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzer.zza(str);
        } else {
            zzer.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
