package androidx.datastore.core;

import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;

@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2$1$1", f = "DataMigrationInitializer.kt", l = {45}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0000H@"}, d2 = {"T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DataMigrationInitializer$Companion$runMigrations$2$1$1 extends SuspendLambda implements l<c<? super Unit>, Object> {
    public final /* synthetic */ c<T> $migration;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$2$1$1(c<T> cVar, c<? super DataMigrationInitializer$Companion$runMigrations$2$1$1> cVar2) {
        super(1, cVar2);
        this.$migration = cVar;
    }

    public final c<Unit> create(c<?> cVar) {
        return new DataMigrationInitializer$Companion$runMigrations$2$1$1(this.$migration, cVar);
    }

    public final Object invoke(c<? super Unit> cVar) {
        return ((DataMigrationInitializer$Companion$runMigrations$2$1$1) create(cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            c<T> cVar = this.$migration;
            this.label = 1;
            if (cVar.b(this) == d11) {
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
