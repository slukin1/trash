package oupson.apng;

import java.net.URL;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import oupson.apng.Loader;

@d(c = "oupson.apng.Loader$Companion", f = "Loader.kt", l = {23}, m = "load")
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"Ljava/net/URL;", "url", "Lkotlin/coroutines/c;", "", "continuation", "", "load"}, k = 3, mv = {1, 4, 2})
public final class Loader$Companion$load$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ Loader.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Loader$Companion$load$1(Loader.Companion companion, c cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((URL) null, this);
    }
}
