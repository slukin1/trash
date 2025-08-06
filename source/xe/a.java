package xe;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f26358a;

    /* renamed from: b  reason: collision with root package name */
    public int f26359b;

    public a(int i11, int i12) {
        this.f26358a = i11;
        this.f26359b = i12;
    }

    public final int a() {
        return this.f26358a;
    }

    public final int b() {
        return this.f26359b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f26358a == aVar.f26358a && this.f26359b == aVar.f26359b;
    }

    public int hashCode() {
        return (this.f26358a * 31) + this.f26359b;
    }

    public String toString() {
        return "CommunityJoinNumEvent(joinNum=" + this.f26358a + ", type=" + this.f26359b + ')';
    }
}
