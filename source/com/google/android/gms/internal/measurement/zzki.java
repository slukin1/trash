package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzki extends zzjq {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzki.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzd = zznu.zzx();
    public zzkj zza;

    private zzki() {
    }

    public /* synthetic */ zzki(zzkh zzkh) {
    }

    @Deprecated
    public static int zzt(int i11, zzmi zzmi, zzmt zzmt) {
        int zzbu = ((zzjk) zzmi).zzbu(zzmt);
        int zzx = zzx(i11 << 3);
        return zzx + zzx + zzbu;
    }

    public static int zzu(int i11) {
        if (i11 >= 0) {
            return zzx(i11);
        }
        return 10;
    }

    public static int zzv(zzmi zzmi, zzmt zzmt) {
        int zzbu = ((zzjk) zzmi).zzbu(zzmt);
        return zzx(zzbu) + zzbu;
    }

    public static int zzw(String str) {
        int i11;
        try {
            i11 = zznz.zzc(str);
        } catch (zzny unused) {
            i11 = str.getBytes(zzlj.zzb).length;
        }
        return zzx(i11) + i11;
    }

    public static int zzx(int i11) {
        if ((i11 & -128) == 0) {
            return 1;
        }
        if ((i11 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i11) == 0) {
            return 3;
        }
        return (i11 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzy(long j11) {
        int i11;
        if ((-128 & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if ((-34359738368L & j11) != 0) {
            i11 = 6;
            j11 >>>= 28;
        } else {
            i11 = 2;
        }
        if ((-2097152 & j11) != 0) {
            j11 >>>= 14;
            i11 += 2;
        }
        return (j11 & -16384) != 0 ? i11 + 1 : i11;
    }

    public static zzki zzz(byte[] bArr, int i11, int i12) {
        return new zzkf(bArr, 0, i12);
    }

    public final void zzA() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzB(String str, zzny zzny) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzny);
        byte[] bytes = str.getBytes(zzlj.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzkg(e11);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b11) throws IOException;

    public abstract void zzd(int i11, boolean z11) throws IOException;

    public abstract void zze(int i11, zzka zzka) throws IOException;

    public abstract void zzf(int i11, int i12) throws IOException;

    public abstract void zzg(int i11) throws IOException;

    public abstract void zzh(int i11, long j11) throws IOException;

    public abstract void zzi(long j11) throws IOException;

    public abstract void zzj(int i11, int i12) throws IOException;

    public abstract void zzk(int i11) throws IOException;

    public abstract void zzl(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void zzm(int i11, String str) throws IOException;

    public abstract void zzo(int i11, int i12) throws IOException;

    public abstract void zzp(int i11, int i12) throws IOException;

    public abstract void zzq(int i11) throws IOException;

    public abstract void zzr(int i11, long j11) throws IOException;

    public abstract void zzs(long j11) throws IOException;
}
