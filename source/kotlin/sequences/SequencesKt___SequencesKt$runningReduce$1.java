package kotlin.sequences;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", l = {2348, 2351}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningReduce$1 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ p<Object, Object, Object> $operation;
    public final /* synthetic */ g<Object> $this_runningReduce;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduce$1(g<Object> gVar, p<Object, Object, Object> pVar, c<? super SequencesKt___SequencesKt$runningReduce$1> cVar) {
        super(2, cVar);
        this.$this_runningReduce = gVar;
        this.$operation = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, cVar);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt___SequencesKt$runningReduce$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r3) goto L_0x000e
            if (r1 != r2) goto L_0x001c
        L_0x000e:
            java.lang.Object r1 = r7.L$2
            java.lang.Object r3 = r7.L$1
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.k.b(r8)
            goto L_0x004c
        L_0x001c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0024:
            kotlin.k.b(r8)
            java.lang.Object r8 = r7.L$0
            r4 = r8
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.sequences.g<java.lang.Object> r8 = r7.$this_runningReduce
            java.util.Iterator r8 = r8.iterator()
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r8.next()
            r7.L$0 = r4
            r7.L$1 = r8
            r7.L$2 = r1
            r7.label = r3
            java.lang.Object r3 = r4.b(r1, r7)
            if (r3 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r3 = r8
        L_0x004c:
            r8 = r7
        L_0x004d:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x006c
            d10.p<java.lang.Object, java.lang.Object, java.lang.Object> r5 = r8.$operation
            java.lang.Object r6 = r3.next()
            java.lang.Object r1 = r5.invoke(r1, r6)
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.b(r1, r8)
            if (r5 != r0) goto L_0x004d
            return r0
        L_0x006c:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
