package com.google.android.recaptcha.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Set;

public final class zzcb {
    public static final zzcb zza = new zzcb();
    private static Set zzb;
    private static Set zzc;
    private static Long zzd;
    private static int zze;

    private zzcb() {
    }

    public static final void zza(zznz zznz) {
        zzb = CollectionsKt___CollectionsKt.N0(zznz.zzf().zzi());
        zzc = CollectionsKt___CollectionsKt.N0(zznz.zzg().zzi());
    }

    public static final boolean zzb(String str) {
        Set set = zzb;
        if (set == null || zzc == null) {
            if (zzd == null) {
                zzd = Long.valueOf(System.currentTimeMillis());
            }
            zze++;
            return true;
        } else if (set.isEmpty()) {
            return true;
        } else {
            if (zzc(str, zzc)) {
                return false;
            }
            return zzc(str, set);
        }
    }

    private static final boolean zzc(String str, Set set) {
        String str2 = "";
        for (String valueOf : StringsKt__StringsKt.K0(str, new char[]{'.'}, false, 0, 6, (Object) null)) {
            String concat = str2.concat(String.valueOf(valueOf));
            if (set.contains(concat)) {
                return true;
            }
            str2 = concat.concat(InstructionFileId.DOT);
        }
        return false;
    }
}
