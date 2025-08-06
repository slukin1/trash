package com.google.android.recaptcha.internal;

import d10.p;
import java.util.Timer;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzbk extends SuspendLambda implements p {
    public final /* synthetic */ zzbm zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbk(zzbm zzbm, c cVar) {
        super(2, cVar);
        this.zza = zzbm;
    }

    public final c create(Object obj, c cVar) {
        return new zzbk(this.zza, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbk) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Unit unit;
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        zzbm zzbm = this.zza;
        synchronized (zzbh.class) {
            zzaz zzb = zzbm.zze;
            if (zzb != null && zzb.zzb() == 0) {
                Timer zzc = zzbm.zzb;
                if (zzc != null) {
                    zzc.cancel();
                }
                zzbm.zzb = null;
            }
            zzbm.zzg();
            unit = Unit.f56620a;
        }
        return unit;
    }
}
