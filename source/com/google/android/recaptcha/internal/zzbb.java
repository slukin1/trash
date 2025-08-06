package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.x;

public final class zzbb {
    private final zzne zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze = null;

    public zzbb(zzne zzne, String str, String str2, String str3, String str4) {
        this.zza = zzne;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbb)) {
            return false;
        }
        zzbb zzbb = (zzbb) obj;
        return zzbb.zza == this.zza && x.b(zzbb.zzb, this.zzb) && x.b(zzbb.zzc, this.zzc) && x.b(zzbb.zzd, this.zzd) && x.b((Object) null, (Object) null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    public final zzne zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
