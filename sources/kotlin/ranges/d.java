package kotlin.ranges;

public final class d implements e<Double> {

    /* renamed from: a  reason: collision with root package name */
    public final double f56834a;

    /* renamed from: b  reason: collision with root package name */
    public final double f56835b;

    public d(double d11, double d12) {
        this.f56834a = d11;
        this.f56835b = d12;
    }

    public boolean a(double d11) {
        return d11 >= this.f56834a && d11 <= this.f56835b;
    }

    public boolean b() {
        return this.f56834a > this.f56835b;
    }

    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (b() && ((d) obj).b()) {
                return true;
            }
            d dVar = (d) obj;
            if (this.f56834a == dVar.f56834a) {
                if (this.f56835b == dVar.f56835b) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (b()) {
            return -1;
        }
        return (Double.doubleToLongBits(this.f56834a) * 31) + Double.doubleToLongBits(this.f56835b);
    }

    public String toString() {
        return this.f56834a + ".." + this.f56835b;
    }
}
