package com.google.android.gms.internal.measurement;

public final class zzgm extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzgm zza;
    private int zzd;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzgm zzgm = new zzgm();
        zza = zzgm;
        zzlb.zzbO(zzgm.class, zzgm);
    }

    private zzgm() {
    }

    public static zzgl zzd() {
        return (zzgl) zza.zzbA();
    }

    public static /* synthetic */ void zzh(zzgm zzgm, long j11) {
        zzgm.zzd |= 1;
        zzgm.zze = j11;
    }

    public static /* synthetic */ void zzi(zzgm zzgm, String str) {
        str.getClass();
        zzgm.zzd |= 2;
        zzgm.zzf = str;
    }

    public static /* synthetic */ void zzj(zzgm zzgm, String str) {
        str.getClass();
        zzgm.zzd |= 4;
        zzgm.zzg = str;
    }

    public static /* synthetic */ void zzk(zzgm zzgm) {
        zzgm.zzd &= -5;
        zzgm.zzg = zza.zzg;
    }

    public static /* synthetic */ void zzm(zzgm zzgm, long j11) {
        zzgm.zzd |= 8;
        zzgm.zzh = j11;
    }

    public static /* synthetic */ void zzn(zzgm zzgm) {
        zzgm.zzd &= -9;
        zzgm.zzh = 0;
    }

    public static /* synthetic */ void zzo(zzgm zzgm, double d11) {
        zzgm.zzd |= 32;
        zzgm.zzj = d11;
    }

    public static /* synthetic */ void zzp(zzgm zzgm) {
        zzgm.zzd &= -33;
        zzgm.zzj = 0.0d;
    }

    public final double zza() {
        return this.zzj;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final long zzc() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zzg;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i12 == 3) {
            return new zzgm();
        } else {
            if (i12 == 4) {
                return new zzgl((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzq() {
        return (this.zzd & 32) != 0;
    }

    public final boolean zzr() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzs() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 4) != 0;
    }
}
