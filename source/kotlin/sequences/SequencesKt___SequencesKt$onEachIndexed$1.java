package kotlin.sequences;

import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class SequencesKt___SequencesKt$onEachIndexed$1 extends Lambda implements p<Integer, Object, Object> {
    public final /* synthetic */ p<Integer, Object, Unit> $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequencesKt___SequencesKt$onEachIndexed$1(p<? super Integer, Object, Unit> pVar) {
        super(2);
        this.$action = pVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), obj2);
    }

    public final Object invoke(int i11, Object obj) {
        this.$action.invoke(Integer.valueOf(i11), obj);
        return obj;
    }
}
