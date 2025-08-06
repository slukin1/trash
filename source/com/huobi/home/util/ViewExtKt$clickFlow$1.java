package com.huobi.home.util;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;

@d(c = "com.huobi.home.util.ViewExtKt$clickFlow$1", f = "ViewExt.kt", l = {573}, m = "invokeSuspend")
final class ViewExtKt$clickFlow$1 extends SuspendLambda implements p<k<? super Unit>, c<? super Unit>, Object> {
    public final /* synthetic */ View $this_clickFlow;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewExtKt$clickFlow$1(View view, c<? super ViewExtKt$clickFlow$1> cVar) {
        super(2, cVar);
        this.$this_clickFlow = view;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void invokeSuspend$lambda$0(k kVar, View view) {
        kVar.q(Unit.f56620a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        ViewExtKt$clickFlow$1 viewExtKt$clickFlow$1 = new ViewExtKt$clickFlow$1(this.$this_clickFlow, cVar);
        viewExtKt$clickFlow$1.L$0 = obj;
        return viewExtKt$clickFlow$1;
    }

    public final Object invoke(k<? super Unit> kVar, c<? super Unit> cVar) {
        return ((ViewExtKt$clickFlow$1) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            kotlin.k.b(obj);
            k kVar = (k) this.L$0;
            this.$this_clickFlow.setOnClickListener(new c(kVar));
            final View view = this.$this_clickFlow;
            AnonymousClass2 r12 = new a<Unit>() {
                public final void invoke() {
                    view.setOnClickListener((View.OnClickListener) null);
                }
            };
            this.label = 1;
            if (ProduceKt.a(kVar, r12, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            kotlin.k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
