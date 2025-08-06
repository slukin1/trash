package com.google.android.gms.internal.auth;

import java.util.List;

public final class zzhr extends zzeu implements zzfx {
    /* access modifiers changed from: private */
    public static final zzhr zzb;
    private zzey zzd = zzeu.zzc();

    static {
        zzhr zzhr = new zzhr();
        zzb = zzhr;
        zzeu.zzg(zzhr.class, zzhr);
    }

    private zzhr() {
    }

    public static zzhr zzk(byte[] bArr) throws zzfa {
        return (zzhr) zzeu.zzb(zzb, bArr);
    }

    public final Object zzi(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzeu.zzf(zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzd"});
        } else if (i12 == 3) {
            return new zzhr();
        } else {
            if (i12 == 4) {
                return new zzhq((zzhp) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final List zzl() {
        return this.zzd;
    }
}
