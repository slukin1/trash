package tl;

import ad.i;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.CollectionMultiple;
import com.huobi.homemarket.bean.OneKeyCollectItem;
import i6.d;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import sl.f0;

public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public List<OneKeyCollectItem> f76576a;

    /* renamed from: b  reason: collision with root package name */
    public final b f76577b;

    public class a implements f0.b {
        public a() {
        }

        public void e(List<SymbolPrice> list) {
        }

        public void onSuccess(List<SymbolPrice> list) {
            h0.this.w(list);
        }
    }

    public interface b {
        void G(List<OneKeyCollectItem> list);

        void a(boolean z11);

        void b();

        void finish();

        BaseActivity<?, ?> getBaseActivity();

        void setHasData(boolean z11);
    }

    public h0(b bVar) {
        this.f76577b = bVar;
    }

    public static /* synthetic */ Boolean n(List list) {
        return Boolean.valueOf(list != null && !list.isEmpty());
    }

    public static /* synthetic */ CollectionMultiple o(OneKeyCollectItem oneKeyCollectItem) {
        String j11 = oneKeyCollectItem.j();
        CollectionMultiple collectionMultiple = new CollectionMultiple();
        collectionMultiple.setWebsite(MarketModuleConfig.a().e0(j11));
        collectionMultiple.setTradingPair(j11);
        return collectionMultiple;
    }

    public static /* synthetic */ Boolean p(List list) {
        return Boolean.valueOf(list != null && !list.isEmpty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable q(List list) {
        return Observable.from(this.f76576a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(List list) {
        this.f76577b.G(this.f76576a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(List list) {
        this.f76576a = list;
        this.f76577b.G(list);
        this.f76577b.setHasData(true);
        A();
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(boolean z11) {
        boolean z12;
        Iterator<OneKeyCollectItem> it2 = this.f76576a.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().k()) {
                    z12 = true;
                    break;
                }
            } else {
                z12 = false;
                break;
            }
        }
        this.f76577b.a(z12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(Object obj) {
        d.c("OneKeyCollectView", "Add Collect Success! " + this.f76576a.toString());
        this.f76577b.b();
        this.f76577b.finish();
    }

    public void A() {
        f0.g().e("OneKeyCollectPresenter", new a());
        f0.g().i();
    }

    public void B() {
        f0.g().j("OneKeyCollectPresenter");
        f0.g().n();
    }

    public final OneKeyCollectItem C(OneKeyCollectItem oneKeyCollectItem) {
        String c11 = oneKeyCollectItem.c();
        String g11 = StringUtils.g(c11 + "usdt");
        SymbolPrice h11 = f0.g().h(g11);
        if (h11 != null) {
            Double close = h11.getClose();
            Double open = h11.getOpen();
            double doubleValue = close.doubleValue() - open.doubleValue();
            String i11 = m.i((doubleValue / open.doubleValue()) * 100.0d, PrecisionUtil.v(c11));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : "");
            sb2.append(i11);
            sb2.append("%");
            oneKeyCollectItem.r(sb2.toString());
            if (Double.compare(doubleValue, 0.0d) > 0) {
                oneKeyCollectItem.q(w.h());
            } else if (Double.compare(doubleValue, 0.0d) < 0) {
                oneKeyCollectItem.q(w.d());
            } else {
                oneKeyCollectItem.q(w.e());
            }
            oneKeyCollectItem.o(m.i(close.doubleValue(), PrecisionUtil.x(g11)));
            oneKeyCollectItem.m(String.format("≈%s %s", new Object[]{LegalCurrencyConfigUtil.n(g11, TradeType.PRO), StringUtils.i(LegalCurrencyConfigUtil.y())}));
        } else {
            oneKeyCollectItem.r("--");
            oneKeyCollectItem.q(w.e());
            oneKeyCollectItem.o("--");
            oneKeyCollectItem.m("--");
        }
        return oneKeyCollectItem;
    }

    public void l() {
        Observable.just(this.f76576a).filter(g0.f29350b).flatMap(i.f3526b).filter(e0.f29346b).map(f0.f29348b).toList().compose(RxJavaHelper.t(this.f76577b.getBaseActivity())).subscribe(q6.d.c(this.f76577b.getBaseActivity(), new z(this)));
    }

    public void m(boolean z11) {
        if (z11) {
            A();
        } else {
            B();
        }
    }

    public void v() {
        w(f0.g().f());
    }

    public final void w(List<SymbolPrice> list) {
        Observable.just(list).filter(x.f29369b).flatMap(new d0(this)).map(new c0(this)).toList().compose(RxJavaHelper.t(this.f76577b.getBaseActivity())).subscribe(SilentSubscriber.a(new a0(this)));
    }

    public void x() {
        OneKeyCollectItem.e(new w(this), new y(this));
    }

    public final void y(List<CollectionMultiple> list) {
        z(list);
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size).getTradingPair());
        }
        MarketModuleConfig.a().b0(arrayList, this.f76577b.getBaseActivity(), "PRO").compose(RxJavaHelper.t(this.f76577b.getBaseActivity())).subscribe(q6.d.c(this.f76577b.getBaseActivity(), new b0(this)));
    }

    public final void z(List<CollectionMultiple> list) {
        HashMap hashMap = new HashMap(1);
        ArrayList arrayList = new ArrayList();
        for (CollectionMultiple tradingPair : list) {
            arrayList.add(tradingPair.getTradingPair());
        }
        hashMap.put("symbol", arrayList);
        BaseModuleConfig.a().d("4828", hashMap, "1005260");
    }
}
