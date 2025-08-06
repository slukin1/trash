package com.google.android.gms.internal.measurement;

public final class zzfr extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfr zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzfr zzfr = new zzfr();
        zza = zzfr;
        zzlb.zzbO(zzfr.class, zzfr);
    }

    private zzfr() {
    }

    public static zzfq zzc() {
        return (zzfq) zza.zzbA();
    }

    public static /* synthetic */ void zze(zzfr zzfr, int i11) {
        zzfr.zzd |= 1;
        zzfr.zze = i11;
    }

    public static /* synthetic */ void zzf(zzfr zzfr, long j11) {
        zzfr.zzd |= 2;
        zzfr.zzf = j11;
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzg() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 1) != 0;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzfr();
        } else {
            if (i12 == 4) {
                return new zzfq((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
