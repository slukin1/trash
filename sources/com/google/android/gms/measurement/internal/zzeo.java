package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

public final class zzeo {
    public static final AtomicReference zza = new AtomicReference();
    public static final AtomicReference zzb = new AtomicReference();
    public static final AtomicReference zzc = new AtomicReference();
    private final zzen zzd;

    public zzeo(zzen zzen) {
        this.zzd = zzen;
    }

    private static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String str3 = strArr[i11];
            if (str == str3 || str.equals(str3)) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[i11];
                    if (str2 == null) {
                        str2 = strArr2[i11] + "(" + strArr[i11] + ")";
                        strArr3[i11] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zzb(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(str);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final String zzb(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(zze(str2));
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                str = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = zza(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            sb2.append(str);
        }
        sb2.append("}]");
        return sb2.toString();
    }

    public final String zzc(zzau zzau) {
        String str;
        if (!this.zzd.zza()) {
            return zzau.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(zzau.zzc);
        sb2.append(",name=");
        sb2.append(zzd(zzau.zza));
        sb2.append(",params=");
        zzas zzas = zzau.zzb;
        if (zzas == null) {
            str = null;
        } else if (!this.zzd.zza()) {
            str = zzas.toString();
        } else {
            str = zzb(zzas.zzc());
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final String zzd(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzhc.zzc, zzhc.zza, zza);
    }

    public final String zze(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzhd.zzb, zzhd.zza, zzb);
    }

    public final String zzf(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zzg(str, zzhe.zzb, zzhe.zza, zzc);
        }
        return "experiment_id(" + str + ")";
    }
}
