package androidx.datastore.preferences.core;

import d10.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferenceDataStoreFactory$create$delegate$1 extends Lambda implements a<File> {
    public final /* synthetic */ a<File> $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(a<? extends File> aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    public final File invoke() {
        File invoke = this.$produceFile.invoke();
        String g11 = FilesKt__UtilsKt.g(invoke);
        c cVar = c.f8970a;
        if (x.b(g11, cVar.e())) {
            return invoke;
        }
        throw new IllegalStateException(("File extension for file: " + invoke + " does not match required extension for Preferences file: " + cVar.e()).toString());
    }
}
