package kotlinx.coroutines.selects;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", l = {41}, m = "whileSelect")
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public WhileSelectKt$whileSelect$1(c<? super WhileSelectKt$whileSelect$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.a((l<? super b<? super Boolean>, Unit>) null, this);
    }
}
