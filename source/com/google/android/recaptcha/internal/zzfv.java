package com.google.android.recaptcha.internal;

import java.io.IOException;
import okio.Utf8;

final class zzfv extends zzfx {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzfv(java.lang.String r2, java.lang.String r3, java.lang.Character r4) {
        /*
            r1 = this;
            com.google.android.recaptcha.internal.zzft r0 = new com.google.android.recaptcha.internal.zzft
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
            com.google.android.recaptcha.internal.zzff.zza(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfv.<init>(java.lang.String, java.lang.String, java.lang.Character):void");
    }

    public final int zza(byte[] bArr, CharSequence charSequence) throws zzfw {
        CharSequence zze = zze(charSequence);
        if (this.zzb.zzc(zze.length())) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < zze.length()) {
                int i13 = i11 + 1;
                int i14 = i12 + 1;
                int zzb = (this.zzb.zzb(zze.charAt(i11)) << 18) | (this.zzb.zzb(zze.charAt(i13)) << 12);
                bArr[i12] = (byte) (zzb >>> 16);
                int i15 = i13 + 1;
                if (i15 < zze.length()) {
                    int i16 = i15 + 1;
                    int zzb2 = zzb | (this.zzb.zzb(zze.charAt(i15)) << 6);
                    i12 = i14 + 1;
                    bArr[i14] = (byte) ((zzb2 >>> 8) & 255);
                    if (i16 < zze.length()) {
                        bArr[i12] = (byte) ((zzb2 | this.zzb.zzb(zze.charAt(i16))) & 255);
                        i12++;
                        i11 = i16 + 1;
                    } else {
                        i11 = i16;
                    }
                } else {
                    i11 = i15;
                    i12 = i14;
                }
            }
            return i12;
        }
        throw new zzfw("Invalid input length " + zze.length());
    }

    public final void zzb(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzff.zzd(0, i12, bArr.length);
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
            zzf(appendable, bArr, i13, i12 - i13);
        }
    }
}
