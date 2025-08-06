package com.huobi.app.rms;

import com.huobi.app.rms.bean.HBRMSResourceDownloadMode;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.huobi.app.rms.HBRMSManager$startDownloadInMode$1", f = "HBRMSManager.kt", l = {181}, m = "invokeSuspend")
public final class HBRMSManager$startDownloadInMode$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ HBRMSResourceDownloadMode $mode;
    public int label;
    public final /* synthetic */ HBRMSManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$startDownloadInMode$1(HBRMSManager hBRMSManager, HBRMSResourceDownloadMode hBRMSResourceDownloadMode, c<? super HBRMSManager$startDownloadInMode$1> cVar) {
        super(2, cVar);
        this.this$0 = hBRMSManager;
        this.$mode = hBRMSResourceDownloadMode;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new HBRMSManager$startDownloadInMode$1(this.this$0, this.$mode, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((HBRMSManager$startDownloadInMode$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            if (this.this$0.f42159m || this.$mode == HBRMSResourceDownloadMode.Force) {
                HBRMSManager hBRMSManager = this.this$0;
                HBRMSResourceDownloadMode hBRMSResourceDownloadMode = this.$mode;
                this.label = 1;
                if (hBRMSManager.P(hBRMSResourceDownloadMode, this) == d11) {
                    return d11;
                }
            } else {
                this.this$0.f42160n.add(this.$mode);
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
