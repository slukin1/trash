package m9;

import android.util.Log;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import g9.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class r {

    /* renamed from: f  reason: collision with root package name */
    public static volatile r f70910f;

    /* renamed from: a  reason: collision with root package name */
    public List<SymbolPrice> f70911a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Map<String, SymbolPrice> f70912b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    public Map<String, b> f70913c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public a.d f70914d = new q(this);

    /* renamed from: e  reason: collision with root package name */
    public MarketOverviewListener f70915e = new a();

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            for (Map.Entry value : r.this.f70913c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.onSuccess(r.this.f70911a);
                }
            }
        }

        /* renamed from: l */
        public MarketOverviewResponse g(MarketOverviewResponse marketOverviewResponse) {
            Log.i("SwapOverviewController", "SwapOverviewController onSuccessAsync  market.overview:");
            List<SymbolPrice> list = (List) marketOverviewResponse.getData();
            if (list != null) {
                for (SymbolPrice symbolPrice : list) {
                    if (!(symbolPrice == null || symbolPrice.getSymbol() == null)) {
                        r.this.f70912b.put(symbolPrice.getSymbol(), symbolPrice);
                    }
                }
            }
            r.this.f70911a.clear();
            r.this.f70911a.addAll(r.this.f70912b.values());
            for (Map.Entry value : r.this.f70913c.entrySet()) {
                b bVar = (b) value.getValue();
                if (bVar != null) {
                    bVar.e(r.this.f70911a);
                }
            }
            return (MarketOverviewResponse) super.g(marketOverviewResponse);
        }
    }

    public interface b {
        void e(List<SymbolPrice> list);

        void onSuccess(List<SymbolPrice> list);
    }

    public static r g() {
        if (f70910f == null) {
            synchronized (r.class) {
                if (f70910f == null) {
                    f70910f = new r();
                }
            }
        }
        return f70910f;
    }

    public synchronized void e(String str, b bVar) {
        this.f70913c.put(str, bVar);
    }

    public List<SymbolPrice> f() {
        return this.f70911a;
    }

    public Map<String, SymbolPrice> h() {
        return this.f70912b;
    }

    public synchronized void j(String str) {
        this.f70913c.remove(str);
    }

    public void k(String str) {
        b bVar = this.f70913c.get(str);
        if (bVar != null) {
            bVar.onSuccess(this.f70911a);
        }
    }

    /* renamed from: l */
    public void i() {
        l9.a.a().e(true, this.f70915e);
        l9.a.a().d(this.f70914d);
    }

    public void m() {
        l9.a.a().e(false, this.f70915e);
        l9.a.a().c(this.f70914d);
    }

    public void n() {
        if (this.f70913c.size() == 0) {
            l9.a.a().e(false, this.f70915e);
            l9.a.a().c(this.f70914d);
        }
    }
}
