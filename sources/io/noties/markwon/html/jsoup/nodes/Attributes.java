package io.noties.markwon.html.jsoup.nodes;

import java.util.Arrays;
import java.util.Iterator;

public class Attributes implements Iterable<wz.a>, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f55345e = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public int f55346b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String[] f55347c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f55348d;

    public class a implements Iterator<wz.a> {

        /* renamed from: b  reason: collision with root package name */
        public int f55349b = 0;

        public a() {
        }

        /* renamed from: a */
        public wz.a next() {
            Attributes attributes = Attributes.this;
            String[] strArr = attributes.f55348d;
            int i11 = this.f55349b;
            String str = strArr[i11];
            String str2 = attributes.f55347c[i11];
            if (str == null) {
                str = "";
            }
            wz.a aVar = new wz.a(str2, str, attributes);
            this.f55349b++;
            return aVar;
        }

        public boolean hasNext() {
            return this.f55349b < Attributes.this.f55346b;
        }

        public void remove() {
            Attributes attributes = Attributes.this;
            int i11 = this.f55349b - 1;
            this.f55349b = i11;
            attributes.m(i11);
        }
    }

    public Attributes() {
        String[] strArr = f55345e;
        this.f55347c = strArr;
        this.f55348d = strArr;
    }

    public static String g(String str) {
        return str == null ? "" : str;
    }

    public static String[] i(String[] strArr, int i11) {
        String[] strArr2 = new String[i11];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i11));
        return strArr2;
    }

    public final void d(String str, String str2) {
        e(this.f55346b + 1);
        String[] strArr = this.f55347c;
        int i11 = this.f55346b;
        strArr[i11] = str;
        this.f55348d[i11] = str2;
        this.f55346b = i11 + 1;
    }

    public final void e(int i11) {
        vz.a.d(i11 >= this.f55346b);
        String[] strArr = this.f55347c;
        int length = strArr.length;
        if (length < i11) {
            int i12 = 4;
            if (length >= 4) {
                i12 = this.f55346b * 2;
            }
            if (i11 <= i12) {
                i11 = i12;
            }
            this.f55347c = i(strArr, i11);
            this.f55348d = i(this.f55348d, i11);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.f55346b == attributes.f55346b && Arrays.equals(this.f55347c, attributes.f55347c)) {
            return Arrays.equals(this.f55348d, attributes.f55348d);
        }
        return false;
    }

    /* renamed from: h */
    public Attributes clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.f55346b = this.f55346b;
            this.f55347c = i(this.f55347c, this.f55346b);
            this.f55348d = i(this.f55348d, this.f55346b);
            return attributes;
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    public int hashCode() {
        return (((this.f55346b * 31) + Arrays.hashCode(this.f55347c)) * 31) + Arrays.hashCode(this.f55348d);
    }

    public Iterator<wz.a> iterator() {
        return new a();
    }

    public String j(String str) {
        int k11 = k(str);
        if (k11 == -1) {
            return "";
        }
        return g(this.f55348d[k11]);
    }

    public int k(String str) {
        vz.a.f(str);
        for (int i11 = 0; i11 < this.f55346b; i11++) {
            if (str.equals(this.f55347c[i11])) {
                return i11;
            }
        }
        return -1;
    }

    public Attributes l(String str, String str2) {
        int k11 = k(str);
        if (k11 != -1) {
            this.f55348d[k11] = str2;
        } else {
            d(str, str2);
        }
        return this;
    }

    public final void m(int i11) {
        vz.a.b(i11 >= this.f55346b);
        int i12 = (this.f55346b - i11) - 1;
        if (i12 > 0) {
            String[] strArr = this.f55347c;
            int i13 = i11 + 1;
            System.arraycopy(strArr, i13, strArr, i11, i12);
            String[] strArr2 = this.f55348d;
            System.arraycopy(strArr2, i13, strArr2, i11, i12);
        }
        int i14 = this.f55346b - 1;
        this.f55346b = i14;
        this.f55347c[i14] = null;
        this.f55348d[i14] = null;
    }

    public int size() {
        return this.f55346b;
    }
}
