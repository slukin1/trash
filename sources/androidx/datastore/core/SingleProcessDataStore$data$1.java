package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.f;

@d(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/e;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$data$1 extends SuspendLambda implements p<e<? super T>, c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    @d(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/j;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<j<T>, c<? super Boolean>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            AnonymousClass1 r02 = new AnonymousClass1(jVar, cVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(j<T> jVar, c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(jVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.label == 0) {
                k.b(obj);
                j<T> jVar = (j) this.L$0;
                j<T> jVar2 = jVar;
                boolean z11 = false;
                if (!(jVar2 instanceof b) && !(jVar2 instanceof f) && jVar == jVar2) {
                    z11 = true;
                }
                return a.a(z11);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, c<? super SingleProcessDataStore$data$1> cVar) {
        super(2, cVar);
        this.this$0 = singleProcessDataStore;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.this$0, cVar);
        singleProcessDataStore$data$1.L$0 = obj;
        return singleProcessDataStore$data$1;
    }

    public final Object invoke(e<? super T> eVar, c<? super Unit> cVar) {
        return ((SingleProcessDataStore$data$1) create(eVar, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            e eVar = (e) this.L$0;
            final j jVar = (j) this.this$0.f8931h.getValue();
            if (!(jVar instanceof b)) {
                this.this$0.f8933j.e(new SingleProcessDataStore.b.a(jVar));
            }
            SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 = new SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1(f.u(this.this$0.f8931h, new AnonymousClass1((c<? super AnonymousClass1>) null)));
            this.label = 1;
            if (f.w(eVar, singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1, this) == d11) {
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
