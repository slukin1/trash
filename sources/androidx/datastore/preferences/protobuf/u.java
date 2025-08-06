package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f9213a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f9214b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f9215c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f9216d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f9217e;

    public interface a extends i<Boolean> {
    }

    public interface b extends i<Double> {
    }

    public interface c {
        int getNumber();
    }

    public interface d<T extends c> {
        T findValueByNumber(int i11);
    }

    public interface e {
        boolean isInRange(int i11);
    }

    public interface f extends i<Float> {
    }

    public interface g extends i<Integer> {
    }

    public interface h extends i<Long> {
    }

    public interface i<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        i<E> mutableCopyWithCapacity(int i11);
    }

    static {
        byte[] bArr = new byte[0];
        f9215c = bArr;
        f9216d = ByteBuffer.wrap(bArr);
        f9217e = g.i(bArr);
    }

    public static <T> T a(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static <T> T b(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static int c(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static int e(byte[] bArr, int i11, int i12) {
        int i13 = i(i12, bArr, i11, i12);
        if (i13 == 0) {
            return 1;
        }
        return i13;
    }

    public static int f(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.s(bArr);
    }

    public static Object h(Object obj, Object obj2) {
        return ((f0) obj).toBuilder().a((f0) obj2).buildPartial();
    }

    public static int i(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static String j(byte[] bArr) {
        return new String(bArr, f9213a);
    }
}
