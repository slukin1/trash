package p2;

import java.util.Arrays;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String[] f16365a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f16366b;

    /* renamed from: c  reason: collision with root package name */
    public String f16367c;

    public a(String[] strArr, int[] iArr, String str) {
        this.f16365a = strArr;
        this.f16366b = iArr;
        this.f16367c = str;
    }

    public boolean c(String str, String[] strArr, int[] iArr) {
        if (w2.a.f(this.f16365a, this.f16366b, strArr, iArr) && str.equals(this.f16367c)) {
            return false;
        }
        this.f16367c = str;
        this.f16365a = strArr;
        this.f16366b = iArr;
        return true;
    }

    public boolean d(a aVar) {
        return Arrays.equals(this.f16365a, aVar.f16365a) && Arrays.equals(this.f16366b, aVar.f16366b) && w2.a.m(this.f16367c, aVar.f16367c);
    }

    public String[] e() {
        return this.f16365a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return Arrays.equals(this.f16365a, aVar.f16365a) && Arrays.equals(this.f16366b, aVar.f16366b) && w2.a.m(this.f16367c, aVar.f16367c);
    }

    public int[] f() {
        return this.f16366b;
    }

    public String g() {
        return this.f16367c;
    }

    public int hashCode() {
        return (((Arrays.hashCode(new Object[]{this.f16367c}) * 31) + Arrays.hashCode(this.f16365a)) * 31) + Arrays.hashCode(this.f16366b);
    }
}
