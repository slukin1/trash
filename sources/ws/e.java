package ws;

import com.huobi.trade.handler.TradeGuideListItemHandler;

public class e implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f85041b;

    /* renamed from: c  reason: collision with root package name */
    public String f85042c;

    /* renamed from: d  reason: collision with root package name */
    public String f85043d;

    /* renamed from: e  reason: collision with root package name */
    public a f85044e;

    public interface a {
        void N3(e eVar, int i11);

        int N6();

        int getItemCount();
    }

    public e(int i11, String str, String str2, a aVar) {
        j(i11);
        i(str);
        h(str2);
        g(aVar);
    }

    public boolean a(Object obj) {
        return obj instanceof e;
    }

    public a c() {
        return this.f85044e;
    }

    public String d() {
        return this.f85043d;
    }

    public String e() {
        return this.f85042c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!eVar.a(this) || f() != eVar.f()) {
            return false;
        }
        String e11 = e();
        String e12 = eVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = eVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = eVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int f() {
        return this.f85041b;
    }

    public void g(a aVar) {
        this.f85044e = aVar;
    }

    public String getViewHandlerName() {
        return TradeGuideListItemHandler.class.getName();
    }

    public void h(String str) {
        this.f85043d = str;
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int f11 = ((f() + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        String d11 = d();
        int hashCode = (f11 * 59) + (d11 == null ? 43 : d11.hashCode());
        a c11 = c();
        int i12 = hashCode * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public void i(String str) {
        this.f85042c = str;
    }

    public void j(int i11) {
        this.f85041b = i11;
    }

    public String toString() {
        return "TradeGuideListItem(type=" + f() + ", title=" + e() + ", desc=" + d() + ", callback=" + c() + ")";
    }
}
