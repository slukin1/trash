package wz;

import io.noties.markwon.html.jsoup.nodes.Attributes;
import java.util.Map;

public class a implements Map.Entry<String, String>, Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public String f60202b;

    /* renamed from: c  reason: collision with root package name */
    public String f60203c;

    /* renamed from: d  reason: collision with root package name */
    public Attributes f60204d;

    public a(String str, String str2, Attributes attributes) {
        vz.a.f(str);
        this.f60202b = str.trim();
        vz.a.e(str);
        this.f60203c = str2;
        this.f60204d = attributes;
    }

    /* renamed from: b */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    /* renamed from: c */
    public String getKey() {
        return this.f60202b;
    }

    /* renamed from: d */
    public String getValue() {
        return this.f60203c;
    }

    /* renamed from: e */
    public String setValue(String str) {
        int k11;
        String j11 = this.f60204d.j(this.f60202b);
        Attributes attributes = this.f60204d;
        if (!(attributes == null || (k11 = attributes.k(this.f60202b)) == -1)) {
            this.f60204d.f55348d[k11] = str;
        }
        this.f60203c = str;
        return j11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f60202b;
        if (str == null ? aVar.f60202b != null : !str.equals(aVar.f60202b)) {
            return false;
        }
        String str2 = this.f60203c;
        String str3 = aVar.f60203c;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f60202b;
        int i11 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f60203c;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }
}
