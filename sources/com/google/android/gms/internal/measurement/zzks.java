package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class zzks {
    private static final zzks zzb = new zzks(true);
    public final zzng zza = new zzmw(16);
    private boolean zzc;
    private boolean zzd;

    private zzks() {
    }

    public static zzks zza() {
        throw null;
    }

    private static final void zzd(zzkr zzkr, Object obj) {
        boolean z11;
        zzoa zzb2 = zzkr.zzb();
        byte[] bArr = zzlj.zzd;
        Objects.requireNonNull(obj);
        zzoa zzoa = zzoa.DOUBLE;
        zzob zzob = zzob.INT;
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
                if ((obj instanceof zzka) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzld)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzmi) || (obj instanceof zzln)) {
                    return;
                }
        }
        if (z11) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzkr.zza()), zzkr.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzks zzks = new zzks();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry zzg = this.zza.zzg(i11);
            zzks.zzc((zzkr) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzks.zzc((zzkr) entry.getKey(), entry.getValue());
        }
        zzks.zzd = this.zzd;
        return zzks;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return false;
        }
        return this.zza.equals(((zzks) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
                Map.Entry zzg = this.zza.zzg(i11);
                if (zzg.getValue() instanceof zzlb) {
                    ((zzlb) zzg.getValue()).zzbM();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzkr zzkr, Object obj) {
        if (!zzkr.zzc()) {
            zzd(zzkr, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(zzkr, arrayList.get(i11));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzln) {
            this.zzd = true;
        }
        this.zza.put(zzkr, obj);
    }

    private zzks(boolean z11) {
        zzb();
        zzb();
    }
}
