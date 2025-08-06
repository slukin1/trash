package kv;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final BigInteger f22880a;

    /* renamed from: b  reason: collision with root package name */
    public static String f22881b = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+-";

    /* renamed from: c  reason: collision with root package name */
    public static final BigInteger f22882c = BigInteger.valueOf((long) "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+-".length());

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static boolean f22883a = false;

        /* renamed from: b  reason: collision with root package name */
        public static final ThreadLocal<Random> f22884b = new C0196a();

        /* renamed from: kv.d$a$a  reason: collision with other inner class name */
        public class C0196a extends ThreadLocal<Random> {
            /* renamed from: a */
            public Random initialValue() {
                return new Random();
            }
        }

        public static class b {
            public static Random b() {
                return ThreadLocalRandom.current();
            }
        }

        static {
            try {
                Class.forName("java.util.concurrent.ThreadLocalRandom");
            } catch (ClassNotFoundException unused) {
            }
        }

        public static Random a() {
            if (f22883a) {
                return b.b();
            }
            return f22884b.get();
        }
    }

    static {
        BigInteger bigInteger = BigInteger.ONE;
        f22880a = bigInteger.shiftLeft(64).subtract(bigInteger);
    }

    public static String a() {
        String b11 = b();
        String b12 = b();
        return b12 + b11;
    }

    public static String b() {
        return BigInteger.valueOf(c()).and(f22880a).toString(16);
    }

    public static long c() {
        long j11 = 0;
        while (j11 == 0) {
            j11 = a.a().nextLong();
        }
        return j11;
    }
}
