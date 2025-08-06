package kotlinx.coroutines.selects;

import d10.l;
import kotlin.coroutines.c;
import kotlinx.coroutines.DelayKt;

public final class a {
    public static final <R> void a(b<? super R> bVar, long j11, l<? super c<? super R>, ? extends Object> lVar) {
        bVar.a(new OnTimeout(j11).b(), lVar);
    }

    public static final <R> void b(b<? super R> bVar, long j11, l<? super c<? super R>, ? extends Object> lVar) {
        a(bVar, DelayKt.d(j11), lVar);
    }
}
