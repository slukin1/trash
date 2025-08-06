package com.huobi.index.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import bj.d;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.index.presenter.g;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m9.r;
import pro.huobi.R;
import sn.f;
import us.i;
import us.j;

public class l0 extends a {

    /* renamed from: c  reason: collision with root package name */
    public List<SwapCurrencyInfo> f73455c;

    public class a extends BaseSubscriber<List<c>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.a f73456b;

        public a(g.a aVar) {
            this.f73456b = aVar;
        }

        public void onNext(List<c> list) {
            g.a aVar = this.f73456b;
            if (aVar != null && list != null) {
                l0.this.f73424b = list;
                aVar.onUpdate();
            }
        }
    }

    public class b implements r.b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
            l0 l0Var = l0.this;
            if (l0Var.f73455c != null && l0Var.f73423a != null) {
                Map<String, SymbolPrice> h11 = r.g().h();
                ArrayList arrayList = new ArrayList();
                for (SwapCurrencyInfo next : l0.this.f73455c) {
                    SymbolPrice symbolPrice = h11.get(next.getContractShortType());
                    if (symbolPrice != null) {
                        arrayList.add(new c(next, symbolPrice));
                    }
                }
                l0 l0Var2 = l0.this;
                l0Var2.f73424b = arrayList;
                l0Var2.f73423a.onUpdate();
            }
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public static class c implements g.b {

        /* renamed from: a  reason: collision with root package name */
        public SwapCurrencyInfo f73459a;

        /* renamed from: b  reason: collision with root package name */
        public SymbolPrice f73460b;

        public c(SwapCurrencyInfo swapCurrencyInfo, SymbolPrice symbolPrice) {
            this.f73459a = swapCurrencyInfo;
            this.f73460b = symbolPrice;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void h(View view) {
            f.I(view.getContext(), this.f73459a.getContractShortType(), this.f73459a.getContractCode(), this.f73459a, TradeType.SWAP);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public String a() {
            return j.j(BaseApplication.b());
        }

        public String b() {
            return this.f73459a.getContractShortType();
        }

        public String c() {
            return this.f73459a.getSymbol();
        }

        public String d(Context context) {
            Double close = this.f73460b.getClose();
            String m11 = close.doubleValue() >= 0.0d ? m.m(String.valueOf(close), i.o(this.f73459a.getSymbol())) : "--";
            return context.getResources().getString(R.string.contract_symbol_price_dollar) + m11;
        }

        public Double e() {
            SymbolPrice symbolPrice = this.f73460b;
            Double valueOf = Double.valueOf(0.0d);
            if (symbolPrice == null) {
                return valueOf;
            }
            Double close = symbolPrice.getClose();
            Double open = this.f73460b.getOpen();
            return (close == null || open == null || Double.compare(close.doubleValue(), 0.0d) == 0) ? valueOf : Double.valueOf((close.doubleValue() - open.doubleValue()) / open.doubleValue());
        }

        public String f() {
            String str;
            String symbol = this.f73459a.getSymbol();
            String contractType = this.f73459a.getContractType();
            if (symbol == null) {
                str = "";
            } else {
                str = symbol.toLowerCase();
            }
            if (TextUtils.isEmpty(contractType)) {
                return str;
            }
            return str + "_" + contractType;
        }

        public View.OnClickListener getOnItemClickListener() {
            return new m0(this);
        }

        public String getTitle() {
            return j.i(this.f73459a.getSymbol());
        }
    }

    public l0(g.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(List list) {
        this.f73455c = list;
    }

    public static /* synthetic */ c l(Map map, SwapCurrencyInfo swapCurrencyInfo) {
        return new c(swapCurrencyInfo, (SymbolPrice) map.get(swapCurrencyInfo.getContractShortType()));
    }

    public static /* synthetic */ Boolean m(c cVar) {
        return Boolean.valueOf(cVar.f73460b != null);
    }

    public void c() {
        r.g().e("SwapRankListProvide", new b());
    }

    public void d(g.a aVar) {
        SwapCurrencyInfoController.k().f(true).compose(RxJavaHelper.s()).doOnNext(new i0(this)).flatMap(ad.i.f3526b).map(new j0(r.g().h())).filter(k0.f73453b).toList().subscribe(new a(aVar));
    }

    public boolean e() {
        return d.v(6);
    }

    public void f() {
        r.g().j("SwapRankListProvide");
    }
}
