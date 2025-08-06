package androidx.datastore;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Landroid/content/Context;", "", "fileName", "Ljava/io/File;", "a", "datastore_release"}, k = 2, mv = {1, 5, 1})
public final class a {
    public static final File a(Context context, String str) {
        return new File(context.getApplicationContext().getFilesDir(), x.i("datastore/", str));
    }
}
