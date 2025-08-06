package wl;

import com.huobi.index.presenter.g;
import com.huobi.index.viewhandler.FutureDropRankViewHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public g.b f76656b;

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public g.b c() {
        return this.f76656b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        g.b c11 = c();
        g.b c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return FutureDropRankViewHandler.class.getName();
    }

    public int hashCode() {
        g.b c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "FutureDropRankItemData(item=" + c() + ")";
    }
}
