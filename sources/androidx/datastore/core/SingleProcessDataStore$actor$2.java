package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import d10.p;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.t;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"T", "Landroidx/datastore/core/SingleProcessDataStore$b;", "msg", "", "ex", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$actor$2 extends Lambda implements p<SingleProcessDataStore.b<T>, Throwable, Unit> {
    public static final SingleProcessDataStore$actor$2 INSTANCE = new SingleProcessDataStore$actor$2();

    public SingleProcessDataStore$actor$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SingleProcessDataStore.b) obj, (Throwable) obj2);
        return Unit.f56620a;
    }

    public final void invoke(SingleProcessDataStore.b<T> bVar, Throwable th2) {
        if (bVar instanceof SingleProcessDataStore.b.C0033b) {
            t a11 = ((SingleProcessDataStore.b.C0033b) bVar).a();
            if (th2 == null) {
                th2 = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            a11.o(th2);
        }
    }
}
