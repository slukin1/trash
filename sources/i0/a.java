package i0;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f15939a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    public static final long[] f15940b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Object[] f15941c = new Object[0];

    public static int a(int[] iArr, int i11, int i12) {
        int i13 = i11 - 1;
        int i14 = 0;
        while (i14 <= i13) {
            int i15 = (i14 + i13) >>> 1;
            int i16 = iArr[i15];
            if (i16 < i12) {
                i14 = i15 + 1;
            } else if (i16 <= i12) {
                return i15;
            } else {
                i13 = i15 - 1;
            }
        }
        return ~i14;
    }

    public static int b(long[] jArr, int i11, long j11) {
        int i12 = i11 - 1;
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) >>> 1;
            int i15 = (jArr[i14] > j11 ? 1 : (jArr[i14] == j11 ? 0 : -1));
            if (i15 < 0) {
                i13 = i14 + 1;
            } else if (i15 <= 0) {
                return i14;
            } else {
                i12 = i14 - 1;
            }
        }
        return ~i13;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int d(int i11) {
        for (int i12 = 4; i12 < 32; i12++) {
            int i13 = (1 << i12) - 12;
            if (i11 <= i13) {
                return i13;
            }
        }
        return i11;
    }

    public static int e(int i11) {
        return d(i11 * 4) / 4;
    }

    public static int f(int i11) {
        return d(i11 * 8) / 8;
    }
}
