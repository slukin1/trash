package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huobi.points.entity.Points;
import java.util.EnumMap;

public final class zzhb {
    public static final zzhb zza = new zzhb((Boolean) null, (Boolean) null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzhb(Boolean bool, Boolean bool2, int i11) {
        EnumMap enumMap = new EnumMap(zzha.class);
        this.zzb = enumMap;
        enumMap.put(zzha.AD_STORAGE, bool);
        enumMap.put(zzha.ANALYTICS_STORAGE, bool2);
        this.zzc = i11;
    }

    public static zzhb zzb(Bundle bundle, int i11) {
        if (bundle == null) {
            return new zzhb((Boolean) null, (Boolean) null, i11);
        }
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzha : zzha.values()) {
            enumMap.put(zzha, zzp(bundle.getString(zzha.zzd)));
        }
        return new zzhb(enumMap, i11);
    }

    public static zzhb zzc(String str, int i11) {
        EnumMap enumMap = new EnumMap(zzha.class);
        if (str != null) {
            int i12 = 0;
            while (true) {
                zzha[] zzhaArr = zzha.zzc;
                int length = zzhaArr.length;
                if (i12 >= 2) {
                    break;
                }
                zzha zzha = zzhaArr[i12];
                int i13 = i12 + 2;
                if (i13 < str.length()) {
                    char charAt = str.charAt(i13);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (charAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(zzha, bool);
                }
                i12++;
            }
        }
        return new zzhb(enumMap, i11);
    }

    public static String zzh(Bundle bundle) {
        String string;
        for (zzha zzha : zzha.values()) {
            if (bundle.containsKey(zzha.zzd) && (string = bundle.getString(zzha.zzd)) != null && zzp(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean zzk(int i11, int i12) {
        return i11 <= i12;
    }

    public static final int zzo(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean zzp(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals(Points.STATE_DENIED)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhb)) {
            return false;
        }
        zzhb zzhb = (zzhb) obj;
        for (zzha zzha : zzha.values()) {
            if (zzo((Boolean) this.zzb.get(zzha)) != zzo((Boolean) zzhb.zzb.get(zzha))) {
                return false;
            }
        }
        if (this.zzc == zzhb.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.zzc * 17;
        for (Boolean zzo : this.zzb.values()) {
            i11 = (i11 * 31) + zzo(zzo);
        }
        return i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("settings: source=");
        sb2.append(this.zzc);
        for (zzha zzha : zzha.values()) {
            sb2.append(", ");
            sb2.append(zzha.name());
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            Boolean bool = (Boolean) this.zzb.get(zzha);
            if (bool == null) {
                sb2.append("uninitialized");
            } else {
                sb2.append(true != bool.booleanValue() ? Points.STATE_DENIED : "granted");
            }
        }
        return sb2.toString();
    }

    public final int zza() {
        return this.zzc;
    }

    public final zzhb zzd(zzhb zzhb) {
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzha : zzha.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzha);
            Boolean bool2 = (Boolean) zzhb.zzb.get(zzha);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                bool = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
            enumMap.put(zzha, bool);
        }
        return new zzhb(enumMap, 100);
    }

    public final zzhb zze(zzhb zzhb) {
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzha : zzha.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzha);
            if (bool == null) {
                bool = (Boolean) zzhb.zzb.get(zzha);
            }
            enumMap.put(zzha, bool);
        }
        return new zzhb(enumMap, this.zzc);
    }

    public final Boolean zzf() {
        return (Boolean) this.zzb.get(zzha.AD_STORAGE);
    }

    public final Boolean zzg() {
        return (Boolean) this.zzb.get(zzha.ANALYTICS_STORAGE);
    }

    public final String zzi() {
        char c11;
        StringBuilder sb2 = new StringBuilder("G1");
        zzha[] zzhaArr = zzha.zzc;
        int length = zzhaArr.length;
        for (int i11 = 0; i11 < 2; i11++) {
            Boolean bool = (Boolean) this.zzb.get(zzhaArr[i11]);
            if (bool == null) {
                c11 = '-';
            } else {
                c11 = bool.booleanValue() ? '1' : '0';
            }
            sb2.append(c11);
        }
        return sb2.toString();
    }

    public final boolean zzj(zzha zzha) {
        Boolean bool = (Boolean) this.zzb.get(zzha);
        return bool == null || bool.booleanValue();
    }

    public final boolean zzl() {
        for (Boolean bool : this.zzb.values()) {
            if (bool != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzm(zzhb zzhb) {
        return zzn(zzhb, (zzha[]) this.zzb.keySet().toArray(new zzha[0]));
    }

    public final boolean zzn(zzhb zzhb, zzha... zzhaArr) {
        for (zzha zzha : zzhaArr) {
            Boolean bool = (Boolean) this.zzb.get(zzha);
            Boolean bool2 = (Boolean) zzhb.zzb.get(zzha);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public zzhb(EnumMap enumMap, int i11) {
        EnumMap enumMap2 = new EnumMap(zzha.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i11;
    }
}
