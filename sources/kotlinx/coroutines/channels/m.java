package kotlinx.coroutines.channels;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.selects.h;

public interface m<E> {

    public static final class a {
        public static /* synthetic */ boolean a(m mVar, Throwable th2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    th2 = null;
                }
                return mVar.K(th2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    void H(l<? super Throwable, Unit> lVar);

    boolean K(Throwable th2);

    h<E, m<E>> d();

    Object q(E e11);

    Object send(E e11, c<? super Unit> cVar);

    boolean u();
}
