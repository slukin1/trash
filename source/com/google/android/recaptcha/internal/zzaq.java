package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzaq extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zzaw zzb;
    public final /* synthetic */ RecaptchaAction zzc;
    public final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaq(zzaw zzaw, RecaptchaAction recaptchaAction, long j11, c cVar) {
        super(2, cVar);
        this.zzb = zzaw;
        this.zzc = recaptchaAction;
        this.zzd = j11;
    }

    public final c create(Object obj, c cVar) {
        return new zzaq(this.zzb, this.zzc, this.zzd, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaq) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 != 0) {
            obj2 = ((Result) obj).m3081unboximpl();
        } else {
            zzaw zzaw = this.zzb;
            RecaptchaAction recaptchaAction = this.zzc;
            long j11 = this.zzd;
            this.zza = 1;
            obj2 = zzaw.zzk(recaptchaAction, j11, this);
            if (obj2 == d11) {
                return d11;
            }
        }
        return Result.m3071boximpl(obj2);
    }
}
