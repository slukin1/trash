package com.google.android.gms.internal.measurement;

public class zzlo {
    private static final zzkn zzb = zzkn.zza;
    public volatile zzmi zza;
    private volatile zzka zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlo)) {
            return false;
        }
        zzlo zzlo = (zzlo) obj;
        zzmi zzmi = this.zza;
        zzmi zzmi2 = zzlo.zza;
        if (zzmi == null && zzmi2 == null) {
            return zzb().equals(zzlo.zzb());
        }
        if (zzmi != null && zzmi2 != null) {
            return zzmi.equals(zzmi2);
        }
        if (zzmi != null) {
            zzlo.zzc(zzmi.zzbV());
            return zzmi.equals(zzlo.zza);
        }
        zzc(zzmi2.zzbV());
        return this.zza.equals(zzmi2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzjx) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbz();
        }
        return 0;
    }

    public final zzka zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzka zzka = this.zzc;
                return zzka;
            }
            if (this.zza == null) {
                this.zzc = zzka.zzb;
            } else {
                this.zzc = this.zza.zzbv();
            }
            zzka zzka2 = this.zzc;
            return zzka2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.measurement.zzmi r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzmi r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzmi r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.zza = r2     // Catch:{ zzll -> 0x0011 }
            com.google.android.gms.internal.measurement.zzka r0 = com.google.android.gms.internal.measurement.zzka.zzb     // Catch:{ zzll -> 0x0011 }
            r1.zzc = r0     // Catch:{ zzll -> 0x0011 }
            goto L_0x0017
        L_0x0011:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.measurement.zzka r2 = com.google.android.gms.internal.measurement.zzka.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzc(com.google.android.gms.internal.measurement.zzmi):void");
    }
}
