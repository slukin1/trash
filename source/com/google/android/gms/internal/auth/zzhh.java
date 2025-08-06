package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzhh {
    public final Unsafe zza;

    public zzhh(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j11);

    public abstract float zzb(Object obj, long j11);

    public abstract void zzc(Object obj, long j11, boolean z11);

    public abstract void zzd(Object obj, long j11, double d11);

    public abstract void zze(Object obj, long j11, float f11);

    public abstract boolean zzf(Object obj, long j11);

    public final int zzg(Class cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzh(Class cls) {
        return this.zza.arrayIndexScale(cls);
    }

    public final int zzi(Object obj, long j11) {
        return this.zza.getInt(obj, j11);
    }

    public final long zzj(Object obj, long j11) {
        return this.zza.getLong(obj, j11);
    }

    public final long zzk(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final Object zzl(Object obj, long j11) {
        return this.zza.getObject(obj, j11);
    }

    public final void zzm(Object obj, long j11, int i11) {
        this.zza.putInt(obj, j11, i11);
    }

    public final void zzn(Object obj, long j11, long j12) {
        this.zza.putLong(obj, j11, j12);
    }

    public final void zzo(Object obj, long j11, Object obj2) {
        this.zza.putObject(obj, j11, obj2);
    }
}
