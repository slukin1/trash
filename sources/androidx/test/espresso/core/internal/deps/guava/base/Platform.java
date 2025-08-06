package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Locale;
import java.util.logging.Logger;

final class Platform {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f11160a = Logger.getLogger(Platform.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final PatternCompiler f11161b = b();

    public static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }
    }

    private Platform() {
    }

    public static String a(double d11) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(d11)});
    }

    public static PatternCompiler b() {
        return new JdkPatternCompiler();
    }

    public static long c() {
        return System.nanoTime();
    }
}
