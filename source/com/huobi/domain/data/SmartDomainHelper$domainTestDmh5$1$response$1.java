package com.huobi.domain.data;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import okhttp3.Request;
import okhttp3.Response;

@d(c = "com.huobi.domain.data.SmartDomainHelper$domainTestDmh5$1$response$1", f = "SmartDomainHelper.kt", l = {}, m = "invokeSuspend")
public final class SmartDomainHelper$domainTestDmh5$1$response$1 extends SuspendLambda implements p<h0, c<? super Response>, Object> {
    public final /* synthetic */ Request $request;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartDomainHelper$domainTestDmh5$1$response$1(Request request, c<? super SmartDomainHelper$domainTestDmh5$1$response$1> cVar) {
        super(2, cVar);
        this.$request = request;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SmartDomainHelper$domainTestDmh5$1$response$1(this.$request, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Response> cVar) {
        return ((SmartDomainHelper$domainTestDmh5$1$response$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            return SmartDomainHelper.f43845c.newCall(this.$request).execute();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
