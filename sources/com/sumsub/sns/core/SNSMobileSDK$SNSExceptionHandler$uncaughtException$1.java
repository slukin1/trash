package com.sumsub.sns.core;

import com.sumsub.log.logger.a;
import com.sumsub.sns.core.SNSMobileSDK;
import com.sumsub.sns.internal.core.data.model.LogParams;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.sumsub.sns.core.SNSMobileSDK$SNSExceptionHandler$uncaughtException$1", f = "SNSMobileSDK.kt", l = {670}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SNSMobileSDK$SNSExceptionHandler$uncaughtException$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Throwable $e;
    public int label;
    public final /* synthetic */ SNSMobileSDK.SNSExceptionHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSMobileSDK$SNSExceptionHandler$uncaughtException$1(SNSMobileSDK.SNSExceptionHandler sNSExceptionHandler, Throwable th2, c<? super SNSMobileSDK$SNSExceptionHandler$uncaughtException$1> cVar) {
        super(2, cVar);
        this.this$0 = sNSExceptionHandler;
        this.$e = th2;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SNSMobileSDK$SNSExceptionHandler$uncaughtException$1(this.this$0, this.$e, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            LogParams access$prepareLogParams = this.this$0.prepareLogParams(this.$e);
            if (access$prepareLogParams != null) {
                com.sumsub.sns.internal.log.cacher.c access$getSink$p = this.this$0.sink;
                this.label = 1;
                obj = access$getSink$p.send(access$prepareLogParams, this);
                if (obj == d11) {
                    return d11;
                }
            } else {
                a.c(com.sumsub.sns.internal.log.a.f34862a, b.f30747a, "Ignoring host appliaction's exceptions", (Throwable) null, 4, (Object) null);
                return Unit.f56620a;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.coroutines.jvm.internal.a.a(((Boolean) obj).booleanValue());
        return Unit.f56620a;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SNSMobileSDK$SNSExceptionHandler$uncaughtException$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }
}
