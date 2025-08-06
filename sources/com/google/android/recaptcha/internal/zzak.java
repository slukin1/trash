package com.google.android.recaptcha.internal;

import android.app.Application;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzak extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ Application zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzak(Application application, String str, long j11, c cVar) {
        super(2, cVar);
        this.zzb = application;
        this.zzc = str;
        this.zzd = j11;
    }

    public final c create(Object obj, c cVar) {
        return new zzak(this.zzb, this.zzc, this.zzd, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzak) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 == 0) {
            zzam zzam = zzam.zza;
            Application application = this.zzb;
            String str = this.zzc;
            long j11 = this.zzd;
            this.zza = 1;
            obj = zzam.zzc(application, str, j11, (zzbq) null, this);
            if (obj == d11) {
                return d11;
            }
        }
        return obj;
    }
}
