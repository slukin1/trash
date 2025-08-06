package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Objects;

final class zzkf extends zzki {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzkf(byte[] bArr, int i11, int i12) {
        super((zzkh) null);
        Objects.requireNonNull(bArr, "buffer");
        int length = bArr.length;
        if (((length - i12) | i12) >= 0) {
            this.zzc = bArr;
            this.zze = 0;
            this.zzd = i12;
            return;
        }
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(length), 0, Integer.valueOf(i12)}));
    }

    public final int zza() {
        return this.zzd - this.zze;
    }

    public final void zzb(byte b11) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i11 = this.zze;
            this.zze = i11 + 1;
            bArr[i11] = b11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e11);
        }
    }

    public final void zzc(byte[] bArr, int i11, int i12) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i12);
            this.zze += i12;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i12)}), e11);
        }
    }

    public final void zzd(int i11, boolean z11) throws IOException {
        zzq(i11 << 3);
        zzb(z11 ? (byte) 1 : 0);
    }

    public final void zze(int i11, zzka zzka) throws IOException {
        zzq((i11 << 3) | 2);
        zzq(zzka.zzd());
        zzka.zzh(this);
    }

    public final void zzf(int i11, int i12) throws IOException {
        zzq((i11 << 3) | 5);
        zzg(i12);
    }

    public final void zzg(int i11) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i12 = this.zze;
            int i13 = i12 + 1;
            this.zze = i13;
            bArr[i12] = (byte) (i11 & 255);
            int i14 = i13 + 1;
            this.zze = i14;
            bArr[i13] = (byte) ((i11 >> 8) & 255);
            int i15 = i14 + 1;
            this.zze = i15;
            bArr[i14] = (byte) ((i11 >> 16) & 255);
            this.zze = i15 + 1;
            bArr[i15] = (byte) ((i11 >> 24) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e11);
        }
    }

    public final void zzh(int i11, long j11) throws IOException {
        zzq((i11 << 3) | 1);
        zzi(j11);
    }

    public final void zzi(long j11) throws IOException {
        try {
            byte[] bArr = this.zzc;
            int i11 = this.zze;
            int i12 = i11 + 1;
            this.zze = i12;
            bArr[i11] = (byte) (((int) j11) & 255);
            int i13 = i12 + 1;
            this.zze = i13;
            bArr[i12] = (byte) (((int) (j11 >> 8)) & 255);
            int i14 = i13 + 1;
            this.zze = i14;
            bArr[i13] = (byte) (((int) (j11 >> 16)) & 255);
            int i15 = i14 + 1;
            this.zze = i15;
            bArr[i14] = (byte) (((int) (j11 >> 24)) & 255);
            int i16 = i15 + 1;
            this.zze = i16;
            bArr[i15] = (byte) (((int) (j11 >> 32)) & 255);
            int i17 = i16 + 1;
            this.zze = i17;
            bArr[i16] = (byte) (((int) (j11 >> 40)) & 255);
            int i18 = i17 + 1;
            this.zze = i18;
            bArr[i17] = (byte) (((int) (j11 >> 48)) & 255);
            this.zze = i18 + 1;
            bArr[i18] = (byte) (((int) (j11 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e11);
        }
    }

    public final void zzj(int i11, int i12) throws IOException {
        zzq(i11 << 3);
        zzk(i12);
    }

    public final void zzk(int i11) throws IOException {
        if (i11 >= 0) {
            zzq(i11);
        } else {
            zzs((long) i11);
        }
    }

    public final void zzl(byte[] bArr, int i11, int i12) throws IOException {
        zzc(bArr, 0, i12);
    }

    public final void zzm(int i11, String str) throws IOException {
        zzq((i11 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i11 = this.zze;
        try {
            int zzx = zzki.zzx(str.length() * 3);
            int zzx2 = zzki.zzx(str.length());
            if (zzx2 == zzx) {
                int i12 = i11 + zzx2;
                this.zze = i12;
                int zzb = zznz.zzb(str, this.zzc, i12, this.zzd - i12);
                this.zze = i11;
                zzq((zzb - i11) - zzx2);
                this.zze = zzb;
                return;
            }
            zzq(zznz.zzc(str));
            byte[] bArr = this.zzc;
            int i13 = this.zze;
            this.zze = zznz.zzb(str, bArr, i13, this.zzd - i13);
        } catch (zzny e11) {
            this.zze = i11;
            zzB(str, e11);
        } catch (IndexOutOfBoundsException e12) {
            throw new zzkg(e12);
        }
    }

    public final void zzo(int i11, int i12) throws IOException {
        zzq((i11 << 3) | i12);
    }

    public final void zzp(int i11, int i12) throws IOException {
        zzq(i11 << 3);
        zzq(i12);
    }

    public final void zzq(int i11) throws IOException {
        while ((i11 & -128) != 0) {
            byte[] bArr = this.zzc;
            int i12 = this.zze;
            this.zze = i12 + 1;
            bArr[i12] = (byte) ((i11 & 127) | 128);
            i11 >>>= 7;
        }
        try {
            byte[] bArr2 = this.zzc;
            int i13 = this.zze;
            this.zze = i13 + 1;
            bArr2[i13] = (byte) i11;
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e11);
        }
    }

    public final void zzr(int i11, long j11) throws IOException {
        zzq(i11 << 3);
        zzs(j11);
    }

    public final void zzs(long j11) throws IOException {
        if (!zzki.zzd || this.zzd - this.zze < 10) {
            while ((j11 & -128) != 0) {
                byte[] bArr = this.zzc;
                int i11 = this.zze;
                this.zze = i11 + 1;
                bArr[i11] = (byte) ((((int) j11) & 127) | 128);
                j11 >>>= 7;
            }
            try {
                byte[] bArr2 = this.zzc;
                int i12 = this.zze;
                this.zze = i12 + 1;
                bArr2[i12] = (byte) ((int) j11);
            } catch (IndexOutOfBoundsException e11) {
                throw new zzkg(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1}), e11);
            }
        } else {
            while ((j11 & -128) != 0) {
                byte[] bArr3 = this.zzc;
                int i13 = this.zze;
                this.zze = i13 + 1;
                zznu.zzn(bArr3, (long) i13, (byte) ((((int) j11) & 127) | 128));
                j11 >>>= 7;
            }
            byte[] bArr4 = this.zzc;
            int i14 = this.zze;
            this.zze = i14 + 1;
            zznu.zzn(bArr4, (long) i14, (byte) ((int) j11));
        }
    }
}
