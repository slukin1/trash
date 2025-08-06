package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

class zzfx extends zzfy {
    public final zzft zzb;
    public final Character zzc;

    public zzfx(zzft zzft, Character ch2) {
        this.zzb = zzft;
        if (ch2 != null) {
            ch2.charValue();
            if (zzft.zzd('=')) {
                throw new IllegalArgumentException(zzfi.zza("Padding character %s was already in alphabet", ch2));
            }
        }
        this.zzc = ch2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfx) {
            zzfx zzfx = (zzfx) obj;
            if (this.zzb.equals(zzfx.zzb)) {
                Character ch2 = this.zzc;
                Character ch3 = zzfx.zzc;
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
        Character ch2 = this.zzc;
        int hashCode = this.zzb.hashCode();
        if (ch2 == null) {
            i11 = 0;
        } else {
            i11 = ch2.hashCode();
        }
        return i11 ^ hashCode;
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

    public int zza(byte[] bArr, CharSequence charSequence) throws zzfw {
        zzft zzft;
        CharSequence zze = zze(charSequence);
        if (this.zzb.zzc(zze.length())) {
            int i11 = 0;
            int i12 = 0;
            while (i11 < zze.length()) {
                long j11 = 0;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    zzft = this.zzb;
                    if (i13 >= zzft.zzc) {
                        break;
                    }
                    j11 <<= zzft.zzb;
                    if (i11 + i13 < zze.length()) {
                        j11 |= (long) this.zzb.zzb(zze.charAt(i14 + i11));
                        i14++;
                    }
                    i13++;
                }
                int i15 = zzft.zzd;
                int i16 = i14 * zzft.zzb;
                int i17 = (i15 - 1) * 8;
                while (i17 >= (i15 * 8) - i16) {
                    bArr[i12] = (byte) ((int) ((j11 >>> i17) & 255));
                    i17 -= 8;
                    i12++;
                }
                i11 += this.zzb.zzc;
            }
            return i12;
        }
        throw new zzfw("Invalid input length " + zze.length());
    }

    public void zzb(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        zzff.zzd(0, i12, bArr.length);
        while (i13 < i12) {
            zzf(appendable, bArr, i13, Math.min(this.zzb.zzd, i12 - i13));
            i13 += this.zzb.zzd;
        }
    }

    public final int zzc(int i11) {
        return (int) (((((long) this.zzb.zzb) * ((long) i11)) + 7) / 8);
    }

    public final int zzd(int i11) {
        zzft zzft = this.zzb;
        return zzft.zzc * zzga.zza(i11, zzft.zzd, RoundingMode.CEILING);
    }

    public final CharSequence zze(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Character ch2 = this.zzc;
        if (ch2 == null) {
            return charSequence;
        }
        ch2.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0 || charSequence.charAt(length) != '=') {
            }
            length--;
            break;
        } while (charSequence.charAt(length) != '=');
        return charSequence.subSequence(0, length + 1);
    }

    public final void zzf(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
        zzff.zzd(i11, i11 + i12, bArr.length);
        int i13 = 0;
        zzff.zza(i12 <= this.zzb.zzd);
        long j11 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            j11 = (j11 | ((long) (bArr[i11 + i14] & 255))) << 8;
        }
        int i15 = (i12 + 1) * 8;
        zzft zzft = this.zzb;
        while (i13 < i12 * 8) {
            long j12 = j11 >>> ((i15 - zzft.zzb) - i13);
            zzft zzft2 = this.zzb;
            appendable.append(zzft2.zza(((int) j12) & zzft2.zza));
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

    public zzfx(String str, String str2, Character ch2) {
        this(new zzft(str, str2.toCharArray()), ch2);
    }
}
