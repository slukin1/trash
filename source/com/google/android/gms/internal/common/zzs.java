package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
public final class zzs {
    @CanIgnoreReturnValue
    public static int zza(int i11, int i12, String str) {
        String str2;
        if (i11 >= 0 && i11 < i12) {
            return i11;
        }
        if (i11 < 0) {
            str2 = zzy.zza("%s (%s) must not be negative", "index", Integer.valueOf(i11));
        } else if (i12 < 0) {
            throw new IllegalArgumentException("negative size: " + i12);
        } else {
            str2 = zzy.zza("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i11), Integer.valueOf(i12));
        }
        throw new IndexOutOfBoundsException(str2);
    }

    @CanIgnoreReturnValue
    public static int zzb(int i11, int i12, String str) {
        if (i11 >= 0 && i11 <= i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(zzd(i11, i12, "index"));
    }

    public static void zzc(int i11, int i12, int i13) {
        String str;
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            if (i11 < 0 || i11 > i13) {
                str = zzd(i11, i13, "start index");
            } else if (i12 < 0 || i12 > i13) {
                str = zzd(i12, i13, "end index");
            } else {
                str = zzy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    private static String zzd(int i11, int i12, String str) {
        if (i11 < 0) {
            return zzy.zza("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return zzy.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            throw new IllegalArgumentException("negative size: " + i12);
        }
    }
}
