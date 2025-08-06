package kotlinx.coroutines.reactive;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.reactive.ReactiveSubscriber", f = "ReactiveFlow.kt", l = {129}, m = "takeNextOrNull")
final class ReactiveSubscriber$takeNextOrNull$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ e<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactiveSubscriber$takeNextOrNull$1(e<Object> eVar, c<? super ReactiveSubscriber$takeNextOrNull$1> cVar) {
        super(cVar);
        this.this$0 = eVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
