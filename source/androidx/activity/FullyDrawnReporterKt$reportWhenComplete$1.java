package androidx.activity;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
public final class FullyDrawnReporterKt$reportWhenComplete$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FullyDrawnReporterKt$reportWhenComplete$1(c<? super FullyDrawnReporterKt$reportWhenComplete$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.a((FullyDrawnReporter) null, (l<? super c<? super Unit>, ? extends Object>) null, this);
    }
}
