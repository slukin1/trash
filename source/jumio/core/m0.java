package jumio.core;

import d10.l;
import java.util.Locale;
import kotlin.jvm.internal.Lambda;

public final class m0 extends Lambda implements l<String, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final m0 f56273a = new m0();

    public m0() {
        super(1);
    }

    public final Object invoke(Object obj) {
        return ((String) obj).toUpperCase(Locale.ROOT);
    }
}
