package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import d10.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n"}, d2 = {"T", "Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class SingleProcessDataStore$file$2 extends Lambda implements a<File> {
    public final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$file$2(SingleProcessDataStore<T> singleProcessDataStore) {
        super(0);
        this.this$0 = singleProcessDataStore;
    }

    public final File invoke() {
        File file = (File) this.this$0.f8924a.invoke();
        String absolutePath = file.getAbsolutePath();
        SingleProcessDataStore.a aVar = SingleProcessDataStore.f8921k;
        synchronized (aVar.b()) {
            if (!aVar.a().contains(absolutePath)) {
                aVar.a().add(absolutePath);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return file;
    }
}
