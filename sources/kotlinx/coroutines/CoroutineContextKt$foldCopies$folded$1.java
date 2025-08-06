package kotlinx.coroutines;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

public final class CoroutineContextKt$foldCopies$folded$1 extends Lambda implements p<CoroutineContext, CoroutineContext.a, CoroutineContext> {
    public final /* synthetic */ boolean $isNewCoroutine;
    public final /* synthetic */ Ref$ObjectRef<CoroutineContext> $leftoverContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineContextKt$foldCopies$folded$1(Ref$ObjectRef<CoroutineContext> ref$ObjectRef, boolean z11) {
        super(2);
        this.$leftoverContext = ref$ObjectRef;
        this.$isNewCoroutine = z11;
    }

    public final CoroutineContext invoke(CoroutineContext coroutineContext, CoroutineContext.a aVar) {
        if (!(aVar instanceof b0)) {
            return coroutineContext.plus(aVar);
        }
        CoroutineContext.a aVar2 = ((CoroutineContext) this.$leftoverContext.element).get(aVar.getKey());
        if (aVar2 == null) {
            b0 b0Var = (b0) aVar;
            if (this.$isNewCoroutine) {
                b0Var = b0Var.l();
            }
            return coroutineContext.plus(b0Var);
        }
        Ref$ObjectRef<CoroutineContext> ref$ObjectRef = this.$leftoverContext;
        ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).minusKey(aVar.getKey());
        return coroutineContext.plus(((b0) aVar).g(aVar2));
    }
}
