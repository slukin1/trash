package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

final class zzfx implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ zzga zza;
    private final String zzb;

    public zzfx(zzga zzga, String str) {
        this.zza = zzga;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th2) {
        this.zza.zzt.zzaA().zzd().zzb(this.zzb, th2);
    }
}
