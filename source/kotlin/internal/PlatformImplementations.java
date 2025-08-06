package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.x;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;

public class PlatformImplementations {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56697a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final Method f56698b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f56699c;

        static {
            Method method;
            Method method2;
            Class<Throwable> cls = Throwable.class;
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                method = null;
                if (i12 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i12];
                if (x.b(method2.getName(), "addSuppressed") && x.b(ArraysKt___ArraysKt.o0(method2.getParameterTypes()), cls)) {
                    break;
                }
                i12++;
            }
            f56698b = method2;
            int length2 = methods.length;
            while (true) {
                if (i11 >= length2) {
                    break;
                }
                Method method3 = methods[i11];
                if (x.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i11++;
            }
            f56699c = method;
        }
    }

    public void a(Throwable th2, Throwable th3) {
        Method method = a.f56698b;
        if (method != null) {
            method.invoke(th2, new Object[]{th3});
        }
    }

    public Random b() {
        return new FallbackThreadLocalRandom();
    }
}
