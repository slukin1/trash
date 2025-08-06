package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

public final class zzoz extends zzit implements zzkf {
    /* access modifiers changed from: private */
    public static final zzoz zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzoz zzoz = new zzoz();
        zzb = zzoz;
        zzit.zzD(zzoz.class, zzoz);
    }

    private zzoz() {
    }

    public static zzoz zzg(InputStream inputStream) throws IOException {
        return (zzoz) zzit.zzt(zzb, inputStream);
    }

    public final Object zzh(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzit.zzA(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzoz();
        } else {
            if (i12 == 4) {
                return new zzoy((zzor) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzpb zzi() {
        zzpb zzb2 = zzpb.zzb(this.zzf);
        return zzb2 == null ? zzpb.UNRECOGNIZED : zzb2;
    }
}
