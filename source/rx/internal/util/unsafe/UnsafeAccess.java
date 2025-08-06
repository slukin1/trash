package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
public final class UnsafeAccess {
    private static final boolean DISABLED_BY_USER = (System.getProperty("rx.unsafe-disable") != null);
    public static final Unsafe UNSAFE;

    static {
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get((Object) null);
        } catch (Throwable unused) {
        }
        UNSAFE = unsafe;
    }

    private UnsafeAccess() {
        throw new IllegalStateException("No instances!");
    }

    public static long addressOf(Class<?> cls, String str) {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e11) {
            InternalError internalError = new InternalError();
            internalError.initCause(e11);
            throw internalError;
        }
    }

    public static boolean compareAndSwapInt(Object obj, long j11, int i11, int i12) {
        return UNSAFE.compareAndSwapInt(obj, j11, i11, i12);
    }

    public static int getAndAddInt(Object obj, long j11, int i11) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j11);
        } while (!unsafe.compareAndSwapInt(obj, j11, intVolatile, intVolatile + i11));
        return intVolatile;
    }

    public static int getAndIncrementInt(Object obj, long j11) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j11);
        } while (!unsafe.compareAndSwapInt(obj, j11, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    public static int getAndSetInt(Object obj, long j11, int i11) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j11);
        } while (!unsafe.compareAndSwapInt(obj, j11, intVolatile, i11));
        return intVolatile;
    }

    public static boolean isUnsafeAvailable() {
        return UNSAFE != null && !DISABLED_BY_USER;
    }
}
