package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzfy extends FutureTask implements Comparable {
    public final boolean zza;
    public final /* synthetic */ zzga zzb;
    private final long zzc;
    private final String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfy(zzga zzga, Runnable runnable, boolean z11, String str) {
        super(runnable, (Object) null);
        this.zzb = zzga;
        Preconditions.checkNotNull(str);
        long andIncrement = zzga.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z11;
        if (andIncrement == Long.MAX_VALUE) {
            zzga.zzt.zzaA().zzd().zza("Tasks index overflow");
        }
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzfy zzfy = (zzfy) obj;
        boolean z11 = this.zza;
        if (z11 != zzfy.zza) {
            return !z11 ? 1 : -1;
        }
        int i11 = (this.zzc > zzfy.zzc ? 1 : (this.zzc == zzfy.zzc ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        if (i11 > 0) {
            return 1;
        }
        this.zzb.zzt.zzaA().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.zzc));
        return 0;
    }

    public final void setException(Throwable th2) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzt.zzaA().zzd().zzb(this.zzd, th2);
        if ((th2 instanceof zzfw) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
        }
        super.setException(th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfy(zzga zzga, Callable callable, boolean z11, String str) {
        super(callable);
        this.zzb = zzga;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzga.zza.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z11;
        if (andIncrement == Long.MAX_VALUE) {
            zzga.zzt.zzaA().zzd().zza("Tasks index overflow");
        }
    }
}
