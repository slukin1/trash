package kotlinx.coroutines.reactive;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class FlowSubscription$createInitialContinuation$1$1 extends FunctionReferenceImpl implements l<c<? super Unit>, Object> {
    public FlowSubscription$createInitialContinuation$1$1(Object obj) {
        super(1, obj, FlowSubscription.class, "flowProcessing", "flowProcessing(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(c<? super Unit> cVar) {
        return ((FlowSubscription) this.receiver).k1(cVar);
    }
}
