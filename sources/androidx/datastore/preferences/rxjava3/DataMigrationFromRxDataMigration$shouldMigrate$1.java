package androidx.datastore.preferences.rxjava3;

import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@d(c = "androidx.datastore.preferences.rxjava3.DataMigrationFromRxDataMigration", f = "RxPreferenceDataStoreBuilder.kt", l = {171}, m = "shouldMigrate")
final class DataMigrationFromRxDataMigration$shouldMigrate$1 extends ContinuationImpl {
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ a<Object> this$0;

    public DataMigrationFromRxDataMigration$shouldMigrate$1(a<Object> aVar, c<? super DataMigrationFromRxDataMigration$shouldMigrate$1> cVar) {
        super(cVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}
