package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

final class zzft implements zzo {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzfu zzb;

    public zzft(zzfu zzfu, String str) {
        this.zzb = zzfu;
        this.zza = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.zzb.zzg.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
