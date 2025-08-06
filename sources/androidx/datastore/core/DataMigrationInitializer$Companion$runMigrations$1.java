package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DataMigrationInitializer.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, c<? super DataMigrationInitializer$Companion$runMigrations$1> cVar) {
        super(cVar);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((List) null, (g) null, this);
    }
}
