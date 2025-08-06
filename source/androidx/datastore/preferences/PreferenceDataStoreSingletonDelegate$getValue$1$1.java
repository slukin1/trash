package androidx.datastore.preferences;

import android.content.Context;
import d10.a;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Ljava/io/File;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PreferenceDataStoreSingletonDelegate$getValue$1$1 extends Lambda implements a<File> {
    public final /* synthetic */ Context $applicationContext;
    public final /* synthetic */ PreferenceDataStoreSingletonDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreSingletonDelegate$getValue$1$1(Context context, PreferenceDataStoreSingletonDelegate preferenceDataStoreSingletonDelegate) {
        super(0);
        this.$applicationContext = context;
        this.this$0 = preferenceDataStoreSingletonDelegate;
    }

    public final File invoke() {
        return a.a(this.$applicationContext, this.this$0.f8954a);
    }
}
