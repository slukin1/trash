package androidx.datastore.core;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/h0;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$transformAndWrite$newData$1 extends SuspendLambda implements p<h0, c<? super T>, Object> {
    public final /* synthetic */ T $curData;
    public final /* synthetic */ p<T, c<? super T>, Object> $transform;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$transformAndWrite$newData$1(p<? super T, ? super c<? super T>, ? extends Object> pVar, T t11, c<? super SingleProcessDataStore$transformAndWrite$newData$1> cVar) {
        super(2, cVar);
        this.$transform = pVar;
        this.$curData = t11;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.$transform, this.$curData, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super T> cVar) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            p<T, c<? super T>, Object> pVar = this.$transform;
            T t11 = this.$curData;
            this.label = 1;
            obj = pVar.invoke(t11, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
