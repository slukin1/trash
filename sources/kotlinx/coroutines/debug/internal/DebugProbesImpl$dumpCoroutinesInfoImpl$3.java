package kotlinx.coroutines.debug.internal;

import d10.l;
import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

public final class DebugProbesImpl$dumpCoroutinesInfoImpl$3 extends Lambda implements l<c.a<?>, Object> {
    public final /* synthetic */ p<c.a<?>, CoroutineContext, Object> $create;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$3(p<? super c.a<?>, ? super CoroutineContext, Object> pVar) {
        super(1);
        this.$create = pVar;
    }

    public final Object invoke(c.a<?> aVar) {
        CoroutineContext c11;
        if (!c.f57098a.e(aVar) && (c11 = aVar.f57110c.c()) != null) {
            return this.$create.invoke(aVar, c11);
        }
        return null;
    }
}
