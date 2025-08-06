package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzlj {
    public static final Charset zza = Charset.forName(C.ASCII_NAME);
    public static final Charset zzb = Charset.forName("UTF-8");
    public static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzke zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i11 = zzke.zza;
        zzkc zzkc = new zzkc(bArr, 0, 0, false, (zzkb) null);
        try {
            zzkc.zza(0);
            zzf = zzkc;
        } catch (zzll e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int zza(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int zzb(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static Object zzc(Object obj, String str) {
        Objects.requireNonNull(obj, str);
        return obj;
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zzb);
    }
}
