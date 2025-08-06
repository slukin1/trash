package com.sumsub.sns.core.data.listener;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

@d(c = "com.sumsub.sns.core.data.listener.CordovaTokenExpirationHandler$onTokenExpired$1", f = "TokenExpirationHandler.kt", l = {25}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class CordovaTokenExpirationHandler$onTokenExpired$1 extends SuspendLambda implements p<h0, c<? super String>, Object> {
    public int label;
    public final /* synthetic */ CordovaTokenExpirationHandler this$0;

    @d(c = "com.sumsub.sns.core.data.listener.CordovaTokenExpirationHandler$onTokenExpired$1$1", f = "TokenExpirationHandler.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* renamed from: com.sumsub.sns.core.data.listener.CordovaTokenExpirationHandler$onTokenExpired$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super String>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(cordovaTokenExpirationHandler, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.label == 0) {
                k.b(obj);
                return cordovaTokenExpirationHandler.onTokenExpiredMain();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(h0 h0Var, c<? super String> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CordovaTokenExpirationHandler$onTokenExpired$1(CordovaTokenExpirationHandler cordovaTokenExpirationHandler, c<? super CordovaTokenExpirationHandler$onTokenExpired$1> cVar) {
        super(2, cVar);
        this.this$0 = cordovaTokenExpirationHandler;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new CordovaTokenExpirationHandler$onTokenExpired$1(this.this$0, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            MainCoroutineDispatcher c11 = v0.c();
            final CordovaTokenExpirationHandler cordovaTokenExpirationHandler = this.this$0;
            AnonymousClass1 r12 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            obj = g.g(c11, r12, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    public final Object invoke(h0 h0Var, c<? super String> cVar) {
        return ((CordovaTokenExpirationHandler$onTokenExpired$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }
}
