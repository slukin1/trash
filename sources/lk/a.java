package lk;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f47627a;

    public a(boolean z11) {
        this.f47627a = z11;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public boolean b() {
        return this.f47627a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar.a(this) && b() == aVar.b();
    }

    public int hashCode() {
        return 59 + (b() ? 79 : 97);
    }

    public String toString() {
        return "ChangeVerticalSpotEvent(useOldSpotMargin=" + b() + ")";
    }
}
