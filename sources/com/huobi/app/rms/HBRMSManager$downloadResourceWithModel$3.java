package com.huobi.app.rms;

import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class HBRMSManager$downloadResourceWithModel$3 extends Lambda implements p<Exception, String, Unit> {
    public final /* synthetic */ p<Exception, String, Unit> $completion;
    public final /* synthetic */ HBRMSResourceInfoModel $downloadModel;
    public final /* synthetic */ HBRMSManager this$0;

    @d(c = "com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$3$1", f = "HBRMSManager.kt", l = {419}, m = "invokeSuspend")
    /* renamed from: com.huobi.app.rms.HBRMSManager$downloadResourceWithModel$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(hBRMSManager, hBRMSResourceInfoModel, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                HBRMSManager hBRMSManager = hBRMSManager;
                HBRMSResourceInfoModel hBRMSResourceInfoModel = hBRMSResourceInfoModel;
                this.label = 1;
                if (hBRMSManager.s(hBRMSResourceInfoModel, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$downloadResourceWithModel$3(p<? super Exception, ? super String, Unit> pVar, HBRMSManager hBRMSManager, HBRMSResourceInfoModel hBRMSResourceInfoModel) {
        super(2);
        this.$completion = pVar;
        this.this$0 = hBRMSManager;
        this.$downloadModel = hBRMSResourceInfoModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Exception) obj, (String) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Exception exc, String str) {
        if (exc == null) {
            g1 g1Var = g1.f57277b;
            final HBRMSManager hBRMSManager = this.this$0;
            final HBRMSResourceInfoModel hBRMSResourceInfoModel = this.$downloadModel;
            n1 unused = i.d(g1Var, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
        }
        p<Exception, String, Unit> pVar = this.$completion;
        if (pVar != null) {
            pVar.invoke(exc, str);
        }
    }
}
