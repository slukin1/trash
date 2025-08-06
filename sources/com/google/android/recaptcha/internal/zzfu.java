package com.google.android.recaptcha.internal;

import java.io.IOException;

final class zzfu extends zzfx {
    public final char[] zza = new char[512];

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzfu(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            com.google.android.recaptcha.internal.zzft r4 = new com.google.android.recaptcha.internal.zzft
            java.lang.String r5 = "0123456789ABCDEF"
            char[] r5 = r5.toCharArray()
            java.lang.String r0 = "base16()"
            r4.<init>(r0, r5)
            r5 = 0
            r3.<init>(r4, r5)
            r5 = 512(0x200, float:7.175E-43)
            char[] r5 = new char[r5]
            r3.zza = r5
            char[] r5 = r4.zzf
            int r5 = r5.length
            r0 = 0
            r1 = 16
            if (r5 != r1) goto L_0x0023
            r5 = 1
            goto L_0x0024
        L_0x0023:
            r5 = r0
        L_0x0024:
            com.google.android.recaptcha.internal.zzff.zza(r5)
        L_0x0027:
            r5 = 256(0x100, float:3.59E-43)
            if (r0 >= r5) goto L_0x0044
            char[] r5 = r3.zza
            int r1 = r0 >>> 4
            char r1 = r4.zza(r1)
            r5[r0] = r1
            char[] r5 = r3.zza
            r1 = r0 | 256(0x100, float:3.59E-43)
            r2 = r0 & 15
            char r2 = r4.zza(r2)
            r5[r1] = r2
            int r0 = r0 + 1
            goto L_0x0027
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfu.<init>(java.lang.String, java.lang.String):void");
    }

    public final int zza(byte[] bArr, CharSequence charSequence) throws zzfw {
        if (charSequence.length() % 2 != 1) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < charSequence.length()) {
                bArr[i12] = (byte) ((this.zzb.zzb(charSequence.charAt(i11)) << 4) | this.zzb.zzb(charSequence.charAt(i11 + 1)));
                i11 += 2;
                i12++;
            }
            return i12;
        }
        throw new zzfw("Invalid input length " + charSequence.length());
    }

    public final void zzb(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        zzff.zzd(0, i12, bArr.length);
        for (int i13 = 0; i13 < i12; i13++) {
            byte b11 = bArr[i13] & 255;
            appendable.append(this.zza[b11]);
            appendable.append(this.zza[b11 | 256]);
        }
    }
}
