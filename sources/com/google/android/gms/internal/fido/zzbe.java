package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;

class zzbe extends zzbf {
    public final zzbb zzb;
    public final Character zzc;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbe(com.google.android.gms.internal.fido.zzbb r4, java.lang.Character r5) {
        /*
            r3 = this;
            r3.<init>()
            r3.zzb = r4
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L_0x0017
            r5.charValue()
            r2 = 61
            boolean r4 = r4.zzb(r2)
            if (r4 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r4 = r0
            goto L_0x0018
        L_0x0017:
            r4 = r1
        L_0x0018:
            if (r4 == 0) goto L_0x001d
            r3.zzc = r5
            return
        L_0x001d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r5
            java.lang.String r5 = "Padding character %s was already in alphabet"
            java.lang.String r5 = com.google.android.gms.internal.fido.zzan.zza(r5, r1)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fido.zzbe.<init>(com.google.android.gms.internal.fido.zzbb, java.lang.Character):void");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbe) {
            zzbe zzbe = (zzbe) obj;
            if (this.zzb.equals(zzbe.zzb)) {
                Character ch2 = this.zzc;
                Character ch3 = zzbe.zzc;
                if (ch2 == ch3) {
                    return true;
                }
                if (ch2 == null || !ch2.equals(ch3)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = this.zzb.hashCode();
        Character ch2 = this.zzc;
        if (ch2 == null) {
            i11 = 0;
        } else {
            i11 = ch2.hashCode();
        }
        return hashCode ^ i11;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("BaseEncoding.");
        sb2.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb2.append(".omitPadding()");
            } else {
                sb2.append(".withPadChar('");
                sb2.append(this.zzc);
                sb2.append("')");
            }
        }
        return sb2.toString();
    }

    public void zza(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzam.zze(0, i12, bArr.length);
        while (i13 < i12) {
            zzc(appendable, bArr, i13, Math.min(this.zzb.zzd, i12 - i13));
            i13 += this.zzb.zzd;
        }
    }

    public final int zzb(int i11) {
        zzbb zzbb = this.zzb;
        return zzbb.zzc * zzbh.zza(i11, zzbb.zzd, RoundingMode.CEILING);
    }

    public final void zzc(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        zzam.zze(i11, i11 + i12, bArr.length);
        int i13 = 0;
        zzam.zzc(i12 <= this.zzb.zzd);
        long j11 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            j11 = (j11 | ((long) (bArr[i11 + i14] & 255))) << 8;
        }
        int i15 = ((i12 + 1) * 8) - this.zzb.zzb;
        while (i13 < i12 * 8) {
            zzbb zzbb = this.zzb;
            appendable.append(zzbb.zza(zzbb.zza & ((int) (j11 >>> (i15 - i13)))));
            i13 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i13 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i13 += this.zzb.zzb;
            }
        }
    }

    public zzbe(String str, String str2, Character ch2) {
        this(new zzbb(str, str2.toCharArray()), ch2);
    }
}
