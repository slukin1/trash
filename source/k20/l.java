package k20;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Object f68254a;

    /* renamed from: b  reason: collision with root package name */
    public final j f68255b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f68256c = true;

    public l(Object obj, j jVar) {
        this.f68254a = obj;
        this.f68255b = jVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f68254a != lVar.f68254a || !this.f68255b.equals(lVar.f68255b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f68254a.hashCode() + this.f68255b.f68240f.hashCode();
    }
}
