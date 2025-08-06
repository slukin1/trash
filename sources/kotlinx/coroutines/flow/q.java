package kotlinx.coroutines.flow;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;

public final /* synthetic */ class q {

    public static final class a implements d<T> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f57274b;

        public a(Object obj) {
            this.f57274b = obj;
        }

        public Object collect(e<? super T> eVar, c<? super Unit> cVar) {
            Object emit = eVar.emit(this.f57274b, cVar);
            if (emit == IntrinsicsKt__IntrinsicsKt.d()) {
                return emit;
            }
            return Unit.f56620a;
        }
    }

    public static final <T> d<T> a(p<? super k<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return new CallbackFlowBuilder(pVar, (CoroutineContext) null, 0, (BufferOverflow) null, 14, (r) null);
    }

    public static final <T> d<T> b(p<? super e<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return new e1(pVar);
    }

    public static final <T> d<T> c(T t11) {
        return new a(t11);
    }
}
