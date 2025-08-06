package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzha extends zzhc {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl = Integer.MAX_VALUE;

    public /* synthetic */ zzha(InputStream inputStream, int i11, zzgz zzgz) {
        super((zzhb) null);
        byte[] bArr = zzjc.zzd;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i11) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i11 > 0) {
            int min = Math.min(i11, 4096);
            byte[] bArr = new byte[min];
            int i12 = 0;
            while (i12 < min) {
                int read = this.zze.read(bArr, i12, min - i12);
                if (read != -1) {
                    this.zzk += read;
                    i12 += read;
                } else {
                    throw zzje.zzj();
                }
            }
            i11 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i11 = this.zzg + this.zzh;
        this.zzg = i11;
        int i12 = this.zzk + i11;
        int i13 = this.zzl;
        if (i12 > i13) {
            int i14 = i12 - i13;
            this.zzh = i14;
            this.zzg = i11 - i14;
            return;
        }
        this.zzh = 0;
    }

    private final void zzK(int i11) throws IOException {
        if (zzL(i11)) {
            return;
        }
        if (i11 > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw zzje.zzi();
        }
        throw zzje.zzj();
    }

    private final boolean zzL(int i11) throws IOException {
        int i12 = this.zzi;
        int i13 = i12 + i11;
        int i14 = this.zzg;
        if (i13 > i14) {
            int i15 = this.zzk;
            if (i11 > (Integer.MAX_VALUE - i15) - i12 || i15 + i12 + i11 > this.zzl) {
                return false;
            }
            if (i12 > 0) {
                if (i14 > i12) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i12, bArr, 0, i14 - i12);
                }
                i15 = this.zzk + i12;
                this.zzk = i15;
                i14 = this.zzg - i12;
                this.zzg = i14;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i14, Math.min(4096 - i14, (Integer.MAX_VALUE - i15) - i14));
                if (read == 0 || read < -1 || read > 4096) {
                    throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.zzg += read;
                    zzJ();
                    if (this.zzg >= i11) {
                        return true;
                    }
                    return zzL(i11);
                }
            } catch (zzje e11) {
                e11.zzk();
                throw e11;
            }
        } else {
            throw new IllegalStateException("refillBuffer() called when " + i11 + " bytes were already available in buffer");
        }
    }

    private final byte[] zzM(int i11, boolean z11) throws IOException {
        byte[] zzN = zzN(i11);
        if (zzN != null) {
            return zzN;
        }
        int i12 = this.zzi;
        int i13 = this.zzg;
        int i14 = i13 - i12;
        this.zzk += i13;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzI = zzI(i11 - i14);
        byte[] bArr = new byte[i11];
        System.arraycopy(this.zzf, i12, bArr, 0, i14);
        for (byte[] bArr2 : zzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i14, length);
            i14 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i11) throws IOException {
        if (i11 == 0) {
            return zzjc.zzd;
        }
        if (i11 >= 0) {
            int i12 = this.zzk;
            int i13 = this.zzi;
            int i14 = i12 + i13 + i11;
            if (CellBase.GROUP_ID_END_USER + i14 <= 0) {
                int i15 = this.zzl;
                if (i14 <= i15) {
                    int i16 = this.zzg - i13;
                    int i17 = i11 - i16;
                    if (i17 >= 4096) {
                        try {
                            if (i17 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzje e11) {
                            e11.zzk();
                            throw e11;
                        }
                    }
                    byte[] bArr = new byte[i11];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i16);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i16 < i11) {
                        try {
                            int read = this.zze.read(bArr, i16, i11 - i16);
                            if (read != -1) {
                                this.zzk += read;
                                i16 += read;
                            } else {
                                throw zzje.zzj();
                            }
                        } catch (zzje e12) {
                            e12.zzk();
                            throw e12;
                        }
                    }
                    return bArr;
                }
                zzB((i15 - i12) - i13);
                throw zzje.zzj();
            }
            throw zzje.zzi();
        }
        throw zzje.zzf();
    }

    public final void zzA(int i11) {
        this.zzl = i11;
        zzJ();
    }

    public final void zzB(int i11) throws IOException {
        int i12 = this.zzg;
        int i13 = this.zzi;
        int i14 = i12 - i13;
        if (i11 <= i14 && i11 >= 0) {
            this.zzi = i13 + i11;
        } else if (i11 >= 0) {
            int i15 = this.zzk;
            int i16 = i15 + i13;
            int i17 = this.zzl;
            if (i16 + i11 <= i17) {
                this.zzk = i16;
                this.zzg = 0;
                this.zzi = 0;
                while (i14 < i11) {
                    try {
                        long j11 = (long) (i11 - i14);
                        long skip = this.zze.skip(j11);
                        int i18 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i18 < 0 || skip > j11) {
                            throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                        } else if (i18 == 0) {
                            break;
                        } else {
                            i14 += (int) skip;
                        }
                    } catch (zzje e11) {
                        e11.zzk();
                        throw e11;
                    } catch (Throwable th2) {
                        this.zzk += i14;
                        zzJ();
                        throw th2;
                    }
                }
                this.zzk += i14;
                zzJ();
                if (i14 < i11) {
                    int i19 = this.zzg;
                    int i21 = i19 - this.zzi;
                    this.zzi = i19;
                    zzK(1);
                    while (true) {
                        int i22 = i11 - i21;
                        int i23 = this.zzg;
                        if (i22 > i23) {
                            i21 += i23;
                            this.zzi = i23;
                            zzK(1);
                        } else {
                            this.zzi = i22;
                            return;
                        }
                    }
                }
            } else {
                zzB((i17 - i15) - i13);
                throw zzje.zzj();
            }
        } else {
            throw zzje.zzf();
        }
    }

    public final boolean zzC() throws IOException {
        return this.zzi == this.zzg && !zzL(1);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final boolean zzE(int i11) throws IOException {
        int zzm;
        int i12 = i11 & 7;
        int i13 = 0;
        if (i12 == 0) {
            if (this.zzg - this.zzi >= 10) {
                while (i13 < 10) {
                    byte[] bArr = this.zzf;
                    int i14 = this.zzi;
                    this.zzi = i14 + 1;
                    if (bArr[i14] < 0) {
                        i13++;
                    }
                }
                throw zzje.zze();
            }
            while (i13 < 10) {
                if (zza() < 0) {
                    i13++;
                }
            }
            throw zzje.zze();
            return true;
        } else if (i12 == 1) {
            zzB(8);
            return true;
        } else if (i12 == 2) {
            zzB(zzj());
            return true;
        } else if (i12 == 3) {
            do {
                zzm = zzm();
                if (zzm == 0 || !zzE(zzm)) {
                    zzz(((i11 >>> 3) << 3) | 4);
                }
                zzm = zzm();
                break;
            } while (!zzE(zzm));
            zzz(((i11 >>> 3) << 3) | 4);
            return true;
        } else if (i12 == 4) {
            return false;
        } else {
            if (i12 == 5) {
                zzB(4);
                return true;
            }
            throw zzje.zza();
        }
    }

    public final byte zza() throws IOException {
        if (this.zzi == this.zzg) {
            zzK(1);
        }
        byte[] bArr = this.zzf;
        int i11 = this.zzi;
        this.zzi = i11 + 1;
        return bArr[i11];
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzk + this.zzi;
    }

    public final int zze(int i11) throws zzje {
        if (i11 >= 0) {
            int i12 = this.zzk + this.zzi;
            int i13 = this.zzl;
            int i14 = i11 + i12;
            if (i14 <= i13) {
                this.zzl = i14;
                zzJ();
                return i13;
            }
            throw zzje.zzj();
        }
        throw zzje.zzf();
    }

    public final int zzf() throws IOException {
        return zzj();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i11 = this.zzi;
        if (this.zzg - i11 < 4) {
            zzK(4);
            i11 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i11 + 4;
        int i12 = (bArr[i11 + 1] & 255) << 8;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | i12 | (bArr[i11] & 255) | ((bArr[i11 + 2] & 255) << 16);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] < 0) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L_0x0007
            goto L_0x006d
        L_0x0007:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzi = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x006a
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x006a
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x006a
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r5.zzi = r1
            return r0
        L_0x006d:
            long r0 = r5.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzha.zzj():int");
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzhc.zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzj = zzj2;
        if ((zzj2 >>> 3) != 0) {
            return zzj2;
        }
        throw zzje.zzc();
    }

    public final int zzn() throws IOException {
        return zzj();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i11 = this.zzi;
        if (this.zzg - i11 < 8) {
            zzK(8);
            i11 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i11 + 8;
        long j11 = (long) bArr[i11 + 2];
        long j12 = (long) bArr[i11 + 3];
        long j13 = (long) bArr[i11 + 4];
        long j14 = (long) bArr[i11 + 5];
        long j15 = (long) bArr[i11 + 6];
        long j16 = (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((j11 & 255) << 16) | ((j12 & 255) << 24);
        return ((((long) bArr[i11 + 7]) & 255) << 56) | j16 | ((j13 & 255) << 32) | ((j14 & 255) << 40) | ((j15 & 255) << 48);
    }

    public final long zzr() throws IOException {
        long j11;
        long j12;
        long j13;
        long j14;
        byte b11;
        int i11 = this.zzi;
        int i12 = this.zzg;
        if (i12 != i11) {
            byte[] bArr = this.zzf;
            int i13 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 >= 0) {
                this.zzi = i13;
                return (long) b12;
            } else if (i12 - i13 >= 9) {
                int i14 = i13 + 1;
                byte b13 = b12 ^ (bArr[i13] << 7);
                if (b13 < 0) {
                    b11 = b13 ^ Byte.MIN_VALUE;
                } else {
                    int i15 = i14 + 1;
                    byte b14 = b13 ^ (bArr[i14] << 14);
                    if (b14 >= 0) {
                        j12 = (long) (b14 ^ 16256);
                    } else {
                        i14 = i15 + 1;
                        byte b15 = b14 ^ (bArr[i15] << 21);
                        if (b15 < 0) {
                            b11 = b15 ^ -2080896;
                        } else {
                            i15 = i14 + 1;
                            long j15 = ((long) b15) ^ (((long) bArr[i14]) << 28);
                            if (j15 >= 0) {
                                j14 = 266354560;
                            } else {
                                int i16 = i15 + 1;
                                long j16 = j15 ^ (((long) bArr[i15]) << 35);
                                if (j16 < 0) {
                                    j13 = -34093383808L;
                                } else {
                                    i15 = i16 + 1;
                                    j15 = j16 ^ (((long) bArr[i16]) << 42);
                                    if (j15 >= 0) {
                                        j14 = 4363953127296L;
                                    } else {
                                        i16 = i15 + 1;
                                        j16 = j15 ^ (((long) bArr[i15]) << 49);
                                        if (j16 < 0) {
                                            j13 = -558586000294016L;
                                        } else {
                                            i15 = i16 + 1;
                                            j12 = (j16 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                            if (j12 < 0) {
                                                i16 = i15 + 1;
                                                if (((long) bArr[i15]) >= 0) {
                                                    j11 = j12;
                                                    i14 = i16;
                                                    this.zzi = i14;
                                                    return j11;
                                                }
                                            }
                                        }
                                    }
                                }
                                j11 = j13 ^ j16;
                                i14 = i16;
                                this.zzi = i14;
                                return j11;
                            }
                            j12 = j15 ^ j14;
                        }
                    }
                    i14 = i15;
                    j11 = j12;
                    this.zzi = i14;
                    return j11;
                }
                j11 = (long) b11;
                this.zzi = i14;
                return j11;
            }
        }
        return zzs();
    }

    public final long zzs() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte zza = zza();
            j11 |= ((long) (zza & Ascii.DEL)) << i11;
            if ((zza & 128) == 0) {
                return j11;
            }
        }
        throw zzje.zze();
    }

    public final long zzt() throws IOException {
        return zzq();
    }

    public final long zzu() throws IOException {
        return zzhc.zzG(zzr());
    }

    public final long zzv() throws IOException {
        return zzr();
    }

    public final zzgw zzw() throws IOException {
        int zzj2 = zzj();
        int i11 = this.zzg;
        int i12 = this.zzi;
        if (zzj2 <= i11 - i12 && zzj2 > 0) {
            zzgw zzm = zzgw.zzm(this.zzf, i12, zzj2);
            this.zzi += zzj2;
            return zzm;
        } else if (zzj2 == 0) {
            return zzgw.zzb;
        } else {
            byte[] zzN = zzN(zzj2);
            if (zzN != null) {
                return zzgw.zzm(zzN, 0, zzN.length);
            }
            int i13 = this.zzi;
            int i14 = this.zzg;
            int i15 = i14 - i13;
            this.zzk += i14;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzI = zzI(zzj2 - i15);
            byte[] bArr = new byte[zzj2];
            System.arraycopy(this.zzf, i13, bArr, 0, i15);
            for (byte[] bArr2 : zzI) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i15, length);
                i15 += length;
            }
            return new zzgt(bArr);
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i11 = this.zzg;
            int i12 = this.zzi;
            if (zzj2 <= i11 - i12) {
                String str = new String(this.zzf, i12, zzj2, zzjc.zzb);
                this.zzi += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 > this.zzg) {
            return new String(zzM(zzj2, false), zzjc.zzb);
        }
        zzK(zzj2);
        String str2 = new String(this.zzf, this.zzi, zzj2, zzjc.zzb);
        this.zzi += zzj2;
        return str2;
    }

    public final String zzy() throws IOException {
        byte[] bArr;
        int zzj2 = zzj();
        int i11 = this.zzi;
        int i12 = this.zzg;
        if (zzj2 <= i12 - i11 && zzj2 > 0) {
            bArr = this.zzf;
            this.zzi = i11 + zzj2;
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 <= i12) {
                zzK(zzj2);
                bArr = this.zzf;
                this.zzi = zzj2;
            } else {
                bArr = zzM(zzj2, false);
            }
            i11 = 0;
        }
        return zzma.zzd(bArr, i11, zzj2);
    }

    public final void zzz(int i11) throws zzje {
        if (this.zzj != i11) {
            throw zzje.zzb();
        }
    }
}
