package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjk;

public abstract class zzjj<MessageType extends zzjk<MessageType, BuilderType>, BuilderType extends zzjj<MessageType, BuilderType>> implements zzmh {
    /* renamed from: zzav */
    public abstract zzjj clone();

    public zzjj zzaw(byte[] bArr, int i11, int i12) throws zzll {
        throw null;
    }

    public zzjj zzax(byte[] bArr, int i11, int i12, zzkn zzkn) throws zzll {
        throw null;
    }

    public final /* synthetic */ zzmh zzay(byte[] bArr) throws zzll {
        return zzaw(bArr, 0, bArr.length);
    }

    public final /* synthetic */ zzmh zzaz(byte[] bArr, zzkn zzkn) throws zzll {
        return zzax(bArr, 0, bArr.length, zzkn);
    }
}
