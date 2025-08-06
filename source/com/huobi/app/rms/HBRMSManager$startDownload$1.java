package com.huobi.app.rms;

import com.huobi.app.rms.bean.HBRMSResourceDownloadMode;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.huobi.app.rms.HBRMSManager", f = "HBRMSManager.kt", l = {270}, m = "startDownload")
public final class HBRMSManager$startDownload$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ HBRMSManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$startDownload$1(HBRMSManager hBRMSManager, c<? super HBRMSManager$startDownload$1> cVar) {
        super(cVar);
        this.this$0 = hBRMSManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.P((HBRMSResourceDownloadMode) null, this);
    }
}
