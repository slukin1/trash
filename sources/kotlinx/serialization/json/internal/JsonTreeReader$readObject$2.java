package kotlinx.serialization.json.internal;

import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.serialization.json.g;

@d(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {23}, m = "readObject")
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ JsonTreeReader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, c<? super JsonTreeReader$readObject$2> cVar) {
        super(cVar);
        this.this$0 = jsonTreeReader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h((kotlin.c<Unit, g>) null, this);
    }
}
