package xe;

import kotlin.jvm.internal.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public String f26365a;

    /* renamed from: b  reason: collision with root package name */
    public int f26366b;

    public e(String str, int i11) {
        this.f26365a = str;
        this.f26366b = i11;
    }

    public final int a() {
        return this.f26366b;
    }

    public final String b() {
        return this.f26365a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f26365a, eVar.f26365a) && this.f26366b == eVar.f26366b;
    }

    public int hashCode() {
        return (this.f26365a.hashCode() * 31) + this.f26366b;
    }

    public String toString() {
        return "FollowStatusEvent(uidUnique=" + this.f26365a + ", followStatus=" + this.f26366b + ')';
    }
}
