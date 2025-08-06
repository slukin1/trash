package kotlin.text;

import com.jumio.commons.log.LogUtils;
import com.sumsub.sns.internal.core.analytics.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CharIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.x;
import kotlin.l;
import kotlin.ranges.f;
import kotlin.ranges.h;
import kotlin.sequences.g;

class StringsKt__StringsKt extends StringsKt__StringsJVMKt {

    public static final class a extends CharIterator {

        /* renamed from: b  reason: collision with root package name */
        public int f56905b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CharSequence f56906c;

        public a(CharSequence charSequence) {
            this.f56906c = charSequence;
        }

        public char a() {
            CharSequence charSequence = this.f56906c;
            int i11 = this.f56905b;
            this.f56905b = i11 + 1;
            return charSequence.charAt(i11);
        }

        public boolean hasNext() {
            return this.f56905b < this.f56906c.length();
        }
    }

    public static String A0(String str, CharSequence charSequence) {
        return R0(str, charSequence, false, 2, (Object) null) ? str.substring(charSequence.length()) : str;
    }

    public static CharSequence B0(CharSequence charSequence, int i11, int i12) {
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("End index (" + i12 + ") is less than start index (" + i11 + ").");
        } else if (i12 == i11) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence.length() - (i12 - i11));
            sb2.append(charSequence, 0, i11);
            sb2.append(charSequence, i12, charSequence.length());
            return sb2;
        }
    }

    public static String C0(String str, CharSequence charSequence) {
        return X(str, charSequence, false, 2, (Object) null) ? str.substring(0, str.length() - charSequence.length()) : str;
    }

    public static String D0(String str, CharSequence charSequence) {
        return E0(str, charSequence, charSequence);
    }

    public static final String E0(String str, CharSequence charSequence, CharSequence charSequence2) {
        return (str.length() < charSequence.length() + charSequence2.length() || !R0(str, charSequence, false, 2, (Object) null) || !X(str, charSequence2, false, 2, (Object) null)) ? str : str.substring(charSequence.length(), str.length() - charSequence2.length());
    }

    public static CharSequence F0(CharSequence charSequence, int i11, int i12, CharSequence charSequence2) {
        if (i12 >= i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i11);
            sb2.append(charSequence2);
            sb2.append(charSequence, i12, charSequence.length());
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i12 + ") is less than start index (" + i11 + ").");
    }

    public static final void G0(int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i11).toString());
        }
    }

    public static final List<String> H0(CharSequence charSequence, char[] cArr, boolean z11, int i11) {
        if (cArr.length == 1) {
            return J0(charSequence, String.valueOf(cArr[0]), z11, i11);
        }
        Iterable<h> h11 = SequencesKt___SequencesKt.h(x0(charSequence, cArr, 0, z11, i11, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(h11, 10));
        for (h S0 : h11) {
            arrayList.add(S0(charSequence, S0));
        }
        return arrayList;
    }

    public static final List<String> I0(CharSequence charSequence, String[] strArr, boolean z11, int i11) {
        boolean z12 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z12 = false;
            }
            if (!z12) {
                return J0(charSequence, str, z11, i11);
            }
        }
        Iterable<h> h11 = SequencesKt___SequencesKt.h(y0(charSequence, strArr, 0, z11, i11, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(h11, 10));
        for (h S0 : h11) {
            arrayList.add(S0(charSequence, S0));
        }
        return arrayList;
    }

    public static final List<String> J0(CharSequence charSequence, String str, boolean z11, int i11) {
        G0(i11);
        int i12 = 0;
        int c02 = c0(charSequence, str, 0, z11);
        if (c02 == -1 || i11 == 1) {
            return CollectionsKt__CollectionsJVMKt.e(charSequence.toString());
        }
        boolean z12 = i11 > 0;
        int i13 = 10;
        if (z12) {
            i13 = RangesKt___RangesKt.g(i11, 10);
        }
        ArrayList arrayList = new ArrayList(i13);
        do {
            arrayList.add(charSequence.subSequence(i12, c02).toString());
            i12 = str.length() + c02;
            if ((z12 && arrayList.size() == i11 - 1) || (c02 = c0(charSequence, str, i12, z11)) == -1) {
                arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i12, c02).toString());
            i12 = str.length() + c02;
            break;
        } while ((c02 = c0(charSequence, str, i12, z11)) == -1);
        arrayList.add(charSequence.subSequence(i12, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List K0(CharSequence charSequence, char[] cArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return H0(charSequence, cArr, z11, i11);
    }

    public static /* synthetic */ List L0(CharSequence charSequence, String[] strArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return I0(charSequence, strArr, z11, i11);
    }

    public static final g<String> M0(CharSequence charSequence, String[] strArr, boolean z11, int i11) {
        return SequencesKt___SequencesKt.s(y0(charSequence, strArr, 0, z11, i11, 2, (Object) null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
    }

    public static /* synthetic */ g N0(CharSequence charSequence, String[] strArr, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z11 = false;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return M0(charSequence, strArr, z11, i11);
    }

    public static final boolean O(CharSequence charSequence, char c11, boolean z11) {
        return f0(charSequence, c11, 0, z11, 2, (Object) null) >= 0;
    }

    public static final boolean O0(CharSequence charSequence, char c11, boolean z11) {
        return charSequence.length() > 0 && CharsKt__CharKt.e(charSequence.charAt(0), c11, z11);
    }

    public static boolean P(CharSequence charSequence, CharSequence charSequence2, boolean z11) {
        if (charSequence2 instanceof String) {
            if (g0(charSequence, (String) charSequence2, 0, z11, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (e0(charSequence, charSequence2, 0, charSequence.length(), z11, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean P0(CharSequence charSequence, CharSequence charSequence2, boolean z11) {
        if (!z11 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.M((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return z0(charSequence, 0, charSequence2, 0, charSequence2.length(), z11);
    }

    public static /* synthetic */ boolean Q(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return O(charSequence, c11, z11);
    }

    public static /* synthetic */ boolean Q0(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return O0(charSequence, c11, z11);
    }

    public static /* synthetic */ boolean R(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return P(charSequence, charSequence2, z11);
    }

    public static /* synthetic */ boolean R0(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return P0(charSequence, charSequence2, z11);
    }

    public static final boolean S(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.w((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!CharsKt__CharKt.e(charSequence.charAt(i11), charSequence2.charAt(i11), true)) {
                return false;
            }
        }
        return true;
    }

    public static final String S0(CharSequence charSequence, h hVar) {
        return charSequence.subSequence(hVar.j().intValue(), hVar.i().intValue() + 1).toString();
    }

    public static final boolean T(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return x.b(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (charSequence.charAt(i11) != charSequence2.charAt(i11)) {
                return false;
            }
        }
        return true;
    }

    public static final String T0(String str, char c11, String str2) {
        int f02 = f0(str, c11, 0, false, 6, (Object) null);
        return f02 == -1 ? str2 : str.substring(f02 + 1, str.length());
    }

    public static final boolean U(CharSequence charSequence, char c11, boolean z11) {
        return charSequence.length() > 0 && CharsKt__CharKt.e(charSequence.charAt(a0(charSequence)), c11, z11);
    }

    public static final String U0(String str, String str2, String str3) {
        int g02 = g0(str, str2, 0, false, 6, (Object) null);
        return g02 == -1 ? str3 : str.substring(g02 + str2.length(), str.length());
    }

    public static final boolean V(CharSequence charSequence, CharSequence charSequence2, boolean z11) {
        if (!z11 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt__StringsJVMKt.v((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return z0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z11);
    }

    public static /* synthetic */ String V0(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return T0(str, c11, str2);
    }

    public static /* synthetic */ boolean W(CharSequence charSequence, char c11, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return U(charSequence, c11, z11);
    }

    public static /* synthetic */ String W0(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return U0(str, str2, str3);
    }

    public static /* synthetic */ boolean X(CharSequence charSequence, CharSequence charSequence2, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return V(charSequence, charSequence2, z11);
    }

    public static String X0(String str, char c11, String str2) {
        int l02 = l0(str, c11, 0, false, 6, (Object) null);
        return l02 == -1 ? str2 : str.substring(l02 + 1, str.length());
    }

    public static final Pair<Integer, String> Y(CharSequence charSequence, Collection<String> collection, int i11, boolean z11, boolean z12) {
        T t11;
        T t12;
        if (z11 || collection.size() != 1) {
            f hVar = !z12 ? new h(RangesKt___RangesKt.d(i11, 0), charSequence.length()) : RangesKt___RangesKt.l(RangesKt___RangesKt.g(i11, a0(charSequence)), 0);
            if (charSequence instanceof String) {
                int a11 = hVar.a();
                int b11 = hVar.b();
                int c11 = hVar.c();
                if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
                    while (true) {
                        Iterator<T> it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                t12 = null;
                                break;
                            }
                            t12 = it2.next();
                            String str = (String) t12;
                            if (StringsKt__StringsJVMKt.A(str, 0, (String) charSequence, a11, str.length(), z11)) {
                                break;
                            }
                        }
                        String str2 = (String) t12;
                        if (str2 == null) {
                            if (a11 == b11) {
                                break;
                            }
                            a11 += c11;
                        } else {
                            return l.a(Integer.valueOf(a11), str2);
                        }
                    }
                }
            } else {
                int a12 = hVar.a();
                int b12 = hVar.b();
                int c12 = hVar.c();
                if ((c12 > 0 && a12 <= b12) || (c12 < 0 && b12 <= a12)) {
                    while (true) {
                        Iterator<T> it3 = collection.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                t11 = null;
                                break;
                            }
                            t11 = it3.next();
                            String str3 = (String) t11;
                            if (z0(str3, 0, charSequence, a12, str3.length(), z11)) {
                                break;
                            }
                        }
                        String str4 = (String) t11;
                        if (str4 == null) {
                            if (a12 == b12) {
                                break;
                            }
                            a12 += c12;
                        } else {
                            return l.a(Integer.valueOf(a12), str4);
                        }
                    }
                }
            }
            return null;
        }
        String str5 = (String) CollectionsKt___CollectionsKt.v0(collection);
        CharSequence charSequence2 = charSequence;
        String str6 = str5;
        int i12 = i11;
        int g02 = !z12 ? g0(charSequence2, str6, i12, false, 4, (Object) null) : m0(charSequence2, str6, i12, false, 4, (Object) null);
        if (g02 < 0) {
            return null;
        }
        return l.a(Integer.valueOf(g02), str5);
    }

    public static final String Y0(String str, String str2, String str3) {
        int m02 = m0(str, str2, 0, false, 6, (Object) null);
        return m02 == -1 ? str3 : str.substring(m02 + str2.length(), str.length());
    }

    public static final h Z(CharSequence charSequence) {
        return new h(0, charSequence.length() - 1);
    }

    public static /* synthetic */ String Z0(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return X0(str, c11, str2);
    }

    public static int a0(CharSequence charSequence) {
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String a1(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return Y0(str, str2, str3);
    }

    public static final int b0(CharSequence charSequence, char c11, int i11, boolean z11) {
        if (!z11 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c11, i11);
        }
        return h0(charSequence, new char[]{c11}, i11, z11);
    }

    public static final String b1(String str, char c11, String str2) {
        int f02 = f0(str, c11, 0, false, 6, (Object) null);
        return f02 == -1 ? str2 : str.substring(0, f02);
    }

    public static final int c0(CharSequence charSequence, String str, int i11, boolean z11) {
        if (!z11 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i11);
        }
        return e0(charSequence, str, i11, charSequence.length(), z11, false, 16, (Object) null);
    }

    public static final String c1(String str, String str2, String str3) {
        int g02 = g0(str, str2, 0, false, 6, (Object) null);
        return g02 == -1 ? str3 : str.substring(0, g02);
    }

    public static final int d0(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z11, boolean z12) {
        f fVar;
        if (!z12) {
            fVar = new h(RangesKt___RangesKt.d(i11, 0), RangesKt___RangesKt.g(i12, charSequence.length()));
        } else {
            fVar = RangesKt___RangesKt.l(RangesKt___RangesKt.g(i11, a0(charSequence)), RangesKt___RangesKt.d(i12, 0));
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a11 = fVar.a();
            int b11 = fVar.b();
            int c11 = fVar.c();
            if ((c11 <= 0 || a11 > b11) && (c11 >= 0 || b11 > a11)) {
                return -1;
            }
            while (true) {
                if (z0(charSequence2, 0, charSequence, a11, charSequence2.length(), z11)) {
                    return a11;
                }
                if (a11 == b11) {
                    return -1;
                }
                a11 += c11;
            }
        } else {
            int a12 = fVar.a();
            int b12 = fVar.b();
            int c12 = fVar.c();
            if ((c12 <= 0 || a12 > b12) && (c12 >= 0 || b12 > a12)) {
                return -1;
            }
            while (true) {
                if (StringsKt__StringsJVMKt.A((String) charSequence2, 0, (String) charSequence, a12, charSequence2.length(), z11)) {
                    return a12;
                }
                if (a12 == b12) {
                    return -1;
                }
                a12 += c12;
            }
        }
    }

    public static /* synthetic */ String d1(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return b1(str, c11, str2);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, CharSequence charSequence2, int i11, int i12, boolean z11, boolean z12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            z12 = false;
        }
        return d0(charSequence, charSequence2, i11, i12, z11, z12);
    }

    public static /* synthetic */ String e1(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str3 = str;
        }
        return c1(str, str2, str3);
    }

    public static /* synthetic */ int f0(CharSequence charSequence, char c11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return b0(charSequence, c11, i11, z11);
    }

    public static final String f1(String str, char c11, String str2) {
        int l02 = l0(str, c11, 0, false, 6, (Object) null);
        return l02 == -1 ? str2 : str.substring(0, l02);
    }

    public static /* synthetic */ int g0(CharSequence charSequence, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return c0(charSequence, str, i11, z11);
    }

    public static /* synthetic */ String g1(String str, char c11, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = str;
        }
        return f1(str, c11, str2);
    }

    public static final int h0(CharSequence charSequence, char[] cArr, int i11, boolean z11) {
        boolean z12;
        if (z11 || cArr.length != 1 || !(charSequence instanceof String)) {
            IntIterator d11 = new h(RangesKt___RangesKt.d(i11, 0), a0(charSequence)).iterator();
            while (d11.hasNext()) {
                int a11 = d11.a();
                char charAt = charSequence.charAt(a11);
                int length = cArr.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        z12 = false;
                        continue;
                        break;
                    } else if (CharsKt__CharKt.e(cArr[i12], charAt, z11)) {
                        z12 = true;
                        continue;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (z12) {
                    return a11;
                }
            }
            return -1;
        }
        return ((String) charSequence).indexOf(ArraysKt___ArraysKt.n0(cArr), i11);
    }

    public static Boolean h1(String str) {
        if (x.b(str, "true")) {
            return Boolean.TRUE;
        }
        if (x.b(str, d.f31895b)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final CharIterator i0(CharSequence charSequence) {
        return new a(charSequence);
    }

    public static CharSequence i1(CharSequence charSequence) {
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z11 = false;
        while (i11 <= length) {
            boolean c11 = CharsKt__CharJVMKt.c(charSequence.charAt(!z11 ? i11 : length));
            if (!z11) {
                if (!c11) {
                    z11 = true;
                } else {
                    i11++;
                }
            } else if (!c11) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static final int j0(CharSequence charSequence, char c11, int i11, boolean z11) {
        if (!z11 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c11, i11);
        }
        return n0(charSequence, new char[]{c11}, i11, z11);
    }

    public static CharSequence j1(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            if (!CharsKt__CharJVMKt.c(charSequence.charAt(i11))) {
                return charSequence.subSequence(i11, charSequence.length());
            }
        }
        return "";
    }

    public static final int k0(CharSequence charSequence, String str, int i11, boolean z11) {
        if (z11 || !(charSequence instanceof String)) {
            return d0(charSequence, str, i11, 0, z11, true);
        }
        return ((String) charSequence).lastIndexOf(str, i11);
    }

    public static /* synthetic */ int l0(CharSequence charSequence, char c11, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = a0(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return j0(charSequence, c11, i11, z11);
    }

    public static /* synthetic */ int m0(CharSequence charSequence, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = a0(charSequence);
        }
        if ((i12 & 4) != 0) {
            z11 = false;
        }
        return k0(charSequence, str, i11, z11);
    }

    public static final int n0(CharSequence charSequence, char[] cArr, int i11, boolean z11) {
        if (z11 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int g11 = RangesKt___RangesKt.g(i11, a0(charSequence)); -1 < g11; g11--) {
                char charAt = charSequence.charAt(g11);
                int length = cArr.length;
                boolean z12 = false;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (CharsKt__CharKt.e(cArr[i12], charAt, z11)) {
                        z12 = true;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (z12) {
                    return g11;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(ArraysKt___ArraysKt.n0(cArr), i11);
    }

    public static final g<String> o0(CharSequence charSequence) {
        return N0(charSequence, new String[]{LogUtils.NEW_LINE, "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> p0(CharSequence charSequence) {
        return SequencesKt___SequencesKt.w(o0(charSequence));
    }

    public static final CharSequence q0(CharSequence charSequence, int i11, char c11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Desired length " + i11 + " is less than zero.");
        } else if (i11 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i11);
            sb2.append(charSequence);
            IntIterator d11 = new h(1, i11 - charSequence.length()).iterator();
            while (d11.hasNext()) {
                d11.a();
                sb2.append(c11);
            }
            return sb2;
        }
    }

    public static final String r0(String str, int i11, char c11) {
        return q0(str, i11, c11).toString();
    }

    public static /* synthetic */ String s0(String str, int i11, char c11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            c11 = ' ';
        }
        return r0(str, i11, c11);
    }

    public static final CharSequence t0(CharSequence charSequence, int i11, char c11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("Desired length " + i11 + " is less than zero.");
        } else if (i11 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i11);
            IntIterator d11 = new h(1, i11 - charSequence.length()).iterator();
            while (d11.hasNext()) {
                d11.a();
                sb2.append(c11);
            }
            sb2.append(charSequence);
            return sb2;
        }
    }

    public static String u0(String str, int i11, char c11) {
        return t0(str, i11, c11).toString();
    }

    public static final g<h> v0(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12) {
        G0(i12);
        return new c(charSequence, i11, i12, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z11));
    }

    public static final g<h> w0(CharSequence charSequence, String[] strArr, int i11, boolean z11, int i12) {
        G0(i12);
        return new c(charSequence, i11, i12, new StringsKt__StringsKt$rangesDelimitedBy$2(ArraysKt___ArraysJvmKt.d(strArr), z11));
    }

    public static /* synthetic */ g x0(CharSequence charSequence, char[] cArr, int i11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return v0(charSequence, cArr, i11, z11, i12);
    }

    public static /* synthetic */ g y0(CharSequence charSequence, String[] strArr, int i11, boolean z11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        if ((i13 & 8) != 0) {
            i12 = 0;
        }
        return w0(charSequence, strArr, i11, z11, i12);
    }

    public static final boolean z0(CharSequence charSequence, int i11, CharSequence charSequence2, int i12, int i13, boolean z11) {
        if (i12 < 0 || i11 < 0 || i11 > charSequence.length() - i13 || i12 > charSequence2.length() - i13) {
            return false;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            if (!CharsKt__CharKt.e(charSequence.charAt(i11 + i14), charSequence2.charAt(i12 + i14), z11)) {
                return false;
            }
        }
        return true;
    }
}
