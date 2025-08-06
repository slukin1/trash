package androidx.datastore.rxjava3;

import d10.p;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.rx3.RxAwaitKt;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@"}, d2 = {"T", "curData", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@d(c = "androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder$build$1", f = "RxSharedPreferencesMigration.kt", l = {111}, m = "invokeSuspend")
final class RxSharedPreferencesMigrationBuilder$build$1 extends SuspendLambda implements p<Object, c<? super Boolean>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ d<Object> this$0;

    public RxSharedPreferencesMigrationBuilder$build$1(d<Object> dVar, c<? super RxSharedPreferencesMigrationBuilder$build$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RxSharedPreferencesMigrationBuilder$build$1 rxSharedPreferencesMigrationBuilder$build$1 = new RxSharedPreferencesMigrationBuilder$build$1(this.this$0, cVar);
        rxSharedPreferencesMigrationBuilder$build$1.L$0 = obj;
        return rxSharedPreferencesMigrationBuilder$build$1;
    }

    public final Object invoke(Object obj, c<? super Boolean> cVar) {
        return ((RxSharedPreferencesMigrationBuilder$build$1) create(obj, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            Single<Boolean> a11 = d.a(this.this$0).a(this.L$0);
            this.label = 1;
            obj = RxAwaitKt.a(a11, this);
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
