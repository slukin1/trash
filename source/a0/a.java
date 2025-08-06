package a0;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Quirks f3460a = new Quirks(b.a());

    public static <T extends Quirk> T a(Class<T> cls) {
        return f3460a.get(cls);
    }

    public static Quirks b() {
        return f3460a;
    }

    public static <T extends Quirk> List<T> c(Class<T> cls) {
        return f3460a.getAll(cls);
    }
}
