package f4;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class h {
    public static void a(boolean z11, String str) {
        if (!z11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T c(T t11) {
        if (!t11.isEmpty()) {
            return t11;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static <T> T d(T t11) {
        return e(t11, "Argument must not be null");
    }

    public static <T> T e(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }
}
