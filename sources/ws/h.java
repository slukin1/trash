package ws;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public Integer f85053a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f85054b;

    public h(Integer num, Integer num2) {
        this.f85053a = num;
        this.f85054b = num2;
    }

    public boolean a(Object obj) {
        return obj instanceof h;
    }

    public Integer b() {
        return this.f85054b;
    }

    public Integer c() {
        return this.f85053a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!hVar.a(this)) {
            return false;
        }
        Integer c11 = c();
        Integer c12 = hVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        Integer b11 = b();
        Integer b12 = hVar.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int hashCode() {
        Integer c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        Integer b11 = b();
        int i12 = (hashCode + 59) * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "UpdateTradeOrderEvent(tab=" + c() + ", subTab=" + b() + ")";
    }
}
