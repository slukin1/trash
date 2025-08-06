package f2;

import com.alibaba.fastjson.JSON;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String[] f15744a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15745b;

    public g(int i11) {
        this.f15745b = i11 - 1;
        this.f15744a = new String[i11];
        a("$ref", 0, 4, 1185263);
        String str = JSON.DEFAULT_TYPE_KEY;
        a(str, 0, str.length(), JSON.DEFAULT_TYPE_KEY.hashCode());
    }

    public static String d(String str, int i11, int i12) {
        char[] cArr = new char[i12];
        str.getChars(i11, i12 + i11, cArr, 0);
        return new String(cArr);
    }

    public String a(String str, int i11, int i12, int i13) {
        return b(str, i11, i12, i13, false);
    }

    public String b(String str, int i11, int i12, int i13, boolean z11) {
        int i14 = this.f15745b & i13;
        String str2 = this.f15744a[i14];
        if (str2 == null) {
            if (i12 != str.length()) {
                str = d(str, i11, i12);
            }
            String intern = str.intern();
            this.f15744a[i14] = intern;
            return intern;
        } else if (i13 == str2.hashCode() && i12 == str2.length() && str.startsWith(str2, i11)) {
            return str2;
        } else {
            String d11 = d(str, i11, i12);
            if (z11) {
                this.f15744a[i14] = d11;
            }
            return d11;
        }
    }

    public String c(char[] cArr, int i11, int i12, int i13) {
        int i14 = this.f15745b & i13;
        String str = this.f15744a[i14];
        if (str != null) {
            boolean z11 = false;
            if (i13 == str.hashCode() && i12 == str.length()) {
                int i15 = 0;
                while (true) {
                    if (i15 >= i12) {
                        z11 = true;
                        break;
                    } else if (cArr[i11 + i15] != str.charAt(i15)) {
                        break;
                    } else {
                        i15++;
                    }
                }
            }
            if (z11) {
                return str;
            }
            return new String(cArr, i11, i12);
        }
        String intern = new String(cArr, i11, i12).intern();
        this.f15744a[i14] = intern;
        return intern;
    }
}
