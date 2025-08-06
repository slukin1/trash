package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzgd;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhg;
import com.google.android.gms.measurement.internal.zzik;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.List;
import java.util.Map;

final class zza extends zzd {
    private final zzgd zza;
    private final zzik zzb;

    public zza(zzgd zzgd) {
        super((zzc) null);
        Preconditions.checkNotNull(zzgd);
        this.zza = zzgd;
        this.zzb = zzgd.zzq();
    }

    public final int zza(String str) {
        this.zzb.zzh(str);
        return 25;
    }

    public final long zzb() {
        return this.zza.zzv().zzq();
    }

    public final Boolean zzc() {
        return this.zzb.zzi();
    }

    public final Double zzd() {
        return this.zzb.zzj();
    }

    public final Integer zze() {
        return this.zzb.zzl();
    }

    public final Long zzf() {
        return this.zzb.zzm();
    }

    public final Object zzg(int i11) {
        if (i11 == 0) {
            return this.zzb.zzr();
        }
        if (i11 == 1) {
            return this.zzb.zzm();
        }
        if (i11 == 2) {
            return this.zzb.zzj();
        }
        if (i11 != 3) {
            return this.zzb.zzi();
        }
        return this.zzb.zzl();
    }

    public final String zzh() {
        return this.zzb.zzo();
    }

    public final String zzi() {
        return this.zzb.zzp();
    }

    public final String zzj() {
        return this.zzb.zzq();
    }

    public final String zzk() {
        return this.zzb.zzo();
    }

    public final String zzl() {
        return this.zzb.zzr();
    }

    public final List zzm(String str, String str2) {
        return this.zzb.zzs(str, str2);
    }

    public final Map zzn(boolean z11) {
        List<zzlk> zzt = this.zzb.zzt(z11);
        ArrayMap arrayMap = new ArrayMap(zzt.size());
        for (zzlk zzlk : zzt) {
            Object zza2 = zzlk.zza();
            if (zza2 != null) {
                arrayMap.put(zzlk.zzb, zza2);
            }
        }
        return arrayMap;
    }

    public final Map zzo(String str, String str2, boolean z11) {
        return this.zzb.zzu(str, str2, z11);
    }

    public final void zzp(String str) {
        this.zza.zzd().zzd(str, this.zza.zzax().elapsedRealtime());
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.zza.zzd().zze(str, this.zza.zzax().elapsedRealtime());
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.zzb.zzD(str, str2, bundle);
    }

    public final void zzt(String str, String str2, Bundle bundle, long j11) {
        this.zzb.zzE(str, str2, bundle, true, false, j11);
    }

    public final void zzu(zzhg zzhg) {
        this.zzb.zzJ(zzhg);
    }

    public final void zzv(Bundle bundle) {
        this.zzb.zzP(bundle);
    }

    public final void zzw(zzhf zzhf) {
        this.zzb.zzT(zzhf);
    }

    public final void zzx(zzhg zzhg) {
        this.zzb.zzZ(zzhg);
    }
}
