package kotlinx.coroutines;

import d10.l;
import kotlin.Unit;
import kotlin.coroutines.c;

public interface k<T> extends c<T> {

    public static final class a {
        public static /* synthetic */ boolean a(k kVar, Throwable th2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    th2 = null;
                }
                return kVar.m(th2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }

    Object B(Throwable th2);

    Object D(T t11, Object obj, l<? super Throwable, Unit> lVar);

    void I(CoroutineDispatcher coroutineDispatcher, T t11);

    boolean a();

    void c(CoroutineDispatcher coroutineDispatcher, Throwable th2);

    void h(T t11, l<? super Throwable, Unit> lVar);

    boolean isActive();

    boolean m(Throwable th2);

    void w(Object obj);

    void x(l<? super Throwable, Unit> lVar);
}
