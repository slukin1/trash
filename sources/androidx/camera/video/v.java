package androidx.camera.video;

import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f6365a;

    /* renamed from: b  reason: collision with root package name */
    public static final v f6366b;

    /* renamed from: c  reason: collision with root package name */
    public static final v f6367c;

    /* renamed from: d  reason: collision with root package name */
    public static final v f6368d;

    /* renamed from: e  reason: collision with root package name */
    public static final v f6369e;

    /* renamed from: f  reason: collision with root package name */
    public static final v f6370f;

    /* renamed from: g  reason: collision with root package name */
    public static final v f6371g = b.e(-1, "NONE");

    /* renamed from: h  reason: collision with root package name */
    public static final Set<v> f6372h;

    /* renamed from: i  reason: collision with root package name */
    public static final List<v> f6373i;

    @AutoValue
    public static abstract class b extends v {
        public b() {
            super();
        }

        public static b e(int i11, String str) {
            return new j(i11, str);
        }

        public abstract String c();

        public abstract int d();
    }

    static {
        b e11 = b.e(4, "SD");
        f6365a = e11;
        b e12 = b.e(5, "HD");
        f6366b = e12;
        b e13 = b.e(6, "FHD");
        f6367c = e13;
        b e14 = b.e(8, "UHD");
        f6368d = e14;
        b e15 = b.e(0, "LOWEST");
        f6369e = e15;
        b e16 = b.e(1, "HIGHEST");
        f6370f = e16;
        f6372h = new HashSet(Arrays.asList(new v[]{e15, e16, e11, e12, e13, e14}));
        f6373i = Arrays.asList(new v[]{e14, e13, e12, e11});
    }

    public static boolean a(v vVar) {
        return f6372h.contains(vVar);
    }

    public static List<v> b() {
        return new ArrayList(f6373i);
    }

    public v() {
    }
}
