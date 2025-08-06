package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.j0;

public final class m<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i11, r rVar) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e11) {
        if (j0.a() && !(!(e11 instanceof List))) {
            throw new AssertionError();
        } else if (obj == null) {
            return a(e11);
        } else {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(e11);
                return a(obj);
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(e11);
            return a(arrayList);
        }
    }
}
