package kotlinx.coroutines;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.sequences.SequenceScope;

@d(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {956, 958}, m = "invokeSuspend")
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super n1>, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ JobSupport this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, c<? super JobSupport$children$1> cVar) {
        super(2, cVar);
        this.this$0 = jobSupport;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, cVar);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    public final Object invoke(SequenceScope<? super n1> sequenceScope, c<? super Unit> cVar) {
        return ((JobSupport$children$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r7.L$1
            kotlinx.coroutines.internal.LockFreeLinkedListHead r3 = (kotlinx.coroutines.internal.LockFreeLinkedListHead) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.k.b(r8)
            r8 = r7
            goto L_0x007e
        L_0x001f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0027:
            kotlin.k.b(r8)
            goto L_0x0083
        L_0x002b:
            kotlin.k.b(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
            kotlinx.coroutines.JobSupport r1 = r7.this$0
            java.lang.Object r1 = r1.s0()
            boolean r4 = r1 instanceof kotlinx.coroutines.r
            if (r4 == 0) goto L_0x0049
            kotlinx.coroutines.r r1 = (kotlinx.coroutines.r) r1
            kotlinx.coroutines.s r1 = r1.f57390f
            r7.label = r3
            java.lang.Object r8 = r8.b(r1, r7)
            if (r8 != r0) goto L_0x0083
            return r0
        L_0x0049:
            boolean r3 = r1 instanceof kotlinx.coroutines.i1
            if (r3 == 0) goto L_0x0083
            kotlinx.coroutines.i1 r1 = (kotlinx.coroutines.i1) r1
            kotlinx.coroutines.NodeList r1 = r1.a()
            if (r1 == 0) goto L_0x0083
            java.lang.Object r3 = r1.i()
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L_0x0060:
            boolean r5 = kotlin.jvm.internal.x.b(r1, r3)
            if (r5 != 0) goto L_0x0083
            boolean r5 = r1 instanceof kotlinx.coroutines.r
            if (r5 == 0) goto L_0x007e
            r5 = r1
            kotlinx.coroutines.r r5 = (kotlinx.coroutines.r) r5
            kotlinx.coroutines.s r5 = r5.f57390f
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.b(r5, r8)
            if (r5 != r0) goto L_0x007e
            return r0
        L_0x007e:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.j()
            goto L_0x0060
        L_0x0083:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
