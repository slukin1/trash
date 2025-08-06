package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzap {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final long zze;
    public final zzas zzf;

    public zzap(zzgd zzgd, String str, String str2, String str3, long j11, long j12, Bundle bundle) {
        zzas zzas;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j11;
        this.zze = j12;
        if (j12 != 0 && j12 > j11) {
            zzgd.zzaA().zzk().zzb("Event created with reverse previous/current timestamps. appId", zzet.zzn(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzas = new zzas(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it2 = bundle2.keySet().iterator();
            while (it2.hasNext()) {
                String str4 = (String) it2.next();
                if (str4 == null) {
                    zzgd.zzaA().zzd().zza("Param name can't be null");
                    it2.remove();
                } else {
                    Object zzA = zzgd.zzv().zzA(str4, bundle2.get(str4));
                    if (zzA == null) {
                        zzgd.zzaA().zzk().zzb("Param value can't be null", zzgd.zzj().zze(str4));
                        it2.remove();
                    } else {
                        zzgd.zzv().zzP(bundle2, str4, zzA);
                    }
                }
            }
            zzas = new zzas(bundle2);
        }
        this.zzf = zzas;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String obj = this.zzf.toString();
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + obj + "}";
    }

    public final zzap zza(zzgd zzgd, long j11) {
        return new zzap(zzgd, this.zzc, this.zza, this.zzb, this.zzd, j11, this.zzf);
    }

    private zzap(zzgd zzgd, String str, String str2, String str3, long j11, long j12, zzas zzas) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzas);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j11;
        this.zze = j12;
        if (j12 != 0 && j12 > j11) {
            zzgd.zzaA().zzk().zzc("Event created with reverse previous/current timestamps. appId, name", zzet.zzn(str2), zzet.zzn(str3));
        }
        this.zzf = zzas;
    }
}
