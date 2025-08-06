package androidx.datastore.rxjava3;

import d10.p;
import io.reactivex.rxjava3.core.Single;
import j00.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.rx3.RxAwaitKt;

@d(c = "androidx.datastore.rxjava3.RxDataStore$updateDataAsync$1", f = "RxDataStore.kt", l = {124}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/h0;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class RxDataStore$updateDataAsync$1 extends SuspendLambda implements p<h0, c<? super T>, Object> {
    public final /* synthetic */ h<T, Single<T>> $transform;
    public int label;
    public final /* synthetic */ RxDataStore<T> this$0;

    @d(c = "androidx.datastore.rxjava3.RxDataStore$updateDataAsync$1$1", f = "RxDataStore.kt", l = {125}, m = "invokeSuspend")
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H@"}, d2 = {"", "T", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: androidx.datastore.rxjava3.RxDataStore$updateDataAsync$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<T, c<? super T>, Object> {
        public /* synthetic */ Object L$0;
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            AnonymousClass1 r02 = new AnonymousClass1(hVar, cVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(T t11, c<? super T> cVar) {
            return ((AnonymousClass1) create(t11, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                Object obj2 = this.L$0;
                this.label = 1;
                obj = RxAwaitKt.a(hVar.apply(obj2), this);
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxDataStore$updateDataAsync$1(RxDataStore<T> rxDataStore, h<T, Single<T>> hVar, c<? super RxDataStore$updateDataAsync$1> cVar) {
        super(2, cVar);
        this.this$0 = rxDataStore;
        this.$transform = hVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RxDataStore$updateDataAsync$1(this.this$0, this.$transform, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super T> cVar) {
        return ((RxDataStore$updateDataAsync$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            androidx.datastore.core.d a11 = this.this$0.f9273b;
            final h<T, Single<T>> hVar = this.$transform;
            AnonymousClass1 r12 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            obj = a11.a(r12, this);
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
