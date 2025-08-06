package com.google.android.recaptcha.internal;

public class zzjk {
    private static final zzie zzb = zzie.zza;
    public volatile zzke zza;
    private volatile zzgw zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjk)) {
            return false;
        }
        zzjk zzjk = (zzjk) obj;
        zzke zzke = this.zza;
        zzke zzke2 = zzjk.zza;
        if (zzke == null && zzke2 == null) {
            return zzb().equals(zzjk.zzb());
        }
        if (zzke != null && zzke2 != null) {
            return zzke.equals(zzke2);
        }
        if (zzke != null) {
            zzjk.zzd(zzke.zzY());
            return zzke.equals(zzjk.zza);
        }
        zzd(zzke2.zzY());
        return this.zza.equals(zzke2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgt) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzn();
        }
        return 0;
    }

    public final zzgw zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgw zzgw = this.zzc;
                return zzgw;
            }
            if (this.zza == null) {
                this.zzc = zzgw.zzb;
            } else {
                this.zzc = this.zza.zzb();
            }
            zzgw zzgw2 = this.zzc;
            return zzgw2;
        }
    }

    public final zzke zzc(zzke zzke) {
        zzke zzke2 = this.zza;
        this.zzc = null;
        this.zza = zzke;
        return zzke2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.recaptcha.internal.zzke r2) {
        /*
            r1 = this;
            com.google.android.recaptcha.internal.zzke r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.recaptcha.internal.zzke r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x000c:
            r1.zza = r2     // Catch:{ zzje -> 0x0013 }
            com.google.android.recaptcha.internal.zzgw r0 = com.google.android.recaptcha.internal.zzgw.zzb     // Catch:{ zzje -> 0x0013 }
            r1.zzc = r0     // Catch:{ zzje -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.recaptcha.internal.zzgw r2 = com.google.android.recaptcha.internal.zzgw.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzjk.zzd(com.google.android.recaptcha.internal.zzke):void");
    }
}
