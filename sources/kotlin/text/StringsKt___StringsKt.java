package kotlin.text;

import d10.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.SlidingWindowKt;

class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static List<String> k1(CharSequence charSequence, int i11) {
        return v1(charSequence, i11, i11, true);
    }

    public static String l1(String str, int i11) {
        if (i11 >= 0) {
            return str.substring(RangesKt___RangesKt.g(i11, str.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i11 + " is less than zero.").toString());
    }

    public static String m1(String str, int i11) {
        if (i11 >= 0) {
            return q1(str, RangesKt___RangesKt.d(str.length() - i11, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i11 + " is less than zero.").toString());
    }

    public static char n1(CharSequence charSequence) {
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(StringsKt__StringsKt.a0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char o1(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        } else if (length == 1) {
            return charSequence.charAt(0);
        } else {
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
    }

    public static CharSequence p1(CharSequence charSequence, int i11) {
        if (i11 >= 0) {
            return charSequence.subSequence(0, RangesKt___RangesKt.g(i11, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i11 + " is less than zero.").toString());
    }

    public static String q1(String str, int i11) {
        if (i11 >= 0) {
            return str.substring(0, RangesKt___RangesKt.g(i11, str.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i11 + " is less than zero.").toString());
    }

    public static String r1(String str, int i11) {
        if (i11 >= 0) {
            int length = str.length();
            return str.substring(length - RangesKt___RangesKt.g(i11, length));
        }
        throw new IllegalArgumentException(("Requested character count " + i11 + " is less than zero.").toString());
    }

    public static final <C extends Collection<? super Character>> C s1(CharSequence charSequence, C c11) {
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            c11.add(Character.valueOf(charSequence.charAt(i11)));
        }
        return c11;
    }

    public static List<Character> t1(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (length != 1) {
            return u1(charSequence);
        }
        return CollectionsKt__CollectionsJVMKt.e(Character.valueOf(charSequence.charAt(0)));
    }

    public static List<Character> u1(CharSequence charSequence) {
        return (List) s1(charSequence, new ArrayList(charSequence.length()));
    }

    public static final List<String> v1(CharSequence charSequence, int i11, int i12, boolean z11) {
        return w1(charSequence, i11, i12, z11, StringsKt___StringsKt$windowed$1.INSTANCE);
    }

    public static final <R> List<R> w1(CharSequence charSequence, int i11, int i12, boolean z11, l<? super CharSequence, ? extends R> lVar) {
        SlidingWindowKt.a(i11, i12);
        int length = charSequence.length();
        ArrayList arrayList = new ArrayList((length / i12) + (length % i12 == 0 ? 0 : 1));
        int i13 = 0;
        while (true) {
            if (!(i13 >= 0 && i13 < length)) {
                break;
            }
            int i14 = i13 + i11;
            if (i14 < 0 || i14 > length) {
                if (!z11) {
                    break;
                }
                i14 = length;
            }
            arrayList.add(lVar.invoke(charSequence.subSequence(i13, i14)));
            i13 += i12;
        }
        return arrayList;
    }
}
