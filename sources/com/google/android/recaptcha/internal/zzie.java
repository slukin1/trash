package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzie {
    public static final zzie zza = new zzie(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzie() {
        this.zzd = new HashMap();
    }

    public final zzir zza(zzke zzke, int i11) {
        return (zzir) this.zzd.get(new zzid(zzke, i11));
    }

    public zzie(boolean z11) {
        this.zzd = Collections.emptyMap();
    }
}
