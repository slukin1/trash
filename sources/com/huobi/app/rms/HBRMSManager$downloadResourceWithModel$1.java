package com.huobi.app.rms;

import com.huobi.app.rms.bean.HBRMSResourceInfoModel;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.huobi.app.rms.HBRMSManager", f = "HBRMSManager.kt", l = {406}, m = "downloadResourceWithModel")
public final class HBRMSManager$downloadResourceWithModel$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HBRMSManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$downloadResourceWithModel$1(HBRMSManager hBRMSManager, c<? super HBRMSManager$downloadResourceWithModel$1> cVar) {
        super(cVar);
        this.this$0 = hBRMSManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x((HBRMSResourceInfoModel) null, (p<? super Long, ? super Long, Unit>) null, (p<? super Exception, ? super String, Unit>) null, this);
    }
}
