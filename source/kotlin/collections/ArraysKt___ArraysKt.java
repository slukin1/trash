package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.x;
import kotlin.l;

class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {

    public static final class a implements Iterable<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object[] f56632b;

        public a(Object[] objArr) {
            this.f56632b = objArr;
        }

        public Iterator<T> iterator() {
            return h.a(this.f56632b);
        }
    }

    public static boolean A(int[] iArr, int i11) {
        return O(iArr, i11) >= 0;
    }

    public static final List<Double> A0(double[] dArr) {
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double valueOf : dArr) {
            arrayList.add(Double.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean B(long[] jArr, long j11) {
        return P(jArr, j11) >= 0;
    }

    public static final List<Float> B0(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float valueOf : fArr) {
            arrayList.add(Float.valueOf(valueOf));
        }
        return arrayList;
    }

    public static <T> boolean C(T[] tArr, T t11) {
        return Q(tArr, t11) >= 0;
    }

    public static final List<Integer> C0(int[] iArr) {
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public static boolean D(short[] sArr, short s11) {
        return R(sArr, s11) >= 0;
    }

    public static final List<Long> D0(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long valueOf : jArr) {
            arrayList.add(Long.valueOf(valueOf));
        }
        return arrayList;
    }

    public static <T> List<T> E(T[] tArr, int i11) {
        if (i11 >= 0) {
            return q0(tArr, RangesKt___RangesKt.d(tArr.length - i11, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static <T> List<T> E0(T[] tArr) {
        return new ArrayList(CollectionsKt__CollectionsKt.h(tArr));
    }

    public static <T> List<T> F(T[] tArr) {
        return (List) G(tArr, new ArrayList());
    }

    public static final List<Short> F0(short[] sArr) {
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short valueOf : sArr) {
            arrayList.add(Short.valueOf(valueOf));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super T>, T> C G(T[] tArr, C c11) {
        for (T t11 : tArr) {
            if (t11 != null) {
                c11.add(t11);
            }
        }
        return c11;
    }

    public static final <T> Set<T> G0(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return SetsKt__SetsKt.d();
        }
        if (length != 1) {
            return (Set) r0(tArr, new LinkedHashSet(MapsKt__MapsJVMKt.d(tArr.length)));
        }
        return SetsKt__SetsJVMKt.c(tArr[0]);
    }

    public static float H(float[] fArr) {
        if (!(fArr.length == 0)) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> Iterable<m<T>> H0(T[] tArr) {
        return new n(new ArraysKt___ArraysKt$withIndex$1(tArr));
    }

    public static <T> T I(T[] tArr) {
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T, R> List<Pair<T, R>> I0(T[] tArr, R[] rArr) {
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i11 = 0; i11 < min; i11++) {
            arrayList.add(l.a(tArr[i11], rArr[i11]));
        }
        return arrayList;
    }

    public static final int J(byte[] bArr) {
        return bArr.length - 1;
    }

    public static int K(long[] jArr) {
        return jArr.length - 1;
    }

    public static <T> int L(T[] tArr) {
        return tArr.length - 1;
    }

    public static <T> T M(T[] tArr, int i11) {
        if (i11 < 0 || i11 > L(tArr)) {
            return null;
        }
        return tArr[i11];
    }

    public static final int N(byte[] bArr, byte b11) {
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (b11 == bArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final int O(int[] iArr, int i11) {
        int length = iArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            if (i11 == iArr[i12]) {
                return i12;
            }
        }
        return -1;
    }

    public static final int P(long[] jArr, long j11) {
        int length = jArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (j11 == jArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static <T> int Q(T[] tArr, T t11) {
        int i11 = 0;
        if (t11 == null) {
            int length = tArr.length;
            while (i11 < length) {
                if (tArr[i11] == null) {
                    return i11;
                }
                i11++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i11 < length2) {
            if (x.b(t11, tArr[i11])) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static final int R(short[] sArr, short s11) {
        int length = sArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (s11 == sArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public static final <A extends Appendable> A S(double[] dArr, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Double, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (double d11 : dArr) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            if (lVar != null) {
                a11.append((CharSequence) lVar.invoke(Double.valueOf(d11)));
            } else {
                a11.append(String.valueOf(d11));
            }
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final <A extends Appendable> A T(float[] fArr, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Float, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (float f11 : fArr) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            if (lVar != null) {
                a11.append((CharSequence) lVar.invoke(Float.valueOf(f11)));
            } else {
                a11.append(String.valueOf(f11));
            }
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final <A extends Appendable> A U(int[] iArr, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Integer, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (int i13 : iArr) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            if (lVar != null) {
                a11.append((CharSequence) lVar.invoke(Integer.valueOf(i13)));
            } else {
                a11.append(String.valueOf(i13));
            }
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final <A extends Appendable> A V(long[] jArr, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Long, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (long j11 : jArr) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            if (lVar != null) {
                a11.append((CharSequence) lVar.invoke(Long.valueOf(j11)));
            } else {
                a11.append(String.valueOf(j11));
            }
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final <T, A extends Appendable> A W(T[] tArr, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super T, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (T t11 : tArr) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            StringsKt__AppendableKt.a(a11, t11, lVar);
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final <A extends Appendable> A X(short[] sArr, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Short, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (short s11 : sArr) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            if (lVar != null) {
                a11.append((CharSequence) lVar.invoke(Short.valueOf(s11)));
            } else {
                a11.append(String.valueOf(s11));
            }
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final String Y(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Double, ? extends CharSequence> lVar) {
        return ((StringBuilder) S(dArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static final String Z(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Float, ? extends CharSequence> lVar) {
        return ((StringBuilder) T(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static final String a0(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Integer, ? extends CharSequence> lVar) {
        return ((StringBuilder) U(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static final String b0(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Long, ? extends CharSequence> lVar) {
        return ((StringBuilder) V(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static final <T> String c0(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super T, ? extends CharSequence> lVar) {
        return ((StringBuilder) W(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static final String d0(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super Short, ? extends CharSequence> lVar) {
        return ((StringBuilder) X(sArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String e0(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return Y(dArr, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static /* synthetic */ String f0(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return Z(fArr, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static /* synthetic */ String g0(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return a0(iArr, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static /* synthetic */ String h0(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return b0(jArr, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static /* synthetic */ String i0(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return c0(objArr, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static /* synthetic */ String j0(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return d0(sArr, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static <T> T k0(T[] tArr) {
        if (!(tArr.length == 0)) {
            return tArr[L(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int l0(byte[] bArr, byte b11) {
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (b11 == bArr[length]) {
                    return length;
                }
                if (i11 < 0) {
                    break;
                }
                length = i11;
            }
        }
        return -1;
    }

    public static byte[] m0(byte[] bArr) {
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int J = J(bArr);
        IntIterator d11 = new kotlin.ranges.h(0, J).iterator();
        while (d11.hasNext()) {
            int a11 = d11.a();
            bArr2[J - a11] = bArr[a11];
        }
        return bArr2;
    }

    public static char n0(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static <T> T o0(T[] tArr) {
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static List<Byte> p0(byte[] bArr, kotlin.ranges.h hVar) {
        if (hVar.isEmpty()) {
            return CollectionsKt__CollectionsKt.k();
        }
        return ArraysKt___ArraysJvmKt.c(ArraysKt___ArraysJvmKt.i(bArr, hVar.j().intValue(), hVar.i().intValue() + 1));
    }

    public static final <T> List<T> q0(T[] tArr, int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        } else if (i11 == 0) {
            return CollectionsKt__CollectionsKt.k();
        } else {
            int length = tArr.length;
            if (i11 >= length) {
                return x0(tArr);
            }
            if (i11 == 1) {
                return CollectionsKt__CollectionsJVMKt.e(tArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = length - i11; i12 < length; i12++) {
                arrayList.add(tArr[i12]);
            }
            return arrayList;
        }
    }

    public static final <T, C extends Collection<? super T>> C r0(T[] tArr, C c11) {
        for (T add : tArr) {
            c11.add(add);
        }
        return c11;
    }

    public static List<Byte> s0(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return z0(bArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(Byte.valueOf(bArr[0]));
    }

    public static List<Double> t0(double[] dArr) {
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return A0(dArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(Double.valueOf(dArr[0]));
    }

    public static List<Float> u0(float[] fArr) {
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return B0(fArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(Float.valueOf(fArr[0]));
    }

    public static List<Integer> v0(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return C0(iArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(Integer.valueOf(iArr[0]));
    }

    public static List<Long> w0(long[] jArr) {
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return D0(jArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(Long.valueOf(jArr[0]));
    }

    public static <T> List<T> x0(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return E0(tArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(tArr[0]);
    }

    public static <T> Iterable<T> y(T[] tArr) {
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        return new a(tArr);
    }

    public static List<Short> y0(short[] sArr) {
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return F0(sArr);
        }
        return CollectionsKt__CollectionsJVMKt.e(Short.valueOf(sArr[0]));
    }

    public static boolean z(byte[] bArr, byte b11) {
        return N(bArr, b11) >= 0;
    }

    public static final List<Byte> z0(byte[] bArr) {
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte valueOf : bArr) {
            arrayList.add(Byte.valueOf(valueOf));
        }
        return arrayList;
    }
}
