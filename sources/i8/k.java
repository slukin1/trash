package i8;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import g9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class k {

    /* renamed from: f  reason: collision with root package name */
    public static volatile k f70359f;

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolPrice> f70360a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SymbolPrice> f70361b = new ConcurrentHashMap(256);

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b> f70362c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public a.d f70363d = new j(this);

    /* renamed from: e  reason: collision with root package name */
    public MarketOverviewListener f70364e = new a();

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (Map.Entry value : k.this.f70362c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.onSuccess(k.this.f70360a);
                }
            }
        }

        /* renamed from: l */
        public MarketOverviewResponse g(MarketOverviewResponse marketOverviewResponse) {
            List<SymbolPrice> list = (List) marketOverviewResponse.getData();
            if (list != null) {
                for (SymbolPrice symbolPrice : list) {
                    if (!(symbolPrice == null || symbolPrice.getSymbol() == null)) {
                        k.this.f70361b.put(symbolPrice.getSymbol(), symbolPrice);
                    }
                }
            }
            k.this.f70360a.clear();
            k.this.f70360a.addAll(k.this.f70361b.values());
            for (Map.Entry value : k.this.f70362c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.e(k.this.f70360a);
                }
            }
            return (MarketOverviewResponse) super.g(marketOverviewResponse);
        }
    }

    public interface b {
        void e(List<SymbolPrice> list);

        void onSuccess(List<SymbolPrice> list);
    }

    public static k g() {
        if (f70359f == null) {
            synchronized (k.class) {
                if (f70359f == null) {
                    f70359f = new k();
                }
            }
        }
        return f70359f;
    }

    public synchronized void e(String str, b bVar) {
        this.f70362c.put(str, bVar);
    }

    public List<SymbolPrice> f() {
        return this.f70360a;
    }

    public Map<String, SymbolPrice> h() {
        return this.f70361b;
    }

    public synchronized void j(String str) {
        this.f70362c.remove(str);
    }

    public void k(String str) {
        b bVar = this.f70362c.get(str);
        if (bVar != null) {
            bVar.onSuccess(this.f70360a);
        }
    }

    /* renamed from: l */
    public void i() {
        h8.a.a().e(true, this.f70364e);
        h8.a.a().d(this.f70363d);
    }

    public void m() {
        h8.a.a().e(false, this.f70364e);
        h8.a.a().c(this.f70363d);
    }

    public void n() {
        if (this.f70362c.size() == 0) {
            h8.a.a().e(false, this.f70364e);
            h8.a.a().c(this.f70363d);
        }
    }
}
