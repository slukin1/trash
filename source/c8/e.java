package c8;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import g9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {

    /* renamed from: f  reason: collision with root package name */
    public static volatile e f70191f;

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolPrice> f70192a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SymbolPrice> f70193b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b> f70194c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public a.d f70195d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public MarketOverviewListener f70196e = new a();

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (Map.Entry value : e.this.f70194c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.onSuccess(e.this.f70192a);
                }
            }
        }

        /* renamed from: l */
        public MarketOverviewResponse g(MarketOverviewResponse marketOverviewResponse) {
            List<SymbolPrice> list = (List) marketOverviewResponse.getData();
            if (list != null) {
                for (SymbolPrice symbolPrice : list) {
                    symbolPrice.setSymbol(symbolPrice.getSymbol() + "-Index");
                }
                for (SymbolPrice symbolPrice2 : list) {
                    e.this.f70193b.put(symbolPrice2.getSymbol(), symbolPrice2);
                }
            }
            e.this.f70192a.clear();
            e.this.f70192a.addAll(e.this.f70193b.values());
            for (Map.Entry value : e.this.f70194c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.e(e.this.f70192a);
                }
            }
            return (MarketOverviewResponse) super.g(marketOverviewResponse);
        }
    }

    public interface b {
        void e(List<SymbolPrice> list);

        void onSuccess(List<SymbolPrice> list);
    }

    public static e g() {
        if (f70191f == null) {
            synchronized (e.class) {
                if (f70191f == null) {
                    f70191f = new e();
                }
            }
        }
        return f70191f;
    }

    public synchronized void e(String str, b bVar) {
        this.f70194c.put(str, bVar);
    }

    public List<SymbolPrice> f() {
        return this.f70192a;
    }

    public Map<String, SymbolPrice> h() {
        return this.f70193b;
    }

    public synchronized void j(String str) {
        this.f70194c.remove(str);
    }

    public void k(String str) {
        b bVar = this.f70194c.get(str);
        if (bVar != null) {
            bVar.onSuccess(this.f70192a);
        }
    }

    /* renamed from: l */
    public void i() {
        b8.a.a().e(true, this.f70196e);
        b8.a.a().d(this.f70195d);
    }

    public void m() {
        b8.a.a().e(false, this.f70196e);
        b8.a.a().c(this.f70195d);
    }

    public void n() {
        if (this.f70194c.size() == 0) {
            b8.a.a().e(false, this.f70196e);
            b8.a.a().c(this.f70195d);
        }
    }
}
