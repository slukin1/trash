package kotlinx.coroutines;

public final class a1 implements i1 {

    /* renamed from: b  reason: collision with root package name */
    public final boolean f56977b;

    public a1(boolean z11) {
        this.f56977b = z11;
    }

    public NodeList a() {
        return null;
    }

    public boolean isActive() {
        return this.f56977b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(isActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
