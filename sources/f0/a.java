package f0;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.Quirks;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Quirks f15680a = new Quirks(b.a());

    public static <T extends Quirk> T a(Class<T> cls) {
        return f15680a.get(cls);
    }
}
