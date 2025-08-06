package x00;

import junit.framework.Assert;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f60206a;

    /* renamed from: b  reason: collision with root package name */
    public String f60207b;

    /* renamed from: c  reason: collision with root package name */
    public String f60208c;

    /* renamed from: d  reason: collision with root package name */
    public int f60209d;

    /* renamed from: e  reason: collision with root package name */
    public int f60210e;

    public a(int i11, String str, String str2) {
        this.f60206a = i11;
        this.f60207b = str;
        this.f60208c = str2;
    }

    public final boolean a() {
        return this.f60207b.equals(this.f60208c);
    }

    public String b(String str) {
        if (this.f60207b == null || this.f60208c == null || a()) {
            return Assert.format(str, this.f60207b, this.f60208c);
        }
        f();
        g();
        return Assert.format(str, c(this.f60207b), c(this.f60208c));
    }

    public final String c(String str) {
        String str2 = "[" + str.substring(this.f60209d, (str.length() - this.f60210e) + 1) + "]";
        if (this.f60209d > 0) {
            str2 = d() + str2;
        }
        if (this.f60210e <= 0) {
            return str2;
        }
        return str2 + e();
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f60209d > this.f60206a ? "..." : "");
        sb2.append(this.f60207b.substring(Math.max(0, this.f60209d - this.f60206a), this.f60209d));
        return sb2.toString();
    }

    public final String e() {
        int min = Math.min((this.f60207b.length() - this.f60210e) + 1 + this.f60206a, this.f60207b.length());
        StringBuilder sb2 = new StringBuilder();
        String str = this.f60207b;
        sb2.append(str.substring((str.length() - this.f60210e) + 1, min));
        sb2.append((this.f60207b.length() - this.f60210e) + 1 < this.f60207b.length() - this.f60206a ? "..." : "");
        return sb2.toString();
    }

    public final void f() {
        this.f60209d = 0;
        int min = Math.min(this.f60207b.length(), this.f60208c.length());
        while (true) {
            int i11 = this.f60209d;
            if (i11 < min && this.f60207b.charAt(i11) == this.f60208c.charAt(this.f60209d)) {
                this.f60209d++;
            } else {
                return;
            }
        }
    }

    public final void g() {
        int length = this.f60207b.length() - 1;
        int length2 = this.f60208c.length() - 1;
        while (true) {
            int i11 = this.f60209d;
            if (length2 < i11 || length < i11 || this.f60207b.charAt(length) != this.f60208c.charAt(length2)) {
                this.f60210e = this.f60207b.length() - length;
            } else {
                length2--;
                length--;
            }
        }
        this.f60210e = this.f60207b.length() - length;
    }
}
