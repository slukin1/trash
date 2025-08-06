package w3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import java.util.List;
import n3.e;

public class d implements e<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f66660a;

    public d(Context context) {
        this.f66660a = context.getApplicationContext();
    }

    /* renamed from: c */
    public r<Drawable> b(Uri uri, int i11, int i12, Options options) {
        Context d11 = d(uri, uri.getAuthority());
        return c.c(a.b(this.f66660a, d11, g(d11, uri)));
    }

    public final Context d(Uri uri, String str) {
        if (str.equals(this.f66660a.getPackageName())) {
            return this.f66660a;
        }
        try {
            return this.f66660a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e11) {
            if (str.contains(this.f66660a.getPackageName())) {
                return this.f66660a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e11);
        }
    }

    public final int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e11) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e11);
        }
    }

    public final int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    public final int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* renamed from: h */
    public boolean a(Uri uri, Options options) {
        return uri.getScheme().equals("android.resource");
    }
}
