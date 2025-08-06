package com.google.android.recaptcha.internal;

public final class zzu implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        String s02 = StringsKt__StringsKt.s0(String.valueOf(this.zzb / ((long) this.zza)), 10, 0, 2, (Object) null);
        String s03 = StringsKt__StringsKt.s0(String.valueOf(this.zzc), 10, 0, 2, (Object) null);
        String s04 = StringsKt__StringsKt.s0(String.valueOf(this.zzb), 10, 0, 2, (Object) null);
        String s05 = StringsKt__StringsKt.s0(String.valueOf(this.zza), 5, 0, 2, (Object) null);
        return "avgExecutionTime: " + s02 + " us| maxExecutionTime: " + s03 + " us| totalTime: " + s04 + " us| #Usages: " + s05;
    }

    /* renamed from: zza */
    public final int compareTo(zzu zzu) {
        return ComparisonsKt__ComparisonsKt.a(Long.valueOf(this.zzb), Long.valueOf(zzu.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j11) {
        this.zzc = j11;
    }

    public final void zzf(long j11) {
        this.zzb = j11;
    }

    public final void zzg(int i11) {
        this.zza = i11;
    }
}
