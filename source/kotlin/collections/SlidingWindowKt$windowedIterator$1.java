package kotlin.collections;

import d10.p;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.sequences.SequenceScope;

@d(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements p<SequenceScope<? super List<? extends T>>, c<? super Unit>, Object> {
    public final /* synthetic */ Iterator<T> $iterator;
    public final /* synthetic */ boolean $partialWindows;
    public final /* synthetic */ boolean $reuseBuffer;
    public final /* synthetic */ int $size;
    public final /* synthetic */ int $step;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int i11, int i12, Iterator<? extends T> it2, boolean z11, boolean z12, c<? super SlidingWindowKt$windowedIterator$1> cVar) {
        super(2, cVar);
        this.$size = i11;
        this.$step = i12;
        this.$iterator = it2;
        this.$reuseBuffer = z11;
        this.$partialWindows = z12;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, cVar);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, c<? super Unit> cVar) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0125 A[SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r12.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x005a
            if (r1 == r6) goto L_0x0046
            if (r1 == r5) goto L_0x0041
            if (r1 == r4) goto L_0x002f
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            goto L_0x0041
        L_0x0019:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0021:
            java.lang.Object r1 = r12.L$1
            kotlin.collections.s r1 = (kotlin.collections.s) r1
            java.lang.Object r4 = r12.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.k.b(r13)
            r13 = r12
            goto L_0x014d
        L_0x002f:
            java.lang.Object r1 = r12.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r12.L$1
            kotlin.collections.s r5 = (kotlin.collections.s) r5
            java.lang.Object r8 = r12.L$0
            kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
            kotlin.k.b(r13)
            r13 = r12
            goto L_0x011f
        L_0x0041:
            kotlin.k.b(r13)
            goto L_0x0169
        L_0x0046:
            int r1 = r12.I$0
            java.lang.Object r2 = r12.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r12.L$1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.lang.Object r4 = r12.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.k.b(r13)
            r13 = r12
            r8 = r1
            goto L_0x00a8
        L_0x005a:
            kotlin.k.b(r13)
            java.lang.Object r13 = r12.L$0
            kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
            int r1 = r12.$size
            r8 = 1024(0x400, float:1.435E-42)
            int r1 = kotlin.ranges.RangesKt___RangesKt.g(r1, r8)
            int r8 = r12.$step
            int r9 = r12.$size
            int r8 = r8 - r9
            if (r8 < 0) goto L_0x00dc
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            r1 = 0
            java.util.Iterator<T> r3 = r12.$iterator
            r4 = r13
            r13 = r12
            r11 = r3
            r3 = r2
            r2 = r11
        L_0x007d:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x00ba
            java.lang.Object r9 = r2.next()
            if (r1 <= 0) goto L_0x008c
            int r1 = r1 + -1
            goto L_0x007d
        L_0x008c:
            r3.add(r9)
            int r9 = r3.size()
            int r10 = r13.$size
            if (r9 != r10) goto L_0x007d
            r13.L$0 = r4
            r13.L$1 = r3
            r13.L$2 = r2
            r13.I$0 = r8
            r13.label = r6
            java.lang.Object r1 = r4.b(r3, r13)
            if (r1 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            boolean r1 = r13.$reuseBuffer
            if (r1 == 0) goto L_0x00b0
            r3.clear()
            goto L_0x00b8
        L_0x00b0:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r13.$size
            r1.<init>(r3)
            r3 = r1
        L_0x00b8:
            r1 = r8
            goto L_0x007d
        L_0x00ba:
            boolean r1 = r3.isEmpty()
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x0169
            boolean r1 = r13.$partialWindows
            if (r1 != 0) goto L_0x00cd
            int r1 = r3.size()
            int r2 = r13.$size
            if (r1 != r2) goto L_0x0169
        L_0x00cd:
            r13.L$0 = r7
            r13.L$1 = r7
            r13.L$2 = r7
            r13.label = r5
            java.lang.Object r13 = r4.b(r3, r13)
            if (r13 != r0) goto L_0x0169
            return r0
        L_0x00dc:
            kotlin.collections.s r5 = new kotlin.collections.s
            r5.<init>(r1)
            java.util.Iterator<T> r1 = r12.$iterator
            r8 = r13
            r13 = r12
        L_0x00e5:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0125
            java.lang.Object r9 = r1.next()
            r5.d(r9)
            boolean r9 = r5.h()
            if (r9 == 0) goto L_0x00e5
            int r9 = r5.size()
            int r10 = r13.$size
            if (r9 >= r10) goto L_0x0105
            kotlin.collections.s r5 = r5.g(r10)
            goto L_0x00e5
        L_0x0105:
            boolean r9 = r13.$reuseBuffer
            if (r9 == 0) goto L_0x010b
            r9 = r5
            goto L_0x0110
        L_0x010b:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>(r5)
        L_0x0110:
            r13.L$0 = r8
            r13.L$1 = r5
            r13.L$2 = r1
            r13.label = r4
            java.lang.Object r9 = r8.b(r9, r13)
            if (r9 != r0) goto L_0x011f
            return r0
        L_0x011f:
            int r9 = r13.$step
            r5.i(r9)
            goto L_0x00e5
        L_0x0125:
            boolean r1 = r13.$partialWindows
            if (r1 == 0) goto L_0x0169
            r1 = r5
            r4 = r8
        L_0x012b:
            int r5 = r1.size()
            int r8 = r13.$step
            if (r5 <= r8) goto L_0x0153
            boolean r5 = r13.$reuseBuffer
            if (r5 == 0) goto L_0x0139
            r5 = r1
            goto L_0x013e
        L_0x0139:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r1)
        L_0x013e:
            r13.L$0 = r4
            r13.L$1 = r1
            r13.L$2 = r7
            r13.label = r3
            java.lang.Object r5 = r4.b(r5, r13)
            if (r5 != r0) goto L_0x014d
            return r0
        L_0x014d:
            int r5 = r13.$step
            r1.i(r5)
            goto L_0x012b
        L_0x0153:
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x0169
            r13.L$0 = r7
            r13.L$1 = r7
            r13.L$2 = r7
            r13.label = r2
            java.lang.Object r13 = r4.b(r1, r13)
            if (r13 != r0) goto L_0x0169
            return r0
        L_0x0169:
            kotlin.Unit r13 = kotlin.Unit.f56620a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
