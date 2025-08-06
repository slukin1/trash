package com.google.android.recaptcha.internal;

import java.io.IOException;

public abstract class zzfy {
    private static final zzfy zza = new zzfv("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzfy zzb = new zzfv("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzfy zzc = new zzfx("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzfy zzd = new zzfx("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzfy zze = new zzfu("base16()", "0123456789ABCDEF");

    public static zzfy zzg() {
        return zza;
    }

    public static zzfy zzh() {
        return zzb;
    }

    public abstract int zza(byte[] bArr, CharSequence charSequence) throws zzfw;

    public abstract void zzb(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzc(int i11);

    public abstract int zzd(int i11);

    public CharSequence zze(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i11, int i12) {
        zzff.zzd(0, i12, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzd(i12));
        try {
            zzb(sb2, bArr, 0, i12);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence zze2 = zze(charSequence);
            int zzc2 = zzc(zze2.length());
            byte[] bArr = new byte[zzc2];
            int zza2 = zza(bArr, zze2);
            if (zza2 == zzc2) {
                return bArr;
            }
            byte[] bArr2 = new byte[zza2];
            System.arraycopy(bArr, 0, bArr2, 0, zza2);
            return bArr2;
        } catch (zzfw e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
