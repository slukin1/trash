package q8;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import g9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {

    /* renamed from: f  reason: collision with root package name */
    public static volatile d f70141f;

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolPrice> f70142a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SymbolPrice> f70143b = new HashMap(16);

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b> f70144c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public a.d f70145d = new c(this);

    /* renamed from: e  reason: collision with root package name */
    public MarketOverviewListener f70146e = new a();

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (Map.Entry value : d.this.f70144c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.onSuccess(d.this.f70142a);
                }
            }
        }

        /* renamed from: l */
        public MarketOverviewResponse g(MarketOverviewResponse marketOverviewResponse) {
            List<SymbolPrice> list = (List) marketOverviewResponse.getData();
            if (list != null) {
                for (SymbolPrice symbolPrice : list) {
                    d.this.f70143b.put(symbolPrice.getSymbol(), symbolPrice);
                }
            }
            d.this.f70142a.clear();
            d.this.f70142a.addAll(d.this.f70143b.values());
            for (Map.Entry value : d.this.f70144c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.e(d.this.f70142a);
                }
            }
            return (MarketOverviewResponse) super.g(marketOverviewResponse);
        }
    }

    public interface b {
        void e(List<SymbolPrice> list);

        void onSuccess(List<SymbolPrice> list);
    }

    public static d f() {
        if (f70141f == null) {
            synchronized (d.class) {
                if (f70141f == null) {
                    f70141f = new d();
                }
            }
        }
        return f70141f;
    }

    public synchronized void e(String str, b bVar) {
        this.f70144c.put(str, bVar);
    }

    public synchronized void h(String str) {
        this.f70144c.remove(str);
    }

    /* renamed from: i */
    public void g() {
        p8.a.a().e(true, this.f70146e);
        p8.a.a().d(this.f70145d);
    }

    public void j() {
        p8.a.a().e(false, this.f70146e);
        p8.a.a().c(this.f70145d);
    }

    public void k() {
        if (this.f70144c.size() == 0) {
            p8.a.a().e(false, this.f70146e);
            p8.a.a().c(this.f70145d);
        }
    }
}
