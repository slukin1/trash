package com.google.android.gms.internal.fido;

import java.io.IOException;

public abstract class zzbf {
    private static final zzbf zza = new zzbd("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzbf zzb = new zzbd("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzbf zzc = new zzbe("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final zzbf zzd = new zzbe("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final zzbf zze = new zzbc("base16()", "0123456789ABCDEF");

    public static zzbf zzd() {
        return zze;
    }

    public abstract void zza(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzb(int i11);

    public final String zze(byte[] bArr, int i11, int i12) {
        zzam.zze(0, i12, bArr.length);
        StringBuilder sb2 = new StringBuilder(zzb(i12));
        try {
            zza(sb2, bArr, 0, i12);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
