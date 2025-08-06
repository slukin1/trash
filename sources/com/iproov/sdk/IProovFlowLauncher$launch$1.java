package com.iproov.sdk;

import android.content.Context;
import com.iproov.sdk.IProov;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.iproov.sdk.IProovFlowLauncher", f = "IProovFlowLauncher.kt", l = {65}, m = "launch")
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
public final class IProovFlowLauncher$launch$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ IProovFlowLauncher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IProovFlowLauncher$launch$1(IProovFlowLauncher iProovFlowLauncher, c<? super IProovFlowLauncher$launch$1> cVar) {
        super(cVar);
        this.this$0 = iProovFlowLauncher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.launch((Context) null, (String) null, (String) null, (IProov.Options) null, this);
    }
}
