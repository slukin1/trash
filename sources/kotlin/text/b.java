package kotlin.text;

import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f56907a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f56908b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f56909c = Charset.forName(C.UTF16_NAME);

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f56910d = Charset.forName("UTF-16BE");

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f56911e = Charset.forName(C.UTF16LE_NAME);

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f56912f = Charset.forName(C.ASCII_NAME);

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f56913g = Charset.forName("ISO-8859-1");

    /* renamed from: h  reason: collision with root package name */
    public static volatile Charset f56914h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Charset f56915i;

    public final Charset a() {
        Charset charset = f56915i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        f56915i = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f56914h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        f56914h = forName;
        return forName;
    }
}
