package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

final class zzhg extends zzhh {
    public zzhg(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j11) {
        return Double.longBitsToDouble(zzj(obj, j11));
    }

    public final float zzb(Object obj, long j11) {
        return Float.intBitsToFloat(zzi(obj, j11));
    }

    public final void zzc(Object obj, long j11, boolean z11) {
        if (zzhi.zza) {
            zzhi.zzi(obj, j11, z11);
        } else {
            zzhi.zzj(obj, j11, z11);
        }
    }

    public final void zzd(Object obj, long j11, double d11) {
        zzn(obj, j11, Double.doubleToLongBits(d11));
    }

    public final void zze(Object obj, long j11, float f11) {
        zzm(obj, j11, Float.floatToIntBits(f11));
    }

    public final boolean zzf(Object obj, long j11) {
        if (zzhi.zza) {
            return zzhi.zzq(obj, j11);
        }
        return zzhi.zzr(obj, j11);
    }
}
