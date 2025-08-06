package androidx.datastore.preferences.rxjava3;

import android.content.Context;
import d10.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class RxPreferenceDataStoreBuilder$build$delegate$2 extends Lambda implements a<File> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxPreferenceDataStoreBuilder$build$delegate$2(Context context, String str) {
        super(0);
        this.$context = context;
        this.$name = str;
    }

    public final File invoke() {
        return androidx.datastore.preferences.a.a(this.$context, this.$name);
    }
}
