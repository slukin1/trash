package vk;

public class v {

    /* renamed from: a  reason: collision with root package name */
    public int f48014a;

    /* renamed from: b  reason: collision with root package name */
    public int f48015b;

    public v(int i11, int i12) {
        this.f48014a = i11;
        this.f48015b = i12;
    }

    public boolean a(Object obj) {
        return obj instanceof v;
    }

    public int b() {
        return this.f48014a;
    }

    public int c() {
        return this.f48015b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return vVar.a(this) && b() == vVar.b() && c() == vVar.c();
    }

    public int hashCode() {
        return ((b() + 59) * 59) + c();
    }

    public String toString() {
        return "TabConfig(mainTabIndex=" + b() + ", secondTabIndex=" + c() + ")";
    }
}
