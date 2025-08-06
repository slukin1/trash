package xe;

import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f26360a;

    /* renamed from: b  reason: collision with root package name */
    public int f26361b;

    /* renamed from: c  reason: collision with root package name */
    public int f26362c;

    public b(String str, int i11, int i12) {
        this.f26360a = str;
        this.f26361b = i11;
        this.f26362c = i12;
    }

    public final String a() {
        return this.f26360a;
    }

    public final int b() {
        return this.f26362c;
    }

    public final int c() {
        return this.f26361b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f26360a, bVar.f26360a) && this.f26361b == bVar.f26361b && this.f26362c == bVar.f26362c;
    }

    public int hashCode() {
        return (((this.f26360a.hashCode() * 31) + this.f26361b) * 31) + this.f26362c;
    }

    public String toString() {
        return "CommunityPraiseEvent(dynamicId=" + this.f26360a + ", praiseStatus=" + this.f26361b + ", praiseNum=" + this.f26362c + ')';
    }
}
