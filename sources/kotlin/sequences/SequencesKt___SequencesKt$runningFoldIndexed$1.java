package kotlin.sequences;

import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", l = {2318, 2323}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$runningFoldIndexed$1 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ Object $initial;
    public final /* synthetic */ q<Integer, Object, Object, Object> $operation;
    public final /* synthetic */ g<Object> $this_runningFoldIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(Object obj, g<Object> gVar, q<? super Integer, Object, Object, Object> qVar, c<? super SequencesKt___SequencesKt$runningFoldIndexed$1> cVar) {
        super(2, cVar);
        this.$initial = obj;
        this.$this_runningFoldIndexed = gVar;
        this.$operation = qVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, cVar);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: kotlin.sequences.SequenceScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0030
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r9.I$0
            java.lang.Object r3 = r9.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r9.L$1
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.k.b(r10)
            r10 = r1
            r1 = r4
            goto L_0x0051
        L_0x0020:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0028:
            java.lang.Object r1 = r9.L$0
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.k.b(r10)
            goto L_0x0045
        L_0x0030:
            kotlin.k.b(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            java.lang.Object r10 = r9.$initial
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = r1.b(r10, r9)
            if (r10 != r0) goto L_0x0045
            return r0
        L_0x0045:
            r10 = 0
            java.lang.Object r3 = r9.$initial
            kotlin.sequences.g<java.lang.Object> r4 = r9.$this_runningFoldIndexed
            java.util.Iterator r4 = r4.iterator()
            r5 = r1
            r1 = r3
            r3 = r4
        L_0x0051:
            r4 = r9
        L_0x0052:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0081
            java.lang.Object r6 = r3.next()
            d10.q<java.lang.Integer, java.lang.Object, java.lang.Object, java.lang.Object> r7 = r4.$operation
            int r8 = r10 + 1
            if (r10 >= 0) goto L_0x0065
            kotlin.collections.CollectionsKt__CollectionsKt.t()
        L_0x0065:
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.a.c(r10)
            java.lang.Object r10 = r7.invoke(r10, r1, r6)
            r4.L$0 = r5
            r4.L$1 = r10
            r4.L$2 = r3
            r4.I$0 = r8
            r4.label = r2
            java.lang.Object r1 = r5.b(r10, r4)
            if (r1 != r0) goto L_0x007e
            return r0
        L_0x007e:
            r1 = r10
            r10 = r8
            goto L_0x0052
        L_0x0081:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
