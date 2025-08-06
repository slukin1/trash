package androidx.lifecycle;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;

@d(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {81}, m = "invokeSuspend")
final class FlowLiveDataConversions$asLiveData$1 extends SuspendLambda implements p<y<Object>, c<? super Unit>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.d<Object> $this_asLiveData;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a<T> implements e {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y<T> f9892b;

        public a(y<T> yVar) {
            this.f9892b = yVar;
        }

        public final Object emit(T t11, c<? super Unit> cVar) {
            Object emit = this.f9892b.emit(t11, cVar);
            return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asLiveData$1(kotlinx.coroutines.flow.d<Object> dVar, c<? super FlowLiveDataConversions$asLiveData$1> cVar) {
        super(2, cVar);
        this.$this_asLiveData = dVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, cVar);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    public final Object invoke(y<Object> yVar, c<? super Unit> cVar) {
        return ((FlowLiveDataConversions$asLiveData$1) create(yVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            kotlinx.coroutines.flow.d<Object> dVar = this.$this_asLiveData;
            a aVar = new a((y) this.L$0);
            this.label = 1;
            if (dVar.collect(aVar, this) == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f56620a;
    }
}
