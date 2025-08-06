package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzft extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzft zza;
    private int zzd;
    /* access modifiers changed from: private */
    public zzli zze = zzlb.zzbH();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzft zzft = new zzft();
        zza = zzft;
        zzlb.zzbO(zzft.class, zzft);
    }

    private zzft() {
    }

    public static zzfs zze() {
        return (zzfs) zza.zzbA();
    }

    public static /* synthetic */ void zzj(zzft zzft, int i11, zzfx zzfx) {
        zzfx.getClass();
        zzft.zzv();
        zzft.zze.set(i11, zzfx);
    }

    public static /* synthetic */ void zzk(zzft zzft, zzfx zzfx) {
        zzfx.getClass();
        zzft.zzv();
        zzft.zze.add(zzfx);
    }

    public static /* synthetic */ void zzm(zzft zzft, Iterable iterable) {
        zzft.zzv();
        zzjk.zzbw(iterable, zzft.zze);
    }

    public static /* synthetic */ void zzo(zzft zzft, int i11) {
        zzft.zzv();
        zzft.zze.remove(i11);
    }

    public static /* synthetic */ void zzp(zzft zzft, String str) {
        str.getClass();
        zzft.zzd |= 1;
        zzft.zzf = str;
    }

    public static /* synthetic */ void zzq(zzft zzft, long j11) {
        zzft.zzd |= 2;
        zzft.zzg = j11;
    }

    public static /* synthetic */ void zzr(zzft zzft, long j11) {
        zzft.zzd |= 4;
        zzft.zzh = j11;
    }

    private final void zzv() {
        zzli zzli = this.zze;
        if (!zzli.zzc()) {
            this.zze = zzlb.zzbI(zzli);
        }
    }

    public final int zza() {
        return this.zzi;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final long zzc() {
        return this.zzh;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final zzfx zzg(int i11) {
        return (zzfx) this.zze.get(i11);
    }

    public final String zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzd", "zze", zzfx.class, "zzf", "zzg", "zzh", "zzi"});
        } else if (i12 == 3) {
            return new zzft();
        } else {
            if (i12 == 4) {
                return new zzfs((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzs() {
        return (this.zzd & 8) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzu() {
        return (this.zzd & 2) != 0;
    }
}
