package com.huobi.edgeengine.debugger;

import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class Debugger$runStethoAndV8Safely$1 extends Lambda implements a<Object> {
    public final /* synthetic */ a<Object> $action;
    public final /* synthetic */ Debugger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Debugger$runStethoAndV8Safely$1(Debugger debugger, a<Object> aVar) {
        super(0);
        this.this$0 = debugger;
        this.$action = aVar;
    }

    public final Object invoke() {
        this.this$0.n();
        return this.$action.invoke();
    }
}
