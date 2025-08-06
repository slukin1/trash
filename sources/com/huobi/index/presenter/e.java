package com.huobi.index.presenter;

import ad.i;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import bj.d;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.index.presenter.g;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o6.b;
import pro.huobi.R;
import sn.f;

public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    public List<ContractCurrencyInfo> f73432c;

    public class a extends BaseSubscriber<List<c>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.a f73433b;

        public a(g.a aVar) {
            this.f73433b = aVar;
        }

        public void onNext(List<c> list) {
            g.a aVar = this.f73433b;
            if (aVar != null && list != null) {
                e.this.f73424b = list;
                aVar.onUpdate();
            }
        }
    }

    public class b implements b.C0747b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
            e eVar = e.this;
            if (eVar.f73432c != null && eVar.f73423a != null) {
                Map<String, SymbolPrice> h11 = o6.b.g().h();
                ArrayList arrayList = new ArrayList();
                for (ContractCurrencyInfo next : e.this.f73432c) {
                    SymbolPrice symbolPrice = h11.get(next.getContractShortType());
                    if (symbolPrice != null) {
                        arrayList.add(new c(next, symbolPrice));
                    }
                }
                e eVar2 = e.this;
                eVar2.f73424b = arrayList;
                eVar2.f73423a.onUpdate();
            }
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public static class c implements g.b {

        /* renamed from: a  reason: collision with root package name */
        public ContractCurrencyInfo f73436a;

        /* renamed from: b  reason: collision with root package name */
        public SymbolPrice f73437b;

        public c(ContractCurrencyInfo contractCurrencyInfo, SymbolPrice symbolPrice) {
            this.f73436a = contractCurrencyInfo;
            this.f73437b = symbolPrice;
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void h(View view) {
            f.z(view.getContext(), this.f73436a.getContractShortType(), this.f73436a.getContractCode(), this.f73436a, TradeType.CONTRACT);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public String a() {
            return ej.g.j(BaseApplication.b(), this.f73436a.getContractCode(), this.f73436a.getContractType());
        }

        public String b() {
            return this.f73436a.getContractShortType();
        }

        public String c() {
            return this.f73436a.getSymbol();
        }

        public String d(Context context) {
            Double close = this.f73437b.getClose();
            String m11 = close.doubleValue() >= 0.0d ? m.m(String.valueOf(close), ej.f.p(this.f73436a.getContractCode())) : "--";
            return context.getResources().getString(R.string.contract_symbol_price_dollar) + m11;
        }

        public Double e() {
            SymbolPrice symbolPrice = this.f73437b;
            Double valueOf = Double.valueOf(0.0d);
            if (symbolPrice == null) {
                return valueOf;
            }
            Double close = symbolPrice.getClose();
            Double open = this.f73437b.getOpen();
            return (close == null || open == null || Double.compare(close.doubleValue(), 0.0d) == 0) ? valueOf : Double.valueOf((close.doubleValue() - open.doubleValue()) / open.doubleValue());
        }

        public String f() {
            String str;
            String symbol = this.f73436a.getSymbol();
            String contractType = this.f73436a.getContractType();
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
            return new f(this);
        }

        public String getTitle() {
            return ej.g.i(BaseApplication.b(), this.f73436a.getSymbol());
        }
    }

    public e(g.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(List list) {
        this.f73432c = list;
    }

    public static /* synthetic */ c l(Map map, ContractCurrencyInfo contractCurrencyInfo) {
        return new c(contractCurrencyInfo, (SymbolPrice) map.get(contractCurrencyInfo.getContractShortType()));
    }

    public static /* synthetic */ Boolean m(c cVar) {
        return Boolean.valueOf(cVar.f73437b != null);
    }

    public void c() {
        o6.b.g().e("ContractRankListProvide", new b());
    }

    public void d(g.a aVar) {
        ContractCurrencyUtils.g(true).compose(RxJavaHelper.s()).doOnNext(new b(this)).flatMap(i.f3526b).map(new c(o6.b.g().h())).filter(d.f73430b).toList().subscribe(new a(aVar));
    }

    public boolean e() {
        return d.v(3);
    }

    public void f() {
        o6.b.g().j("ContractRankListProvide");
    }
}
