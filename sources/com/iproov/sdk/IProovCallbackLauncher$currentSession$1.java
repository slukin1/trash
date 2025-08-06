package com.iproov.sdk;

import com.iproov.sdk.IProov;
import com.iproov.sdk.p009do.Ccase;
import com.iproov.sdk.p009do.Cnew;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.iproov.sdk.IProovCallbackLauncher$currentSession$1", f = "IProovCallbackLauncher.kt", l = {140}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "Lcom/iproov/sdk/IProov$Session;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class IProovCallbackLauncher$currentSession$1 extends SuspendLambda implements p<h0, c<? super IProov.Session>, Object> {
    public int label;

    public IProovCallbackLauncher$currentSession$1(c<? super IProovCallbackLauncher$currentSession$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new IProovCallbackLauncher$currentSession$1(cVar);
    }

    public final Object invoke(h0 h0Var, c<? super IProov.Session> cVar) {
        return ((IProovCallbackLauncher$currentSession$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            Cnew newR = Cnew.f489do;
            this.label = 1;
            obj = newR.m574do((c<? super Ccase>) this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Ccase caseR = (Ccase) obj;
        if (caseR == null) {
            return null;
        }
        return Cdo.m544do(caseR);
    }
}
