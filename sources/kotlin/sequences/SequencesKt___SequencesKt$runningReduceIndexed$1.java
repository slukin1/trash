package kotlin.sequences;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", l = {2377, 2381}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningReduceIndexed$1 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ q<Integer, Object, Object, Object> $operation;
    public final /* synthetic */ g<Object> $this_runningReduceIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(g<Object> gVar, q<? super Integer, Object, Object, Object> qVar, c<? super SequencesKt___SequencesKt$runningReduceIndexed$1> cVar) {
        super(2, cVar);
        this.$this_runningReduceIndexed = gVar;
        this.$operation = qVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, cVar);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r3) goto L_0x002a
            if (r1 != r2) goto L_0x0022
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.k.b(r11)
            r11 = r10
            r9 = r3
            r3 = r1
            r1 = r9
            goto L_0x0060
        L_0x0022:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002a:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.k.b(r11)
            goto L_0x005f
        L_0x0038:
            kotlin.k.b(r11)
            java.lang.Object r11 = r10.L$0
            r5 = r11
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.sequences.g<java.lang.Object> r11 = r10.$this_runningReduceIndexed
            java.util.Iterator r4 = r11.iterator()
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x008f
            java.lang.Object r1 = r4.next()
            r10.L$0 = r5
            r10.L$1 = r4
            r10.L$2 = r1
            r10.label = r3
            java.lang.Object r11 = r5.b(r1, r10)
            if (r11 != r0) goto L_0x005f
            return r0
        L_0x005f:
            r11 = r10
        L_0x0060:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x008f
            d10.q<java.lang.Integer, java.lang.Object, java.lang.Object, java.lang.Object> r6 = r11.$operation
            int r7 = r3 + 1
            if (r3 >= 0) goto L_0x006f
            kotlin.collections.CollectionsKt__CollectionsKt.t()
        L_0x006f:
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.a.c(r3)
            java.lang.Object r8 = r4.next()
            java.lang.Object r3 = r6.invoke(r3, r1, r8)
            r11.L$0 = r5
            r11.L$1 = r4
            r11.L$2 = r3
            r11.I$0 = r7
            r11.label = r2
            java.lang.Object r1 = r5.b(r3, r11)
            if (r1 != r0) goto L_0x008c
            return r0
        L_0x008c:
            r1 = r3
            r3 = r7
            goto L_0x0060
        L_0x008f:
            kotlin.Unit r11 = kotlin.Unit.f56620a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
