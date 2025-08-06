package gh;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f47530a;

    public b(boolean z11) {
        this.f47530a = z11;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public boolean b() {
        return this.f47530a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.a(this) && b() == bVar.b();
    }

    public int hashCode() {
        return 59 + (b() ? 79 : 97);
    }

    public String toString() {
        return "HideAmountEvent(show=" + b() + ")";
    }
}
