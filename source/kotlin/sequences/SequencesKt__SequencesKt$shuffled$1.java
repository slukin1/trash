package kotlin.sequences;

import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlin.random.Random;

@d(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", l = {145}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ Random $random;
    public final /* synthetic */ g<Object> $this_shuffled;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$shuffled$1(g<Object> gVar, Random random, c<? super SequencesKt__SequencesKt$shuffled$1> cVar) {
        super(2, cVar);
        this.$this_shuffled = gVar;
        this.$random = random;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, cVar);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt__SequencesKt$shuffled$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        List list;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            list = SequencesKt___SequencesKt.x(this.$this_shuffled);
            sequenceScope = (SequenceScope) this.L$0;
        } else if (i11 == 1) {
            list = (List) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!list.isEmpty()) {
            int nextInt = this.$random.nextInt(list.size());
            Object H = CollectionsKt__MutableCollectionsKt.H(list);
            if (nextInt < list.size()) {
                H = list.set(nextInt, H);
            }
            this.L$0 = sequenceScope;
            this.L$1 = list;
            this.label = 1;
            if (sequenceScope.b(H, this) == d11) {
                return d11;
            }
        }
        return Unit.f56620a;
    }
}
