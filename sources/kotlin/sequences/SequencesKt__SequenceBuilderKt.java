package kotlin.sequences;

import d10.p;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.c;

class SequencesKt__SequenceBuilderKt {

    public static final class a implements g<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p f56866a;

        public a(p pVar) {
            this.f56866a = pVar;
        }

        public Iterator<T> iterator() {
            return SequencesKt__SequenceBuilderKt.a(this.f56866a);
        }
    }

    public static <T> Iterator<T> a(p<? super SequenceScope<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.j(IntrinsicsKt__IntrinsicsJvmKt.b(pVar, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    public static <T> g<T> b(p<? super SequenceScope<? super T>, ? super c<? super Unit>, ? extends Object> pVar) {
        return new a(pVar);
    }
}
