package n20;

import com.iproov.sdk.bridge.OptionsBridge;

public final class d {

    /* renamed from: f  reason: collision with root package name */
    public static d f22971f;

    /* renamed from: a  reason: collision with root package name */
    public e f22972a;

    /* renamed from: b  reason: collision with root package name */
    public e f22973b;

    /* renamed from: c  reason: collision with root package name */
    public e f22974c;

    /* renamed from: d  reason: collision with root package name */
    public e f22975d;

    /* renamed from: e  reason: collision with root package name */
    public e f22976e;

    public d() {
        o oVar = o.f22985a;
        s sVar = s.f22989a;
        b bVar = b.f22970a;
        f fVar = f.f22981a;
        j jVar = j.f22982a;
        k kVar = k.f22983a;
        this.f22972a = new e(new c[]{oVar, sVar, bVar, fVar, jVar, kVar});
        this.f22973b = new e(new c[]{q.f22987a, oVar, sVar, bVar, fVar, jVar, kVar});
        n nVar = n.f22984a;
        p pVar = p.f22986a;
        this.f22974c = new e(new c[]{nVar, pVar, sVar, jVar, kVar});
        this.f22975d = new e(new c[]{nVar, r.f22988a, pVar, sVar, kVar});
        this.f22976e = new e(new c[]{pVar, sVar, kVar});
    }

    public static d b() {
        if (f22971f == null) {
            f22971f = new d();
        }
        return f22971f;
    }

    public g a(Object obj) {
        g gVar = (g) this.f22974c.b(obj == null ? null : obj.getClass());
        if (gVar != null) {
            return gVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No duration converter found for type: ");
        sb2.append(obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public h c(Object obj) {
        h hVar = (h) this.f22972a.b(obj == null ? null : obj.getClass());
        if (hVar != null) {
            return hVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No instant converter found for type: ");
        sb2.append(obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public i d(Object obj) {
        i iVar = (i) this.f22976e.b(obj == null ? null : obj.getClass());
        if (iVar != null) {
            return iVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No interval converter found for type: ");
        sb2.append(obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public l e(Object obj) {
        l lVar = (l) this.f22973b.b(obj == null ? null : obj.getClass());
        if (lVar != null) {
            return lVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No partial converter found for type: ");
        sb2.append(obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public m f(Object obj) {
        m mVar = (m) this.f22975d.b(obj == null ? null : obj.getClass());
        if (mVar != null) {
            return mVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("No period converter found for type: ");
        sb2.append(obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    public String toString() {
        return "ConverterManager[" + this.f22972a.d() + " instant," + this.f22973b.d() + " partial," + this.f22974c.d() + " duration," + this.f22975d.d() + " period," + this.f22976e.d() + " interval]";
    }
}
