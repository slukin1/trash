package kotlinx.coroutines.flow;

import d10.q;
import d10.r;
import d10.s;
import d10.t;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.internal.CombineKt;

public final /* synthetic */ class FlowKt__ZipKt {

    public static final class a implements d<R> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f57185b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f57186c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ q f57187d;

        public a(d dVar, d dVar2, q qVar) {
            this.f57185b = dVar;
            this.f57186c = dVar2;
            this.f57187d = qVar;
        }

        public Object collect(e<? super R> eVar, c<? super Unit> cVar) {
            Object a11 = CombineKt.a(eVar, new d[]{this.f57185b, this.f57186c}, FlowKt__ZipKt.h(), new FlowKt__ZipKt$combine$1$1(this.f57187d, (c<? super FlowKt__ZipKt$combine$1$1>) null), cVar);
            if (a11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return a11;
            }
            return Unit.f56620a;
        }
    }

    public static final <T1, T2, R> d<R> b(d<? extends T1> dVar, d<? extends T2> dVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return f.G(dVar, dVar2, qVar);
    }

    public static final <T1, T2, T3, R> d<R> c(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, r<? super T1, ? super T2, ? super T3, ? super c<? super R>, ? extends Object> rVar) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1(new d[]{dVar, dVar2, dVar3}, rVar);
    }

    public static final <T1, T2, T3, T4, R> d<R> d(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, s<? super T1, ? super T2, ? super T3, ? super T4, ? super c<? super R>, ? extends Object> sVar) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2(new d[]{dVar, dVar2, dVar3, dVar4}, sVar);
    }

    public static final <T1, T2, T3, T4, T5, R> d<R> e(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, d<? extends T4> dVar4, d<? extends T5> dVar5, t<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super c<? super R>, ? extends Object> tVar) {
        return new FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3(new d[]{dVar, dVar2, dVar3, dVar4, dVar5}, tVar);
    }

    public static final <T1, T2, T3, R> d<R> f(d<? extends T1> dVar, d<? extends T2> dVar2, d<? extends T3> dVar3, s<? super e<? super R>, ? super T1, ? super T2, ? super T3, ? super c<? super Unit>, ? extends Object> sVar) {
        return f.F(new FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$3(new d[]{dVar, dVar2, dVar3}, (c) null, sVar));
    }

    public static final <T1, T2, R> d<R> g(d<? extends T1> dVar, d<? extends T2> dVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return new a(dVar, dVar2, qVar);
    }

    public static final <T> d10.a<T[]> h() {
        return FlowKt__ZipKt$nullArrayFactory$1.INSTANCE;
    }
}
