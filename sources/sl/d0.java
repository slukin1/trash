package sl;

import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ml.d;
import rx.subjects.BehaviorSubject;

public class d0 {

    /* renamed from: f  reason: collision with root package name */
    public static volatile d0 f76491f;

    /* renamed from: a  reason: collision with root package name */
    public List<d> f76492a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f76493b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public List<SymbolPrice> f76494c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public BehaviorSubject<List<SymbolPrice>> f76495d = BehaviorSubject.create();

    /* renamed from: e  reason: collision with root package name */
    public Map<String, SymbolPrice> f76496e = new HashMap();

    public static d0 a() {
        if (f76491f == null) {
            synchronized (d0.class) {
                if (f76491f == null) {
                    f76491f = new d0();
                }
            }
        }
        return f76491f;
    }

    public SymbolPrice b(String str) {
        return this.f76496e.get(str);
    }

    public BehaviorSubject<List<SymbolPrice>> c() {
        return this.f76495d;
    }

    public void d(MarketOverviewResponse marketOverviewResponse) {
        if (marketOverviewResponse != null && marketOverviewResponse.getData() != null) {
            for (SymbolPrice symbolPrice : (List) marketOverviewResponse.getData()) {
                this.f76496e.put(symbolPrice.getSymbol(), symbolPrice);
            }
            LegalCurrencyConfigUtil.e0(this.f76496e);
            this.f76494c.clear();
            this.f76494c.addAll(this.f76496e.values());
            try {
                this.f76495d.onNext(this.f76494c);
            } catch (Exception e11) {
                BaseModuleConfig.a().e(e11);
            }
        }
    }
}
