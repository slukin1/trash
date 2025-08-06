package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzgk extends zzgu {
    public zzgk(int i11) {
        super(i11, (zzgt) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i11 = 0; i11 < zzb(); i11++) {
                Map.Entry zzg = zzg(i11);
                if (((zzeo) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzeo) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
