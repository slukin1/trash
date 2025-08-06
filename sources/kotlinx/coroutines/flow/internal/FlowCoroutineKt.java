package kotlinx.coroutines.flow.internal;

import d10.p;
import d10.q;
import f10.b;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.h0;

public final class FlowCoroutineKt {

    public static final class a implements d<R> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f57254b;

        public a(q qVar) {
            this.f57254b = qVar;
        }

        public Object collect(e<? super R> eVar, c<? super Unit> cVar) {
            Object a11 = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(this.f57254b, eVar, (c<? super FlowCoroutineKt$scopedFlow$1$1>) null), cVar);
            if (a11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return a11;
            }
            return Unit.f56620a;
        }
    }

    public static final <R> Object a(p<? super h0, ? super c<? super R>, ? extends Object> pVar, c<? super R> cVar) {
        f fVar = new f(cVar.getContext(), cVar);
        Object c11 = b.c(fVar, fVar, pVar);
        if (c11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return c11;
    }

    public static final <R> d<R> b(q<? super h0, ? super e<? super R>, ? super c<? super Unit>, ? extends Object> qVar) {
        return new a(qVar);
    }
}
