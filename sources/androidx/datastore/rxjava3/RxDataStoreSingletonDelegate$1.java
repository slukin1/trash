package androidx.datastore.rxjava3;

import android.content.Context;
import androidx.datastore.core.c;
import d10.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"", "T", "Landroid/content/Context;", "it", "", "Landroidx/datastore/core/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class RxDataStoreSingletonDelegate$1 extends Lambda implements l<Context, List<? extends c<Object>>> {
    public static final RxDataStoreSingletonDelegate$1 INSTANCE = new RxDataStoreSingletonDelegate$1();

    public RxDataStoreSingletonDelegate$1() {
        super(1);
    }

    public final List<c<Object>> invoke(Context context) {
        return CollectionsKt__CollectionsKt.k();
    }
}
