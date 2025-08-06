package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlinx.coroutines.internal.i;

public final class n {
    public static final void a(k<?> kVar, x0 x0Var) {
        kVar.x(new y0(x0Var));
    }

    public static final <T> l<T> b(c<? super T> cVar) {
        if (!(cVar instanceof i)) {
            return new l<>(cVar, 1);
        }
        l<T> l11 = ((i) cVar).l();
        if (l11 != null) {
            if (!l11.M()) {
                l11 = null;
            }
            if (l11 != null) {
                return l11;
            }
        }
        return new l<>(cVar, 2);
    }
}
