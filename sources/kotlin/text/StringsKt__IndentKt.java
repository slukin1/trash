package kotlin.text;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import d10.l;
import java.util.ArrayList;
import java.util.List;

class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static final l<String, String> b(String str) {
        if (str.length() == 0) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    public static final int c(String str) {
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            } else if (!CharsKt__CharJVMKt.c(str.charAt(i11))) {
                break;
            } else {
                i11++;
            }
        }
        return i11 == -1 ? str.length() : i11;
    }

    public static final String d(String str, String str2) {
        String invoke;
        List<String> p02 = StringsKt__StringsKt.p0(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (T next : p02) {
            if (!StringsKt__StringsJVMKt.z((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
        for (String c11 : arrayList) {
            arrayList2.add(Integer.valueOf(c(c11)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.p0(arrayList2);
        int i11 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * p02.size());
        l<String, String> b11 = b(str2);
        int m11 = CollectionsKt__CollectionsKt.m(p02);
        ArrayList arrayList3 = new ArrayList();
        for (T next2 : p02) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            String str3 = (String) next2;
            if ((i11 == 0 || i11 == m11) && StringsKt__StringsJVMKt.z(str3)) {
                str3 = null;
            } else {
                String l12 = StringsKt___StringsKt.l1(str3, intValue);
                if (!(l12 == null || (invoke = b11.invoke(l12)) == null)) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i11 = i12;
        }
        return ((StringBuilder) CollectionsKt___CollectionsKt.i0(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 124, (Object) null)).toString();
    }

    public static final String e(String str, String str2, String str3) {
        int i11;
        String invoke;
        if (!StringsKt__StringsJVMKt.z(str3)) {
            List<String> p02 = StringsKt__StringsKt.p0(str);
            int length = str.length() + (str2.length() * p02.size());
            l<String, String> b11 = b(str2);
            int m11 = CollectionsKt__CollectionsKt.m(p02);
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            for (T next : p02) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                String str4 = (String) next;
                String str5 = null;
                if ((i12 == 0 || i12 == m11) && StringsKt__StringsJVMKt.z(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length2) {
                            i11 = -1;
                            break;
                        } else if (!CharsKt__CharJVMKt.c(str4.charAt(i14))) {
                            i11 = i14;
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (i11 != -1 && StringsKt__StringsJVMKt.L(str4, str3, i11, false, 4, (Object) null)) {
                        str5 = str4.substring(i11 + str3.length());
                    }
                    if (!(str5 == null || (invoke = b11.invoke(str5)) == null)) {
                        str4 = invoke;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i12 = i13;
            }
            return ((StringBuilder) CollectionsKt___CollectionsKt.i0(arrayList, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 124, (Object) null)).toString();
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String str) {
        return d(str, "");
    }

    public static final String g(String str, String str2) {
        return e(str, "", str2);
    }

    public static /* synthetic */ String h(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return g(str, str2);
    }
}
