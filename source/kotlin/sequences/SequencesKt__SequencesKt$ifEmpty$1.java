package kotlin.sequences;

import d10.a;
import d10.p;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", l = {69, 71}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ a<g<Object>> $defaultValue;
    public final /* synthetic */ g<Object> $this_ifEmpty;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$ifEmpty$1(g<Object> gVar, a<? extends g<Object>> aVar, c<? super SequencesKt__SequencesKt$ifEmpty$1> cVar) {
        super(2, cVar);
        this.$this_ifEmpty = gVar;
        this.$defaultValue = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, cVar);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Iterator<Object> it2 = this.$this_ifEmpty.iterator();
            if (it2.hasNext()) {
                this.label = 1;
                if (sequenceScope.d(it2, this) == d11) {
                    return d11;
                }
            } else {
                this.label = 2;
                if (sequenceScope.f(this.$defaultValue.invoke(), this) == d11) {
                    return d11;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
