package kotlinx.coroutines.rx3;

import d10.l;
import h00.j;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.rx3.RxChannelKt", f = "RxChannel.kt", l = {99}, m = "collect")
public final class RxChannelKt$collect$2<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public RxChannelKt$collect$2(c<? super RxChannelKt$collect$2> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return RxChannelKt.b((j) null, (l) null, this);
    }
}
