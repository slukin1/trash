package com.google.common.hash;

import com.google.common.base.Ascii;
import com.google.common.primitives.Longs;
import java.nio.ByteOrder;
import sun.misc.Unsafe;

final class LittleEndianByteArray {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray;

    public enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE {
            public long getLongLittleEndian(byte[] bArr, int i11) {
                return Longs.fromBytes(bArr[i11 + 7], bArr[i11 + 6], bArr[i11 + 5], bArr[i11 + 4], bArr[i11 + 3], bArr[i11 + 2], bArr[i11 + 1], bArr[i11]);
            }

            public void putLongLittleEndian(byte[] bArr, int i11, long j11) {
                long j12 = 255;
                for (int i12 = 0; i12 < 8; i12++) {
                    bArr[i11 + i12] = (byte) ((int) ((j11 & j12) >> (i12 * 8)));
                    j12 <<= 8;
                }
            }
        }
    }

    public interface LittleEndianBytes {
        long getLongLittleEndian(byte[] bArr, int i11);

        void putLongLittleEndian(byte[] bArr, int i11, long j11);
    }

    public enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN {
            public long getLongLittleEndian(byte[] bArr, int i11) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i11) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            public void putLongLittleEndian(byte[] bArr, int i11, long j11) {
                UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i11) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), j11);
            }
        },
        UNSAFE_BIG_ENDIAN {
            public long getLongLittleEndian(byte[] bArr, int i11) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i11) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET)));
            }

            public void putLongLittleEndian(byte[] bArr, int i11, long j11) {
                long reverseBytes = Long.reverseBytes(j11);
                UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i11) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), reverseBytes);
            }
        };
        
        /* access modifiers changed from: private */
        public static final int BYTE_ARRAY_BASE_OFFSET = 0;
        /* access modifiers changed from: private */
        public static final Unsafe theUnsafe = null;

        /* access modifiers changed from: public */
        static {
            Class<byte[]> cls;
            Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(cls);
            if (unsafe.arrayIndexScale(cls) != 1) {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
            return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.AnonymousClass3());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static sun.misc.Unsafe getUnsafe() {
            /*
                sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                return r0
            L_0x0005:
                com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3 r0 = new com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3     // Catch:{ PrivilegedActionException -> 0x0011 }
                r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
                java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
                sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
                return r0
            L_0x0011:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.getUnsafe():sun.misc.Unsafe");
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        byteArray = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }

    public static int load32(byte[] bArr, int i11) {
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << 16);
    }

    public static long load64(byte[] bArr, int i11) {
        return byteArray.getLongLittleEndian(bArr, i11);
    }

    public static long load64Safely(byte[] bArr, int i11, int i12) {
        int min = Math.min(i12, 8);
        long j11 = 0;
        for (int i13 = 0; i13 < min; i13++) {
            j11 |= (((long) bArr[i11 + i13]) & 255) << (i13 * 8);
        }
        return j11;
    }

    public static void store64(byte[] bArr, int i11, long j11) {
        byteArray.putLongLittleEndian(bArr, i11, j11);
    }

    public static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }
}
