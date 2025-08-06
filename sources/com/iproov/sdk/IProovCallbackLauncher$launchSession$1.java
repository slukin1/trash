package com.iproov.sdk;

import android.content.Context;
import com.iproov.sdk.IProov;
import com.iproov.sdk.p026return.Cextends;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.iproov.sdk.IProovCallbackLauncher$launchSession$1", f = "IProovCallbackLauncher.kt", l = {164}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "Lcom/iproov/sdk/IProov$Session;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class IProovCallbackLauncher$launchSession$1 extends SuspendLambda implements p<h0, c<? super IProov.Session>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ Cextends $sessionOptions;
    public final /* synthetic */ String $streamingUrl;
    public final /* synthetic */ String $token;
    public int label;
    public final /* synthetic */ IProovCallbackLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IProovCallbackLauncher$launchSession$1(IProovCallbackLauncher iProovCallbackLauncher, Context context, String str, String str2, Cextends extendsR, c<? super IProovCallbackLauncher$launchSession$1> cVar) {
        super(2, cVar);
        this.this$0 = iProovCallbackLauncher;
        this.$context = context;
        this.$streamingUrl = str;
        this.$token = str2;
        this.$sessionOptions = extendsR;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new IProovCallbackLauncher$launchSession$1(this.this$0, this.$context, this.$streamingUrl, this.$token, this.$sessionOptions, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super IProov.Session> cVar) {
        return ((IProovCallbackLauncher$launchSession$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
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
            Cextends extendsR = this.$sessionOptions;
            this.label = 1;
            obj = access$getIProovFlowLauncher$p.launchSession$iproov_release(context, str, str2, extendsR, this);
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
