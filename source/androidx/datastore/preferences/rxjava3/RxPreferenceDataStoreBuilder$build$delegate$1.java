package androidx.datastore.preferences.rxjava3;

import d10.a;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class RxPreferenceDataStoreBuilder$build$delegate$1 extends Lambda implements a<File> {
    public final /* synthetic */ Callable<File> $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxPreferenceDataStoreBuilder$build$delegate$1(Callable<File> callable) {
        super(0);
        this.$produceFile = callable;
    }

    public final File invoke() {
        return this.$produceFile.call();
    }
}
