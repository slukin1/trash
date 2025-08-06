package kotlin.sequences;

import d10.p;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", l = {2855}, m = "invokeSuspend")
final class SequencesKt___SequencesKt$zipWithNext$2 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ g<Object> $this_zipWithNext;
    public final /* synthetic */ p<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$zipWithNext$2(g<Object> gVar, p<Object, Object, Object> pVar, c<? super SequencesKt___SequencesKt$zipWithNext$2> cVar) {
        super(2, cVar);
        this.$this_zipWithNext = gVar;
        this.$transform = pVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, cVar);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        SequenceScope sequenceScope;
        Iterator<Object> it2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            Iterator<Object> it3 = this.$this_zipWithNext.iterator();
            if (!it3.hasNext()) {
                return Unit.f56620a;
            }
            sequenceScope = sequenceScope2;
            obj2 = it3.next();
            it2 = it3;
        } else if (i11 == 1) {
            Object obj3 = this.L$2;
            it2 = (Iterator) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            k.b(obj);
            obj2 = obj3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it2.hasNext()) {
            Object next = it2.next();
            Object invoke = this.$transform.invoke(obj2, next);
            this.L$0 = sequenceScope;
            this.L$1 = it2;
            this.L$2 = next;
            this.label = 1;
            if (sequenceScope.b(invoke, this) == d11) {
                return d11;
            }
            obj2 = next;
        }
        return Unit.f56620a;
    }
}
