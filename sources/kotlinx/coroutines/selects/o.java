package kotlinx.coroutines.selects;

import d10.l;
import d10.p;
import java.util.Collections;
import java.util.List;
import kotlin.coroutines.c;
import kotlinx.coroutines.selects.SelectImplementation;

public class o<R> extends SelectImplementation<R> {

    /* renamed from: h  reason: collision with root package name */
    public final List<SelectImplementation<R>.a> f57538h;

    public final void G() {
        try {
            Collections.shuffle(this.f57538h);
            for (SelectImplementation.a A : this.f57538h) {
                SelectImplementation.A(this, A, false, 1, (Object) null);
            }
        } finally {
            this.f57538h.clear();
        }
    }

    public void a(d dVar, l<? super c<? super R>, ? extends Object> lVar) {
        this.f57538h.add(new SelectImplementation.a(dVar.d(), dVar.c(), dVar.b(), SelectKt.i(), lVar, dVar.a()));
    }

    public <Q> void c(f<? extends Q> fVar, p<? super Q, ? super c<? super R>, ? extends Object> pVar) {
        this.f57538h.add(new SelectImplementation.a(fVar.d(), fVar.c(), fVar.b(), (Object) null, pVar, fVar.a()));
    }

    public Object r(c<? super R> cVar) {
        return G();
    }
}
