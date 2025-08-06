package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class zzcx extends Lambda implements p {
    public final /* synthetic */ zzcj zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcx(zzcj zzcj, String str, int i11) {
        super(2);
        this.zza = zzcj;
        this.zzb = str;
        this.zzc = i11;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        this.zza.zzi().zzb(this.zzb, (String) obj2);
        int i11 = this.zzc;
        if (i11 != -1) {
            this.zza.zzc().zzf(i11, objArr);
        }
        return Unit.f56620a;
    }
}
