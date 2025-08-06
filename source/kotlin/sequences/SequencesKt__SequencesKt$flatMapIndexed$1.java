package kotlin.sequences;

import d10.l;
import d10.p;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", l = {332}, m = "invokeSuspend")
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements p<SequenceScope<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ l<Object, Iterator<Object>> $iterator;
    public final /* synthetic */ g<Object> $source;
    public final /* synthetic */ p<Integer, Object, Object> $transform;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt__SequencesKt$flatMapIndexed$1(g<Object> gVar, p<? super Integer, Object, Object> pVar, l<Object, ? extends Iterator<Object>> lVar, c<? super SequencesKt__SequencesKt$flatMapIndexed$1> cVar) {
        super(2, cVar);
        this.$source = gVar;
        this.$transform = pVar;
        this.$iterator = lVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, cVar);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    public final Object invoke(SequenceScope<Object> sequenceScope, c<? super Unit> cVar) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) create(sequenceScope, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Iterator<Object> it2;
        int i11;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i12 = this.label;
        if (i12 == 0) {
            k.b(obj);
            i11 = 0;
            it2 = this.$source.iterator();
            sequenceScope = (SequenceScope) this.L$0;
        } else if (i12 == 1) {
            i11 = this.I$0;
            it2 = (Iterator) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it2.hasNext()) {
            Object next = it2.next();
            p<Integer, Object, Object> pVar = this.$transform;
            int i13 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            Object invoke = pVar.invoke(a.c(i11), next);
            this.L$0 = sequenceScope;
            this.L$1 = it2;
            this.I$0 = i13;
            this.label = 1;
            if (sequenceScope.d(this.$iterator.invoke(invoke), this) == d11) {
                return d11;
            }
            i11 = i13;
        }
        return Unit.f56620a;
    }
}
