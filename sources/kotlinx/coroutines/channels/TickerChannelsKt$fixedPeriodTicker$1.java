package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", l = {84, 88, 94, 96}, m = "fixedPeriodTicker")
public final class TickerChannelsKt$fixedPeriodTicker$1 extends ContinuationImpl {
    public long J$0;
    public long J$1;
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public TickerChannelsKt$fixedPeriodTicker$1(c<? super TickerChannelsKt$fixedPeriodTicker$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TickerChannelsKt.d(0, 0, (m<? super Unit>) null, this);
    }
}
