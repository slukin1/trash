package com.google.android.recaptcha.internal;

import java.util.Map;

final class zzku extends zzle {
    public zzku(int i11) {
        super(i11, (zzld) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i11 = 0; i11 < zzb(); i11++) {
                ((zzii) zzg(i11).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzii) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
