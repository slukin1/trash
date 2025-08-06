package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfx extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfx zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;
    /* access modifiers changed from: private */
    public zzli zzj = zzlb.zzbH();

    static {
        zzfx zzfx = new zzfx();
        zza = zzfx;
        zzlb.zzbO(zzfx.class, zzfx);
    }

    private zzfx() {
    }

    public static zzfw zze() {
        return (zzfw) zza.zzbA();
    }

    public static /* synthetic */ void zzj(zzfx zzfx, String str) {
        str.getClass();
        zzfx.zzd |= 1;
        zzfx.zze = str;
    }

    public static /* synthetic */ void zzk(zzfx zzfx, String str) {
        str.getClass();
        zzfx.zzd |= 2;
        zzfx.zzf = str;
    }

    public static /* synthetic */ void zzm(zzfx zzfx) {
        zzfx.zzd &= -3;
        zzfx.zzf = zza.zzf;
    }

    public static /* synthetic */ void zzn(zzfx zzfx, long j11) {
        zzfx.zzd |= 4;
        zzfx.zzg = j11;
    }

    public static /* synthetic */ void zzo(zzfx zzfx) {
        zzfx.zzd &= -5;
        zzfx.zzg = 0;
    }

    public static /* synthetic */ void zzp(zzfx zzfx, double d11) {
        zzfx.zzd |= 16;
        zzfx.zzi = d11;
    }

    public static /* synthetic */ void zzq(zzfx zzfx) {
        zzfx.zzd &= -17;
        zzfx.zzi = 0.0d;
    }

    public static /* synthetic */ void zzr(zzfx zzfx, zzfx zzfx2) {
        zzfx2.getClass();
        zzfx.zzz();
        zzfx.zzj.add(zzfx2);
    }

    public static /* synthetic */ void zzs(zzfx zzfx, Iterable iterable) {
        zzfx.zzz();
        zzjk.zzbw(iterable, zzfx.zzj);
    }

    private final void zzz() {
        zzli zzli = this.zzj;
        if (!zzli.zzc()) {
            this.zzj = zzlb.zzbI(zzli);
        }
    }

    public final double zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzh;
    }

    public final int zzc() {
        return this.zzj.size();
    }

    public final long zzd() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zze;
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zzj;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzfx.class});
        } else if (i12 == 3) {
            return new zzfx();
        } else {
            if (i12 == 4) {
                return new zzfw((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzu() {
        return (this.zzd & 16) != 0;
    }

    public final boolean zzv() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzw() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzx() {
        return (this.zzd & 1) != 0;
    }

    public final boolean zzy() {
        return (this.zzd & 2) != 0;
    }
}
