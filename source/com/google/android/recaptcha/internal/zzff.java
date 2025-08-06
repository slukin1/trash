package com.google.android.recaptcha.internal;

public final class zzff {
    public static void zza(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzb(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzc(boolean z11, String str, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(zzfi.zza(str, Character.valueOf(c11)));
        }
    }

    public static void zzd(int i11, int i12, int i13) {
        String str;
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            if (i11 < 0 || i11 > i13) {
                str = zzf(i11, i13, "start index");
            } else if (i12 < 0 || i12 > i13) {
                str = zzf(i12, i13, "end index");
            } else {
                str = zzfi.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void zze(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzf(int i11, int i12, String str) {
        if (i11 < 0) {
            return zzfi.zza("%s (%s) must not be negative", str, Integer.valueOf(i11));
        }
        return zzfi.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
    }
}
