package i1;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final a f15959a;

    public a(a aVar) {
        this.f15959a = aVar;
    }

    public static a a(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return new c((a) null, context, uri);
        }
        return null;
    }

    public abstract String b();
}
