package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

final class zzba implements Comparator {
    public final /* synthetic */ zzai zza;
    public final /* synthetic */ zzg zzb;

    public zzba(zzai zzai, zzg zzg) {
        this.zza = zzai;
        this.zzb = zzg;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzap zzap = (zzap) obj;
        boolean z11 = zzap instanceof zzau;
        zzap zzap2 = (zzap) obj2;
        zzai zzai = this.zza;
        zzg zzg = this.zzb;
        if (z11) {
            return !(zzap2 instanceof zzau) ? 1 : 0;
        }
        if (zzap2 instanceof zzau) {
            return -1;
        }
        if (zzai == null) {
            return zzap.zzi().compareTo(zzap2.zzi());
        }
        return (int) zzh.zza(zzai.zza(zzg, Arrays.asList(new zzap[]{zzap, zzap2})).zzh().doubleValue());
    }
}
