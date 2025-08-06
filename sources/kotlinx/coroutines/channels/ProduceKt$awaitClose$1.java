package kotlinx.coroutines.channels;

import d10.a;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
public final class ProduceKt$awaitClose$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;

    public ProduceKt$awaitClose$1(c<? super ProduceKt$awaitClose$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ProduceKt.a((k<?>) null, (a<Unit>) null, this);
    }
}
