package androidx.datastore;

import android.content.Context;
import d10.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class DataStoreSingletonDelegate$getValue$1$1 extends Lambda implements a<File> {
    public final /* synthetic */ Context $applicationContext;
    public final /* synthetic */ b<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreSingletonDelegate$getValue$1$1(Context context, b<Object> bVar) {
        super(0);
        this.$applicationContext = context;
    }

    public final File invoke() {
        return a.a(this.$applicationContext, b.c(this.this$0));
    }
}
