package kotlin.coroutines.intrinsics;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.k;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 extends ContinuationImpl {
    public final /* synthetic */ Object $receiver$inlined;
    public final /* synthetic */ p $this_createCoroutineUnintercepted$inlined;
    private int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(c cVar, CoroutineContext coroutineContext, p pVar, Object obj) {
        super(cVar, coroutineContext);
        this.$this_createCoroutineUnintercepted$inlined = pVar;
        this.$receiver$inlined = obj;
    }

    public Object invokeSuspend(Object obj) {
        int i11 = this.label;
        if (i11 == 0) {
            this.label = 1;
            k.b(obj);
            return ((p) TypeIntrinsics.e(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
        } else if (i11 == 1) {
            this.label = 2;
            k.b(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
