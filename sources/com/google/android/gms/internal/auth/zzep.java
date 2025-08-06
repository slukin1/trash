package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzep {
    private static final zzep zzb = new zzep(true);
    public final zzgu zza = new zzgk(16);
    private boolean zzc;
    private boolean zzd;

    private zzep() {
    }

    public static zzep zza() {
        throw null;
    }

    private static final void zzd(zzeo zzeo, Object obj) {
        boolean z11;
        zzhn zzb2 = zzeo.zzb();
        zzez.zze(obj);
        zzhn zzhn = zzhn.DOUBLE;
        zzho zzho = zzho.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z11 = obj instanceof Integer;
                break;
            case 1:
                z11 = obj instanceof Long;
                break;
            case 2:
                z11 = obj instanceof Float;
                break;
            case 3:
                z11 = obj instanceof Double;
                break;
            case 4:
                z11 = obj instanceof Boolean;
                break;
            case 5:
                z11 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzee) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzew)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzfw) || (obj instanceof zzfb)) {
                    return;
                }
        }
        if (z11) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzeo.zza()), zzeo.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzep zzep = new zzep();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry zzg = this.zza.zzg(i11);
            zzep.zzc((zzeo) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzep.zzc((zzeo) entry.getKey(), entry.getValue());
        }
        zzep.zzd = this.zzd;
        return zzep;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzep)) {
            return false;
        }
        return this.zza.equals(((zzep) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzeo zzeo, Object obj) {
        if (!zzeo.zzc()) {
            zzd(zzeo, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(zzeo, arrayList.get(i11));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfb) {
            this.zzd = true;
        }
        this.zza.put(zzeo, obj);
    }

    private zzep(boolean z11) {
        zzb();
        zzb();
    }
}
