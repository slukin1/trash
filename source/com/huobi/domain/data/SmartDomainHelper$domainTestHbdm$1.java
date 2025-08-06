package com.huobi.domain.data;

import com.huobi.domain.data.SmartDomainHelper;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;
import okhttp3.Request;
import okhttp3.Response;

@d(c = "com.huobi.domain.data.SmartDomainHelper$domainTestHbdm$1", f = "SmartDomainHelper.kt", l = {155}, m = "invokeSuspend")
public final class SmartDomainHelper$domainTestHbdm$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ SmartDomainHelper.a $callback;
    public final /* synthetic */ String $domain;
    public final /* synthetic */ String $url;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmartDomainHelper$domainTestHbdm$1(String str, SmartDomainHelper.a aVar, String str2, c<? super SmartDomainHelper$domainTestHbdm$1> cVar) {
        super(2, cVar);
        this.$url = str;
        this.$callback = aVar;
        this.$domain = str2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SmartDomainHelper$domainTestHbdm$1(this.$url, this.$callback, this.$domain, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SmartDomainHelper$domainTestHbdm$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            Request build = new Request.Builder().url(this.$url).build();
            CoroutineDispatcher b11 = v0.b();
            SmartDomainHelper$domainTestHbdm$1$response$1 smartDomainHelper$domainTestHbdm$1$response$1 = new SmartDomainHelper$domainTestHbdm$1$response$1(build, (c<? super SmartDomainHelper$domainTestHbdm$1$response$1>) null);
            this.label = 1;
            obj = g.g(b11, smartDomainHelper$domainTestHbdm$1$response$1, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            try {
                k.b(obj);
            } catch (Exception e11) {
                SmartDomainHelper.a aVar = this.$callback;
                String str = this.$domain;
                aVar.onError(str, -100, "" + e11.getMessage());
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Response response = (Response) obj;
        if (response == null) {
            SmartDomainHelper.a aVar2 = this.$callback;
            String str2 = this.$domain;
            aVar2.onError(str2, -1, this.$domain + " response is null ");
        } else if (!response.isSuccessful()) {
            this.$callback.onError(this.$domain, response.code(), response.message());
        } else {
            this.$callback.a(this.$domain, response.code());
        }
        return Unit.f56620a;
    }
}
