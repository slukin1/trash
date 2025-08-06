package kotlinx.coroutines.selects;

import d10.l;
import d10.p;
import kotlin.coroutines.c;

public interface b<R> {
    void a(d dVar, l<? super c<? super R>, ? extends Object> lVar);

    <Q> void c(f<? extends Q> fVar, p<? super Q, ? super c<? super R>, ? extends Object> pVar);
}
