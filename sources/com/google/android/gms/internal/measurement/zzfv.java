package com.google.android.gms.internal.measurement;

public final class zzfv extends zzlb implements zzmj {
    /* access modifiers changed from: private */
    public static final zzfv zza;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        zzfv zzfv = new zzfv();
        zza = zzfv;
        zzlb.zzbO(zzfv.class, zzfv);
    }

    private zzfv() {
    }

    public static zzfu zza() {
        return (zzfu) zza.zzbA();
    }

    public static /* synthetic */ void zzc(zzfv zzfv, String str) {
        str.getClass();
        zzfv.zzd |= 1;
        zzfv.zze = str;
    }

    public static /* synthetic */ void zzd(zzfv zzfv, long j11) {
        zzfv.zzd |= 2;
        zzfv.zzf = j11;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzfv();
        } else {
            if (i12 == 4) {
                return new zzfu((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zza;
        }
    }
}
