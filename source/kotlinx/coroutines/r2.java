package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.internal.j;

public final class r2 {
    public static final Object a(c<? super Unit> cVar) {
        Object obj;
        CoroutineContext context = cVar.getContext();
        p1.i(context);
        c c11 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        i iVar = c11 instanceof i ? (i) c11 : null;
        if (iVar == null) {
            obj = Unit.f56620a;
        } else {
            if (iVar.f57310e.B(context)) {
                iVar.n(context, Unit.f56620a);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext plus = context.plus(yieldContext);
                Unit unit = Unit.f56620a;
                iVar.n(plus, unit);
                if (yieldContext.f56975b) {
                    obj = j.d(iVar) ? IntrinsicsKt__IntrinsicsKt.d() : unit;
                }
            }
            obj = IntrinsicsKt__IntrinsicsKt.d();
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return obj == IntrinsicsKt__IntrinsicsKt.d() ? obj : Unit.f56620a;
    }
}
