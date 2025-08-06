package kotlinx.coroutines;

public final class h1 implements i1 {

    /* renamed from: b  reason: collision with root package name */
    public final NodeList f57280b;

    public h1(NodeList nodeList) {
        this.f57280b = nodeList;
    }

    public NodeList a() {
        return this.f57280b;
    }

    public boolean isActive() {
        return false;
    }

    public String toString() {
        return j0.c() ? a().q("New") : super.toString();
    }
}
