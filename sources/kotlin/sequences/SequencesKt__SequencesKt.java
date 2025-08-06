package kotlin.sequences;

import d10.l;
import java.util.Iterator;

class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {

    public static final class a implements g<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Iterator f56867a;

        public a(Iterator it2) {
            this.f56867a = it2;
        }

        public Iterator<T> iterator() {
            return this.f56867a;
        }
    }

    public static <T> g<T> c(Iterator<? extends T> it2) {
        return d(new a(it2));
    }

    public static final <T> g<T> d(g<? extends T> gVar) {
        return gVar instanceof a ? gVar : new a(gVar);
    }

    public static <T> g<T> e() {
        return d.f56874a;
    }

    public static <T> g<T> f(d10.a<? extends T> aVar, l<? super T, ? extends T> lVar) {
        return new f(aVar, lVar);
    }

    public static <T> g<T> g(T t11, l<? super T, ? extends T> lVar) {
        if (t11 == null) {
            return d.f56874a;
        }
        return new f(new SequencesKt__SequencesKt$generateSequence$2(t11), lVar);
    }
}
