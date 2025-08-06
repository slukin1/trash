package v4;

import android.content.Context;
import java.io.File;
import java.util.UUID;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66657a = new a();

    public final File a(Context context) {
        return new File(context.getCacheDir(), UUID.randomUUID().toString());
    }
}
