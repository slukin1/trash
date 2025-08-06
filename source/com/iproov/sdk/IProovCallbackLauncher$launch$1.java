package com.iproov.sdk;

import android.content.Context;
import com.iproov.sdk.IProov;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.iproov.sdk.IProovCallbackLauncher$launch$1", f = "IProovCallbackLauncher.kt", l = {150}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "Lcom/iproov/sdk/IProov$Session;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class IProovCallbackLauncher$launch$1 extends SuspendLambda implements p<h0, c<? super IProov.Session>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ IProov.Options $options;
    public final /* synthetic */ String $streamingUrl;
    public final /* synthetic */ String $token;
    public int label;
    public final /* synthetic */ IProovCallbackLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IProovCallbackLauncher$launch$1(IProovCallbackLauncher iProovCallbackLauncher, Context context, String str, String str2, IProov.Options options, c<? super IProovCallbackLauncher$launch$1> cVar) {
        super(2, cVar);
        this.this$0 = iProovCallbackLauncher;
        this.$context = context;
        this.$streamingUrl = str;
        this.$token = str2;
        this.$options = options;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new IProovCallbackLauncher$launch$1(this.this$0, this.$context, this.$streamingUrl, this.$token, this.$options, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super IProov.Session> cVar) {
        return ((IProovCallbackLauncher$launch$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            IProovFlowLauncher access$getIProovFlowLauncher$p = this.this$0.iProovFlowLauncher;
            Context context = this.$context;
            String str = this.$streamingUrl;
            String str2 = this.$token;
            IProov.Options options = this.$options;
            this.label = 1;
            obj = access$getIProovFlowLauncher$p.launch(context, str, str2, options, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.createListenerJob(((IProov.Session) obj).getUuid());
        return obj;
    }
}
