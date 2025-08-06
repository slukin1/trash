package kotlin.coroutines.intrinsics;

import d10.l;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.k;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1 extends RestrictedContinuationImpl {
    public final /* synthetic */ l<c<Object>, Object> $block;
    private int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1(c<Object> cVar, l<? super c<Object>, ? extends Object> lVar) {
        super(cVar);
        this.$block = lVar;
    }

    public Object invokeSuspend(Object obj) {
        int i11 = this.label;
        if (i11 == 0) {
            this.label = 1;
            k.b(obj);
            return this.$block.invoke(this);
        } else if (i11 == 1) {
            this.label = 2;
            k.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
