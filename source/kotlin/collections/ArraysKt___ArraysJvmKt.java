package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {

    public static final class a extends a<Byte> implements RandomAccess {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ byte[] f56631b;

        public a(byte[] bArr) {
            this.f56631b = bArr;
        }

        public boolean a(byte b11) {
            return ArraysKt___ArraysKt.z(this.f56631b, b11);
        }

        /* renamed from: b */
        public Byte get(int i11) {
            return Byte.valueOf(this.f56631b[i11]);
        }

        public int c(byte b11) {
            return ArraysKt___ArraysKt.N(this.f56631b, b11);
        }

        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof Byte)) {
                return false;
            }
            return a(((Number) obj).byteValue());
        }

        public int d(byte b11) {
            return ArraysKt___ArraysKt.l0(this.f56631b, b11);
        }

        public int getSize() {
            return this.f56631b.length;
        }

        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return c(((Number) obj).byteValue());
        }

        public boolean isEmpty() {
            return this.f56631b.length == 0;
        }

        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof Byte)) {
                return -1;
            }
            return d(((Number) obj).byteValue());
        }
    }

    public static List<Byte> c(byte[] bArr) {
        return new a(bArr);
    }

    public static <T> List<T> d(T[] tArr) {
        return i.a(tArr);
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i11, int i12, int i13) {
        System.arraycopy(bArr, i12, bArr2, i11, i13 - i12);
        return bArr2;
    }

    public static <T> T[] f(T[] tArr, T[] tArr2, int i11, int i12, int i13) {
        System.arraycopy(tArr, i12, tArr2, i11, i13 - i12);
        return tArr2;
    }

    public static /* synthetic */ byte[] g(byte[] bArr, byte[] bArr2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = bArr.length;
        }
        return e(bArr, bArr2, i11, i12, i13);
    }

    public static /* synthetic */ Object[] h(Object[] objArr, Object[] objArr2, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i11 = 0;
        }
        if ((i14 & 4) != 0) {
            i12 = 0;
        }
        if ((i14 & 8) != 0) {
            i13 = objArr.length;
        }
        return f(objArr, objArr2, i11, i12, i13);
    }

    public static byte[] i(byte[] bArr, int i11, int i12) {
        ArraysKt__ArraysJVMKt.b(i12, bArr.length);
        return Arrays.copyOfRange(bArr, i11, i12);
    }

    public static <T> T[] j(T[] tArr, int i11, int i12) {
        ArraysKt__ArraysJVMKt.b(i12, tArr.length);
        return Arrays.copyOfRange(tArr, i11, i12);
    }

    public static final void k(byte[] bArr, byte b11, int i11, int i12) {
        Arrays.fill(bArr, i11, i12, b11);
    }

    public static void l(int[] iArr, int i11, int i12, int i13) {
        Arrays.fill(iArr, i12, i13, i11);
    }

    public static <T> void m(T[] tArr, T t11, int i11, int i12) {
        Arrays.fill(tArr, i11, i12, t11);
    }

    public static /* synthetic */ void n(byte[] bArr, byte b11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = bArr.length;
        }
        k(bArr, b11, i11, i12);
    }

    public static /* synthetic */ void o(int[] iArr, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 2) != 0) {
            i12 = 0;
        }
        if ((i14 & 4) != 0) {
            i13 = iArr.length;
        }
        l(iArr, i11, i12, i13);
    }

    public static /* synthetic */ void p(Object[] objArr, Object obj, int i11, int i12, int i13, Object obj2) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = objArr.length;
        }
        m(objArr, obj, i11, i12);
    }

    public static byte[] q(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static float[] r(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] copyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static int[] s(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] copyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static long[] t(long[] jArr, long[] jArr2) {
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] copyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static <T> T[] u(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] copyOf = Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static boolean[] v(boolean[] zArr, boolean[] zArr2) {
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] copyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    public static final <T> void w(T[] tArr) {
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final <T> void x(T[] tArr, Comparator<? super T> comparator) {
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
