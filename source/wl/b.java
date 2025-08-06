package wl;

import com.huobi.index.presenter.g;
import com.huobi.index.viewhandler.FutureRiseRankViewHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public g.b f76657b;

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public g.b c() {
        return this.f76657b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this)) {
            return false;
        }
        g.b c11 = c();
        g.b c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return FutureRiseRankViewHandler.class.getName();
    }

    public int hashCode() {
        g.b c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "FutureRankItemData(item=" + c() + ")";
    }
}
