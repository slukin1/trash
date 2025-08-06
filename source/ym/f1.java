package ym;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import bj.l0;
import cn.k2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.bean.FutureTpSlOrder;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCancelAllResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapOrderResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderResult;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlOrder;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTpSlRelationOrder;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTrackOrderInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.linear.swap.retrofit.LinearSwapRetrofit;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.contract.entity.ContractOpenCountInfo;
import com.huobi.future.bean.FutureTpSlOrderDialogItem;
import com.huobi.future.ui.FutureTpSlDetailDialogFragment;
import com.huobi.linearswap.ui.LinearSwapTimeOrderDetailActivity;
import com.huobi.trade.bean.EdgeOrderEmptyItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import qk.o0;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import tg.r;
import ye.a;
import ye.b;
import ye.c;
import ye.d;

public class f1 implements nk.b {
    public LinearSwapOrderResult<LinearSwapTriggerOrderInfo> A;
    public LinearSwapOrderResult<LinearSwapTriggerOrderInfo> B;
    public LinearSwapOrderResult<LinearSwapTrackOrderInfo> C;
    public LinearSwapTimeOrderResult<LinearSwapTimeOrderInfo> D;
    public a.C0260a E = new l();
    public d.a F = new a();
    public d.a G = new b();
    public c.a H = new v0(this);
    public b.a I = new c();
    public bm.a J;

    /* renamed from: a  reason: collision with root package name */
    public k2 f76876a;

    /* renamed from: b  reason: collision with root package name */
    public m f76877b;

    /* renamed from: c  reason: collision with root package name */
    public List<s9.a> f76878c;

    /* renamed from: d  reason: collision with root package name */
    public List<s9.a> f76879d;

    /* renamed from: e  reason: collision with root package name */
    public List<s9.a> f76880e;

    /* renamed from: f  reason: collision with root package name */
    public List<s9.a> f76881f;

    /* renamed from: g  reason: collision with root package name */
    public List<s9.a> f76882g;

    /* renamed from: h  reason: collision with root package name */
    public List<s9.a> f76883h;

    /* renamed from: i  reason: collision with root package name */
    public v9.a<s9.a> f76884i;

    /* renamed from: j  reason: collision with root package name */
    public List<ok.a> f76885j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public EdgeOrderEmptyItem f76886k = new EdgeOrderEmptyItem();

    /* renamed from: l  reason: collision with root package name */
    public ok.b f76887l;

    /* renamed from: m  reason: collision with root package name */
    public Subscriber<List<LinearSwapPositionOrderItem>> f76888m;

    /* renamed from: n  reason: collision with root package name */
    public Subscriber<List<ye.a>> f76889n;

    /* renamed from: o  reason: collision with root package name */
    public Subscriber<List<ye.d>> f76890o;

    /* renamed from: p  reason: collision with root package name */
    public Subscriber<List<ye.d>> f76891p;

    /* renamed from: q  reason: collision with root package name */
    public Subscriber<List<ye.c>> f76892q;

    /* renamed from: r  reason: collision with root package name */
    public Subscriber<List<ye.b>> f76893r;

    /* renamed from: s  reason: collision with root package name */
    public Subscriber<ContractOpenCountInfo> f76894s;

    /* renamed from: t  reason: collision with root package name */
    public ContractOpenCountInfo f76895t = new ContractOpenCountInfo();

    /* renamed from: u  reason: collision with root package name */
    public FutureContractInfo f76896u;

    /* renamed from: v  reason: collision with root package name */
    public TradeType f76897v;

    /* renamed from: w  reason: collision with root package name */
    public int f76898w;

    /* renamed from: x  reason: collision with root package name */
    public String f76899x;

    /* renamed from: y  reason: collision with root package name */
    public LinearSwapPositionOrderItem.a f76900y;

    /* renamed from: z  reason: collision with root package name */
    public LinearSwapOrderResult<LinearSwapCurrentOrderInfo> f76901z;

    public class a implements d.a {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(List list) {
            HuobiToastUtil.s(R.string.string_order_cancel_ok);
            s6.a.b(bh.j.c()).c(R.raw.order_canceled);
            f1 f1Var = f1.this;
            f1Var.a1(f1Var.f76896u.getContractCode(), f1.this.f76896u.getSymbol(), 1, 0, 10, f1.this.Z().getPositionType(), f1.this.Z().e1(), f1.this.Z().T0(), f1.this.f76898w);
            f1.this.U0();
        }

        public void a(ye.d dVar, Context context) {
        }

        public void b(ye.d dVar) {
            Observable<LinearSwapCancelAllResult> observable;
            if (dVar.f() == 2) {
                observable = h8.a.a().t(dVar.g().getContractCode(), dVar.g().getOrderId()).b();
            } else {
                observable = h8.a.a().X(dVar.g().getContractCode(), dVar.g().getOrderId()).b();
            }
            observable.delay(300, TimeUnit.MILLISECONDS).compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t(f1.this.Z())).subscribe(q6.d.c(f1.this.Z(), new e1(this)));
        }
    }

    public class b implements d.a {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(List list) {
            HuobiToastUtil.s(R.string.string_order_cancel_ok);
            s6.a.b(bh.j.c()).c(R.raw.order_canceled);
            f1 f1Var = f1.this;
            f1Var.X0(f1Var.f76896u.getContractCode(), f1.this.f76896u.getSymbol(), 0, 10, f1.this.Z().getPositionType(), f1.this.Z().e1(), f1.this.Z().T0(), f1.this.f76898w);
            f1.this.U0();
        }

        public void a(ye.d dVar, Context context) {
            f1.this.f76877b.b(dVar);
        }

        public void b(ye.d dVar) {
            Observable<LinearSwapCancelAllResult> observable;
            if (dVar.f() == 2) {
                observable = h8.a.a().y(dVar.g().getContractCode(), dVar.g().getOrderId()).b();
            } else {
                observable = h8.a.a().S(dVar.g().getContractCode(), dVar.g().getOrderId()).b();
            }
            observable.delay(300, TimeUnit.MILLISECONDS).compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t(f1.this.Z())).subscribe(q6.d.c(f1.this.Z(), new g1(this)));
        }
    }

    public class c implements b.a {
        public c() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(List list) {
            HuobiToastUtil.s(R.string.n_exchange_timing_stop_order_success);
            s6.a.b(bh.j.c()).c(R.raw.order_canceled);
            f1 f1Var = f1.this;
            f1Var.X0(f1Var.f76896u.getContractCode(), f1.this.f76896u.getSymbol(), 0, 10, f1.this.Z().getPositionType(), f1.this.Z().e1(), f1.this.Z().T0(), f1.this.f76898w);
            f1.this.U0();
        }

        public void a(Context context, ye.b bVar) {
            Intent intent = new Intent(context, LinearSwapTimeOrderDetailActivity.class);
            intent.putExtra("EXTRA_TIME_ORDER_SYMBOL", FutureContractInfoController.n().o(bVar.g().getContractCode()).getSymbol());
            intent.putExtra("EXTRA_TIME_ORDER_ID", bVar.g().getOrderId());
            intent.putExtra("EXTRA_TIME_ORDER_CONTRACT_CODE", bVar.g().getContractCode());
            intent.putExtra("EXTRA_TIME_ORDER_CONTRACT_TYPE", bVar.g().getContractType());
            if (FutureContractInfo.MARGIN_CROSS.equals(bVar.g().getMarginMode())) {
                intent.putExtra("EXTRA_TIME_ORDER_SHOW_MODEL", 1);
            } else {
                intent.putExtra("EXTRA_TIME_ORDER_SHOW_MODEL", 0);
            }
            context.startActivity(intent);
        }

        public void b(ye.b bVar) {
            h8.a.a().z0(bVar.g().getContractCode(), bVar.g().getOrderId()).b().delay(300, TimeUnit.MILLISECONDS).compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t(f1.this.Z())).subscribe(q6.d.c(f1.this.Z(), new h1(this)));
        }
    }

    public class d extends BaseSubscriber<ContractOpenCountInfo> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(ContractOpenCountInfo contractOpenCountInfo) {
            f1.this.Z().d1(contractOpenCountInfo);
        }
    }

    public class e extends EasySubscriber<List<ye.d>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f76906b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76907c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76908d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f76909e;

        public e(int i11, int i12, String str, String str2) {
            this.f76906b = i11;
            this.f76907c = i12;
            this.f76908d = str;
            this.f76909e = str2;
        }

        public void onError2(Throwable th2) {
            f1.this.K0(this.f76906b, this.f76907c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            f1.this.K0(this.f76906b, this.f76907c);
        }

        public void onNext(List<ye.d> list) {
            f1.this.P0(this.f76908d, this.f76909e, this.f76907c, 1, list);
            for (ye.d a11 : list) {
                f1.this.f76877b.a(a11);
            }
        }
    }

    public class f extends EasySubscriber<List<ye.c>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f76911b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76912c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76913d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f76914e;

        public f(int i11, int i12, String str, String str2) {
            this.f76911b = i11;
            this.f76912c = i12;
            this.f76913d = str;
            this.f76914e = str2;
        }

        public void onError2(Throwable th2) {
            f1.this.K0(this.f76911b, this.f76912c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            f1.this.K0(this.f76911b, this.f76912c);
        }

        public void onNext(List<ye.c> list) {
            f1.this.R0(this.f76913d, this.f76914e, this.f76912c, 5, list);
        }
    }

    public class g extends EasySubscriber<List<ye.b>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f76916b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76917c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76918d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f76919e;

        public g(int i11, int i12, String str, String str2) {
            this.f76916b = i11;
            this.f76917c = i12;
            this.f76918d = str;
            this.f76919e = str2;
        }

        public void onError2(Throwable th2) {
            f1.this.K0(this.f76916b, this.f76917c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            f1.this.K0(this.f76916b, this.f76917c);
        }

        public void onNext(List<ye.b> list) {
            f1.this.Q0(this.f76918d, this.f76919e, this.f76917c, 7, list);
        }
    }

    public class h implements Func1<Long, Observable<? extends List<LinearSwapPositionOrderItem>>> {
        public h() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ LinearSwapPositionOrderItem e(LinearSwapPosition linearSwapPosition) {
            LinearSwapPositionOrderItem linearSwapPositionOrderItem = new LinearSwapPositionOrderItem();
            linearSwapPosition.setFromNet(true);
            linearSwapPositionOrderItem.h(linearSwapPosition);
            linearSwapPositionOrderItem.f(f1.this.f76900y);
            linearSwapPositionOrderItem.g(FutureContractInfoController.n().o(linearSwapPosition.getContractCode()));
            return linearSwapPositionOrderItem;
        }

        /* renamed from: c */
        public Observable<? extends List<LinearSwapPositionOrderItem>> call(Long l11) {
            return h8.a.a().n0("", TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL).b().flatMap(j1.f61847b).map(new i1(this)).toList();
        }
    }

    public class i extends EasySubscriber<List<ye.a>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f76922b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76923c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76924d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f76925e;

        public i(int i11, int i12, String str, String str2) {
            this.f76922b = i11;
            this.f76923c = i12;
            this.f76924d = str;
            this.f76925e = str2;
        }

        public void onError2(Throwable th2) {
            f1.this.K0(this.f76922b, this.f76923c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            f1.this.K0(this.f76922b, this.f76923c);
        }

        public void onNext(List<ye.a> list) {
            f1.this.L0(this.f76924d, this.f76925e, this.f76923c, 0, list);
        }
    }

    public class j extends EasySubscriber<List<ye.d>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f76927b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f76928c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f76929d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f76930e;

        public j(int i11, int i12, String str, String str2) {
            this.f76927b = i11;
            this.f76928c = i12;
            this.f76929d = str;
            this.f76930e = str2;
        }

        public void onError2(Throwable th2) {
            f1.this.K0(this.f76927b, this.f76928c);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            f1.this.K0(this.f76927b, this.f76928c);
        }

        public void onNext(List<ye.d> list) {
            f1.this.S0(this.f76929d, this.f76930e, this.f76928c, 1, list);
        }
    }

    public class k extends EasySubscriber<List<LinearSwapPositionOrderItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f76932b;

        public k(boolean z11) {
            this.f76932b = z11;
        }

        public void onNext(List<LinearSwapPositionOrderItem> list) {
            super.onNext(list);
            f1.this.N0(list);
            if (this.f76932b) {
                l0.w().P(f1.this.f76896u.getContractCode(), list);
            } else {
                l0.v().P(f1.this.f76896u.getContractCode(), list);
            }
        }
    }

    public class l implements a.C0260a {
        public l() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(List list) {
            HuobiToastUtil.s(R.string.string_order_cancel_ok);
            s6.a.b(bh.j.c()).c(R.raw.order_canceled);
            f1 f1Var = f1.this;
            f1Var.V0(f1Var.f76896u.getContractCode(), f1.this.f76896u.getSymbol(), 0, 0, 10, f1.this.Z().getPositionType(), f1.this.Z().e1(), f1.this.Z().T0(), f1.this.f76898w);
            f1.this.U0();
        }

        public static /* synthetic */ void f(Context context, LinearSwapTpSlRelationOrder linearSwapTpSlRelationOrder) {
            FutureTpSlDetailDialogFragment futureTpSlDetailDialogFragment = new FutureTpSlDetailDialogFragment();
            List<LinearSwapTpSlOrder> tpSlOrderInfo = linearSwapTpSlRelationOrder.getTpSlOrderInfo();
            ArrayList arrayList = new ArrayList();
            FutureContractInfo o11 = FutureContractInfoController.n().o(linearSwapTpSlRelationOrder.getContractCode());
            for (LinearSwapTpSlOrder linearSwapToFuture : tpSlOrderInfo) {
                FutureTpSlOrderDialogItem futureTpSlOrderDialogItem = new FutureTpSlOrderDialogItem();
                FutureTpSlOrder futureTpSlOrder = new FutureTpSlOrder();
                futureTpSlOrderDialogItem.i(futureTpSlOrder.linearSwapToFuture(futureTpSlOrder, linearSwapToFuture));
                futureTpSlOrderDialogItem.g(o11.getContractFace());
                futureTpSlOrderDialogItem.h(o11.getContractShortType());
                futureTpSlOrderDialogItem.j(o11.getQuoteCurrency());
                arrayList.add(futureTpSlOrderDialogItem);
            }
            futureTpSlDetailDialogFragment.tc(arrayList);
            futureTpSlDetailDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "LinearSwapFutureTpSlDetailDialogFragment");
            HashMap hashMap = new HashMap();
            hashMap.put("Page_name", "contract_view");
            gs.g.i("check_take_profit_and_stop_loss_click", hashMap);
        }

        public void a(ye.a aVar, Context context) {
            h8.b a11 = h8.a.a();
            boolean z11 = true;
            if (aVar.f() != 1) {
                z11 = false;
            }
            a11.T(z11, aVar.g().getContractCode(), String.valueOf(aVar.g().getOrderId())).b().compose(RxJavaHelper.t(f1.this.Z())).subscribe(q6.d.c(f1.this.Z(), new k1(context)));
        }

        public void b(ye.a aVar) {
            Observable<LinearSwapCancelAllResult> observable;
            if (aVar.f() == 2) {
                observable = h8.a.a().q0(aVar.g().getContractCode(), aVar.g().getOrderId().longValue()).b();
            } else {
                observable = h8.a.a().Y(aVar.g().getContractCode(), aVar.g().getOrderId().longValue()).b();
            }
            observable.delay(300, TimeUnit.MILLISECONDS).compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t(f1.this.Z())).subscribe(q6.d.c(f1.this.Z(), new l1(this)));
            is.a.j("4714", (Map<String, Object>) null, is.a.f(TradeType.LINEAR_SWAP));
            HashMap hashMap = new HashMap();
            hashMap.put("module_name", "entrust_list");
            gs.g.j("contract_trade", "usdt_contract", "repeal", hashMap);
        }
    }

    public interface m {
        int B0();

        void a(ye.d dVar);

        void b(ye.d dVar);

        void f(int i11);

        void g(int i11);

        void h(int i11);

        void i(int i11);

        void u2(int i11);
    }

    public f1(k2 k2Var, TradeType tradeType) {
        this.f76876a = k2Var;
        this.f76878c = new ArrayList();
        this.f76879d = new ArrayList();
        this.f76880e = new ArrayList();
        this.f76881f = new ArrayList();
        this.f76882g = new ArrayList();
        this.f76883h = new ArrayList();
        this.f76884i = new v9.a<>(this.f76878c);
        this.f76897v = tradeType;
    }

    public static /* synthetic */ Boolean A0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable B0(LinearSwapOrderResult linearSwapOrderResult) {
        this.A = linearSwapOrderResult;
        return Observable.from(linearSwapOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ye.d C0(LinearSwapTriggerOrderInfo linearSwapTriggerOrderInfo) {
        FutureContractInfo o11 = FutureContractInfoController.n().o(StringUtils.i(linearSwapTriggerOrderInfo.getContractCode()));
        if (o11 == null) {
            return null;
        }
        linearSwapTriggerOrderInfo.setContractFace(o11.getContractFace());
        int i11 = 1;
        if (linearSwapTriggerOrderInfo.getMarginMode().equals(FutureContractInfo.MARGIN_ISOLATED)) {
            i11 = 2;
        }
        return new ye.d(linearSwapTriggerOrderInfo, o11.getQuoteCurrency(), o11.getContractShortType(), this.F, i11, o11.getContractType(), true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable D0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return h8.a.a().m0(i11, i12, str, TtmlNode.COMBINE_ALL, 0).b().flatMap(new d1(this)).map(new f0(this)).toList();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(List list) {
        HuobiToastUtil.s(R.string.string_order_cancel_ok);
        s6.a.b(bh.j.c()).c(R.raw.order_canceled);
        X0(this.f76896u.getContractCode(), this.f76896u.getSymbol(), 0, 10, Z().getPositionType(), Z().e1(), Z().T0(), this.f76898w);
        U0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0(ye.c cVar) {
        Observable<LinearSwapCancelAllResult> observable;
        if (cVar.h() == 2) {
            observable = h8.a.a().q(cVar.g().getContractCode(), cVar.g().getOrderId()).b();
        } else {
            observable = h8.a.a().O(cVar.g().getContractCode(), cVar.g().getContractType(), cVar.g().getPair(), cVar.g().getOrderId()).b();
        }
        observable.delay(300, TimeUnit.MILLISECONDS).compose(LinearSwapRetrofit.n()).compose(RxJavaHelper.t(Z())).subscribe(q6.d.c(Z(), new a0(this)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable e0(LinearSwapOrderResult linearSwapOrderResult) {
        this.f76901z = linearSwapOrderResult;
        return Observable.from(linearSwapOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ye.a f0(LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo) {
        LinearSwapContractInfo m11 = LinearSwapCurrencyInfoController.l().m(linearSwapCurrentOrderInfo.getContractCode());
        linearSwapCurrentOrderInfo.setSymbol(m11.getSymbol());
        linearSwapCurrentOrderInfo.setContractFace(m11.getContractFace());
        return new ye.a(linearSwapCurrentOrderInfo, this.f76896u.getQuoteCurrency(), this.f76896u.getContractShortType(), this.E, linearSwapCurrentOrderInfo.getMarginMode().equals(FutureContractInfo.MARGIN_ISOLATED) ? 2 : 1, FutureContractInfoController.n().o(linearSwapCurrentOrderInfo.getContractCode()).getContractType());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable g0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return h8.a.a().K(i11, i12, str, TtmlNode.COMBINE_ALL, TtmlNode.COMBINE_ALL, "").b().flatMap(new b0(this)).map(new a1(this)).toList();
    }

    public static /* synthetic */ Boolean i0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable k0(LinearSwapOrderResult linearSwapOrderResult) {
        this.B = linearSwapOrderResult;
        return Observable.from(linearSwapOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ye.d l0(LinearSwapTriggerOrderInfo linearSwapTriggerOrderInfo) {
        FutureContractInfo o11 = FutureContractInfoController.n().o(StringUtils.i(linearSwapTriggerOrderInfo.getContractCode()));
        if (o11 == null) {
            return null;
        }
        linearSwapTriggerOrderInfo.setContractFace(o11.getContractFace());
        int i11 = 1;
        if (linearSwapTriggerOrderInfo.getMarginMode().equals(FutureContractInfo.MARGIN_ISOLATED)) {
            i11 = 2;
        }
        return new ye.d(linearSwapTriggerOrderInfo, o11.getQuoteCurrency(), o11.getContractShortType(), this.G, i11, o11.getContractType(), false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable m0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return h8.a.a().y0(i11, i12, str, TtmlNode.COMBINE_ALL, 0).b().flatMap(new b1(this)).map(new g0(this)).toList();
    }

    public static /* synthetic */ Boolean o0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable p0(LinearSwapTimeOrderResult linearSwapTimeOrderResult) {
        this.D = linearSwapTimeOrderResult;
        if (linearSwapTimeOrderResult.getOrders() == null) {
            return Observable.from(new ArrayList());
        }
        return Observable.from(linearSwapTimeOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ye.b q0(LinearSwapTimeOrderInfo linearSwapTimeOrderInfo) {
        FutureContractInfo o11 = FutureContractInfoController.n().o(StringUtils.i(linearSwapTimeOrderInfo.getContractCode()));
        if (o11 == null) {
            return null;
        }
        int i11 = 1;
        if (linearSwapTimeOrderInfo.getMarginMode().equals(FutureContractInfo.MARGIN_ISOLATED)) {
            i11 = 2;
        }
        return new ye.b(linearSwapTimeOrderInfo, o11.getQuoteCurrency(), o11.getContractShortType(), this.I, i11, o11.getContractType());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable r0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return h8.a.a().L(str, i11, i12).b().flatMap(new d0(this)).map(new c0(this)).toList();
    }

    public static /* synthetic */ Boolean t0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable u0(LinearSwapOrderResult linearSwapOrderResult) {
        this.C = linearSwapOrderResult;
        return Observable.from(linearSwapOrderResult.getOrders());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ye.c v0(LinearSwapTrackOrderInfo linearSwapTrackOrderInfo) {
        FutureContractInfo o11 = FutureContractInfoController.n().o(StringUtils.i(linearSwapTrackOrderInfo.getContractCode()));
        if (o11 == null) {
            return null;
        }
        int i11 = 1;
        if (linearSwapTrackOrderInfo.getMarginMode().equals(FutureContractInfo.MARGIN_ISOLATED)) {
            i11 = 2;
        }
        return new ye.c(o11.getContractFace(), this.H, linearSwapTrackOrderInfo, o11.getQuoteCurrency(), o11.getContractShortType(), i11, o11.getContractType());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Observable w0(String str, int i11, int i12, Long l11) {
        if (!o0.b()) {
            str = null;
        }
        return h8.a.a().A(str, i11, i12, 0, TtmlNode.COMBINE_ALL).b().flatMap(new c1(this)).map(new e0(this)).toList();
    }

    public static /* synthetic */ Boolean y0(int i11, List list) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public void E0(m mVar) {
        this.f76877b = mVar;
    }

    public void F0(View view) {
        v9.a<s9.a> aVar = this.f76884i;
        if (aVar != null) {
            aVar.j(view);
        }
    }

    public void G0(LinearSwapPositionOrderItem.a aVar) {
        this.f76900y = aVar;
    }

    public void H0(bm.a aVar) {
        this.J = aVar;
    }

    public void I0(ok.b bVar) {
        this.f76887l = bVar;
    }

    public final void J0(int i11, int i12) {
        if (i11 == 0) {
            this.f76879d.clear();
            this.f76879d.add(this.f76886k);
            this.f76884i.i(this.f76879d);
        } else if (i12 == 1) {
            if (this.f76877b.B0() == 1) {
                this.f76880e.clear();
                this.f76880e.add(this.f76886k);
                this.f76884i.i(this.f76880e);
            } else {
                return;
            }
        } else if (i12 == 2) {
            if (this.f76877b.B0() == 2) {
                this.f76881f.clear();
                this.f76881f.add(this.f76886k);
                this.f76884i.i(this.f76881f);
            } else {
                return;
            }
        } else if (i12 == 3) {
            if (this.f76877b.B0() == 3) {
                this.f76882g.clear();
                this.f76882g.add(this.f76886k);
                this.f76884i.i(this.f76882g);
            } else {
                return;
            }
        } else if (i12 == 4) {
            if (this.f76877b.B0() == 4) {
                this.f76883h.clear();
                this.f76883h.add(this.f76886k);
                this.f76884i.i(this.f76883h);
            } else {
                return;
            }
        } else if (this.f76877b.B0() == 0) {
            this.f76878c.clear();
            this.f76878c.add(this.f76886k);
            this.f76884i.i(this.f76878c);
        } else {
            return;
        }
        this.f76884i.notifyDataSetChanged();
    }

    public final void K0(int i11, int i12) {
        J0(i11, i12);
    }

    public final void L0(String str, String str2, int i11, int i12, List<? extends s9.a> list) {
        this.f76878c.clear();
        int i13 = 0;
        if (list.isEmpty()) {
            this.f76878c.add(new EdgeOrderEmptyItem(str2, i11));
        } else {
            this.f76878c.addAll(list);
            if (list.size() >= 10) {
                this.f76878c.add(new aj.e(str, str2, i12, this.f76898w == 1 ? 1 : 0, this.f76897v));
            }
        }
        if (this.f76877b.B0() == 0) {
            this.f76884i.i(this.f76878c);
            this.f76884i.notifyDataSetChanged();
        }
        if (!this.f76885j.isEmpty()) {
            for (ok.a next : this.f76885j) {
                if (next != null) {
                    next.a();
                }
            }
        }
        m mVar = this.f76877b;
        if (mVar != null) {
            LinearSwapOrderResult<LinearSwapCurrentOrderInfo> linearSwapOrderResult = this.f76901z;
            if (linearSwapOrderResult != null) {
                i13 = linearSwapOrderResult.getTotalSize();
            }
            mVar.h(i13);
        }
    }

    public void M0() {
        J0(Z().e1(), Z().T0());
    }

    public void N0(List<? extends s9.a> list) {
        this.f76879d.clear();
        if (TextUtils.isEmpty(this.f76899x)) {
            this.f76879d.addAll(list);
        } else {
            for (s9.a aVar : list) {
                if (TextUtils.equals(this.f76899x, ((LinearSwapPositionOrderItem) aVar).f26409b.getContractCode())) {
                    this.f76879d.add(aVar);
                }
            }
        }
        if (this.f76879d.isEmpty()) {
            bm.a aVar2 = this.J;
            if (aVar2 != null) {
                aVar2.a(false);
            }
            this.f76879d.add(this.f76886k);
        } else {
            bm.a aVar3 = this.J;
            if (aVar3 != null) {
                aVar3.a(true);
            }
        }
        if (Z().v1() == 0) {
            this.f76884i.i(this.f76879d);
            this.f76884i.notifyDataSetChanged();
        }
        ok.b bVar = this.f76887l;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void O0() {
        J0(Z().e1(), Z().T0());
    }

    public final void P0(String str, String str2, int i11, int i12, List<? extends s9.a> list) {
        this.f76881f.clear();
        int i13 = 0;
        if (list.isEmpty()) {
            this.f76881f.add(new EdgeOrderEmptyItem(str2, i11));
        } else {
            this.f76881f.addAll(list);
            if (list.size() >= 10) {
                this.f76880e.add(new aj.e(str, str2, i12, this.f76898w == 1 ? 1 : 0, this.f76897v));
            }
        }
        if (this.f76877b.B0() == 2) {
            this.f76884i.i(this.f76881f);
            this.f76884i.notifyDataSetChanged();
        }
        m mVar = this.f76877b;
        if (mVar != null) {
            LinearSwapOrderResult<LinearSwapTriggerOrderInfo> linearSwapOrderResult = this.B;
            if (linearSwapOrderResult != null) {
                i13 = linearSwapOrderResult.getTotalSize();
            }
            mVar.f(i13);
        }
    }

    public final void Q0(String str, String str2, int i11, int i12, List<? extends s9.a> list) {
        this.f76883h.clear();
        int i13 = 0;
        if (list.isEmpty()) {
            this.f76883h.add(new EdgeOrderEmptyItem(str2, i11));
        } else {
            this.f76883h.addAll(list);
            if (list.size() >= 10) {
                this.f76883h.add(new aj.e(str, str2, i12, this.f76898w == 1 ? 1 : 0, this.f76897v));
            }
        }
        if (this.f76877b.B0() == 4) {
            this.f76884i.i(this.f76883h);
            this.f76884i.notifyDataSetChanged();
        }
        m mVar = this.f76877b;
        if (mVar != null) {
            LinearSwapTimeOrderResult<LinearSwapTimeOrderInfo> linearSwapTimeOrderResult = this.D;
            if (linearSwapTimeOrderResult != null) {
                i13 = linearSwapTimeOrderResult.getTotalSize();
            }
            mVar.u2(i13);
        }
    }

    public final void R0(String str, String str2, int i11, int i12, List<? extends s9.a> list) {
        this.f76882g.clear();
        int i13 = 0;
        if (list.isEmpty()) {
            this.f76882g.add(new EdgeOrderEmptyItem(str2, i11));
        } else {
            this.f76882g.addAll(list);
            if (list.size() >= 10) {
                this.f76882g.add(new aj.e(str, str2, i12, this.f76898w == 1 ? 1 : 0, this.f76897v));
            }
        }
        if (this.f76877b.B0() == 3) {
            this.f76884i.i(this.f76882g);
            this.f76884i.notifyDataSetChanged();
        }
        m mVar = this.f76877b;
        if (mVar != null) {
            LinearSwapOrderResult<LinearSwapTrackOrderInfo> linearSwapOrderResult = this.C;
            if (linearSwapOrderResult != null) {
                i13 = linearSwapOrderResult.getTotalSize();
            }
            mVar.i(i13);
        }
    }

    public void S() {
        this.f76878c.clear();
        this.f76879d.clear();
        this.f76880e.clear();
        this.f76881f.clear();
        this.f76882g.clear();
    }

    public final void S0(String str, String str2, int i11, int i12, List<? extends s9.a> list) {
        this.f76880e.clear();
        int i13 = 0;
        if (list.isEmpty()) {
            this.f76880e.add(new EdgeOrderEmptyItem(str, i11));
        } else {
            this.f76880e.addAll(list);
            if (list.size() >= 10) {
                this.f76880e.add(new aj.e(str, str2, i12, this.f76898w == 1 ? 1 : 0, this.f76897v));
            }
        }
        if (this.f76877b.B0() == 1) {
            this.f76884i.i(this.f76880e);
            this.f76884i.notifyDataSetChanged();
        }
        m mVar = this.f76877b;
        if (mVar != null) {
            LinearSwapOrderResult<LinearSwapTriggerOrderInfo> linearSwapOrderResult = this.A;
            if (linearSwapOrderResult != null) {
                i13 = linearSwapOrderResult.getTotalSize();
            }
            mVar.g(i13);
        }
    }

    public final Subscriber<List<ye.a>> T(String str, String str2, int i11, int i12) {
        return new i(i11, i12, str, str2);
    }

    public void T0(int i11, int i12) {
        J0(i11, i12);
    }

    public final Subscriber<List<LinearSwapPositionOrderItem>> U(boolean z11) {
        return new k(z11);
    }

    public void U0() {
        Subscriber<ContractOpenCountInfo> subscriber = this.f76894s;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (r.x().F0()) {
            this.f76894s = new d();
            Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(n0.f61868b).retryWhen(q0.f61874b).compose(RxJavaHelper.t(Z())).subscribe(this.f76894s);
            return;
        }
        Z().d1(this.f76895t);
    }

    public final Subscriber<List<ye.d>> V(String str, String str2, int i11, int i12) {
        return new j(i11, i12, str, str2);
    }

    public void V0(String str, String str2, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (!r.x().F0()) {
            T0(i15, i16);
        } else if (i14 != 2 && !TextUtils.isEmpty(str)) {
            this.f76898w = i17;
            Subscriber<List<ye.a>> subscriber = this.f76889n;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f76889n = T(str, str2, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new h0(this, str, i12, i13)).retryWhen(r0.f61878b).filter(new z0(i15)).compose(RxJavaHelper.t(Z())).subscribe(this.f76889n);
        }
    }

    public LinearSwapPositionOrderItem W(LinearSwapPosition linearSwapPosition) {
        LinearSwapPositionOrderItem linearSwapPositionOrderItem = new LinearSwapPositionOrderItem();
        linearSwapPosition.setFromNet(false);
        linearSwapPositionOrderItem.h(linearSwapPosition);
        linearSwapPositionOrderItem.f(this.f76900y);
        linearSwapPositionOrderItem.g(FutureContractInfoController.n().o(linearSwapPosition.getContractCode()));
        return linearSwapPositionOrderItem;
    }

    public void W0(String str, int i11, int i12) {
        this.f76899x = str;
        Subscriber<List<LinearSwapPositionOrderItem>> subscriber = this.f76888m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
        if (i11 == 2) {
            if (!r.x().F0()) {
                O0();
                return;
            }
        } else if (!r.x().F0()) {
            return;
        }
        boolean j11 = SPUtil.j();
        l0.w().X(j11);
        this.f76888m = U(j11);
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS).flatMap(new h()).retryWhen(p0.f61872b).compose(RxJavaHelper.t(Z())).subscribe(this.f76888m);
    }

    public List<s9.a> X() {
        return this.f76879d;
    }

    public void X0(String str, String str2, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!r.x().F0()) {
            T0(i14, i15);
        } else if (i13 != 2 && !TextUtils.isEmpty(str)) {
            e1();
            this.f76898w = i16;
            this.f76891p = new e(i14, i15, str, str2);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new i0(this, str, i11, i12)).retryWhen(o0.f61870b).filter(new w0(i14)).compose(RxJavaHelper.t(Z())).subscribe(this.f76891p);
        }
    }

    public v9.a<s9.a> Y() {
        return this.f76884i;
    }

    public void Y0(String str, String str2, int i11, int i12, int i13, int i14, int i15) {
        if (!r.x().F0()) {
            T0(i14, 4);
        } else if (i13 != 2 && !TextUtils.isEmpty(str)) {
            f1();
            this.f76898w = i15;
            this.f76893r = new g(i14, 4, str, str2);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new j0(this, str, i11, i12)).retryWhen(u0.f61890b).filter(new l0(i14)).compose(RxJavaHelper.t(Z())).subscribe(this.f76893r);
        }
    }

    public final k2 Z() {
        return this.f76876a;
    }

    public void Z0(String str, String str2, int i11, int i12, int i13, int i14, int i15, int i16) {
        if (!r.x().F0()) {
            T0(i14, i15);
        } else if (i13 != 2 && !TextUtils.isEmpty(str)) {
            g1();
            this.f76898w = i16;
            this.f76892q = new f(i14, i15, str, str2);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new k0(this, str, i11, i12)).retryWhen(s0.f61882b).filter(new x0(i14)).compose(RxJavaHelper.t(Z())).subscribe(this.f76892q);
        }
    }

    public List<s9.a> a() {
        return this.f76878c;
    }

    public void a1(String str, String str2, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (!r.x().F0()) {
            T0(i15, i16);
        } else if (i14 != 2 && !TextUtils.isEmpty(str)) {
            Subscriber<List<ye.d>> subscriber = this.f76890o;
            if (subscriber != null) {
                subscriber.unsubscribe();
            }
            this.f76898w = i17;
            this.f76890o = V(str, str2, i15, i16);
            Observable.interval(0, 3000, TimeUnit.MILLISECONDS).flatMap(new m0(this, str, i12, i13)).retryWhen(t0.f61886b).filter(new y0(i15)).compose(RxJavaHelper.t(Z())).subscribe(this.f76890o);
        }
    }

    public void b(ok.a aVar) {
        if (aVar != null) {
            this.f76885j.add(aVar);
        }
    }

    public void b1() {
        Subscriber<ContractOpenCountInfo> subscriber = this.f76894s;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void c1() {
        Subscriber<List<ye.a>> subscriber = this.f76889n;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void d1() {
        Subscriber<List<LinearSwapPositionOrderItem>> subscriber = this.f76888m;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void e1() {
        Subscriber<List<ye.d>> subscriber = this.f76891p;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void f(FutureContractInfo futureContractInfo) {
        this.f76896u = futureContractInfo;
    }

    public void f1() {
        Subscriber<List<ye.b>> subscriber = this.f76893r;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void g1() {
        Subscriber<List<ye.c>> subscriber = this.f76892q;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void h1() {
        Subscriber<List<ye.d>> subscriber = this.f76890o;
        if (subscriber != null) {
            subscriber.unsubscribe();
        }
    }

    public void i1(List<LinearSwapPosition> list) {
        if (list != null) {
            for (LinearSwapPosition next : list) {
                Iterator<s9.a> it2 = this.f76879d.iterator();
                if (it2.hasNext()) {
                    s9.a next2 = it2.next();
                    if (next2 instanceof LinearSwapPositionOrderItem) {
                        LinearSwapPositionOrderItem linearSwapPositionOrderItem = (LinearSwapPositionOrderItem) next2;
                        LinearSwapPosition linearSwapPosition = linearSwapPositionOrderItem.f26409b;
                        if (!next.equals(linearSwapPosition)) {
                            this.f76879d.add(W(next));
                        } else if (next.getVersion() > linearSwapPosition.getVersion()) {
                            if (next.hasVolume()) {
                                linearSwapPositionOrderItem.h(next);
                            } else {
                                this.f76879d.remove(next2);
                            }
                        }
                    }
                }
            }
            if (this.f76879d.isEmpty()) {
                bm.a aVar = this.J;
                if (aVar != null) {
                    aVar.a(false);
                }
                this.f76879d.add(this.f76886k);
            } else {
                bm.a aVar2 = this.J;
                if (aVar2 != null) {
                    aVar2.a(true);
                }
            }
            if (Z().v1() == 0) {
                this.f76884i.i(this.f76879d);
                this.f76884i.notifyDataSetChanged();
            }
            ok.b bVar = this.f76887l;
            if (bVar != null) {
                bVar.c();
            }
        }
    }

    public void j1(List<LinearSwapPosition> list, boolean z11) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (LinearSwapPosition W : list) {
                arrayList.add(W(W));
            }
            if (z11) {
                N0(arrayList);
                l0.w().P(this.f76896u.getContractCode(), arrayList);
            } else if (this.f76879d.isEmpty()) {
                for (LinearSwapPosition linearSwapPosition : list) {
                    if (i6.m.a(linearSwapPosition.volume).doubleValue() <= 0.0d) {
                        return;
                    }
                }
                N0(arrayList);
            } else {
                i1(list);
            }
        }
    }
}
