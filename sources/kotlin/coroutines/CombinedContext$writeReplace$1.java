package kotlin.coroutines;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;

public final class CombinedContext$writeReplace$1 extends Lambda implements p<Unit, CoroutineContext.a, Unit> {
    public final /* synthetic */ CoroutineContext[] $elements;
    public final /* synthetic */ Ref$IntRef $index;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombinedContext$writeReplace$1(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef) {
        super(2);
        this.$elements = coroutineContextArr;
        this.$index = ref$IntRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Unit) obj, (CoroutineContext.a) obj2);
        return Unit.f56620a;
    }

    public final void invoke(Unit unit, CoroutineContext.a aVar) {
        CoroutineContext[] coroutineContextArr = this.$elements;
        Ref$IntRef ref$IntRef = this.$index;
        int i11 = ref$IntRef.element;
        ref$IntRef.element = i11 + 1;
        coroutineContextArr[i11] = aVar;
    }
}
