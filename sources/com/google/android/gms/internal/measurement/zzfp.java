package com.google.android.gms.internal.measurement;

public final class zzfp extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfp zza;
    private int zzd;
    private int zze;
    private zzgi zzf;
    private zzgi zzg;
    private boolean zzh;

    static {
        zzfp zzfp = new zzfp();
        zza = zzfp;
        zzlb.zzbO(zzfp.class, zzfp);
    }

    private zzfp() {
    }

    public static zzfo zzb() {
        return (zzfo) zza.zzbA();
    }

    public static /* synthetic */ void zzf(zzfp zzfp, int i11) {
        zzfp.zzd |= 1;
        zzfp.zze = i11;
    }

    public static /* synthetic */ void zzg(zzfp zzfp, zzgi zzgi) {
        zzgi.getClass();
        zzfp.zzf = zzgi;
        zzfp.zzd |= 2;
    }

    public static /* synthetic */ void zzh(zzfp zzfp, zzgi zzgi) {
        zzfp.zzg = zzgi;
        zzfp.zzd |= 4;
    }

    public static /* synthetic */ void zzi(zzfp zzfp, boolean z11) {
        zzfp.zzd |= 8;
        zzfp.zzh = z11;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzgi zzd() {
        zzgi zzgi = this.zzf;
        return zzgi == null ? zzgi.zzg() : zzgi;
    }

    public final zzgi zze() {
        zzgi zzgi = this.zzg;
        return zzgi == null ? zzgi.zzg() : zzgi;
    }

    public final boolean zzj() {
        return this.zzh;
    }

    public final boolean zzk() {
        return (this.zzd & 1) != 0;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzfp();
        } else {
            if (i12 == 4) {
                return new zzfo((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzm() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzn() {
        return (this.zzd & 4) != 0;
    }
}
