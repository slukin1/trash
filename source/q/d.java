package q;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Quirks f16375a = new Quirks(e.a());

    public static <T extends Quirk> T a(Class<T> cls) {
        return f16375a.get(cls);
    }

    public static Quirks b() {
        return f16375a;
    }
}
