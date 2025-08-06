package androidx.datastore.preferences.protobuf;

import cn.sharesdk.framework.InnerShareParams;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f9071a = Logger.getLogger(c1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Unsafe f9072b = F();

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f9073c = b.b();

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f9074d = o(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9075e = o(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final e f9076f = D();

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f9077g = V();

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f9078h = U();

    /* renamed from: i  reason: collision with root package name */
    public static final long f9079i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f9080j;

    /* renamed from: k  reason: collision with root package name */
    public static final long f9081k;

    /* renamed from: l  reason: collision with root package name */
    public static final long f9082l;

    /* renamed from: m  reason: collision with root package name */
    public static final long f9083m;

    /* renamed from: n  reason: collision with root package name */
    public static final long f9084n;

    /* renamed from: o  reason: collision with root package name */
    public static final long f9085o;

    /* renamed from: p  reason: collision with root package name */
    public static final long f9086p;

    /* renamed from: q  reason: collision with root package name */
    public static final long f9087q;

    /* renamed from: r  reason: collision with root package name */
    public static final long f9088r;

    /* renamed from: s  reason: collision with root package name */
    public static final long f9089s;

    /* renamed from: t  reason: collision with root package name */
    public static final long f9090t;

    /* renamed from: u  reason: collision with root package name */
    public static final long f9091u;

    /* renamed from: v  reason: collision with root package name */
    public static final long f9092v = q(m());

    /* renamed from: w  reason: collision with root package name */
    public static final int f9093w;

    /* renamed from: x  reason: collision with root package name */
    public static final boolean f9094x = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static class a implements PrivilegedExceptionAction<Unsafe> {
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Class<Unsafe> cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get((Object) null);
                if (cls.isInstance(obj)) {
                    return cls.cast(obj);
                }
            }
            return null;
        }
    }

    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public boolean d(Object obj, long j11) {
            if (c1.f9094x) {
                return c1.s(obj, j11);
            }
            return c1.t(obj, j11);
        }

        public byte e(long j11) {
            throw new UnsupportedOperationException();
        }

        public byte f(Object obj, long j11) {
            if (c1.f9094x) {
                return c1.w(obj, j11);
            }
            return c1.x(obj, j11);
        }

        public double g(Object obj, long j11) {
            return Double.longBitsToDouble(k(obj, j11));
        }

        public float h(Object obj, long j11) {
            return Float.intBitsToFloat(i(obj, j11));
        }

        public long j(long j11) {
            throw new UnsupportedOperationException();
        }

        public void n(Object obj, long j11, boolean z11) {
            if (c1.f9094x) {
                c1.K(obj, j11, z11);
            } else {
                c1.L(obj, j11, z11);
            }
        }

        public void o(Object obj, long j11, byte b11) {
            if (c1.f9094x) {
                c1.N(obj, j11, b11);
            } else {
                c1.O(obj, j11, b11);
            }
        }

        public void p(Object obj, long j11, double d11) {
            s(obj, j11, Double.doubleToLongBits(d11));
        }

        public void q(Object obj, long j11, float f11) {
            r(obj, j11, Float.floatToIntBits(f11));
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public boolean d(Object obj, long j11) {
            if (c1.f9094x) {
                return c1.s(obj, j11);
            }
            return c1.t(obj, j11);
        }

        public byte e(long j11) {
            throw new UnsupportedOperationException();
        }

        public byte f(Object obj, long j11) {
            if (c1.f9094x) {
                return c1.w(obj, j11);
            }
            return c1.x(obj, j11);
        }

        public double g(Object obj, long j11) {
            return Double.longBitsToDouble(k(obj, j11));
        }

        public float h(Object obj, long j11) {
            return Float.intBitsToFloat(i(obj, j11));
        }

        public long j(long j11) {
            throw new UnsupportedOperationException();
        }

        public void n(Object obj, long j11, boolean z11) {
            if (c1.f9094x) {
                c1.K(obj, j11, z11);
            } else {
                c1.L(obj, j11, z11);
            }
        }

        public void o(Object obj, long j11, byte b11) {
            if (c1.f9094x) {
                c1.N(obj, j11, b11);
            } else {
                c1.O(obj, j11, b11);
            }
        }

        public void p(Object obj, long j11, double d11) {
            s(obj, j11, Double.doubleToLongBits(d11));
        }

        public void q(Object obj, long j11, float f11) {
            r(obj, j11, Float.floatToIntBits(f11));
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        public void c(long j11, byte[] bArr, long j12, long j13) {
            this.f9095a.copyMemory((Object) null, j11, bArr, c1.f9079i + j12, j13);
        }

        public boolean d(Object obj, long j11) {
            return this.f9095a.getBoolean(obj, j11);
        }

        public byte e(long j11) {
            return this.f9095a.getByte(j11);
        }

        public byte f(Object obj, long j11) {
            return this.f9095a.getByte(obj, j11);
        }

        public double g(Object obj, long j11) {
            return this.f9095a.getDouble(obj, j11);
        }

        public float h(Object obj, long j11) {
            return this.f9095a.getFloat(obj, j11);
        }

        public long j(long j11) {
            return this.f9095a.getLong(j11);
        }

        public void n(Object obj, long j11, boolean z11) {
            this.f9095a.putBoolean(obj, j11, z11);
        }

        public void o(Object obj, long j11, byte b11) {
            this.f9095a.putByte(obj, j11, b11);
        }

        public void p(Object obj, long j11, double d11) {
            this.f9095a.putDouble(obj, j11, d11);
        }

        public void q(Object obj, long j11, float f11) {
            this.f9095a.putFloat(obj, j11, f11);
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f9095a;

        public e(Unsafe unsafe) {
            this.f9095a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f9095a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f9095a.arrayIndexScale(cls);
        }

        public abstract void c(long j11, byte[] bArr, long j12, long j13);

        public abstract boolean d(Object obj, long j11);

        public abstract byte e(long j11);

        public abstract byte f(Object obj, long j11);

        public abstract double g(Object obj, long j11);

        public abstract float h(Object obj, long j11);

        public final int i(Object obj, long j11) {
            return this.f9095a.getInt(obj, j11);
        }

        public abstract long j(long j11);

        public final long k(Object obj, long j11) {
            return this.f9095a.getLong(obj, j11);
        }

        public final Object l(Object obj, long j11) {
            return this.f9095a.getObject(obj, j11);
        }

        public final long m(Field field) {
            return this.f9095a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j11, boolean z11);

        public abstract void o(Object obj, long j11, byte b11);

        public abstract void p(Object obj, long j11, double d11);

        public abstract void q(Object obj, long j11, float f11);

        public final void r(Object obj, long j11, int i11) {
            this.f9095a.putInt(obj, j11, i11);
        }

        public final void s(Object obj, long j11, long j12) {
            this.f9095a.putLong(obj, j11, j12);
        }

        public final void t(Object obj, long j11, Object obj2) {
            this.f9095a.putObject(obj, j11, obj2);
        }
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        long k11 = (long) k(byte[].class);
        f9079i = k11;
        f9080j = (long) k(cls6);
        f9081k = (long) l(cls6);
        f9082l = (long) k(cls5);
        f9083m = (long) l(cls5);
        f9084n = (long) k(cls4);
        f9085o = (long) l(cls4);
        f9086p = (long) k(cls3);
        f9087q = (long) l(cls3);
        f9088r = (long) k(cls2);
        f9089s = (long) l(cls2);
        f9090t = (long) k(cls);
        f9091u = (long) l(cls);
        f9093w = (int) (7 & k11);
    }

    public static int A(Object obj, long j11) {
        return f9076f.i(obj, j11);
    }

    public static long B(long j11) {
        return f9076f.j(j11);
    }

    public static long C(Object obj, long j11) {
        return f9076f.k(obj, j11);
    }

    public static e D() {
        Unsafe unsafe = f9072b;
        if (unsafe == null) {
            return null;
        }
        if (!b.c()) {
            return new d(unsafe);
        }
        if (f9074d) {
            return new c(unsafe);
        }
        if (f9075e) {
            return new b(unsafe);
        }
        return null;
    }

    public static Object E(Object obj, long j11) {
        return f9076f.l(obj, j11);
    }

    public static Unsafe F() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean G() {
        return f9078h;
    }

    public static boolean H() {
        return f9077g;
    }

    public static long I(Field field) {
        return f9076f.m(field);
    }

    public static void J(Object obj, long j11, boolean z11) {
        f9076f.n(obj, j11, z11);
    }

    public static void K(Object obj, long j11, boolean z11) {
        N(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static void L(Object obj, long j11, boolean z11) {
        O(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static void M(byte[] bArr, long j11, byte b11) {
        f9076f.o(bArr, f9079i + j11, b11);
    }

    public static void N(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int A = A(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        R(obj, j12, ((255 & b11) << i11) | (A & (~(255 << i11))));
    }

    public static void O(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        R(obj, j12, ((255 & b11) << i11) | (A(obj, j12) & (~(255 << i11))));
    }

    public static void P(Object obj, long j11, double d11) {
        f9076f.p(obj, j11, d11);
    }

    public static void Q(Object obj, long j11, float f11) {
        f9076f.q(obj, j11, f11);
    }

    public static void R(Object obj, long j11, int i11) {
        f9076f.r(obj, j11, i11);
    }

    public static void S(Object obj, long j11, long j12) {
        f9076f.s(obj, j11, j12);
    }

    public static void T(Object obj, long j11, Object obj2) {
        f9076f.t(obj, j11, obj2);
    }

    public static boolean U() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f9072b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls2.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls2.getMethod("arrayIndexScale", new Class[]{Class.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getInt", new Class[]{cls, cls3});
            cls2.getMethod("putInt", new Class[]{cls, cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            cls2.getMethod("putLong", new Class[]{cls, cls3, cls3});
            cls2.getMethod("getObject", new Class[]{cls, cls3});
            cls2.getMethod("putObject", new Class[]{cls, cls3, cls});
            if (b.c()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls, cls3});
            cls2.getMethod("putByte", new Class[]{cls, cls3, Byte.TYPE});
            cls2.getMethod("getBoolean", new Class[]{cls, cls3});
            cls2.getMethod("putBoolean", new Class[]{cls, cls3, Boolean.TYPE});
            cls2.getMethod("getFloat", new Class[]{cls, cls3});
            cls2.getMethod("putFloat", new Class[]{cls, cls3, Float.TYPE});
            cls2.getMethod("getDouble", new Class[]{cls, cls3});
            cls2.getMethod("putDouble", new Class[]{cls, cls3, Double.TYPE});
            return true;
        } catch (Throwable th2) {
            Logger logger = f9071a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    public static boolean V() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = f9072b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (m() == null) {
                return false;
            }
            if (b.c()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th2) {
            Logger logger = f9071a;
            Level level = Level.WARNING;
            logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
            return false;
        }
    }

    public static long i(ByteBuffer byteBuffer) {
        return f9076f.k(byteBuffer, f9092v);
    }

    public static <T> T j(Class<T> cls) {
        try {
            return f9072b.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static int k(Class<?> cls) {
        if (f9078h) {
            return f9076f.a(cls);
        }
        return -1;
    }

    public static int l(Class<?> cls) {
        if (f9078h) {
            return f9076f.b(cls);
        }
        return -1;
    }

    public static Field m() {
        Field p11;
        if (b.c() && (p11 = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return p11;
        }
        Field p12 = p(Buffer.class, InnerShareParams.ADDRESS);
        if (p12 == null || p12.getType() != Long.TYPE) {
            return null;
        }
        return p12;
    }

    public static void n(long j11, byte[] bArr, long j12, long j13) {
        f9076f.c(j11, bArr, j12, j13);
    }

    public static boolean o(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!b.c()) {
            return false;
        }
        try {
            Class<?> cls3 = f9073c;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Field p(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long q(Field field) {
        e eVar;
        if (field == null || (eVar = f9076f) == null) {
            return -1;
        }
        return eVar.m(field);
    }

    public static boolean r(Object obj, long j11) {
        return f9076f.d(obj, j11);
    }

    public static boolean s(Object obj, long j11) {
        return w(obj, j11) != 0;
    }

    public static boolean t(Object obj, long j11) {
        return x(obj, j11) != 0;
    }

    public static byte u(long j11) {
        return f9076f.e(j11);
    }

    public static byte v(byte[] bArr, long j11) {
        return f9076f.f(bArr, f9079i + j11);
    }

    public static byte w(Object obj, long j11) {
        return (byte) ((A(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3))) & 255);
    }

    public static byte x(Object obj, long j11) {
        return (byte) ((A(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3))) & 255);
    }

    public static double y(Object obj, long j11) {
        return f9076f.g(obj, j11);
    }

    public static float z(Object obj, long j11) {
        return f9076f.h(obj, j11);
    }
}
