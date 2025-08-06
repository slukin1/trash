package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzey extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzey zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private zzli zzh = zzlb.zzbH();

    static {
        zzey zzey = new zzey();
        zza = zzey;
        zzlb.zzbO(zzey.class, zzey);
    }

    private zzey() {
    }

    public static zzey zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzh.size();
    }

    public final String zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzh() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzi() {
        return (this.zzd & 1) != 0;
    }

    public final int zzj() {
        int zza2 = zzex.zza(this.zze);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzd", "zze", zzew.zza, "zzf", "zzg", "zzh"});
        } else if (i12 == 3) {
            return new zzey();
        } else {
            if (i12 == 4) {
                return new zzeu((zzeg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
