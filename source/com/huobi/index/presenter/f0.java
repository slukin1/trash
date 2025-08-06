package com.huobi.index.presenter;

import a7.e;
import ad.i;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import bj.d;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.index.presenter.g;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i8.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import rx.Observable;
import sn.f;

public class f0 extends a {

    /* renamed from: c  reason: collision with root package name */
    public List<FutureContractInfo> f73440c;

    public class a extends BaseSubscriber<List<c>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g.a f73441b;

        public a(g.a aVar) {
            this.f73441b = aVar;
        }

        public void onNext(List<c> list) {
            g.a aVar = this.f73441b;
            if (aVar != null && list != null) {
                f0.this.f73424b = list;
                aVar.onUpdate();
            }
        }
    }

    public class b implements k.b {
        public b() {
        }

        public void e(List<SymbolPrice> list) {
            f0 f0Var = f0.this;
            if (f0Var.f73440c != null && f0Var.f73423a != null) {
                Map<String, SymbolPrice> h11 = k.g().h();
                ArrayList arrayList = new ArrayList();
                for (FutureContractInfo next : f0.this.f73440c) {
                    SymbolPrice symbolPrice = h11.get(next.getContractShortType());
                    if (symbolPrice != null) {
                        arrayList.add(new c(next, symbolPrice));
                    }
                }
                f0 f0Var2 = f0.this;
                f0Var2.f73424b = arrayList;
                f0Var2.f73423a.onUpdate();
            }
        }

        public void onSuccess(List<SymbolPrice> list) {
        }
    }

    public static class c implements g.b {

        /* renamed from: a  reason: collision with root package name */
        public FutureContractInfo f73444a;

        /* renamed from: b  reason: collision with root package name */
        public SymbolPrice f73445b;

        public c(FutureContractInfo futureContractInfo, SymbolPrice symbolPrice) {
            this.f73444a = futureContractInfo;
            this.f73445b = symbolPrice;
        }

        @SensorsDataInstrumented
        public static /* synthetic */ void h(FutureContractInfo futureContractInfo, View view) {
            f.G(view.getContext(), futureContractInfo);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public String a() {
            return e.q(BaseApplication.b(), this.f73444a.getContractCode(), this.f73444a.getContractType());
        }

        public String b() {
            return this.f73444a.getContractShortType();
        }

        public String c() {
            return this.f73444a.getSymbol();
        }

        public String d(Context context) {
            Double close = this.f73445b.getClose();
            return close.doubleValue() >= 0.0d ? m.m(String.valueOf(close), FuturePrecisionUtil.h(this.f73444a.getSymbol())) : "--";
        }

        public Double e() {
            SymbolPrice symbolPrice = this.f73445b;
            Double valueOf = Double.valueOf(0.0d);
            if (symbolPrice == null) {
                return valueOf;
            }
            Double close = symbolPrice.getClose();
            Double open = this.f73445b.getOpen();
            return (close == null || open == null || Double.compare(close.doubleValue(), 0.0d) == 0) ? valueOf : Double.valueOf((close.doubleValue() - open.doubleValue()) / open.doubleValue());
        }

        public String f() {
            String str;
            String symbol = this.f73444a.getSymbol();
            String contractType = this.f73444a.getContractType();
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
            return new g0(FutureContractInfoController.n().o(this.f73444a.getContractCode()));
        }

        public String getTitle() {
            return e.p(BaseApplication.b(), this.f73444a.getSymbol(), this.f73444a.getQuoteCurrency());
        }
    }

    public f0(g.a aVar) {
        super(aVar);
    }

    public static /* synthetic */ List m(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List n(List list, List list2) {
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(List list) {
        this.f73440c = list;
    }

    public static /* synthetic */ c p(Map map, FutureContractInfo futureContractInfo) {
        return new c(futureContractInfo, (SymbolPrice) map.get(futureContractInfo.getContractShortType()));
    }

    public static /* synthetic */ Boolean q(c cVar) {
        return Boolean.valueOf(cVar.f73445b != null);
    }

    public void c() {
        k.g().e("LinearSwapRankListProvider", new b());
    }

    public void d(g.a aVar) {
        Observable.zip(FutureContractInfoController.n().q(true), LinearSwapProductInfoController.o().h(true).onErrorReturn(d0.f73431b), e0.f73438b).compose(RxJavaHelper.s()).doOnNext(new a0(this)).flatMap(i.f3526b).map(new b0(k.g().h())).filter(c0.f73429b).toList().subscribe(new a(aVar));
    }

    public boolean e() {
        return d.v(11);
    }

    public void f() {
        k.g().j("LinearSwapRankListProvider");
    }
}
