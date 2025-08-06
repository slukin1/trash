package com.google.android.recaptcha.internal;

import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.util.Collection;
import kotlin.text.b;

public final class zzcv implements zzdd {
    public static final zzcv zza = new zzcv();

    private zzcv() {
    }

    public final void zza(int i11, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        String str;
        String str2;
        zzpq[] zzpqArr2 = zzpqArr;
        if (zzpqArr2.length == 1) {
            Object zza2 = zzcj.zzc().zza(zzpqArr2[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof int[]) {
                    str = ArraysKt___ArraysKt.g0((int[]) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                } else {
                    if (zza2 instanceof byte[]) {
                        str2 = new String((byte[]) zza2, b.f56908b);
                    } else if (zza2 instanceof long[]) {
                        str = ArraysKt___ArraysKt.h0((long[]) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                    } else if (zza2 instanceof short[]) {
                        str = ArraysKt___ArraysKt.j0((short[]) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                    } else if (zza2 instanceof float[]) {
                        str = ArraysKt___ArraysKt.f0((float[]) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                    } else if (zza2 instanceof double[]) {
                        str = ArraysKt___ArraysKt.e0((double[]) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                    } else if (zza2 instanceof char[]) {
                        str2 = new String((char[]) zza2);
                    } else if (zza2 instanceof Object[]) {
                        str = ArraysKt___ArraysKt.i0((Object[]) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                    } else if (zza2 instanceof Collection) {
                        str = CollectionsKt___CollectionsKt.k0((Iterable) zza2, Constants.ACCEPT_TIME_SEPARATOR_SP, "[", "]", 0, (CharSequence) null, (l) null, 56, (Object) null);
                    } else {
                        throw new zzae(4, 5, (Throwable) null);
                    }
                    str = str2;
                }
                int i12 = i11;
                zzcj.zzc().zzf(i11, str);
                return;
            }
            throw new zzae(4, 5, (Throwable) null);
        }
        throw new zzae(4, 3, (Throwable) null);
    }
}
