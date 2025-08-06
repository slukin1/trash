package com.google.android.recaptcha.internal;

import java.math.BigInteger;
import kotlin.jvm.internal.r;

public final class zzec {
    public static final zzeb zza = new zzeb((r) null);
    /* access modifiers changed from: private */
    public static final zzea zzb = new zzea(11, ((long) Math.pow(2.0d, 32.0d)) ^ 20919936621L, (long) Math.pow(2.0d, 48.0d));
    private final zzea zzc;
    private long zzd;

    public zzec(long j11, long j12, zzea zzea) {
        this.zzc = zzea;
        this.zzd = Math.abs(j11);
    }

    public final long zza() {
        zzea zzea = this.zzc;
        long longValue = (BigInteger.valueOf(zzea.zzb()).multiply(BigInteger.valueOf(this.zzd)).mod(BigInteger.valueOf(zzea.zza())).longValue() + 11) % this.zzc.zza();
        this.zzd = longValue;
        return longValue % 255;
    }
}
