package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.c;

public interface f1<T> extends d<T> {
    List<T> a();

    Object collect(e<? super T> eVar, c<?> cVar);
}
