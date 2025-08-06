package com.google.protobuf;

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

final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    private static final int BYTE_ARRAY_ALIGNMENT;
    public static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    public static final boolean IS_BIG_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();

    public static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        public Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        private static int smallAddress(long j11) {
            return (int) (j11 & -1);
        }

        public void copyMemory(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j11);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j11);
        }

        public byte getByte(Object obj, long j11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j11);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j11);
        }

        public double getDouble(Object obj, long j11) {
            return Double.longBitsToDouble(getLong(obj, j11));
        }

        public float getFloat(Object obj, long j11) {
            return Float.intBitsToFloat(getInt(obj, j11));
        }

        public int getInt(long j11) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j11) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j11, boolean z11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j11, z11);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j11, z11);
            }
        }

        public void putByte(Object obj, long j11, byte b11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j11, b11);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j11, b11);
            }
        }

        public void putDouble(Object obj, long j11, double d11) {
            putLong(obj, j11, Double.doubleToLongBits(d11));
        }

        public void putFloat(Object obj, long j11, float f11) {
            putInt(obj, j11, Float.floatToIntBits(f11));
        }

        public void putInt(long j11, int i11) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j11, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j11) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j11, byte b11) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class Android64MemoryAccessor extends MemoryAccessor {
        public Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j11, byte[] bArr, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public boolean getBoolean(Object obj, long j11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getBooleanBigEndian(obj, j11);
            }
            return UnsafeUtil.getBooleanLittleEndian(obj, j11);
        }

        public byte getByte(Object obj, long j11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                return UnsafeUtil.getByteBigEndian(obj, j11);
            }
            return UnsafeUtil.getByteLittleEndian(obj, j11);
        }

        public double getDouble(Object obj, long j11) {
            return Double.longBitsToDouble(getLong(obj, j11));
        }

        public float getFloat(Object obj, long j11) {
            return Float.intBitsToFloat(getInt(obj, j11));
        }

        public int getInt(long j11) {
            throw new UnsupportedOperationException();
        }

        public long getLong(long j11) {
            throw new UnsupportedOperationException();
        }

        public Object getStaticObject(Field field) {
            try {
                return field.get((Object) null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        public void putBoolean(Object obj, long j11, boolean z11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j11, z11);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j11, z11);
            }
        }

        public void putByte(Object obj, long j11, byte b11) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j11, b11);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j11, b11);
            }
        }

        public void putDouble(Object obj, long j11, double d11) {
            putLong(obj, j11, Double.doubleToLongBits(d11));
        }

        public void putFloat(Object obj, long j11, float f11) {
            putInt(obj, j11, Float.floatToIntBits(f11));
        }

        public void putInt(long j11, int i11) {
            throw new UnsupportedOperationException();
        }

        public void putLong(long j11, long j12) {
            throw new UnsupportedOperationException();
        }

        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        public void copyMemory(byte[] bArr, long j11, long j12, long j13) {
            throw new UnsupportedOperationException();
        }

        public byte getByte(long j11) {
            throw new UnsupportedOperationException();
        }

        public void putByte(long j11, byte b11) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class JvmMemoryAccessor extends MemoryAccessor {
        public JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        public void copyMemory(long j11, byte[] bArr, long j12, long j13) {
            this.unsafe.copyMemory((Object) null, j11, bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j12, j13);
        }

        public boolean getBoolean(Object obj, long j11) {
            return this.unsafe.getBoolean(obj, j11);
        }

        public byte getByte(Object obj, long j11) {
            return this.unsafe.getByte(obj, j11);
        }

        public double getDouble(Object obj, long j11) {
            return this.unsafe.getDouble(obj, j11);
        }

        public float getFloat(Object obj, long j11) {
            return this.unsafe.getFloat(obj, j11);
        }

        public int getInt(long j11) {
            return this.unsafe.getInt(j11);
        }

        public long getLong(long j11) {
            return this.unsafe.getLong(j11);
        }

        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        public void putBoolean(Object obj, long j11, boolean z11) {
            this.unsafe.putBoolean(obj, j11, z11);
        }

        public void putByte(Object obj, long j11, byte b11) {
            this.unsafe.putByte(obj, j11, b11);
        }

        public void putDouble(Object obj, long j11, double d11) {
            this.unsafe.putDouble(obj, j11, d11);
        }

        public void putFloat(Object obj, long j11, float f11) {
            this.unsafe.putFloat(obj, j11, f11);
        }

        public void putInt(long j11, int i11) {
            this.unsafe.putInt(j11, i11);
        }

        public void putLong(long j11, long j12) {
            this.unsafe.putLong(j11, j12);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
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
                UnsafeUtil.logMissingMethod(th2);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Class<Object> cls = Object.class;
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls2 = this.unsafe.getClass();
                Class cls3 = Long.TYPE;
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
                UnsafeUtil.logMissingMethod(th2);
                return false;
            }
        }

        public void copyMemory(byte[] bArr, long j11, long j12, long j13) {
            this.unsafe.copyMemory(bArr, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + j11, (Object) null, j12, j13);
        }

        public byte getByte(long j11) {
            return this.unsafe.getByte(j11);
        }

        public void putByte(long j11, byte b11) {
            this.unsafe.putByte(j11, b11);
        }
    }

    public static abstract class MemoryAccessor {
        public Unsafe unsafe;

        public MemoryAccessor(Unsafe unsafe2) {
            this.unsafe = unsafe2;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract void copyMemory(long j11, byte[] bArr, long j12, long j13);

        public abstract void copyMemory(byte[] bArr, long j11, long j12, long j13);

        public abstract boolean getBoolean(Object obj, long j11);

        public abstract byte getByte(long j11);

        public abstract byte getByte(Object obj, long j11);

        public abstract double getDouble(Object obj, long j11);

        public abstract float getFloat(Object obj, long j11);

        public abstract int getInt(long j11);

        public final int getInt(Object obj, long j11) {
            return this.unsafe.getInt(obj, j11);
        }

        public abstract long getLong(long j11);

        public final long getLong(Object obj, long j11) {
            return this.unsafe.getLong(obj, j11);
        }

        public final Object getObject(Object obj, long j11) {
            return this.unsafe.getObject(obj, j11);
        }

        public abstract Object getStaticObject(Field field);

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j11, boolean z11);

        public abstract void putByte(long j11, byte b11);

        public abstract void putByte(Object obj, long j11, byte b11);

        public abstract void putDouble(Object obj, long j11, double d11);

        public abstract void putFloat(Object obj, long j11, float f11);

        public abstract void putInt(long j11, int i11);

        public final void putInt(Object obj, long j11, int i11) {
            this.unsafe.putInt(obj, j11, i11);
        }

        public abstract void putLong(long j11, long j12);

        public final void putLong(Object obj, long j11, long j12) {
            this.unsafe.putLong(obj, j11, j12);
        }

        public final void putObject(Object obj, long j11, Object obj2) {
            this.unsafe.putObject(obj, j11, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Class<Object> cls = Object.class;
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls2 = unsafe2.getClass();
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
                return true;
            } catch (Throwable th2) {
                UnsafeUtil.logMissingMethod(th2);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe2 = this.unsafe;
            if (unsafe2 == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe2.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                if (UnsafeUtil.bufferAddressField() == null) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                UnsafeUtil.logMissingMethod(th2);
                return false;
            }
        }
    }

    static {
        Class<Object[]> cls = Object[].class;
        Class<double[]> cls2 = double[].class;
        Class<float[]> cls3 = float[].class;
        Class<long[]> cls4 = long[].class;
        Class<int[]> cls5 = int[].class;
        Class<boolean[]> cls6 = boolean[].class;
        long arrayBaseOffset = (long) arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        BOOLEAN_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls6);
        BOOLEAN_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls6);
        INT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls5);
        INT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls5);
        LONG_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls4);
        LONG_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls4);
        FLOAT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls3);
        FLOAT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls3);
        DOUBLE_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls2);
        DOUBLE_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls2);
        OBJECT_ARRAY_BASE_OFFSET = (long) arrayBaseOffset(cls);
        OBJECT_ARRAY_INDEX_SCALE = (long) arrayIndexScale(cls);
        BYTE_ARRAY_ALIGNMENT = (int) (7 & arrayBaseOffset);
    }

    private UnsafeUtil() {
    }

    public static long addressOffset(ByteBuffer byteBuffer) {
        return MEMORY_ACCESSOR.getLong(byteBuffer, BUFFER_ADDRESS_OFFSET);
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static Field bufferAddressField() {
        Field field;
        if (Android.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(Buffer.class, InnerShareParams.ADDRESS);
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    public static void copyMemory(byte[] bArr, long j11, long j12, long j13) {
        MEMORY_ACCESSOR.copyMemory(bArr, j11, j12, j13);
    }

    public static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls3 = MEMORY_CLASS;
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

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    private static int firstDifferingByteIndexNativeEndian(long j11, long j12) {
        int i11;
        if (IS_BIG_ENDIAN) {
            i11 = Long.numberOfLeadingZeros(j11 ^ j12);
        } else {
            i11 = Long.numberOfTrailingZeros(j11 ^ j12);
        }
        return i11 >> 3;
    }

    public static boolean getBoolean(Object obj, long j11) {
        return MEMORY_ACCESSOR.getBoolean(obj, j11);
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j11) {
        return getByteBigEndian(obj, j11) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j11) {
        return getByteLittleEndian(obj, j11) != 0;
    }

    public static byte getByte(Object obj, long j11) {
        return MEMORY_ACCESSOR.getByte(obj, j11);
    }

    /* access modifiers changed from: private */
    public static byte getByteBigEndian(Object obj, long j11) {
        return (byte) ((getInt(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3))) & 255);
    }

    /* access modifiers changed from: private */
    public static byte getByteLittleEndian(Object obj, long j11) {
        return (byte) ((getInt(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3))) & 255);
    }

    public static double getDouble(Object obj, long j11) {
        return MEMORY_ACCESSOR.getDouble(obj, j11);
    }

    public static float getFloat(Object obj, long j11) {
        return MEMORY_ACCESSOR.getFloat(obj, j11);
    }

    public static int getInt(Object obj, long j11) {
        return MEMORY_ACCESSOR.getInt(obj, j11);
    }

    public static long getLong(Object obj, long j11) {
        return MEMORY_ACCESSOR.getLong(obj, j11);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    public static Object getObject(Object obj, long j11) {
        return MEMORY_ACCESSOR.getObject(obj, j11);
    }

    public static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
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
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    /* access modifiers changed from: private */
    public static void logMissingMethod(Throwable th2) {
        Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
        Level level = Level.WARNING;
        logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th2);
    }

    public static int mismatch(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        if (i11 < 0 || i12 < 0 || i13 < 0 || i11 + i13 > bArr.length || i12 + i13 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i14 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            int i15 = (BYTE_ARRAY_ALIGNMENT + i11) & 7;
            while (i14 < i13 && (i15 & 7) != 0) {
                if (bArr[i11 + i14] != bArr2[i12 + i14]) {
                    return i14;
                }
                i14++;
                i15++;
            }
            int i16 = ((i13 - i14) & -8) + i14;
            while (i14 < i16) {
                long j11 = BYTE_ARRAY_BASE_OFFSET;
                long j12 = (long) i14;
                long j13 = getLong((Object) bArr, ((long) i11) + j11 + j12);
                long j14 = getLong((Object) bArr2, j11 + ((long) i12) + j12);
                if (j13 != j14) {
                    return i14 + firstDifferingByteIndexNativeEndian(j13, j14);
                }
                i14 += 8;
            }
        }
        while (i14 < i13) {
            if (bArr[i11 + i14] != bArr2[i12 + i14]) {
                return i14;
            }
            i14++;
        }
        return -1;
    }

    public static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    public static void putBoolean(Object obj, long j11, boolean z11) {
        MEMORY_ACCESSOR.putBoolean(obj, j11, z11);
    }

    /* access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j11, boolean z11) {
        putByteBigEndian(obj, j11, z11 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j11, boolean z11) {
        putByteLittleEndian(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static void putByte(Object obj, long j11, byte b11) {
        MEMORY_ACCESSOR.putByte(obj, j11, b11);
    }

    /* access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = getInt(obj, j12);
        int i12 = ((~((int) j11)) & 3) << 3;
        putInt(obj, j12, ((255 & b11) << i12) | (i11 & (~(255 << i12))));
    }

    /* access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        putInt(obj, j12, ((255 & b11) << i11) | (getInt(obj, j12) & (~(255 << i11))));
    }

    public static void putDouble(Object obj, long j11, double d11) {
        MEMORY_ACCESSOR.putDouble(obj, j11, d11);
    }

    public static void putFloat(Object obj, long j11, float f11) {
        MEMORY_ACCESSOR.putFloat(obj, j11, f11);
    }

    public static void putInt(Object obj, long j11, int i11) {
        MEMORY_ACCESSOR.putInt(obj, j11, i11);
    }

    public static void putLong(Object obj, long j11, long j12) {
        MEMORY_ACCESSOR.putLong(obj, j11, j12);
    }

    public static void putObject(Object obj, long j11, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j11, obj2);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }

    public static void copyMemory(long j11, byte[] bArr, long j12, long j13) {
        MEMORY_ACCESSOR.copyMemory(j11, bArr, j12, j13);
    }

    public static boolean getBoolean(boolean[] zArr, long j11) {
        return MEMORY_ACCESSOR.getBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j11 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    public static byte getByte(byte[] bArr, long j11) {
        return MEMORY_ACCESSOR.getByte(bArr, BYTE_ARRAY_BASE_OFFSET + j11);
    }

    public static double getDouble(double[] dArr, long j11) {
        return MEMORY_ACCESSOR.getDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j11 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    public static float getFloat(float[] fArr, long j11) {
        return MEMORY_ACCESSOR.getFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j11 * FLOAT_ARRAY_INDEX_SCALE));
    }

    public static int getInt(int[] iArr, long j11) {
        return MEMORY_ACCESSOR.getInt(iArr, INT_ARRAY_BASE_OFFSET + (j11 * INT_ARRAY_INDEX_SCALE));
    }

    public static long getLong(long[] jArr, long j11) {
        return MEMORY_ACCESSOR.getLong(jArr, LONG_ARRAY_BASE_OFFSET + (j11 * LONG_ARRAY_INDEX_SCALE));
    }

    public static Object getObject(Object[] objArr, long j11) {
        return MEMORY_ACCESSOR.getObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j11 * OBJECT_ARRAY_INDEX_SCALE));
    }

    public static void putBoolean(boolean[] zArr, long j11, boolean z11) {
        MEMORY_ACCESSOR.putBoolean(zArr, BOOLEAN_ARRAY_BASE_OFFSET + (j11 * BOOLEAN_ARRAY_INDEX_SCALE), z11);
    }

    public static void putByte(byte[] bArr, long j11, byte b11) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j11, b11);
    }

    public static void putDouble(double[] dArr, long j11, double d11) {
        MEMORY_ACCESSOR.putDouble(dArr, DOUBLE_ARRAY_BASE_OFFSET + (j11 * DOUBLE_ARRAY_INDEX_SCALE), d11);
    }

    public static void putFloat(float[] fArr, long j11, float f11) {
        MEMORY_ACCESSOR.putFloat(fArr, FLOAT_ARRAY_BASE_OFFSET + (j11 * FLOAT_ARRAY_INDEX_SCALE), f11);
    }

    public static void putInt(int[] iArr, long j11, int i11) {
        MEMORY_ACCESSOR.putInt(iArr, INT_ARRAY_BASE_OFFSET + (j11 * INT_ARRAY_INDEX_SCALE), i11);
    }

    public static void putLong(long[] jArr, long j11, long j12) {
        MEMORY_ACCESSOR.putLong(jArr, LONG_ARRAY_BASE_OFFSET + (j11 * LONG_ARRAY_INDEX_SCALE), j12);
    }

    public static void putObject(Object[] objArr, long j11, Object obj) {
        MEMORY_ACCESSOR.putObject(objArr, OBJECT_ARRAY_BASE_OFFSET + (j11 * OBJECT_ARRAY_INDEX_SCALE), obj);
    }

    public static void copyMemory(byte[] bArr, long j11, byte[] bArr2, long j12, long j13) {
        System.arraycopy(bArr, (int) j11, bArr2, (int) j12, (int) j13);
    }

    public static byte getByte(long j11) {
        return MEMORY_ACCESSOR.getByte(j11);
    }

    public static int getInt(long j11) {
        return MEMORY_ACCESSOR.getInt(j11);
    }

    public static long getLong(long j11) {
        return MEMORY_ACCESSOR.getLong(j11);
    }

    public static void putByte(long j11, byte b11) {
        MEMORY_ACCESSOR.putByte(j11, b11);
    }

    public static void putInt(long j11, int i11) {
        MEMORY_ACCESSOR.putInt(j11, i11);
    }

    public static void putLong(long j11, long j12) {
        MEMORY_ACCESSOR.putLong(j11, j12);
    }
}
