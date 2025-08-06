package jumio.core;

import d10.a;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.jumio.core.Controller$runOnMain$1", f = "Controller.kt", l = {}, m = "invokeSuspend")
public final class z extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a<Unit> f56349a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(a<Unit> aVar, c<? super z> cVar) {
        super(2, cVar);
        this.f56349a = aVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new z(this.f56349a, cVar);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((z) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        this.f56349a.invoke();
        return Unit.f56620a;
    }
}
