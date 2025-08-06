package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.c;

public interface a1<T> extends f1<T>, e<T> {
    void b();

    boolean d(T t11);

    j1<Integer> e();

    Object emit(T t11, c<? super Unit> cVar);
}
