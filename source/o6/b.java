package o6;

import android.util.Log;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import g9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b {

    /* renamed from: f  reason: collision with root package name */
    public static volatile b f69020f;

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolPrice> f69021a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SymbolPrice> f69022b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    public Map<String, C0747b> f69023c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public a.d f69024d = new a(this);

    /* renamed from: e  reason: collision with root package name */
    public MarketOverviewListener f69025e = new a();

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (Map.Entry value : b.this.f69023c.entrySet()) {
                C0747b bVar = (C0747b) value.getValue();
                if (bVar != null) {
                    bVar.onSuccess(b.this.f69021a);
                }
            }
        }

        /* renamed from: l */
        public MarketOverviewResponse g(MarketOverviewResponse marketOverviewResponse) {
            Log.i("ContractOverviewController", "ContractOverviewController onSuccessAsync  market.overview:");
            List<SymbolPrice> list = (List) marketOverviewResponse.getData();
            if (list != null) {
                for (SymbolPrice symbolPrice : list) {
                    if (!(symbolPrice == null || symbolPrice.getSymbol() == null)) {
                        b.this.f69022b.put(symbolPrice.getSymbol(), symbolPrice);
                    }
                }
            }
            b.this.f69021a.clear();
            b.this.f69021a.addAll(b.this.f69022b.values());
            for (Map.Entry value : b.this.f69023c.entrySet()) {
                C0747b bVar = (C0747b) value.getValue();
                if (bVar != null) {
                    bVar.e(b.this.f69021a);
                }
            }
            return (MarketOverviewResponse) super.g(marketOverviewResponse);
        }
    }

    /* renamed from: o6.b$b  reason: collision with other inner class name */
    public interface C0747b {
        void e(List<SymbolPrice> list);

        void onSuccess(List<SymbolPrice> list);
    }

    public static b g() {
        if (f69020f == null) {
            synchronized (b.class) {
                if (f69020f == null) {
                    f69020f = new b();
                }
            }
        }
        return f69020f;
    }

    public synchronized void e(String str, C0747b bVar) {
        this.f69023c.put(str, bVar);
    }

    public List<SymbolPrice> f() {
        return this.f69021a;
    }

    public Map<String, SymbolPrice> h() {
        return this.f69022b;
    }

    public synchronized void j(String str) {
        this.f69023c.remove(str);
    }

    public void k(String str) {
        C0747b bVar = this.f69023c.get(str);
        if (bVar != null) {
            bVar.onSuccess(this.f69021a);
        }
    }

    /* renamed from: l */
    public void i() {
        q7.a.a().e(true, this.f69025e);
        q7.a.a().d(this.f69024d);
    }

    public void m() {
        q7.a.a().e(false, this.f69025e);
        q7.a.a().c(this.f69024d);
    }

    public void n() {
        if (this.f69023c.size() == 0) {
            q7.a.a().e(false, this.f69025e);
            q7.a.a().c(this.f69024d);
        }
    }
}
