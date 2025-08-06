package z00;

import java.util.Timer;

public final class a {
    public static final Timer a(String str, boolean z11) {
        return str == null ? new Timer(z11) : new Timer(str, z11);
    }
}
