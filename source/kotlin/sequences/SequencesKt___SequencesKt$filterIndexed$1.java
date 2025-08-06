package kotlin.sequences;

import d10.l;
import d10.p;
import kotlin.collections.m;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$filterIndexed$1 extends Lambda implements l<m<Object>, Boolean> {
    public final /* synthetic */ p<Integer, Object, Boolean> $predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$filterIndexed$1(p<? super Integer, Object, Boolean> pVar) {
        super(1);
        this.$predicate = pVar;
    }

    public final Boolean invoke(m<Object> mVar) {
        return this.$predicate.invoke(Integer.valueOf(mVar.c()), mVar.d());
    }
}
