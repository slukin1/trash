package ia;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.davemorrissey.labs.subscaleview.ImageSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f76198a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f76199b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f76200c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f76201d;

    /* renamed from: e  reason: collision with root package name */
    public int f76202e;

    /* renamed from: f  reason: collision with root package name */
    public int f76203f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f76204g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f76205h;

    public e(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(ImageSource.FILE_SCHEME) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f76199b = null;
        this.f76198a = uri;
        this.f76200c = null;
        this.f76201d = true;
    }

    public static e a(String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return n(ImageSource.ASSET_SCHEME + str);
    }

    public static e j(int i11) {
        return new e(i11);
    }

    public static e m(Uri uri) {
        Objects.requireNonNull(uri, "Uri must not be null");
        return new e(uri);
    }

    public static e n(String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = ImageSource.FILE_SCHEME + str;
        }
        return new e(Uri.parse(str));
    }

    public final Bitmap b() {
        return this.f76199b;
    }

    public final Integer c() {
        return this.f76200c;
    }

    public final int d() {
        return this.f76203f;
    }

    public final Rect e() {
        return this.f76204g;
    }

    public final int f() {
        return this.f76202e;
    }

    public final boolean g() {
        return this.f76201d;
    }

    public final Uri h() {
        return this.f76198a;
    }

    public final boolean i() {
        return this.f76205h;
    }

    public e k(boolean z11) {
        this.f76201d = z11;
        return this;
    }

    public e l() {
        return k(true);
    }

    public e(int i11) {
        this.f76199b = null;
        this.f76198a = null;
        this.f76200c = Integer.valueOf(i11);
        this.f76201d = true;
    }
}
