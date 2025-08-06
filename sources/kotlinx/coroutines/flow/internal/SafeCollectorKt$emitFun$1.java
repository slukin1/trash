package kotlinx.coroutines.flow.internal;

import d10.q;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.flow.e;

public /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements q<e<? super Object>, Object, c<? super Unit>, Object> {
    public static final SafeCollectorKt$emitFun$1 INSTANCE = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(e<Object> eVar, Object obj, c<? super Unit> cVar) {
        return eVar.emit(obj, cVar);
    }
}
