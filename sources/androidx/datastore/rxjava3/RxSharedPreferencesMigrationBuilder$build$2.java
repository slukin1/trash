package androidx.datastore.rxjava3;

import androidx.datastore.migrations.b;
import d10.q;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.rx3.RxAwaitKt;

@Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H@"}, d2 = {"T", "Landroidx/datastore/migrations/b;", "spView", "curData", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@d(c = "androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder$build$2", f = "RxSharedPreferencesMigration.kt", l = {108}, m = "invokeSuspend")
final class RxSharedPreferencesMigrationBuilder$build$2 extends SuspendLambda implements q<b, Object, c<Object>, Object> {
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;
    public final /* synthetic */ d<Object> this$0;

    public RxSharedPreferencesMigrationBuilder$build$2(d<Object> dVar, c<? super RxSharedPreferencesMigrationBuilder$build$2> cVar) {
        super(3, cVar);
    }

    public final Object invoke(b bVar, Object obj, c<Object> cVar) {
        RxSharedPreferencesMigrationBuilder$build$2 rxSharedPreferencesMigrationBuilder$build$2 = new RxSharedPreferencesMigrationBuilder$build$2(this.this$0, cVar);
        rxSharedPreferencesMigrationBuilder$build$2.L$0 = bVar;
        rxSharedPreferencesMigrationBuilder$build$2.L$1 = obj;
        return rxSharedPreferencesMigrationBuilder$build$2.invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            Object obj2 = this.L$1;
            Single b11 = d.a(this.this$0).b((b) this.L$0, obj2);
            this.L$0 = null;
            this.label = 1;
            obj = RxAwaitKt.a(b11, this);
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
