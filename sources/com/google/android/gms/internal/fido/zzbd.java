package com.google.android.gms.internal.fido;

import java.io.IOException;
import okio.Utf8;

final class zzbd extends zzbe {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbd(java.lang.String r2, java.lang.String r3, java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.gms.internal.fido.zzbb r0 = new com.google.android.gms.internal.fido.zzbb
            char[] r3 = r3.toCharArray()
            r0.<init>(r2, r3)
            r1.<init>(r0, r4)
            char[] r2 = r0.zzf
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L_0x0017
            r2 = 1
            goto L_0x0018
        L_0x0017:
            r2 = 0
        L_0x0018:
            com.google.android.gms.internal.fido.zzam.zzc(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbd.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    public final void zza(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzam.zze(0, i12, bArr.length);
        for (int i14 = i12; i14 >= 3; i14 -= 3) {
            int i15 = i13 + 1;
            int i16 = i15 + 1;
            byte b11 = ((bArr[i13] & 255) << 16) | ((bArr[i15] & 255) << 8) | (bArr[i16] & 255);
            appendable.append(this.zzb.zza(b11 >>> 18));
            appendable.append(this.zzb.zza((b11 >>> 12) & 63));
            appendable.append(this.zzb.zza((b11 >>> 6) & 63));
            appendable.append(this.zzb.zza(b11 & Utf8.REPLACEMENT_BYTE));
            i13 = i16 + 1;
        }
        if (i13 < i12) {
            zzc(appendable, bArr, i13, i12 - i13);
        }
    }
}
