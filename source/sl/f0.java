package sl;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import g9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f0 {

    /* renamed from: f  reason: collision with root package name */
    public static volatile f0 f76497f;

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolPrice> f76498a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SymbolPrice> f76499b = new HashMap(16);

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b> f76500c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public a.d f76501d = new e0(this);

    /* renamed from: e  reason: collision with root package name */
    public MarketOverviewListener f76502e = new a();

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (Map.Entry value : f0.this.f76500c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.onSuccess(f0.this.f76498a);
                }
            }
        }

        /* renamed from: l */
        public MarketOverviewResponse g(MarketOverviewResponse marketOverviewResponse) {
            List<SymbolPrice> list = (List) marketOverviewResponse.getData();
            if (list != null) {
                for (SymbolPrice symbolPrice : list) {
                    f0.this.f76499b.put(symbolPrice.getSymbol(), symbolPrice);
                }
                LegalCurrencyConfigUtil.e0(f0.this.f76499b);
            }
            f0.this.f76498a.clear();
            f0.this.f76498a.addAll(f0.this.f76499b.values());
            for (Map.Entry value : f0.this.f76500c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.e(f0.this.f76498a);
                }
            }
            return (MarketOverviewResponse) super.g(marketOverviewResponse);
        }
    }

    public interface b {
        void e(List<SymbolPrice> list);

        void onSuccess(List<SymbolPrice> list);
    }

    public static f0 g() {
        if (f76497f == null) {
            synchronized (f0.class) {
                if (f76497f == null) {
                    f76497f = new f0();
                }
            }
        }
        return f76497f;
    }

    public synchronized void e(String str, b bVar) {
        this.f76500c.put(str, bVar);
    }

    public List<SymbolPrice> f() {
        return this.f76498a;
    }

    public SymbolPrice h(String str) {
        return this.f76499b.get(str);
    }

    public synchronized void j(String str) {
        this.f76500c.remove(str);
    }

    public void k(String str) {
        b bVar = this.f76500c.get(str);
        if (bVar != null) {
            bVar.onSuccess(this.f76498a);
        }
    }

    /* renamed from: l */
    public void i() {
        x8.a.a().e(true, this.f76502e);
        x8.a.a().d(this.f76501d);
    }

    public void m() {
        x8.a.a().e(false, this.f76502e);
        x8.a.a().c(this.f76501d);
    }

    public void n() {
        if (this.f76500c.size() == 0) {
            x8.a.a().e(false, this.f76502e);
            x8.a.a().c(this.f76501d);
        }
    }
}
